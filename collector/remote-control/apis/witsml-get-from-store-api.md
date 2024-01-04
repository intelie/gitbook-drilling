# /getFromStore

This feature allows you to execute a WITSML query via API.

{% swagger method="post" path="" baseUrl="http://environment.com/services/plugin-liverig/collectors/getFromStore" summary="?qualifier=qualifier&instance=instance&sourceName=sourceName&rigName=rigName&type=type" %}
{% swagger-description %}

{% endswagger-description %}

{% swagger-parameter in="query" name="qualifier" required="true" %}
Collector qualifier
{% endswagger-parameter %}

{% swagger-parameter in="query" name="instance" required="true" %}
Collector name
{% endswagger-parameter %}

{% swagger-parameter in="query" name="sourceName" required="true" %}
Collector source name
{% endswagger-parameter %}

{% swagger-parameter in="query" name="rigName" required="true" %}
Collector rig name (used as configured event type)
{% endswagger-parameter %}

{% swagger-parameter in="query" name="type" required="true" %}
WITSML object type
{% endswagger-parameter %}

{% swagger-parameter in="header" name="Content-type" type="string" required="true" %}
application/json
{% endswagger-parameter %}

{% swagger-parameter in="body" name="query" required="true" %}
XML query to execute over the source WITMSL server endpoint
{% endswagger-parameter %}

{% swagger-response status="200: OK" description="A JSON object with `success` field and its value represents the effective response from WITSML third-party server wrapped as another JSON object: an `result` short attribute (being 1 a success and 0 for a failure) and a `xml` string attribute with the query results." %}
```javascript
{
    "success": {
        "result": 1,
        "xml": "<?xml version='1.0' encoding='utf-8'?>..."
    }
}
```
{% endswagger-response %}

{% swagger-response status="200: OK" description="In case of internal Liverig failures, one of the following responses will raise." %}
```javascript
{
    "failure": "IllegalArgumentException: anything can come here, just an example.."
}
{
    "cancel": ""
}
{
    "interrupt": ""
}
```
{% endswagger-response %}
{% endswagger %}

## Example

![Identifying the Liverig integration qualifier](../../.gitbook/assets/collector-source-details/basic-qualifier-and-instance-information.png)

![Identifying the additional collector source details for WITSML protocol](../../.gitbook/assets/collector-source-details/witsml-source-details.png)

A example is demonstrated below using effective requests and responses. That is for demonstration purposes only. Do not copy/paste into a production environment.

### Request

```java
OkHttpClient client = new OkHttpClient().newBuilder()
  .build();
MediaType mediaType = MediaType.parse("application/json");
RequestBody body = RequestBody.create(mediaType, "<wells xmlns=\"http://www.witsml.org/schemas/1series\" version=\"1.4.1.1\">\n  <well uid=\"Energistics-well-0001\">\n    <name />\n  </well>\n</wells>");
Request request = new Request.Builder()
  .url("https://rtolive.intelie.com/services/plugin-liverig/collectors/getFromStore?qualifier=real&instance=real-collector&sourceName=Witsml certification&rigName=cert&type=well")
  .method("POST", body)
  .addHeader("x-csrf-token", "e39e59aa-cd1d-4b61-802a-a75c35803fa9")
  .addHeader("Content-Type", "application/json")
  .addHeader("Cookie", "JSESSIONID=node02gbcgw4hpnq51u6fx83c9vjp12438.node0")
  .build();
Response response = client.newCall(request).execute();
```

### Response

```json
{
    "success": {
        "result": 1,
        "xml": "<?xml version='1.0' encoding='utf-8'?><wells xmlns=\"http://www.witsml.org/schemas/1series\" version=\"1.4.1.1\"><well uid=\"Energistics-well-0001\"><name>Energistics Certification Well 1</name><numGovt>Energistics-numGovt-11111</numGovt><dTimLicense>2001-05-15T13:20:00Z</dTimLicense><field>Big Field</field><country>US</country><state>TX</state><county>Montgomery</county><region>Region Name</region><district>District Name</district><block>Block Name</block><timeZone>-06:00</timeZone><operator>Operating Company</operator><operatorDiv>Division Name</operatorDiv><pcInterest uom=\"%\">65</pcInterest><numAPI>Energistics-numAPI-11111</numAPI><statusWell>drilling</statusWell><purposeWell>exploration</purposeWell><dTimSpud>2001-05-31T08:15:00Z</dTimSpud><dTimPa>2001-07-15T15:30:00Z</dTimPa><wellDatum uid=\"KB\"><name>Kelly Bushing</name><code>KB</code><elevation uom=\"ft\">78.5</elevation></wellDatum><wellCRS uid=\"proj1\"><name>ED50 / UTM Zone 31N</name><mapProjection><nameCRS namingSystem=\"epsg\">ED50 / UTM Zone 31N</nameCRS><NADType>unknown</NADType></mapProjection></wellCRS><wellCRS uid=\"geog1\"><name>ED50</name><geographic><nameCRS namingSystem=\"epsg\">ED50</nameCRS></geographic></wellCRS><commonData><dTimCreation>2023-09-04T16:23:03.021Z</dTimCreation><dTimLastChange>2023-09-04T16:33:53.869Z</dTimLastChange></commonData></well></wells>"
    }
}
```
