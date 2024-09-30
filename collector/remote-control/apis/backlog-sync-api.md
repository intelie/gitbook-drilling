# /backlog-sync

This feature allows you to create Backlog Sync requests via API.

{% hint style="warning" %}
This endpoint only supports WITSML protocol
{% endhint %}

## Required information

![Identifying the Liverig integration qualifier](../../../.gitbook/assets/basic-qualifier-and-instance-information.png)

![Identifying the additional collector source details for WITSML protocol](../../../.gitbook/assets/witsml-source-details.png)

## /backlog-sync/request?qualifier=qualifier\&instance=instance

<mark style="color:green;">`POST`</mark> `http://environment.com/services/plugin-liverig/collectors/backlog-sync/request`

Create a new request to retrieve historical high-frequency data from WITSML Logs and supports both date time and depth information

#### Query Parameters

| Name                                        | Type   | Description         |
| ------------------------------------------- | ------ | ------------------- |
| instance<mark style="color:red;">\*</mark>  | string | Collector instance  |
| qualifier<mark style="color:red;">\*</mark> | string | Collector qualifier |

#### Headers

| Name                                           | Type   | Description      |
| ---------------------------------------------- | ------ | ---------------- |
| Content-type<mark style="color:red;">\*</mark> | string | application/json |

#### Request Body

| Name                                      | Type   | Description                                                                                                          |
| ----------------------------------------- | ------ | -------------------------------------------------------------------------------------------------------------------- |
| source<mark style="color:red;">\*</mark>  | string | The source name                                                                                                      |
| rigName<mark style="color:red;">\*</mark> | string | The rig name of that source                                                                                          |
| wells<mark style="color:red;">\*</mark>   | json   | An object representing the logs that will be retrieved from WITSML Store. See examples below.                        |
| start                                     | string | ATTENTION: ONLY FOR DATE TIME requests, the Unix epoch timestamp for the initial startDateTimeindex to be retrieved. |
| end                                       | string | ATTENTION: ONLY FOR DATE TIME requests, the Unix epoch timestamp for the last endDateTimeindex to be retrieved.      |
| depth                                     | json   | ATTENTION: ONLY FOR DEPTH requests, an inner object containing `start`, `end` and `uom`.                             |
| qualifier                                 | string | Collector qualifier (yes, unfortunately also in body, known bug)                                                     |
| instance                                  | string | Collector instance (yes, unfortunately also in body, known bug)                                                      |

{% tabs %}
{% tab title="200 An UUID that can be used later to monitor the progress of historical task" %}
```json
{"success":"02a7533a-fa69-46fc-9441-7592b9b9cb2a"}
```
{% endtab %}
{% endtabs %}

### Examples

#### Body for date time WITSML Logs

* Source name: "Example WITSML server"
* Rig name: "RIG02"
* Date time range: from 01/03/2024 12:00:00 AM to 01/04/2024 12:00:00 AM (UTC-03)
* WITSML Date-time Log UID: "Energistics-w1-wb1-log-0002"
* WITSML Well UID: "Energistics-well-0001"
* WITSML Wellbore UID: "Energistics-w1-wellbore-0001"

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

* Source name: "Example WITSML server"
* Rig name: "RIG02"
* Depth range: from 100 meters to 200 meters
* WITSML Depth Log UID: "Energistics-w1-wb1-log-0002"
* WITSML Well UID: "Energistics-well-0001"
* WITSML Wellbore UID: "Energistics-w1-wellbore-0001"

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
