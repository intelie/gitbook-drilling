# OPC-UA

The **OPCUA** protocol is a service-oriented architecture that does not work polling information, instead uses a subscription and notification system, letting the server monitor the queried items.\
The **OPCUA** server uses the Node Ids to find the items, grouping them in a Subscription. These Node Ids are also called Tags. For more information on how to configure an **OPCUA** Source from the ground up, go to this [page](../configuration/configuring-an-opc-ua-source.md).

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
    <opcua_config>
        <security_config>
            <min_security_mode>None</min_security_mode>
            <max_security_mode>SignAndEncrypt</max_security_mode>
            <min_security_policy>Basic256</min_security_policy>
            <max_security_policy>Basic256Sha256</max_security_policy>
        </security_config>
    </opcua_config>
</source>
```

The same example could be configured through the source page, at the collector's tab:

![OPC-UA Source Configuration](<../../.gitbook/assets/collector-protocol-opc-ua-1.png>)
![OPC-UA Source Configuration](<../../.gitbook/assets/collector-protocol-opc-ua-2.png>)

In this example we can see that an OPCUA Source should have a single Request and the following information must be provided:

| Name          | Description                                     | Required  | Default value |
|---------------|-------------------------------------------------|-----------|---------------|
| object        | Protocol name                                   | **opcua** |               |
| query\_period | Execution interval, in seconds, of each request | **yes**   |               |
| uid\_log      | Request identifier                              | no        | 1             |
| enabled       | Request collection enabled                      | no        | False         |


From Collector version 5.33.0, the security ranges configuration is also available for OPC-UA Sources. This configuration 
is optional and can be set as following. Parameters not set will be considered as null and the default values will be used. 
The default values are those defined in the collector's properties file.

| Name                  | Description                                                                                                                                                         | Required | Default value (if not set) |
|-----------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|----------------------------|
| min\_security\_mode   | Minimum security mode allowed for the connection. Possible values: null (absence), "None", "Sign", "SignAndEncrypt"                                                 | no       | null (absence)             |
| max\_security\_mode   | Maximum security mode allowed for the connection. Possible values: null (absence), "None", "Sign", "SignAndEncrypt"                                                 | no       | null (absence)             |
| min\_security\_policy | Minimum security policy allowed for the connection. Possible values: null (absence), "None", "Basic128Rsa15", "Basic256", "Basic256Sha256", "Aes128_Sha256_RsaOaep" | no       | null (absence)             |
| max\_security\_policy | Maximum security policy allowed for the connection. Possible values: null (absence), "None", "Basic128Rsa15", "Basic256", "Basic256Sha256", "Aes128_Sha256_RsaOaep" | no       | null (absence)             |      

The Liverig collector also ***requires*** the Node Ids (Tags) values, among other information, to query properly. These values should be configured at the [store.json](./../configuration/store.json.md) file.

