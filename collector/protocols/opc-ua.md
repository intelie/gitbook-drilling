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

The same example could be configured through the source page, at the collector's tab:

![OPC-UA Source Configuration](<../../.gitbook/assets/collector-protocol-opc-ua-1.png>)
![OPC-UA Source Configuration](<../../.gitbook/assets/collector-protocol-opc-ua-2.png>)

In this example we can see that an OPCUA Source should have a single Request and the following information must be provided:

| Name          | Description                                     | Required  | Default value |
| ------------- | ----------------------------------------------- | --------- | ------------- |
| object        | Protocol name                                   | **opcua** |               |
| query\_period | Execution interval, in seconds, of each request | **yes**   |               |
| uid\_log      | Request identifier                              | no        | 1             |
| enabled       | Request collection enabled                      | no        | False         |

The Liverig collector also ***requires*** the Node Ids (Tags) values, among other information, to query properly. These values should be configured at the [store.json](./../configuration/store.json.md) file.

