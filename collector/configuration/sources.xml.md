# sources.xml

This file stores the configuration regarding the connection to all the remote data sources, for any protocol.

### Sources

| Field     | Type                  |
| --------- | --------------------- |
| `sources` | list\<Sources.Source> |

### Sources.Source

| Field                                                                                                                                                                                 | Type                          | Restricted to          |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------- | ---------------------- |
| `name`                                                                                                                                                                                | string                        |                        |
| `enabled`                                                                                                                                                                             | boolean                       |                        |
| `rig_name`                                                                                                                                                                            | string                        |                        |
| `service_company`                                                                                                                                                                     | string                        |                        |
| `protocol_name`                                                                                                                                                                       | string                        |                        |
| The protocol name defines the interpretation of all the other fields. Possible values are `witsml`, `wits`, `opc-da`,`opc-ua`, `csv`, and `raw`.                                      |                               |                        |
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
| `requests`                                                                                                                                                                            | list\<Sources.Source.Request> | witsml                 |

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
| `mnemonics`                                                                                                                                                                                                                                                                                                     | string  | witsml, opc-da, opc-ua |
| For opc-da and opc-ua, it should be combined with a list provided on the file `store.json`.                                                                                                                                                                                                                     |         |                        |
| `log_delay`                                                                                                                                                                                                                                                                                                     | int     | witsml                 |
| Represents an amount of time that will be subtracted from the `startDateTimeIndex` and `endDateTimeIndex` indexes on each request for data.                                                                                                                                                                     |         |                        |
| `state_path`                                                                                                                                                                                                                                                                                                    | string  |                        |
| The directory where the files related to this request are saved. This is generated automatically by the collector, but can be overriden.                                                                                                                                                                        |         |                        |

### Example

```markup
<sources>
    <source>
        <name>my connection</name>
        <mode>client</mode>
        <rig_name>my rig</rig_name>
        <service_company>the company</service_company>
        <protocol_name>witsml</protocol_name>
        <protocol_version>1.3.1.1</protocol_version>
        <endpoint>http://the_server:9999/witsml</endpoint>
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
