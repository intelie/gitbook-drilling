# OPC-DA

The **OPCDA** protocol is a service-oriented architecture that does not work polling information, instead uses a subscription and notification system, letting the **server** monitor the queried items. **OPCDA** is a protocol based on Microsoft’s COM/DCOM2 interface do write and read data in automation and uses the Node Ids to find the queried items, grouping them in a Subscription. These Node Ids are also called Tags.

In this example, we can see that an OPCDA Source should have a single Request and the following information must be provided:

| Name          | Description                                     | Required  | Default Value |
| ------------- | ----------------------------------------------- | --------- | ------------- |
| object        | Protocol name                                   | **opcda** |               |
| query\_period | Execution interval, in seconds, of each request | **yes**   |               |
| uid\_log      | Request identifier                              | no        | 1             |
| enabled       | Request collection enabled                      | no        | false         |

The **OPCDA** Source also needs a **ProgID** and a **CLSID**. These values could be configured on the screen or concatenated directly on the field. In the example below `OPC.Simulation.1` is the **ProgId** and `f8582cf2-88fb-11d0-b850-00c0f0104305` is the **CLSID**, always following the pattern `opcda://{computerAddress}/{ProgID}/{CLSID}`. The `username` and `password` must reflect the server’s computer user settings.

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
    </endpoint>
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

The same example could be configured through the source page, at the collector's tab:

![OPC-DA Source Configuration](<../../.gitbook/assets/collector-protocol-opc-da-1.png>)
![OPC-DA Source Configuration](<../../.gitbook/assets/collector-protocol-opc-da-2.png>)

The Liverig collector also ***requires*** the Node Ids (Tags) values, among other information, to query properly. These values should be configured at the [store.json](./../configuration/store.json.md) file.