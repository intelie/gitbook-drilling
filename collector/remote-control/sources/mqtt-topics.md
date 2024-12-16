# MQTT Requests

When selecting an MQTT source, it is possible to configure the MQTT topics to subscribe and its configuration using the `Topics` tab.
This page allows the user to remotely configure the [mqtt.json file](./../../configuration/mqtt.json.md). 
It is possible to also configure this file manually, for more information, check its page.

![MQTT Topics page](<../../../.gitbook/assets/collector-remote-control-mqtt-topics-1.png>)

The image above shows the `Topics` page for a new source. As shown above there is no configuration present for any topics.
Here is how you can add a new configuration for a specific topic:

### Adding a new topic configuration

First you must click the `New Topic` button on the left side of the screen as shown in the image bellow.

![New Topic Button](<../../../.gitbook/assets/collector-remote-control-mqtt-new-topic-button.png>)

After clicking the `New Topic` button, the right side of the screen should update, as shown in the image bellow.

![New Topic Screen](<../../../.gitbook/assets/collector-remote-control-mqtt-topics-2.png>)

Now you must add the necessary information for the topic subscription. For more information, check the next step.

### Configuring the topic to subscribe

To configure a topic for subscription, you must be on the `About` tab of the `Topic Details` page as shown in the image bellow.

![Topic Configuration](<../../../.gitbook/assets/collector-remote-control-mqtt-topic-configuration.png>)

As shown above, you must specify some values. Here is some information on each field:

| Name                     | Description                                                                                                    | Required |
|--------------------------|----------------------------------------------------------------------------------------------------------------|----------|
| Title                    | The name of this specific configuration. <br>This is used to better organize all topic configurations.</br>    | no       |
| Topic Path               | The topic to subscribe to. <br>This is usually in an `path`-like format.</br>                                  | **yes**  |
| Quality of Service (QoS) | The QoS of the subscription. <br>This will specify how the MQTT broker should validate messages received.</br> | **yes**  |

After specifying the values for the topic configuration, you must configure the wanted transmitted channels from the received MQTT messages.
For more information, check the next step.

### Configuring Channels

To configure a channel, you must be on the `Channels` tab of the `Topic Details` page.

![Channel Configuration Page](<../../../.gitbook/assets/collector-remote-control-mqtt-channel-1.png>)

In this page you can configure the channels to transmit to Live and how its data can be perceived by Live.

Each MQTT message will be parsed into channels based on the attributes received by the broker.
Each channel configuration acts as a filter, only allowing data transmission to Live channels that are configured in this page.

If you don't know how each channel will be transmitted and/or how an MQTT message will be parsed, 
you can use the `Transmit every channel from this topic` toggle.

![Transmit Every Channel Toggle](<../../../.gitbook/assets/collector-remote-control-mqtt-channel-wildcard.png>)

In the `Data Timestamp` field, you can configure how to timestamp the data received by the LiveRig Collector.
You can configure to use the capture moment as the data's timestamp, or, you can set a received channel as the data's timestamp.

![Data Timestamp](<../../../.gitbook/assets/collector-remote-control-mqtt-data-timestamp.png>)

You can configure the channels to transmit and their units using the table.
The list of units of measurement is the same as used by live, so it's possible that some units could be hidden or customized units could be shown through customization of the platform.

![Channel Configuration Table](<../../../.gitbook/assets/collector-remote-control-mqtt-channel-2.png>)

After saving the new topic configuration, it takes some time to the collector to apply those changes.
