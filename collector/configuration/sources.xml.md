# sources.xml

This file stores the configuration regarding the connection to all the remote data sources, for any protocol.

### Sources

| Field     | Type                  |
| --------- | --------------------- |
| `sources` | list\<Sources.Source> |

### Sources.Source

| Field                                                                                                                                                                                 | Type                          | Restricted to          |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------|------------------------|
| `name`                                                                                                                                                                                | string                        |                        |
| `enabled`                                                                                                                                                                             | boolean                       |                        |
| `rig_name`                                                                                                                                                                            | string                        |                        |
| `service_company`                                                                                                                                                                     | string                        |                        |
| `protocol_name`                                                                                                                                                                       | string                        |                        |
| The protocol name defines the interpretation of all the other fields. Possible values are `witsml`, `wits`, `opc-da`,`opc-ua`, `modbus`, `csv`, and `raw`.                            |                               |                        |
| `protocol_version`                                                                                                                                                                    | string                        |                        |
| `endpoint`                                                                                                                                                                            | string                        |                        |
| The format of the endpoint varies by protocol.                                                                                                                                        |                               |                        |
| `username`                                                                                                                                                                            | string                        |                        |
| Used if applicable. In opc-da, it can include the domain                                                                                                                              |                               |                        |
| `password`                                                                                                                                                                            | string                        | witsml, opc-ua, opc-da |
| Used if applicable.                                                                                                                                                                   |                               |                        |
| `mode`                                                                                                                                                                                | string                        |                        |
| `client` or `server`                                                                                                                                                                  |                               |                        |
| `query_period`                                                                                                                                                                        | int                           | witsml, opc-da, opc-ua |
| The interval between consecutive requests starts.                                                                                                                                     |                               |                        |
| `wildcard_period`                                                                                                                                                                     | int                           | witsml                 |
| The interval in which the collector gets the witsml store and creates the dynamic requests. If the tag does not exist, the wildcard\_period value from liverig.property will be used. |                               |                        |
| `uid_well`                                                                                                                                                                            | string                        | witsml                 |
| This filter can represent either the desired uid\_well or the wildcard `*`, meaning to collect data from all wells.                                                                   |                               |                        |
| `uid_wellbore`                                                                                                                                                                        | string                        | witsml                 |
| This filter can represent either the desired uid\_wellbore or the wildcard `*`, meaning to collect data from all wellbores.                                                           |                               |                        |
| `tls_auth`                                                                                                                                                                            | boolean                       | witsml                 |
| This flag indicates if a witsml source using https protocol should use a certificate to authenticate.                                                                                 |                               |                        |
| `requests`                                                                                                                                                                            | list\<Sources.Source.Request> | witsml                 |
| `opcua_config`                                                                                                                                                                        | Sources.Source.OpcuaConfig    | opc-ua                 |
| Specific configurations related to an OPC-UA source. It includes connection's security configuration.                                                                                 |                               |                        |

{% hint style="info" %}
As part of XML, any string connection for `endpoint` that needs URL parameters needs to escape `&` as `&amp;`.

For example:

`<endpoint>https://server:1234?key=value&another=value</endpoint>` is not a valid XML

`<endpoint>https://server:1234?key=value&amp;another=value</endpoint>` is the correct format
{% endhint %}

### Sources.Source.Request

