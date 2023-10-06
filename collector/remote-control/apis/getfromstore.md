# getFromStore
This feature allows a plugin to execute a WITSML query via API.
```
POST
http://environment.com/services/plugin-liverig/collectors/getFromStore?qualifier=qualifier&instance=instance&sourceName=sourceName&rigName=rigName&type=type
```
## Request 
### Parameters
| key         | value                                                       |
|-------------|-------------------------------------------------------------|
| qualifier*  | Liverig Collector plugin qualifier | 
| instance*   | Collector name                                              |
| sourceName* | Collector source name                                       | 
| rigName*    | Collector rig name                                          |
| type*       | Witsml Object Type                                          |
### Body
| key | value                                           |
| --- |-------------------------------------------------|
| query* | XML query to be execute on WITMSL |

![](https://github.com/efsh/gitbook-drilling/assets/1487210/c57f7648-451d-48d3-8eb6-7a9194ab26d0)

![](https://github.com/efsh/gitbook-drilling/assets/1487210/ba1eb88d-b33a-44af-bccd-3aac8b193046)

## Response
### Status message 
- [X] 200: OK
### Body message
Returns a Json object with an `result` short attribute (being 1 a success and 0 for a failure) and a `xml` string attribute with the query results.
```json
{
    "success": {
        "result": 1,
        "xml": "..."
    }
}
```
## Example
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
The example above is for demonstration purposes only. Do not copy/paste into a production environment.
