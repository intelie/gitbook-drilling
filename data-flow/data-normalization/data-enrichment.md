# Data indexes and enrichment

Depending on the context, some metadata is added to the normalized events, as shown below.

## Time-based sources

If the data is received from a source that provides the original date of each measurement, such as time-based WITSML logs, OPC or WITS, the fields `index_timestamp` and `adjusted_index_timestamp` will be added to each event.

The field `adjusted_index_timestamp` should be used by default to plot data from those sources.

For time-based WITSML logs, the value `index_type` will be `date time`.

|                                                                                                                                                                         |   |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- | - |
| `timestamp`                                                                                                                                                             |   |
| is added by Live itself on every event, at the moment the event is received by Live.                                                                                    |   |
| `liverig__index__timestamp`                                                                                                                                             |   |
| is the value for the index curve (`indexCurve`) when it’s a `date time` curve (when it’s a depth curve, the value is instead at `liverig__index`).                      |   |
| `liverig__metadata->timestamp_adjustment`                                                                                                                               |   |
| is not a timestamp, it’s a calculated adjustment which should be added to the source timestamp (`liverig__index__timestamp`) to correct for clock errors at the source. |   |
| `liverig__metadata->capture_timestamp`                                                                                                                                  |   |
| is when the collector received the data from the source.                                                                                                                |   |
| `liverig__metadata->capture_start_timestamp`                                                                                                                            |   |
| is when the collector requested the data from the source.                                                                                                               |   |
| `liverig__metadata->remoteTimestamp`                                                                                                                                    |   |
| is the clock in the collector when it sent the packet with the data to Live.                                                                                            |   |
| `liverig__metadata->localTimestamp`                                                                                                                                     |   |
| is the clock in Live when it received the packet with the data from the collector.                                                                                      |   |

{% hint style="info" %}
In summary, the `adjusted_index_timestamp` on the normalized events is equivalent to `liverig__index__timestamp# + liverig__metadata->timestamp_adjustment#` on the raw events.
{% endhint %}

## Depth-based sources

If the data is received from depth-based sources, such as a depth-based WITSML log, then the fields `depth_value`, `depth_uom` (both relate to the normalized depth), `index_uom`, `index_value`, and `index_mnemonic` will be added to each event.

The field `depth_value` should be used by default to plot data from those sources.

In the WITSML case, the value of `index_type` will be either `measured depth` or `vertical depth`.

![Example of data normalized from a depth-based WITSML log](<../../.gitbook/assets/image (489).png>)

The unit of measurement used for the depth values can be configured on the `Additional Features` area, as the image below shows. This configuration affects the `index_value`, which is the value received from the data sources, and the `depth_value`, which is the value enriched by Intelie Live based on the `Depth channel` configuration.

![Example of selection of the depth unit of measurement](<../../.gitbook/assets/image (265).png>)

{% hint style="info" %}
The `depth_value` can be enriched for time-based sources using the property `depth mnemonic` on each asset normalization configuration.
{% endhint %}
