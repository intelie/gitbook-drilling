# OPC-DA

The **OPCDA** protocol is a service-oriented architecture that does not work polling information, instead uses a subscription and notification system, letting the **server** monitor the queried items. **OPCDA** is a protocol based on Microsoft’s COM/DCOM2 interface do write and read data in automation and uses the Node Ids to find the queried items, grouping them in a Subscription. These Node Ids are also called Tags.

In this example, we can see that an OPCDA Source should have a single Request and the following information must be provided:

| Name          | Description                                     | Required  | Default Value |
| ------------- | ----------------------------------------------- | --------- | ------------- |
| object        | Protocol name                                   | **opcda** |               |
| query\_period | Execution interval, in seconds, of each request | **yes**   |               |
| uid\_log      | Request identifier                              | no        | 1             |
| enabled       | Request collection enabled                      | no        | false         |

The **OPCDA** Source also needs a **ProgID** and a **CLSID**. These values could be configured on the screen or concatenated directly on the field. In the example below `OPC.Simulation.1` is the **ProgId** and `f8582cf2-88fb-11d0-b850-00c0f0104305` is the **CLSID**, always following the pattern `opcda://{computerAddress}/{ProgID}/{CLSID}`. The and must reflect the server’s computer user settings.

```xml
<source>
    <name>OPC-DA-DEMO</name>
    <enabled>true</enabled>
    <mode>client</mode>
    <rig_name>NS04</rig_name>
    <service_company>intelie</service_company>
    <protocol_name>opcda</protocol_name>
    <protocol_version>0.0.0</protocol_version>
    <endpoint>
        opcda://127.0.0.1/OPC.Simulation.1/f8582cf2-88fb-11d0-b850-00c0f0104305
    /endpoint>
    <username>Administrator</username>
    <password>admin</password>
    <requests>
    <request>
    <object>opcda</object>
    <query_period>20</query_period>
    <uid_log>1</uid_log>
    <enabled>true</enabled>
    </request>
    </requests>
</source>
```

The Liverig collector also requires the Node Ids (Tags) values, among other information, to query properly. These values are mapped in the following JSON format, as below, inside the `store.json` file:

```json
{
  "database": {
    "url": "jdbc:postgresql://localhost:5432/?user=root&password=rootpassword"
  },
  "endpoint": "http://127.0.0.1:1234/witsml/store",
  "limit": 1234,
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

Each object under rigs is related to an **OPCDA** Source, linking both files through their Rig Name. Some generic fields configure global collector settings: database, endpoint, and limit. These configurations are required if the **OPCDA** Source is going through the **OPC** to **WITSML** conversion.

The alias is used as a key reference for tags, units and types values.&#x20;

| Name      | Description                        | Required                             | Default value |
| --------- | ---------------------------------- | ------------------------------------ | ------------- |
| name      | An identifier for this rig         | **yes**                              |               |
| timestamp | A timestamp field identifier       | no                                   | TIMESTAMP     |
| tags      | Uses the Tag (nodeId) as a value.  | **yes**                              |               |
| units     | Uses the UOM as a value            | no                                   |               |
| types     | Uses the type as a value           | no (if OPC to WITSML converter, yes) | double        |

Obs: The tag field, should be written as the following pattern: `ns=<namespaceindex>;<type>=<value>`
