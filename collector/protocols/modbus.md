---
description: Based on MODBUS Application Protocol Specification V1.1b3
---

# MODBUS

The MODBUS protocol is capable of receiving data from a PLC (programmable logic controllers) device via TCP connections.

{% hint style="info" %}
This capability is provided by **Liverig Collector 2.28.0** or higher&#x20;
{% endhint %}

There are a number of memory areas defined in the MODBUS specification. Here, are the types of data supported, by the Liverig Collector:

* Coils
  * Discrete Input - Boolean input value, usually representing a binary input to the PLC
  * Coil - Boolean value, usually representing a binary output from the PLC
* Registers
  * Input Register - Short input value, usually representing an analog input to the PLC
  * Holding Register - Short value, usually representing an analog output from the PLC

## Example

The configuration below opens a new connection on port 1552 (default is `502`)

```markup
    <source>
        <name>Modbus TCP</name>
        <enabled>true</enabled>
        <mode>client</mode>
        <rig_name>NS03</rig_name>
        <service_company>intelie</service_company>
        <protocol_name>modbus</protocol_name>
        <protocol_version>1.1b3</protocol_version>
        <endpoint>modbus://127.0.0.1:1552</endpoint>
        <requests>
            <request>
                <revisionWaitingTime>3000</revisionWaitingTime>
                <object>pump-pressure-1</object>
                <query_period>25</query_period>
                <uid_log>1</uid_log>
            </request>
            <request>
                <revisionWaitingTime>3000</revisionWaitingTime>
                <object>water-flow-1</object>
                <query_period>10</query_period>
                <uid_log>2</uid_log>
            </request>
        </requests>
    </source>
```

In this example we have two PLC devices, identified by `<request>` node and the following information must be provided:

| Name                | Description                                                                              | Is required? | Default value |
| ------------------- | ---------------------------------------------------------------------------------------- | ------------ | ------------- |
| revisionWaitingTime | Timeout, in milliseconds, after which a request is terminated.                           | No           | Infinity      |
| object              | Name that will be fetched in `modbus.json` to get more information about the memory area | Yes          |               |
| query\_period       | Interval, in seconds, for the execution of each request                                  | Yes          |               |
| uid\_log            | A number, between 1 and 255, that identifies the target PLC                              | No           | 1             |

To be normalized by Intelie Live, each `<request>` might be mapped on the following JSON format (`modbus.json`).&#x20;

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
