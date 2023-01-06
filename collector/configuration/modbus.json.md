For a modbus source to be normalized by Intelie Live, two files are needed to be configured, the [sources.xml](./sources.xml.md) and the `modbus.json`. The specific setting about a modbus source can be found at the [modbus protocol page](./../protocols/modbus.md). Following the example at the modbus protocol page, two `<request>` objects need to be mapped on the following JSON format (`modbus.json`).&#x20;

```javascript
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

Each `controller` represents a device defined in `<request>/<object>`and describe all memory areas that will be fetched. For each memory area (such as `input-register,` `discrete-input`, `coil` or `holding-register`), the following information must be provided:&#x20;

| Name           | Description                                                                                        | Is required? | Default value |
| -------------- | -------------------------------------------------------------------------------------------------- | ------------ | ------------- |
| start\_address | A number, between 1 and 65536. Represents the starting address of the memory area                  | yes          |               |
| count          | Represents the number of registers or coils that will be read sequentially from the start\_address | No           | 0             |
| unit           | The unit of measurement to be used in Intelie Live                                                 | No           |               |
