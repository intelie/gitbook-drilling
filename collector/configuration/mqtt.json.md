The `mqtt.json` file is used by LiveRig Collector to organize the Topic configurations to be read from the sources configured at `sources.xml`.

The LiveRig Collector depends on the Topic values, among other information, to subscribe to an MQTT Topic properly. These values are mapped in the following JSON format, as below:

```json
{
  "rigs": {
    "MQTT-Rig": [
      {
        "name": "pump",
        "topic": "test/+/pump",
        "qos": 0,
        "timestampChannel": "Time",
        "units": [
          {
            "channel": "MotorSpeed",
            "unit": "rpm"
          },
          {
            "channel": "ChemicalRate",
            "unit": "gpm"
          },
          {
            "channel": "MotorCurrent",
            "unit": "A"
          },
          {
            "channel": "MotorSpeed",
            "unit": "rpm"
          },
          {
            "channel": "MotorTorque",
            "unit": "ft-lbs"
          },
          {
            "channel": "MotorVoltage",
            "unit": "V"
          },
          {
            "channel": "Time"
          }
        ]
      },
      {
        "name": "wildcard",
        "topic": "test/temperature",
        "qos": 1,
        "units": [
          {
            "channel": "*"
          }
        ]
      }
    ]
  }
}
```

The object array under `rigs` is related to an **MQTT** source, linking the `mqtt.json` and `sources.xml` files through their **Rig Name**. 

Each object from the object array is a Topic configuration, and it follows the format bellow:

| Name             | Description                                         | Required | Default value |
|------------------|-----------------------------------------------------|----------|---------------|
| name             | An identifier for this Topic configuration.         | no       |               |
| topic            | The topic name to subscribe.                        | **yes**  |               |
| qos              | The QoS for the subscription.                       | **yes**  | 0             |
| timestampChannel | A channel to use its value as the data's timestamp. | no       |               |
| units            | A list of unit configurations.                      | **yes**  |               |

The `units` object array follows the format bellow:

| Name             | Description                                           | Required |
|------------------|-------------------------------------------------------|----------|
| channel          | The channel generated from the received MQTT message. | **yes**  |
| unit             | The UoM to associate with the channel value.          | no       |

**Note**: The unit mapping works as a **filter**. Only channels declared in the `mqtt.json` file will have its data transmitted to Live.

As shown in the `json` example above, one viable configuration for a channel is the wildcard symbol (`*`).
This will output all channels generated from the MQTT message received.

{% hint style="info" %}
Instead of manually configuring this file, is also possible to use the remote control page [MQTT Topics](./../remote-control/sources/mqtt-topics.md) to change the settings easily.
{% endhint %}