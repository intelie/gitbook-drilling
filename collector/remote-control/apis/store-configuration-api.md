# /storeConfiguration

This feature allows you to add or edit a store.json file via API. We can view the calls created and how you use them.\


{% swagger baseUrl="http://environment.com" path="/services/plugin-liverig/collectors/storeConfiguration?qualifier=qualifier&instance=instance&force=true" method="get" summary="storeConfiguration" %}
{% swagger-description %}
View the store.json file
{% endswagger-description %}

{% swagger-parameter in="path" name="instance" type="string" %}
Collector instance
{% endswagger-parameter %}

{% swagger-parameter in="path" name="qualifier" type="string" %}
Collector qualifier
{% endswagger-parameter %}

{% swagger-response status="200" description="" %}
```
```
{% endswagger-response %}
{% endswagger %}

{% swagger baseUrl="http://environment.com" path="/services/plugin-liverig/collectors/storeConfiguration?qualifier=qualifiers&instance=instance&force=true" method="post" summary="storeConfiguration" %}
{% swagger-description %}
Add or edit the store.json file
{% endswagger-description %}

{% swagger-parameter in="path" name="qualifier" type="string" %}
Collector qualifier
{% endswagger-parameter %}

{% swagger-parameter in="path" name="instance" type="string" %}
Collector instance
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
