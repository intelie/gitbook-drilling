---
description: Based on MODBUS Application Protocol Specification V1.1b3
---

# MODBUS

{% hint style="info" %}
This capability is provided by **LiveRig Collector 2.28.0** or higher
{% endhint %}

```sh
TODO add missing information for TCP slave addres (_unit_id_)

For PLC4x >= 0.13.0 add extra feature _default-payload-byte-order_
```

The MODBUS protocol is capable of receiving data from a PLC (programmable logic controllers) device via TCP, UDP and Serial connections.

There are a number of memory areas defined in the MODBUS specification. Here, are the types of data supported, by the LiveRig Collector:

* Coils
  * Discrete Input - Boolean input value, usually representing a binary input to the PLC
  * Coil - Boolean value, usually representing a binary output from the PLC
* Registers
  * Input Register - Short input value, usually representing an analog input to the PLC
  * Holding Register - Short value, usually representing an analog output from the PLC

## Configuring the `endpoint` field for Modbus sources

### Serial (Liverig > 5.0.0)

### TCP (Liverig >= 5.0.0)

### UDP (Liverig > 5.0.0)


If you are using a LiveRig version 5.0.0 or above, you can change the connection protocol by declaring the endpoint using the
format: `{code}:{transport}://{ip-address}:{port}?{options}`. Here is a list of options:

- **code**: `modbus-tcp`*(default)*, `modbus-adu`, `modbus-ascii`;
- **transport**: `tcp`*(default)*, `udp`, `serial`;
- **options**: `request-timeout`, `unit-identifier` (This will use the following structure: `?{option-1-name}={option-1-value}&{option-2-name}={option-2-value}`)

The `transport`, `port` and `options` fields are optional. The default port value is `502` and if the `code` value is
just `modbus`, it will default to the `modbus-tcp` value.

**Example TCP Modbus endpoint:**

`modbus-tcp:tcp//127.0.0.1:1552`

**Example Serial Modbus endpoint:**
- For Linux Systems:
  `modbus-adu:serial:/dev/ttyUSB0`
- For Windows Systems:
  `modbus-adu:serial:COM1`

**Note:** *You need to add a special permission to access serial Sources on Linux. This can be done by adding the user to
the `dialout` group using a `sudo usermod -a -G dialout $USER` command.*

### LiveRig Collector previous than 5.0.0
If you are using a LiveRig 4.x or bellow, you cannot change the connection protocol, so the endpoint format must be `modbus://{ip-address}:{port}`

## Example

The configuration below opens a new connection on port 1552 (default is `502`)

```xml
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
|---------------------|------------------------------------------------------------------------------------------|:------------:|---------------|
| revisionWaitingTime | Timeout, in milliseconds, after which a request is terminated.                           |      No      | Infinity      |
| object              | Name that will be fetched in `modbus.json` to get more information about the memory area |     Yes      |               |
| query\_period       | Interval, in seconds, for the execution of each request                                  |     Yes      |               |
| uid\_log            | A number, between 1 and 247, that identifies the target PLC                              |      No      | 1             |

A [modbus.json](./../configuration/modbus.json.md) is also needed to be configured in the collector, so the data can be properly retrieved.