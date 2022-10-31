# getFromStore

This feature allows you to execute a WITSML query via API.

{% swagger method="post" path="" baseUrl="http://environment.com/services/plugin-liverig/collectors/getFromStore?" summary="qualifier=qualifier&instance=instance&sourceName=sourceName&rigName=rigName&type=type" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="path" name="qualifier" required="true" %}
Collector qualifier
{% endswagger-parameter %}

{% swagger-parameter in="path" name="instance" required="true" %}
Collector instance
{% endswagger-parameter %}

{% swagger-parameter in="path" name="soureName" required="true" %}
Collector source name
{% endswagger-parameter %}

{% swagger-parameter in="path" name="rigName" required="true" %}
Collector rig name
{% endswagger-parameter %}

{% swagger-parameter in="path" name="type" required="true" %}
Collector type
{% endswagger-parameter %}

{% swagger-parameter in="body" name="query" required="true" %}
Query to be execute on WITMSL
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="Returns an Object with an “result” short attribute, being “1” a query success and “0” for a query failure, and a “xml” string attribute with the query results." %}
```javascript
{
    // Response
}
```
{% endswagger-response %}
{% endswagger %}
