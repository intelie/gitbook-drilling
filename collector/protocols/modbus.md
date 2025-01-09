---
description: Based on MODBUS Application Protocol Specification V1.1b3
---

# MODBUS

{% hint style="info" %}
This capability is provided by **LiveRig Collector 2.28.0** or higher
{% endhint %}

**Modbus** is a serial communication protocol developed by the Modicon corporation (now Schneider Electric) in 1979

It is an open communication protocol to interconnect electronic devices such as:

1. PLC's (programmable logic controllers)
1. Sensors
1. Monitoring equipment
1. Actuators
1. IoT devices
1. Supervising systems

**ModBus** protocol is able of receiving data from any industrial equipment devices that uses TCP and Serial (RS-232 or RS-485) connections.

## Modbus data

There are a number of memory areas defined in the ModBus specification as described below:

- Discrete Input _(Read Only)_ - Boolean input value, usually representing a binary input to the PLC
- Coils _(Read / Write)_ - Boolean value, usually representing a binary output from the PLC
- Registers
  * Input Register (Read Only) - Short input value, usually representing an input to the PLC
  * Holding Register (Read / Write) - Short value, usually representing an stored input or output

**NOTE**: All memory areas described below is _Read Only_ for LiveRig Collector

For defined types in memory areas (e.g. double, long, integer, boolean) check [modbus.json](./../configuration/modbus.json.md) for configuration.

## Configuring connection for Modbus sources

**ModBus** in LiveRig Collector can be accessed by two kinds of transport (TCP or Serial) and its parameter can be configured as follow:

```
{protocol type}:{transport}://{endpoint:{port}|device}?{options}
```

E.g.
```
modbus-tcp:tcp://192.168.1.112:2000?unit_id=2&tcp.keep-alive=false
```

### ModBus protocol types

Supported ModBus protocol types in LiveRig Collector are:

1 - **RTU (Remote Terminal Unit)**: is the most common used

2 - **ModBus ASCII**: Same as RTU but using ASCII characters to transport data using more space size

3 - **ModBus over TCP/IP**: Uses TCP/IP to communicate through Ethernet

Some examples are demonstrated below:

**RTU using Serial**

```
modbus-rtu:serial://dev/ttyUSB0?unit_id=2&serial.baud-rate=9600&serial.parity=EVEN_PARITY
```

**sources.xml**
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
        <endpoint>modbus-rtu:serial://dev/ttyUSB0?unit_id=2&serial.baud-rate=9600&serial.parity=EVEN_PARITY</endpoint>
        ...
    </source>
    ...
</sources>
```

**RTU using TCP**

```
modbus-rtu:tcp://192.168.1.100:502?unit-identifier=5&request-timeout=6000
```

**sources.xml**
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
        <endpoint>modbus-rtu:tcp://192.168.1.100:502?unit-identifier=5&request-timeout=6000</endpoint>
        ...
    </source>
    ...
</sources>
```

LiveRig Collector works as Master mode to collect Slave data. Slave must be identified by _unit-identifier_ in range from 1 to 247.

### ModBus transport types

LiveRig Collector supports different kind of transport connection. Since 5.0.0, both **tcp** and **serial** transport modes are supported. 

Examples of TCP transport modes:

```
modbus-tcp:tcp://192.168.1.115:3000?unit-identifier=10
```

```
modbus-ascii:tcp://192.168.1.115?unit-identifier=10
```

```
modbus-rtu:tcp://192.168.1.115?unit-identifier=10
```

Examples of SERIAL transport modes:

```
modbus-ascii:serial://dev/ttyUSB1?unit-identifier=10
```

```
modbus-rtu:serial://dev/ttyACM0?unit-identifier=10
```


**Serial modes in different OS examples:**
- For Linux Systems:
  `modbus-rtu:serial:/dev/ttyUSB0`
- For Windows Systems:
  `modbus-rtu:serial:COM1`

Some UNIX system is required permission to access serial connection with devices. This can be done by adding the user to the `dialout` group using a `sudo usermod -a -G dialout $USER` command.

### ModBus options types

The connection string options are used to setup some extra configuration in ModBus protocol. See tables below:

#### General option table (used both Serial and TCP transports)

| Name | Type | Description | Required | Default value |
|-|-|-|-|-|
| unit-identifier | Integer | Slave device identifier | No | 1 | 
| request-timeout | Integer | Default timeout for all requests in milliseconds | No | 5000 ms
| ping-address | String | Simple address, that Liverig will use to check connection to device is active | No | 4x00001:BOOL |

#### TCP options table

| Name | Type | Description | Required | Default value |
|-|-|-|-|-|
| port | Integer | ModBus TCP port | No | 502 |
| tcp.keep-alive | Boolean | Packets to be sent keeping alive? | No | false |
| tcp.no-delay | Boolean | Packets should be sent instantly or should give the OS time to aggregate data? | No | true |


#### SERIAL options table

| Name | Type | Description | Required | Default value |
|-|-|-|-|-|
| serial.baud-rate | Integer | Baud rate in _bps_ of the serial port. Available values are: _9600, 14400, 19200, 38400, 57600, 115200, 128000_ | No | 57600 |
| serial.num-data-bits | Integer | Number of bits to send data. Common values: 7 or 8| No | 8 |
| serial.num-stop-bits | Integer | Number of stop bit to terminate data transport. Typical value are 1 or 2. **NOTE**: 1.5 stop bit is not supported | No | 1 |
| serial.parity | String | Data parity check. Available values are: _NO_PARITY, ODD_PARITY, EVEN_PARITY, MARK_PARITY and SPACE_PARITY_ | No | NO_PARITY |

## Collecting data in ModBus

LiveRig Collector works as Master in ModBus to collect data thus `sources.xml` and [modbus.json](./../configuration/modbus.json.md) must be configured to collect typed values. 


Parameters in `sources.xml`
| Name                | Description                                                                              | Is required? | Default value |
|---------------------|------------------------------------------------------------------------------------------|:------------:|---------------|
| revisionWaitingTime | Timeout, in milliseconds, after which a request is terminated.                           |      No      | Infinity      |
| object              | Name that will be fetched in [modbus.json](./../configuration/modbus.json.md) |     Yes      |               |
| query\_period       | Interval, in seconds, for the execution of each request                                  |     Yes      |               |
| uid\_log            | A number, between 1 and 247, that identifies the target PLC                              |      No      | 1             |


### Example

The configuration below opens a new connection on port 1552


**sources.xml**

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

**modbus.json**

```json
{
  "version": "2.0",
  "controllers": {
    "pump-pressure-1": [
      {
        "type": "input-register",
        "start_address": 2,
        "dataType": "float",
        "count": 3,
        "unit": "psi",
        "alias": ["rotary_pump_pressure", "rotation_max_pressure", "hold_back_pressure"]
      },
      {
        "type": "discrete-input",
        "start_address": 4,
        "dataType": "float",
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
        "start_address": 2,
        "dataType": "float",
        "unit": "m3"
      },
      {
        "type": "coil",
        "start_address": 3
      }
    ]
  }
}
```

## Compatibility for LiveRig Collector prior to 5.x

ModBus support for LiveRig Collector prior to 5.0.0 **is limited to TCP transport only**.

The connection string was slightly different as demonstrated below:

```
modbus://your-ip-address:{port}?{options}
```

E.g.:

```
modbus://192.168.1.115:502?unit-identifier=10
```
