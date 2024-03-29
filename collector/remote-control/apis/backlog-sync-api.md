# /backlog-sync

This feature allows you to create Backlog Sync requests via API.

{% hint style="warning" %}
This endpoint only supports WITSML protocol
{% endhint %}

## Required information

![Identifying the Liverig integration qualifier](../../../.gitbook/assets/collector-source-details/basic-qualifier-and-instance-information.png)

![Identifying the additional collector source details for WITSML protocol](../../../.gitbook/assets/collector-source-details/witsml-source-details.png)

{% swagger baseUrl="http://environment.com" path="/services/plugin-liverig/collectors/backlog-sync/request" method="post" summary="/backlog-sync/request?qualifier=qualifier&instance=instance" %}
{% swagger-description %}
Create a new request to retrieve historical high-frequency data from WITSML Logs and supports both date time and depth information
{% endswagger-description %}

{% swagger-parameter in="query" name="instance" type="string" required="true" %}
Collector instance
{% endswagger-parameter %}

{% swagger-parameter in="query" name="qualifier" type="string" required="true" %}
Collector qualifier
{% endswagger-parameter %}

{% swagger-parameter in="header" name="Content-type" type="string" required="true" %}
application/json
{% endswagger-parameter %}

{% swagger-parameter in="body" name="source" type="string" required="true" %}
The source name
{% endswagger-parameter %}

{% swagger-parameter in="body" name="rigName" type="string" required="true" %}
The rig name of that source
{% endswagger-parameter %}

{% swagger-parameter in="body" name="wells" type="json" required="true" %}
An object representing the logs that will be retrieved from WITSML Store. See examples below.
{% endswagger-parameter %}

{% swagger-parameter in="body" name="start" type="string" %}
ATTENTION: ONLY FOR DATE TIME requests, the Unix epoch timestamp for the initial startDateTimeindex to be retrieved. 
{% endswagger-parameter %}

{% swagger-parameter in="body" name="end" type="string" %}
ATTENTION: ONLY FOR DATE TIME requests, the Unix epoch timestamp for the last endDateTimeindex to be retrieved. 
{% endswagger-parameter %}

{% swagger-parameter in="body" name="depth" type="json" %}
ATTENTION: ONLY FOR DEPTH requests, an inner object containing `start`, `end` and `uom`. 
{% endswagger-parameter %}

{% swagger-parameter in="body" name="qualifier" type="string" %}
Collector qualifier (yes, unfortunately also in body, known bug)
{% endswagger-parameter %}

{% swagger-parameter in="body" name="instance" type="string" %}
Collector instance (yes, unfortunately also in body, known bug)
{% endswagger-parameter %}

{% swagger-response status="200" description="An UUID that can be used later to monitor the progress of historical task" %}
```json
{"success":"02a7533a-fa69-46fc-9441-7592b9b9cb2a"}
```
{% endswagger-response %}
{% endswagger %}

### Examples


#### Body for date time WITSML Logs

- Source name: "Example WITSML server"
- Rig name: "RIG02"
- Date time range: from 01/03/2024 12:00:00 AM to 01/04/2024 12:00:00 AM (UTC-03)
- WITSML Date-time Log UID: "Energistics-w1-wb1-log-0002"
- WITSML Well UID: "Energistics-well-0001"
- WITSML Wellbore UID: "Energistics-w1-wellbore-0001"


```json
{
    "source": "Example WITSML server",
    "rigName": "RIG02",
    "wells": {
        "Energistics-well-0001": {
            "Energistics-w1-wellbore-0001": {
                "logs": [
                    {
                        "uid": "Energistics-w1-wb1-log-0002",
                        "indexType": "date time"
                    }
                ]
            }
        }
    },
    "start": 1704250800000,
    "end": 1704337200000,
    "qualifier": "qualifier",
    "instance": "instance"
}
```

#### Body for depth WITSML Logs

- Source name: "Example WITSML server"
- Rig name: "RIG02"
- Depth range: from 100 meters to 200 meters
- WITSML Depth Log UID: "Energistics-w1-wb1-log-0002"
- WITSML Well UID: "Energistics-well-0001"
- WITSML Wellbore UID: "Energistics-w1-wellbore-0001"

```json
{
    "source": "Example WITSML server",
    "rigName": "RIG02",
    "wells": {
        "Energistics-well-0001": {
            "Energistics-w1-wellbore-0001": {
                "logs": [
                    {
                        "uid": "Energistics-w1-wb1-log-0002",
                        "indexType": "measured depth"
                    }
                ]
            }
        }
    },
    "depth": {
        "start": "100",
        "end": "200",
        "uom": "m"
    },
    "qualifier": "qualifier",
    "instance": "instance"
}
```
