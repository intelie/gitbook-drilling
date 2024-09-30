---
description: Integration to expose your local and aggregated data as WITSML objects
---

# WITSML Output

{% hint style="info" %}
WITSML Output is still delivered built-in in the Wells plugin but it is deprecated. For a more complete bundle check out [WITSML Store](../integrations/witsml-store.md).
{% endhint %}

{% hint style="warning" %}
Another codebase containing improvements was launched as another plugin called Generic WITSML Output at [https://marketplace.intelie.com/artifact/plugin-generic-witsml-output](https://marketplace.intelie.com/artifact/plugin-generic-witsml-output/) but is not being actively developed.
{% endhint %}

<div align="left">

<figure><img src="../.gitbook/assets/image (157).png" alt=""><figcaption><p>Integration built-in in standard Wells plugin up to v5 series</p></figcaption></figure>

 

<figure><img src="../.gitbook/assets/image (357).png" alt=""><figcaption><p>Identifying the plugin which delivers the integration type</p></figcaption></figure>

</div>

### Characteristics

* Provides a secure WITSML store server using SOAP protocol in Intelie Live
* WITSML 1.3.1.1 and 1.4.1.1. available&#x20;
* GetFromStore function to list:
  * well, wellbore, log, message, tubular, wbGeometry, mudLog, and trajectory objects
* Pipes query filters(see [pipes filters documentation](https://pipes.intelie.com/docs/0.24/#chapter-quickstart)). There are a lot of possibilities using pipes query to filter objects.&#x20;
  * Some examples
    * for specific objects
    * for merge objects by type
    * for filtered indexes in a specific period of time or range
* Raw objects
  * log
  * message
  * trajectory
  * tubular
  * wbGeometry
  * mudLog
* Normalized artificial objects
  * log
    * based:
      * date time or measured depth indexes
      * selected mnemonics(defined in Channels Management functionality)
* Independent authentication from Intelie Live with multiple users

This configuration follows the following model below:

```javascript
{
  "endpoint": "<enpoint_url>",
  "event_limit": 1000,
  "enableForOutput": true,
  "timestamp_mode": "adjusted",
  "wells": [
    {
      "name": "well name 1",
      "wellbores": [
        {
          "name": "wellbore 1",
          "objects": [
            {
              "type": "type",
              "dataType": "dataType",
              "name": "name",
              "eventType": "eventType",
              "filter": "filter",
              "curveMap": {
                "curve 1": "",
                "curve 2": "renamed curve 2"
              },
              "includeExtra": true,
              "allChannels": false
            },
            ...
          ]
        },
        ...
      ]
    }
  ]
}
```

#### Main Parameters

| Parameters      | Description                                            | Required | Type            | Default Value | Possible Values                  |
| --------------- | ------------------------------------------------------ | -------- | --------------- | ------------- | -------------------------------- |
| endpoint        | the endpoint URL that will be provided in Intelie Live | yes      | string          |               | `http://127.0.0.1:<port>/<path>` |
| event\_limit    | number of max events used  for this pipes query        | no       | positive number | 100.000       |                                  |
| timestamp\_mode | timestamp source for curves                            | yes      | string          |               | source, adjusted, capture, live  |

{% hint style="info" %}
Timestamp Mode values

* source - timestamp comes from WITSML data source
* adjusted - timestamp comes from WITSML data source plus adjustment from capture
* capture - timestamp comes from capture server(liverig-collector)
* live - timestamp comes from live events.
{% endhint %}

#### Object Parameters

| Parameters   | Description                                                                 | Required             | Type    | Default Value | Possible Values                                                                                                                                        |
| ------------ | --------------------------------------------------------------------------- | -------------------- | ------- | ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------ |
| type         | witsml object type                                                          | yes                  | string  |               | log, trajectory, message                                                                                                                               |
| dataType     | the specific data type                                                      | yes                  | string  |               | raw, normalized                                                                                                                                        |
| name         | the witsml object name. The uid will be generated using this name.          | yes                  | string  |               | \*                                                                                                                                                     |
| eventType    | the same event represented by a rig or well.                                | yes                  | string  |               | \*                                                                                                                                                     |
| filter       | pipes filter used to a specific object                                      | no                   | string  |               | `liverig__object->uid:log-uid-1`                                                                                                                       |
| indexType    | the object index type(useful for log objects)                               | only for log objects | string  |               | date time, measured depth, vertical depth                                                                                                              |
| includeExtra | includes extra info when necessary                                          | no                   | boolean | false         | true, false                                                                                                                                            |
| curveMap     | filtered curves that will be showed. It is possible to change channel name. | no                   | json    |               | <p><code>{</code> </p><p><code>"MDIA": "",</code> </p><p><code>"MTIA": "",                     "MTOA": "MTOA_Renamed"</code> </p><p><code>}</code></p> |
| allChannels  | useful to show all channels                                                 | no                   | boolean | true          | true, false                                                                                                                                            |

#### Complete WITSML data output example

```javascript
{
  "endpoint": "http://127.0.0.1:9990/witsml/intelie",
  "event_limit": 1000,
  "enableForOutput": true,
  "timestamp_mode": "adjusted",
  "wells": [
    {
      "name": "well 1",
      "wellbores": [
        {
          "name": "wellbore 1",
          "objects": [
            {
              "type": "trajectory",
              "dataType": "raw",
              "name": "ns01 Raw Trajectory Object",
              "eventType": "raw_ns01",
              "filter": "liverig__object->object:trajectory"
            },
            {
              "type": "log",
              "dataType": "raw",
              "name": "NS01 Raw Log Object",
              "eventType": "raw_ns01",
              "filter": "liverig__object->name:log-name-1"
            },
            {
              "type": "log",
              "dataType": "normalized",
              "name": "NS01 Normalized Log Object",
              "eventType": "ns01",
              "filter": "index_type:\"measured depth\"",
              "indexType": "measured depth",
              "includeExtra": true
            },
            {
              "type": "log",
              "dataType": "normalized",
              "name": "NS01 Normalized Filtered Log Object",
              "eventType": "ns01",
              "indexType": "measured depth",
              "includeExtra": false,
              "curveMap": {
                "MDIA": "",
                "MFIA": "",
                "MFOA": "",
                "MFOP": "",
                "MTIA": "",
                "MTOA": "MTOA Renamed"
              },
              "allChannels": false
            },
            {
              "type": "log",
              "dataType": "normalized",
              "name": "NS01 Normalized Vertical Depth Filtered Log Object",
              "eventType": "ns01",
              "filter": "liverig__object->name:log-name-1"
              "indexType": "vertical depth",
              "includeExtra": true,
              "curveMap": {
                "MDIA": "",
                "MFIA": "MFIA Renamed"
              },
              "allChannels": false
            }
          ]
        },
        {
          "name": "wellbore 2",
          "objects": [
            {
              "type": "trajectory",
              "dataType": "raw",
              "name": "NS02 from ns01 Raw Trajectory Object",
              "eventType": "raw_ns01"
            },
            {
              "type": "log",
              "dataType": "normalized",
              "name": "NS01 Normalized Log Object",
              "eventType": "ns01"
            },
            {
              "type": "log",
              "dataType": "normalized",
              "name": "NS01 Extra Normalized Filtered Log Object",
              "eventType": "ns01"
              "curveMap": {
                "Blender Asset ID": "",
                "BLENDER AUGER 2 RPM": "",
                "BLENDER AUGER 4 RPM": "BA4RPM Extra"
              },
              "includeExtra": true,
              "allChannels": false
            },
            {
              "type": "log",
              "dataType": "normalized",
              "name": "NS01 Normalized Filtered Log Object",
              "eventType": "ns01"
              "curveMap": {
                "Blender Asset ID": "",
                "BLENDER AUGER 2 RPM": "",
                "BLENDER AUGER 4 RPM": "BA4RPM"
              },
              "includeExtra": false,
              "allChannels": false
            },
            {
              "type": "log",
              "dataType": "normalized",
              "name": "NS01 Measured Depth Normalized Log Object",
              "eventType": "ns02",
              "indexType": "measured depth"
            }
          ]
        }
      ]
    },
    {
      "event_type": "ns01",
      "name": "well 2"
    }
  ],
  "users": {},
  "anonymous": true
}
```
