# /testSourceEndpoint

This feature allows you to validate the endpoint connection against the effective server (for some protocols like WITSML, OPC, ModBus) behind the LiveRig Collector using the remote control API.

## Required information

![Identifying the Liverig integration qualifier](../../../.gitbook/assets/collector-source-details/basic-qualifier-and-instance-information.png)

![Identifying the additional collector source details for WITSML protocol](../../../.gitbook/assets/collector-source-details/witsml-source-details.png)

{% hint style="info" %}
Please note that it is necessary to replace the term "environment" with the correct address before using the API.
{% endhint %}

## /testSourceEndpoint?qualifier=qualifier\&instance=instance

<mark style="color:green;">`POST`</mark> `https://environment.com/services/plugin-liverig/collectors/testSourceEndpoint`

Test a source endpoint. Currently supports all server mode protocols, and WITSML, Modus and WITS in client mode.

#### Query Parameters

| Name                                        | Type   | Description         |
| ------------------------------------------- | ------ | ------------------- |
| qualifier<mark style="color:red;">\*</mark> | string | Collector qualifier |
| instance<mark style="color:red;">\*</mark>  | string | Collector instance  |

#### Headers

| Name                                           | Type   | Description      |
| ---------------------------------------------- | ------ | ---------------- |
| Content-type<mark style="color:red;">\*</mark> | string | application/json |

#### Request Body

| Name                                     | Type | Description                                                                        |
| ---------------------------------------- | ---- | ---------------------------------------------------------------------------------- |
| source<mark style="color:red;">\*</mark> | json | Basic information about how to connect to the source endpoint. See examples below. |

{% tabs %}
{% tab title="200 Returns an object with the property "success" as the WITSML response status. See details below." %}
```json
{
    "success": {
        "result": "true"
    }
}
```
{% endtab %}
{% endtabs %}

### Body examples

```json
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
```json
{
    "success": {
        "result": "true"
    }
}
```
{% endtab %}

{% tab title="Warning" %}
```json
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
```json
{
    "failure": "error message string"
}
```
{% endtab %}
{% endtabs %}
