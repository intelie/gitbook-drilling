# /testSourceEndpoint

This feature allows you to validate the endpoint connection against the effective server (for some protocols like WITSML, OPC, ModBus) behind the LiveRig Collector using the remote control API.

## Required information

![Identifying the Liverig integration qualifier](../../../.gitbook/assets/collector-source-details/basic-qualifier-and-instance-information.png)

![Identifying the additional collector source details for WITSML protocol](../../../.gitbook/assets/collector-source-details/witsml-source-details.png)

{% hint style="info" %}
Please note that it is necessary to replace the term "environment" with the correct address before using the API.
{% endhint %}

{% swagger baseUrl="https://environment.com" path="/services/plugin-liverig/collectors/testSourceEndpoint" method="post" summary="/testSourceEndpoint?qualifier=qualifier&instance=instance" %}
{% swagger-description %}
Test a source endpoint. Currently supports all server mode protocols, and WITSML, Modus and WITS in client mode.
{% endswagger-description %}

{% swagger-parameter in="query" name="qualifier" required="true" type="string" %}
Collector qualifier
{% endswagger-parameter %}

{% swagger-parameter in="query" name="instance" type="string" required="true" %}
Collector instance
{% endswagger-parameter %}

{% swagger-parameter in="header" name="Content-type" type="string" required="true" %}
application/json
{% endswagger-parameter %}

{% swagger-parameter in="body" name="source" type="json" required="true" %}
Basic information about how to connect to the source endpoint. See examples below. 
{% endswagger-parameter %}

{% swagger-response status="200" description="Returns an object with the property \"success\" as the WITSML response status. See details below." %}

```
{
    "success": {
        "result": "true"
    }
}
```
{% endswagger-response %}
{% endswagger %}


### Body examples

```
{

    "name": "same used in collector source name",
    "rigName": "same used in collector source rig name",
    "serviceCompany": "same used in collector source service company",
    "username": "myuser",
    "password": "un%prot3ct3d",
    "endpoint": "http://mywitsml.server.com",
    "mode": "client", // or "server",
    "protocolName": "witsml",
    "protocolVersion": "1.4.1.1",
    "tlsAuth": false // or true
}
```


### Response examples

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

