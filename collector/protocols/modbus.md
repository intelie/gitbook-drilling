---
description: Based on MODBUS Application Protocol Specification V1.1b3
---

# MODBUS

{% hint style="info" %}
This capability is provided by **LiveRig Collector 2.28.0** or higher
{% endhint %}

**Modbus** is a serial communication protocol developed by the Modicon corporation (now Schneider Electric) in 1979

It is an open communication prototocol to interconnect electronic devices such as:

1 - PLC's (programmable logic controllers)

2 - Sensors

3 - Monitoring equipment

4 - Actuators

5 - IoT devices

6 - Supervising systems


ModBus protocol is able of receiving data from any industrial equipment devices that uses TCP and Serial connections.

## Modbus data

There are a number of memory areas defined in the ModBus specification as described below:

- Discrete Input _(Read Only)_ - Boolean input value, usually representing a binary input to the PLC
- Coils _(Read / Write)_ - Boolean value, usually representing a binary output from the PLC
- Registers
  * Input Register (Read Only) - Short input value, usually representing an input to the PLC
  * Holding Register (Read / Write) - Short value, usually representing an stored input or output

**NOTE**: All memory areas described below is _Read Only_ for Liverig collector

For defined types in memory areas (double, long, integer, boolean ...) check [modbus.json](./../configuration/modbus.json.md) for configuration

## Configuring connection for Modbus sources

**ModBus** in _Liverig_ can be accessed by two kinds of transport (TCP or Serial) and its parameter can be configured as follow:

```
{protocol type}:{transport}://{endpoint:{port}|device}?{options}
```

E.g.
```
modbus-tcp:tcp://192.168.1.112:2000?unit_id=2&tcp.keep-alive=false
```

### ModBus protocol types

Supported ModBus protocol types in Liverig are:

_1 - RTU (Remote Terminal Unit):_ is the most common used

_2 - ModBus ASCII:_ Same as RTU but using ASCII characters to transport data using more space size

_3 - ModBus over TCP/IP:_ Uses TCP/IP to communicate via Ethernet

**Some examples:**

For Liverig > 5.0.0

1- RTU using Serial

```
modbus-rtu:serial://dev/ttyUSB0?unit_id=2&serial.baud-rate=9600&serial.parity=EVEN_PARITY
```

_sources.xml_
```xml
<sources>
    <source>
        <name>Modbus Serial Example 1</name>
        <enabled>true</enabled>
        <mode>client</mode>
        <rig_name>modbus</rig_name>
        <service_company>Your Company</service_company>
        <protocol_name>modbus</protocol_name>
        <protocol_version>1.1b3</protocol_version>
        <endpoint>modbus-rtu:serial://dev/ttyUSB0?unit_id=2&amp;serial.baud-rate=9600&amp;serial.parity=EVEN_PARITY</endpoint>
        ...
    </source>
    ...
</sources>
```

2- RTU using TCP

```
modbus-rtu:tcp://192.168.1.100:502?unit-identifier=5&request-timeout=6000
```

_sources.xml_
```xml
<sources>
    <source>
        <name>Modbus Serial Example 2</name>
        <enabled>true</enabled>
        <mode>client</mode>
        <rig_name>modbus</rig_name>
        <service_company>Your Company</service_company>
        <protocol_name>modbus</protocol_name>
        <protocol_version>1.1b3</protocol_version>
        <endpoint>modbus-rtu:tcp://192.168.1.100:502?unit-identifier=5&amp;request-timeout=6000</endpoint>
        ...
    </source>
    ...
</sources>
```

Liverig works as Master mode to collect Slave data. Slave must be identified by _unit-identifier_ in range from 1 to 247.

### ModBus transport types

Liverig supports different kind of **transport** connection according to its version

**For Liverig 5.0.0**

TCP only format

```
modbus://your-ip-address:{port}?{options}
```

E.g.:

```
modbus://192.168.1.115:502?unit-identifier=10
```

**For Liverig > 5.0.0**

Transport mode available: _tcp_ or _serial_



E.g. TCP modes:


```
modbus-tcp:tcp://192.168.1.115:3000?unit-identifier=10
```

```
modbus-ascii:tcp://192.168.1.115?unit-identifier=10
```

```
modbus-rtu:tcp://192.168.1.115?unit-identifier=10
```

E.g. SERIAL modes:

```
modbus-ascii:serial://dev/ttyUSB1?unit-identifier=10
```

```
modbus-rtu:serial://dev/ttyACM0?unit-identifier=10
```


**Serial modes in different OS examples (Liverig > 5.0.0):**
- For Linux Systems:
  `modbus-rtu:serial:/dev/ttyUSB0`
- For Windows Systems:
  `modbus-rtu:serial:COM1`

Some UNIX system is required permission to access serial connection with devices. This can be done by adding the user to the `dialout` group using a `sudo usermod -a -G dialout $USER` command.

### ModBus options types

Liverig connection string optios is used to setup some extra configuration in ModBus protocol. See tables below:

#### General option table (used both Serial and TCP transports)

| Name | Type | Description | Required | Default value |
|-|-|-|-|-|
| unit-identifier | Integer | Slave device identifier | No | 1 | 
| request-timeout | Integer | Default timeout for all requests  | No | 5000 ms
| ping-address | String | Simple address, that Liverig will use to check connection to device is active | No | 4x00001:BOOL |

#### TCP options table

| Name | Type | Description | Required | Default value |
|-|-|-|-|-|
| tcp.keep-alive | Boolean | Packets to be sent keeping alive? | No | false |
| tcp.no-delay | Boolean | Packets should be sent instantly or should give the OS time to aggregate data? | No | true |


#### SERIAL options table

| Name | Type | Description | Required | Default value |
|-|-|-|-|-|
| serial.baud-rate | Integer | Baud rate in _bps_ of the serial port. Available values are: _9600, 14400, 19200, 38400, 57600, 115200, 128000_ | No | 57600 |
| serial.num-data-bits | Integer | Number of bits to send data. Common values: 7 or 8| No | 8 |
| serial.num-stop-bits | Integer | Number of stop bit to terminate data transport. Typical value are 1 or 2. _NOTE_ 1.5 stop bit is not supported | No | 1 |
| serial.parity | String | Data parity check. Available values are: _NO_PARITY, ODD_PARITY, EVEN_PARITY, MARK_PARITY and SPACE_PARITY_ | No | NO_PARITY |


TODO: Remove texts below

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