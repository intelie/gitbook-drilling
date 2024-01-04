# /backlog-sync

This feature allows you to create Backlog Sync requests via API.

{% swagger baseUrl="http://environment.com" path="/services/plugin-liverig/collectors/backlog-sync/request?qualifier=qualifier&instance=instance" method="post" summary="/backlog-sync/request" %}
{% swagger-description %}
Create a new request to retrieve historical high-frequency data from WITSML Logs and supports both date time and depth information
{% endswagger-description %}

{% swagger-parameter in="query" name="instance" type="string" %}
Collector instance
{% endswagger-parameter %}

{% swagger-parameter in="query" name="qualifier" type="string" %}
Collector qualifier
{% endswagger-parameter %}

{% swagger-parameter in="body" name="source" type="string" %}
The source name
{% endswagger-parameter %}

{% swagger-parameter in="body" name="rigName" type="integer" %}
The rig name of that source
{% endswagger-parameter %}

{% swagger-parameter in="body" name="wells" type="json" %}
An object representing the logs that will be retrieved from WITSML Store. Example:

```
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
    }
```
{% endswagger-parameter %}

{% swagger-parameter in="body" name="start" type="string" %}
For date time information, the Unix epoch timestamp for the initial startDateTimeindex to be retrieved. 
{% endswagger-parameter %}

{% swagger-parameter in="body" name="end" type="string" %}
For date time information, the Unix epoch timestamp for the last endDateTimeindex to be retrieved. 
{% endswagger-parameter %}

{% swagger-parameter in="body" name="qualifier" type="string" %}
Collector qualifier (yes, unfortunately also in body, known bug)
{% endswagger-parameter %}

{% swagger-parameter in="body" name="instance" type="string" %}
Collector instance (yes, unfortunately also in body, known bug)
{% endswagger-parameter %}

{% swagger-response status="200" description="An UUID that can be used later to monitor the progress of historical task" %}
```
{"success":"02a7533a-fa69-46fc-9441-7592b9b9cb2a"}
```
{% endswagger-response %}
{% endswagger %}


##
