# REST Input

## Characteristics

* Rest Input receives data using the JSON format in a HTTP POST request. Each request can contain one event or a batch of events;
* Data must be modelled as events in a series, each event having a set of attributes;
* Access credentials are configured via Intelie Live admin interface.

## Data format

REST Input data format shares most of the characteristics described for the Rest Output data format.

Each request must send a set of JSON-formatted data. This data must be modelled as events, which are composed of the current values for a set of attributes on a moment in time.&#x20;

* A JSON document may have one or more events;
* Each event has information for one or more attributes;
* We recommend each event contains an attribute recording the moment it was generated, using a timestamp in the Epoch format (in milliseconds). Do no use the attribute `timestamp` for this, as this attribute is automatically inserted on each event by Intelie Live in order to record the time the event was received;
* We recommend each event includes a `__type` attribute, whose value is an identifier for the application. Event storage and queries are segmented by type, so using this attribute usually means their performance is better.

## Example

```
curl -v --user myuser:mypass -H "Content-Type: application/json" -X POST \
  -d "{__type:aaa, a:1}" https://localhost/services/plugin-restinput/myrest/
```

{% hint style="info" %}
If a third-party authentication provider is configured and one is not able to provide the password in the request, the authentication provider of that specific user performing the request, at the user page on the web administration.
{% endhint %}
