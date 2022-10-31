# testSourceEndpoint

{% hint style="info" %}
Please note that it is necessary to replace the term "environment" with the correct address before using the API.
{% endhint %}

{% swagger baseUrl="https://environment.com" path="/services/plugin-liverig/collectors/testSourceEndpoint?qualifier=&instance=live" method="post" summary="testSourceEndpoint" %}
{% swagger-description %}
Test a source endpoint. Currently supports all server mode protocols, and WITSML, Modus and WITS in client mode.
{% endswagger-description %}

{% swagger-parameter in="query" name="qualifier" type="string" %}
Collector qualifier
{% endswagger-parameter %}

{% swagger-parameter in="query" name="instance" type="string" %}
Collector instance
{% endswagger-parameter %}

{% swagger-parameter in="body" name="source" type="string" %}
Source object, containing the 

`endpoint`

, 

`mode`

, 

`name`

, 

`username`

, 

`password`

, 

`protocolName`

, 

`protocolVersion`

, 

`rigName`

 and 

`serviceCompany`

.

\




\


It's used when sent to obtain the source information to validate the endpoint.

\




\



{% endswagger-parameter %}

{% swagger-response status="200" description="Returns an object with the property successif the collector was reached. Otherwise, the return object has the failiture property, containing a string with more information about the error.

The success object represents the validation performed at the collector." %}
{% tabs %}
{% tab title="Ok" %}
```
{
    "success": {
        "result": "true"
    }
}
```
{% endtab %}

{% tab title="Warning" %}
```
{
    "success": {
        "result": "false",
        "exception": "javax.xml.ws.WebServiceException",
        "message": "Unsupported endpoint address: asd1"
    }
}
```
{% endtab %}

{% tab title="Error" %}
```
{
    failure: "error message string"
}
```
{% endtab %}
{% endtabs %}
{% endswagger-response %}
{% endswagger %}

