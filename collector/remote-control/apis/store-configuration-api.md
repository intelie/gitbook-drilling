# /storeConfiguration

This feature allows you to add or edit a store.json file via API. We can view the calls created and how you use them.\


{% swagger baseUrl="http://environment.com" path="/services/plugin-liverig/collectors/storeConfiguration" method="get" summary="?qualifier=qualifier&instance=instance&force=true" %}
{% swagger-description %}
View the store.json file
{% endswagger-description %}

{% swagger-parameter in="query" name="instance" type="string" required="true" %}
Collector instance
{% endswagger-parameter %}

{% swagger-parameter in="query" name="qualifier" type="string" required="true" %}
Collector qualifier
{% endswagger-parameter %}

{% swagger-parameter in="query" name="force" type="boolean" %}
In case of `true`, it will ignore the caching and it will re-read the store configuration from the collector at remote site.
{% endswagger-parameter %}

{% swagger-response status="200" description="" %}
```
```
{% endswagger-response %}
{% endswagger %}

{% swagger baseUrl="http://environment.com" path="/services/plugin-liverig/collectors/storeConfiguration" method="post" summary="?qualifier=qualifiers&instance=instance&force=true" %}
{% swagger-description %}
Add or edit the store.json file
{% endswagger-description %}

{% swagger-parameter in="query" name="qualifier" type="string" required="true" %}
Collector qualifier
{% endswagger-parameter %}

{% swagger-parameter in="query" name="instance" type="string" required="true" %}
Collector instance
{% endswagger-parameter %}

{% swagger-parameter in="query" name="force" type="boolean" %}
In case of `true`, it will ignore the caching and it will re-read the store configuration from the collector at remote site.
{% endswagger-parameter %}

{% swagger-parameter in="body" name="purge" type="string" %}
Set a period to purge tables
{% endswagger-parameter %}

{% swagger-parameter in="body" name="limit" type="integer" %}
Set the size of the WITSML response
{% endswagger-parameter %}

{% swagger-parameter in="body" name="rigs" type="string" %}
Set a list of rig objects, containing the 

`name`

, 

`units`

, 

`tags`

, 

`types`

 and 

`timestamp`

.
{% endswagger-parameter %}

{% swagger-parameter in="body" name="endpoint" type="string" %}
URL service used
{% endswagger-parameter %}

{% swagger-parameter in="body" name="database" type="string" %}
URL database used
{% endswagger-parameter %}

{% swagger-response status="200" description="" %}
```
```
{% endswagger-response %}
{% endswagger %}

##
