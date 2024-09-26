The `store.json` file is used by LiveRig Collector to organize the CSV data stream and OPC tags to be read from the sources configured at `sources.xml`.

## CSV data stream

TODO add CSV data stream convertion in store.json configuration

## OPC protocol
The LiveRig Collector depends on the Node Ids (Tags) values, among other information, to query OPC server properly. These values are mapped in the following JSON format, as below:

```json
{
  "database": {
    "url": "jdbc:postgresql://localhost:5432/?user=root&password=rootpassword",
    "parameters": {
      "timescale": false,
      "timescale.chunk_interval": 604800000,
      "timescale.compress_after": 3600000
    }
  },
  "endpoint": "http://127.0.0.1:1234/witsml/store",
  "limit": 1234,
  "purge": "300000",
  "rigs": {
    "NS04": {
      "name": "NS04",
      "timestamp": "TIME",
      "tags": {
        "RandomInt32": "ns=2;s=Dynamic/RandomInt32",
        "RandomInt64": "ns=2;s=Dynamic/RandomInt64"
      },
      "units": {
        "RandomInt32": "m",
        "RandomInt64": "m/s"
      },
      "types": {
        "RandomInt32": "long",
        "RandomInt64": "long"
      }
    }
  }
}
```

Each object under rigs is related to an **OPC-DA** or **OPC-UA** source, linking the `store.json` and `sources.xml` files through their **Rig Name**. 

Some extra fields are responsible for an additional collector feature known as [OPC to WITSML protocol conversion](./../protocol-conversion.md). These optional fields are: `database`, `endpoint`, `limit` and `purge`. Once the `endpoint` and `database` are configured, a basic WITSML server will start backed by a PostgreSQL database to keep the data and enable the WITSML queries on top of it.

The `alias` is used as a key reference for tags, units and types values.&#x20;

| Name      | Description                        | Required                             | Default value |
| --------- | ---------------------------------- | ------------------------------------ | ------------- |
| name      | An identifier for this rig         | **yes**                              |               |
| timestamp | A timestamp field identifier       | no                                   | TIMESTAMP     |
| tags      | Uses the Tag (nodeId) as a value.  | **yes**                              |               |
| units     | Uses the UOM as a value            | no                                   |               |
| types     | Uses the type as a value           | no (if OPC to WITSML converter, yes) | double        |

**Note**: For **OPC-UA** sources, the tag field should be written as the following pattern: `ns=<namespaceindex>;<type>=<value>`

## LiveRig Collector 5.0.0 or above

Since LiveRig Collector version 5.0.0, the collector can be configured to extract field from object values in **OPC-UA** sources. 

**Example 1:**

![A date time OPC object arrives as is](../../.gitbook/assets/OpcuaObjectEvent1.png)

In this event, the OPC-UA source returned a value structured as an object with the following format:

```json
{
  "utcTime": 133144611706210000
}
```

To extract the field `utcTime` as the value itself we need to configure the tag using the `?field=` parameter. Example:
`{tag}?field={path}`.

So, in this example the previous tag `"ns=2;s=HelloWorld/ScalarTypes/UtcTime"` would be changed to `"ns=2;s=HelloWorld/ScalarTypes/UtcTime?field=/utcTime"`

Resulting in the following value:

![Extracting the timestamp from an OPC date time object](../../.gitbook/assets/OpcuaObjectEvent2.png)

**Example 2:**

![An encoded OPC object arrives as is](../../.gitbook/assets/OpcuaObjectEvent3.png)

In this event, the OPC-UA source returned a value structured as an object with the following format:

```json
{
  "bodyType": "ByteString",
  "encodingId": {
    "identifier": {
      "value": 886
    },
    "namespaceIndex": {
      "value": 0
    }
  },
  "decoded": {},
  "body": {
    "bytes": [0,0,0,0,0,0,0,0,0,0,0,0,0,0,89,64]
  }
}
```
To extract the field `endodingId/indentifier/value` as the value itself we need to configure the tag using the `?field=` parameter. Example:
`{tag}?field={path}`.

So, in this example the previous tag `"ns=2;s=HelloWorld/DataAccess/AnalogValue/0:EURange"` would be changed to `"ns=2;s=HelloWorld/DataAccess/AnalogValue/0:EURange?field=/encodingId/identifier/value"`.
If you want to extract other fields from the same object, you can declare it as a new tag, like `"ns=2;s=HelloWorld/DataAccess/AnalogValue/0:EURange?field=/encodingId/namespaceIndex/value"`
to extract the `encodingId/namespaceIndex/value` as a value.

Resulting in the following value:

![Extracting the encoded object](../../.gitbook/assets/OpcuaObjectEvent4.png)

**Note**: Since the `tags` field from the `store.json` file is a `Map`, you need to add a new alias for each field you want to fetch. Example:
`"RangeObject/Identifier": "ns=2;s=HelloWorld/DataAccess/AnalogValue/0:EURange?field=/encodingId/identifier/value"` and
`"RangeObject/namespaceIndex": "ns=2;s=HelloWorld/DataAccess/AnalogValue/0:EURange?field=/encodingId/namespaceIndex/value"`


{% hint style="info" %} 
Instead of manually configuring this file, is also possible to use the remote control page [OPC Requests](./../remote-control/sources/opc-requests.md) to change the settings easily.
{% endhint %}
