For a Modbus data be ingested by LiveRig Collector and forward to INTELIE Live, two files must be configured: [sources.xml](./sources.xml.md) and `modbus.json`. This page will explain the INTELIE JSON schema for the `modbus.json` LiveRig Collector configuration.

The specific documentation about the Modbus source is provided at the [modbus protocol page](./../protocols/modbus.md). Following the example at that Modbus protocol page, two `<request>` objects depends on additional controller mapping as the following JSON format (`modbus.json`) describes below.

```json
{
  "version": "2.0",
  "controllers": {
    "pump-pressure-1": [
      {
        "type": "input-register",
        "start_address": 1,
        "count": 3,
        "unit": "bar",
        "alias": ["rotary_pump_pressure", "rotation_max_pressure", "hold_back_pressure"]
      },
      {
        "type": "discrete-input",
        "start_address": 5,
        "count": 2,
        "alias": ["water_pressure"]
      },
      {
        "type": "coil",
        "start_address": 10
      }
    ],
    "water-flow-1": [
      {
        "type": "holding-register",
        "start_address": 1,
        "unit": "ft3/d",
        "dataType": "uint16"
      },
      {
        "type": "coil",
        "start_address": 3
      }
    ]
  }
}
```

Each controller in the field `controllers` represents a device defined on [sources.xml](./sources.xml.md) at `<request>/<object>` and it describes all
memory areas that will be fetched. Each memory area has the following fields:

| Name          | Description                                                                                                                                                                                                                                                                                    | Is required? | Default value                                                                                                                         |
|---------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:------------:|---------------------------------------------------------------------------------------------------------------------------------------|
| type          | The modbus register type to be fetched. This can be `input-register`, `holding-register`, `discrete-input` and `coil`                                                                                                                                                                          |     Yes      | -                                                                                                                                     |   
| start_address | A number, between 1 and 65536. Represents the starting address of the memory area. <br> **NOTE:** *the end device could have address mapping differences. For example: returning the value for address 99 when we declared address 100. Please check if it is the case and adjust accordingly.* |     Yes      | -                                                                                                                                     |   
| count         | Represents the number of registers or coils that will be read sequentially from the start_address.                                                                                                                                                                                             |      No      | 1                                                                                                                                     |  
| unit          | The unit of measurement to be used by Intelie Live                                                                                                                                                                                                                                             |      No      | -                                                                                                                                     |
| alias         | A rename for the channel when sent to Intelie Live. *See more info below*                                                                                                                                                                                                                      |      No      | The default channel name uses the format `{type}_{address}`                                                                           |
| dataType      | The data type to parse the values returned by the Modbus source. *See more info below*                                                                                                                                                                                                         |      No      | If the register type is `coil` or `discrete-input`, the default dataType will be `boolean`. Otherwise the default dataType is `int16` |

### Data Types

The `dataType` field from the `modbus.json` file can have the following options on the `modbus.json` file:

- Single Register:
    - `boolean` (1 bit)
    - `int8` (8 bits)
    - `uint8` (8 bits)
    - `byte` (8 bits)
    - `int16` (16 bits)
    - `uint16` (16 bits)
    - `word` (16 bits)
    - `char` (8 bits)
    - `wchar` (16 bits)

- Double Register (32 bits):
    - `int32`
    - `uint32`
    - `float`
    - `word32`

- Quadruple Register (64 bits):
    - `int64`
    - `uint64`
    - `double`
    - `word64`

Using a data type that requires more than 1 register will disable the `count` feature declared at the `modbus.json`
file.

You don't need to declare a count if using Multi-register data types, we will assume it is always the next address.
Example:
If the dataType is `int32` and the `start_address` is `123`, the LiveRig Collector will fetch the values from
addresses `123` and `124` to form the `int32` (long) value.

## Aliases

The `alias` field from the `modbus.json` file is an array of strings. That means that you can allocate more than 1 alias
to a memory area.
If that is the case the alias will be applied by the following rule:
For each address fetched by the memory area, we will apply the alias from the list using the order of both.

**Example 1:**
*If a memory area has a `start_address` set as `123` and a `count` set as `3`, the end result will be values from
addresses `123`, `124` and `125`. If the `alias` field has just the value `["exampeAlias"]`, then the LiveRig Collector
will map `exampeAlias_123` to address `123`, `exampeAlias_124` to address `124` and `exampeAlias_125` to address `125`.*

**Example 2:**
*If a memory area has a `start_address` set as `123` and a `count` set as `3`, the end result will be values from
addresses `123`, `124` and `125`. If the `alias` field has the value `["exampleAlias1", "exampleAlias2", "exampleAlias3"
]`, then the LiveRig Collector will map `exampleAlias1` to address `123`, `exampleAlias2` to address `124` and
`exampleAlias3` to address `125`.*

**Example 3:**
*If a memory area has a `start_address` set as `123` and a `count` set as `3`, the end result will be values from
addresses `123`, `124` and `125`. If the `alias` field has the value `["exampleAlias1", "exampleAlias2", "exampleAlias3"
, "exampleAlias4"]`, then the LiveRig Collector will map `exampeAlias_123` to address `123`, `exampeAlias_124` to
address `124` and `exampeAlias_125` to address `125`. The `exampleAlias4` will not be used as a channel rename.*

**NOTE:**
If there is fewer aliases than the address count (the alias list has a size of `2` and the count of addresses is `4`),
the
LiveRig Collector will raise an exception, since it won't know how to map the aliases to each address.

## Compatibility for LiveRig Collector prior to 5.x

Prior to 5.0.0, the INTELIE `modbus.json` format was not able to support the configuration of multiple coin, input-register or discrete-input for a same controller.

The ancient JSON schema for those deprecated versions is demonstrated bellow just for historical reference. Please consider to upgrade any LiveRig Collector to the most recent version.

```json
{
  "controllers": {
    "pump-pressure-1": {
      "input-register" : {
        "start_address": 0,
        "count": 3,
        "unit": "bar"
      },
      "discrete-input": {
        "start_address": 5,
        "count": 2,
        "unit": "psi"
      },
      "coil": {
        "start_address": 10
      }
    },
    "water-flow-1": {
      "holding-register" : {
        "start_address": 0,
        "unit": "ft3/d"
      },
      "coil": {
        "start_address": 3
      }
    }
  }
}
```

Each `controller` represents a device defined on [sources.xml](./sources.xml.md) at `<request>/<object>` and describe all memory areas that will be fetched. For each memory area (such as `input-register,` `discrete-input`, `coil` or `holding-register`), the following information must be provided:

| Name           | Description                                                                                        | Is required? | Default value |
|----------------|----------------------------------------------------------------------------------------------------|--------------|---------------|
| start\_address | A number, between 1 and 65536. Represents the starting address of the memory area                  | yes          |               |
| count          | Represents the number of registers or coils that will be read sequentially from the start\_address | No           | 0             |
| unit           | The unit of measurement to be used in Intelie Live                                                 | No           |               |