| Field                                                                                                                                                                                                                                                                                                           | Type    | Restricted to          |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------- | ---------------------- |
| `enabled`                                                                                                                                                                                                                                                                                                       | boolean |                        |
| `object`                                                                                                                                                                                                                                                                                                        | string  | witsml                 |
| `query_period`                                                                                                                                                                                                                                                                                                  | int     | witsml, opc-da, opc-ua |
| The interval between consecutive requests starts. It has precedence over the `source` configuration.                                                                                                                                                                                                            |         |                        |
| `uid_well`                                                                                                                                                                                                                                                                                                      | string  | witsml                 |
| This filter can represent either the desired uid\_well or the wildcard `*`, meaning to collect data from all wells. It has precedence over the `source` configuration.                                                                                                                                          |         |                        |
| `uid_wellbore`                                                                                                                                                                                                                                                                                                  | string  | witsml                 |
| This filter can represent either the desired uid\_wellbore or the wildcard `*`, meaning to collect data from all wellbores. It has precedence over the `source` configuration.                                                                                                                                  |         |                        |
| `uid_log`                                                                                                                                                                                                                                                                                                       | string  | witsml                 |
| This filter can represent either the desired uid\_log or the wildcard `*`, meaning to collect data from all logs.                                                                                                                                                                                               |         |                        |
| `name_well`                                                                                                                                                                                                                                                                                                     | string  | witsml                 |
| This field is informative only, and not used on the connection. It can be left blank.                                                                                                                                                                                                                           |         |                        |
| `name_wellbore`                                                                                                                                                                                                                                                                                                 | string  | witsml                 |
| This field is informative only, and not used on the connection. It can be left blank.                                                                                                                                                                                                                           |         |                        |
| `name_log`                                                                                                                                                                                                                                                                                                      | string  | witsml                 |
| This field is informative only, and not used on the connection. It can be left blank.                                                                                                                                                                                                                           |         |                        |
| `index_type`                                                                                                                                                                                                                                                                                                    | string  | witsml                 |
| When a wildcard (`*`) is used for the `uid_log`, this fields restrict the collection for a specific log index type. It is also useful to tell the collector, a priori, not to query by date when a log is depth-indexed, and vice-versa. Possible values are `date time`, `measured depth` or `vertical depth`. |         |                        |
| `query_options`                                                                                                                                                                                                                                                                                                 | string  | witsml, liverig 5.5+   |
| For WITSML, the requests can be made lightweight once metadata information is ommited in responses. That is specially trick for WITSML Log polling. Here you can specify `returnElements=data-only` to make such lightweight requests by default.                                                               |         |                        |
| `mnemonics`                                                                                                                                                                                                                                                                                                     | string  | witsml, opc-da, opc-ua |
| For opc-da and opc-ua, it should be combined with a list provided on the file `store.json`.                                                                                                                                                                                                                     |         |                        |
| `log_delay`                                                                                                                                                                                                                                                                                                     | int     | witsml                 |
| Represents an amount of time that will be subtracted from the `startDateTimeIndex` and `endDateTimeIndex` indexes on each request for data.                                                                                                                                                                     |         |                        |
| `state_path`                                                                                                                                                                                                                                                                                                    | string  |                        |
| The directory where the files related to this request are saved. This is generated automatically by the collector, but can be overriden.                                                                                                                                                                        |         |                        |

### Sources.Source.OpcuaConfig

| Field                                                    | Type                                      | Restricted to |
|----------------------------------------------------------|-------------------------------------------|---------------|
| `security_config`                                        | Sources.Source.OpcuaConfig.SecurityConfig | opc-ua        |
| Defines the security configuration for an OPC-UA source. |                                           |               |

### Sources.Source.OpcuaConfig.SecurityConfig
| Field                                                                                                                                                          | Type   | Restricted to |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|---------------|
| `min_security_mode`                                                                                                                                            | string | opc-ua        |
| The minimun allowed security mode for the connection. Possible values are `None`, `Sign`, and `SignAndEncrypt`                                                 |        |               |
| `max_security_mode`                                                                                                                                            | string | opc-ua        |
| The maximum allowed security mode for the connection. Possible values are `None`, `Sign`, and `SignAndEncrypt`                                                 |        |               |
| `min_security_policy`                                                                                                                                          | string | opc-ua        |
| The minimun allowed security policy for the connection. Possible values are `None`, `Basic128Rsa15`, `Basic256`, `Basic256Sha256`, and `Aes128_Sha256_RsaOaep` |        |               |
| `max_security_policy`                                                                                                                                          | string | opc-ua        |
| The maximum allowed security policy for the connection. Possible values are `None`, `Basic128Rsa15`, `Basic256`, `Basic256Sha256`, and `Aes128_Sha256_RsaOaep` |        |               |

*Important Notes:*
- `None` means no boundary restriction. In this case, the collector will attempt to connect using the most secure configuration supported by the server.
- In case of absence of any security parameter or even the whole `security_config`, the collector will assume the default values, which are those globally configured in its properties. 

### Examples

**WITSML Source**
```xml
<sources>
    <source>
        <name>my connection</name>
        <mode>client</mode>
        <rig_name>my rig</rig_name>
        <service_company>the company</service_company>
        <protocol_name>witsml</protocol_name>
        <protocol_version>1.3.1.1</protocol_version>
        <endpoint>https://the_server:9999/witsml?any_key=any_value&amp;another_key=another_value</endpoint>
        <tls_auth>true</tls_auth>
        <username>witsml</username>
        <password>witsml</password>

        <uid_well>well-1</uid_well>
        <uid_wellbore>wellbore-1</uid_wellbore>

        <requests>
            <request>
                <object>log</object>
                <query_period>10</query_period>
                <uid_log>1111111</uid_log>
            </request>
        </requests>
    </source>
</sources>
```

**OPC-UA Source**
```xml
<sources>
	<source>
		<id>1</id>
		<name>OPC-UA-EXAMPLE</name>
		<enabled>true</enabled>
		<mode>client</mode>
		<rig_name>NS01</rig_name>
		<service_company>intelie</service_company>
		<protocol_name>opcua</protocol_name>
		<protocol_version>0.0.0</protocol_version>
		<endpoint>opc.tcp://theserver:12345/service</endpoint>
		<tls_auth>false</tls_auth>
		<username>user</username>
		<password>password</password>
		<requests>
			<request>
				<id>1</id>
				<object>opcua</object>
				<query_period>2</query_period>
				<state_path>opc-ua/opcua</state_path>
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
</sources>
```
