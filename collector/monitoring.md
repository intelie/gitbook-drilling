# Monitoring

On Intelie Live `Collectors` tab, it is possible to get an overview of all the active collectors and drill down to troubleshoot any issue regarding data collection and transmission.

The interface provides information regarding data availabilty and quality, transmission and compression rates, SSL/TLS status, and many other information about the health of the collectors.

![](<../.gitbook/assets/image (297).png>)

**Sources Status**

The sources using WITSML protocol for data transmission are clickable and Intelie Live provides more details of the source in a modal. When source is a server, basic information is displayed.

When source has mode client, Intelie Live will display basic source information, requests in execution, requests configured and information available in the WITSML server can be requested.

![Modal for sources with mode client (Available only for WITSML) - Configurations](<../.gitbook/assets/image (19).png>)

![Modal for sources with mode client (Available only for WITSML) - Requests](<../.gitbook/assets/image (391).png>)

### The `internal` event

Once per minute, every collector generates an event with many statistics associated to its health and the health of the sources of data. The events provided by different collectors are used by Intelie Live as a heartbeat, and provide a full view of the collectors infrastructure.

![\`internal\` event shown at the console](<../.gitbook/assets/image (462).png>)

The fields contained on this type of event are detailed below.

| Field                                                                                                                                                         | Type    | Since  |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------- | ------ |
| `freeMemory`                                                                                                                                                  | long    |        |
| The amount of free memory in the Java Virtual Machine.                                                                                                        |         |        |
| `totalMemory`                                                                                                                                                 | long    |        |
| The total amount of memory in the Java virtual machine.                                                                                                       |         |        |
| `maxMemory`                                                                                                                                                   | long    |        |
| The maximum amount of memory that the Java virtual machine will attempt to use.                                                                               |         |        |
| `storageUsedEvents`                                                                                                                                           | long    |        |
| Number of events stored for possible retransmission.                                                                                                          |         |        |
| `storageUsedBytes`                                                                                                                                            | long    |        |
| Size of events stored for possible retransmission.                                                                                                            |         |        |
| `receivedBytesControl`                                                                                                                                        | long    |        |
| Number of bytes received by the collector on the control channel.                                                                                             |         |        |
| `receivedBytesRealtime`                                                                                                                                       | long    |        |
| Number of bytes received by the collector on the realtime channel, after compression.                                                                         |         |        |
| `receivedBytesResent`                                                                                                                                         | long    |        |
| Number of bytes received by the collector on the retransmission channel, after compression.                                                                   |         |        |
| `receivedBytesRemoteControl`                                                                                                                                  | long    |        |
| Number of bytes received by the collector on the remote control channel, after compression.                                                                   |         |        |
| `sentBytesControl`                                                                                                                                            | long    |        |
| Number of bytes sent by the collector on the control channel.                                                                                                 |         |        |
| `sentBytesRealtime`                                                                                                                                           | long    |        |
| Number of bytes sent by the collector on the realtime channel, after compression.                                                                             |         |        |
| `sentBytesResent`                                                                                                                                             | long    |        |
| Number of bytes sent by the collector on the retransmission channel, after compression.                                                                       |         |        |
| `sentBytesRemoteControl`                                                                                                                                      | long    |        |
| Number of bytes sent by the collector on the remote control channel, after compression.                                                                       |         |        |
| `receivedBytesCompressed`                                                                                                                                     | long    |        |
| Number of bytes received by the collector before decompression.                                                                                               |         |        |
| `receivedBytesUncompressed`                                                                                                                                   | long    |        |
| Number of bytes received by the collector after decompression.                                                                                                |         |        |
| `sentBytesCompressed`                                                                                                                                         | long    |        |
| Number of bytes sent by the collector after compression.                                                                                                      |         |        |
| `sentBytesUncompressed`                                                                                                                                       | long    |        |
| Number of bytes sent by the collector before compression.                                                                                                     |         |        |
| `protocolErrors`                                                                                                                                              | long    |        |
| Number of protocol errors such as invalid stream, invalid command or data framing errors.                                                                     |         |        |
| `secure`                                                                                                                                                      | boolean | 2.18.0 |
| Whether the connection is using the built-in cryptography.                                                                                                    |         |        |
| `drops`                                                                                                                                                       | map     |        |
| Number of answers rejected by the data sources.                                                                                                               |         |        |
| `config`                                                                                                                                                      | map     |        |
| The configuration that is provided by the `sources.xml` file.                                                                                                 |         |        |
| `runningConfig`                                                                                                                                               | map     |        |
| The configuration that is actually being executed. This can be different of the `config` field due to either inactive datasources or wildcard configurations. |         |        |
| `system.ntp`                                                                                                                                                  | map     |        |
| Information about the NTP state of the host machine, if available.                                                                                            |         |        |
| `system.disk`                                                                                                                                                 | map     | 2.14.2 |
| Information about the local disks state, if available.                                                                                                        |         |        |

{% hint style="info" %}
All the counters, such as bytes and received, errors, and drops, reset every time the collector is restarted.
{% endhint %}

{% hint style="info" %}
The bytes transferred on the control channel are not compressed, since this is the channel that negotiates the compression.
{% endhint %}
