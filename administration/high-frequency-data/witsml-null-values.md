# WITSML Null Values

This feature allows the user to maintain a list of WITSML values that should be ignored globally by Live. They are applied to every channel, and only to data collected after they are saved.

The values are ignored at the Parser. So, if it is necessary to remove null values in the historical data, it would be necessary to recollect and renormalize.

## Screen

The WITSML Null Values screen allows to user to maintain the Null Values list. It's located under **Configurations** > **High Frequency Data** > **WITSML Null Values**.

![](../../.gitbook/assets/witsml-null-values-configuration.png)

## API

{% hint style="info" %}
Please note that it is necessary to replace the term "environment" with the correct address before using the API.
{% endhint %}

{% swagger baseUrl="https://environment.com" path="/services/plugin-liverig/witsmlparser/nullvalues" method="get" summary="Get WITSML Null Values" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-response status="200" description="Null values successfully retrieved." %}
```
["-999.21", "0."]
```
{% endswagger-response %}
{% endswagger %}

{% swagger baseUrl="https://environment.com" path="/services/plugin-liverig/witsmlparser/nullvalues" method="post" summary="Replace the entire set of WITSML Null Values" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="body" name="" type="array" required="true" %}
The array of null values (as strings). An empty array is accepted.
{% endswagger-parameter %}

{% swagger-parameter in="header" name="Content-type" type="String" required="true" %}
application/json
{% endswagger-parameter %}

{% swagger-response status="204" description="" %}
```
```
{% endswagger-response %}
{% endswagger %}

