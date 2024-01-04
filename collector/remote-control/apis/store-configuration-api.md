# /storeConfiguration

This feature allows you to list, add or edit a `store.json` file using LiveRig Collector using the remote control API.

{% hint style="warning" %}
This feature only supports OPC protocol.
{% endhint %}

## Required information

![Identifying the Liverig integration qualifier](../../../.gitbook/assets/collector-source-details/basic-qualifier-and-instance-information.png)

![Identifying the additional collector source details for WITSML protocol](../../../.gitbook/assets/collector-source-details/witsml-source-details.png)

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

{% swagger-response status="200" description="The representational object of current store for the requested source" %}
```
{
    "success": {
        "store": {
            "rigs": {
                "sandbox_opcua": {
                    "name": "sandbox_opcua",
                    "units": {
                        "PUMP": "rpm"
                    },
                    "tags": {
                        "PUMP": "ns=2;s=HelloWorld/Dynamic/Int32"
                    },
                    "types": {
                        "PUMP": "long"
                    }
                }
            },
            "_comment": "Saved 2024-01-04 14:31:44.065 by Live user: john.karter@server.com from web interface"
        },
        "originalHashCode": "c399c3a0c0bc937b4b2b8f0d7e199aba41dee8570a43ef37883f7159678247ee",
        "timestamp": 1704389683053
    }
}
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
Set a list of rig objects, containing the `name`, `units`, `tags`, `types` and `timestamp` fields.
{% endswagger-parameter %}

{% swagger-parameter in="body" name="endpoint" type="string" %}
URL service used
{% endswagger-parameter %}

{% swagger-parameter in="body" name="database" type="string" %}
URL database used
{% endswagger-parameter %}

{% swagger-response status="200" description="" %}
{% endswagger-response %}
{% endswagger %}

### Body examples for POST

{% hint style="warning" %}

The inner fields `database`, `endpoint`, `limit` and `purge` are *optional* and **may be set only if you need the [Protocol Conversion](../../protocol-conversion.md) feature**.

{% endhint %}

```
{
    "store": {
        "database": {
            "url": "jdbc:postgresql://localhost:5432/?user=root&password=rootpassword",
            "parameters": {
                "timescale": false
            }
        },
        "endpoint": "http://127.0.0.1:1234/witsml/store",
        "limit": 1000, 
        "purge": 1000,
        "rigs": {
            "sandbox_opcua": {
                "name": "sandbox_opcua",
                "units": {
                    "PUMP": "rpm"
                },
                "tags": {
                    "PUMP": "ns=2;s=HelloWorld/Dynamic/Int32"
                },
                "types": {
                    "PUMP": "long"
                }
            }
        }
    },
    "timestamp": 1704389683053
}
```
