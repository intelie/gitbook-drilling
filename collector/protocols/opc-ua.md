# OPC-UA

The **OPCUA** protocol is a service-oriented architecture that does not work polling information, instead uses a subscription and notification system, letting the server monitor the queried items.\
The **OPCUA** server uses the Node Ids to find the items, grouping them in a Subscription. These Node Ids are also called Tags. For more information on how to configure an **OPCUA** Source from the ground up, go to this [link](https://docs.google.com/document/u/0/d/11ywrwVIG2qCbM4PJ90V1VKmIaWcL5CQXaEIcrEyycCA/edit).\
\
Example:

```xml
<source>
    <name>OPC-UA-DEMO</name>
    <enabled>true</enabled>
    <mode>client</mode>
    <rig_name>NS04</rig_name>
    <service_company>intelie</service_company>
    <protocol_name>opcua</protocol_name>
    <protocol_version>0.0.0</protocol_version>
    <endpoint>opc.tcp://127.0.0.1:62541/milo</endpoint>
    <username>user1</username>
    <password>password</password>
    <requests>
        <request>
            <object>opcua</object>
            <query_period>20</query_period>
            <uid_log>1</uid_log>
            <enabled>true</enabled>
        </request>
    </requests>
</source>
```

In this example we can see that an OPCUA Source should have a single Request and the following information must be provided:

| Name          | Description                                     | Required  | Default value |
| ------------- | ----------------------------------------------- | --------- | ------------- |
| object        | Protocol name                                   | **opcua** |               |
| query\_period | Execution interval, in seconds, of each request | **yes**   |               |
| uid\_log      | Request identifier                              | no        | 1             |
| enabled       | Request collection enabled                      | no        | False         |

The Liverig collector also requires the Node Ids (Tags) values, among other information, to query properly. These values are mapped in the following JSON format as below, inside the `store.json` file:

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

Each object under rigs is related to an OPCUA Source, linking both files through their Rig Name. Some generic fields configure global collector settings: database, endpoint, and limit. These configurations are required if the OPCUA Source is going through the OPC to WITSML conversion. The configuration fields under the Rig Name are as follows:

| Name      | Description                        | Required                             | Default value |
| --------- | ---------------------------------- | ------------------------------------ | ------------- |
| name      | An identifier for this rig         | **yes**                              |               |
| timestamp | A timestamp field identifier       | no                                   | TIMESTAMP     |
| tags      | Uses the Tag (nodeId) as a value.  | **yes**                              |               |
| units     | Uses the UOM as a value            | no                                   |               |
| types     | Uses the type as a value           | no (if OPC to WITSML converter, yes) | double        |

Note that the alias is used as a key reference for tags, units and types values.&#x20;

