# /storeConfiguration

This feature allows you to list, add or edit a `store.json` file using LiveRig Collector using the remote control API.

{% hint style="warning" %}
This endpoint only supports OPC protocol
{% endhint %}

## Required information

![Identifying the Liverig integration qualifier](../../../.gitbook/assets/basic-qualifier-and-instance-information.png)

![Identifying the additional collector source details for WITSML protocol](../../../.gitbook/assets/witsml-source-details.png)

## /storeConfiguration?qualifier=qualifier\&instance=instance\&force=true

<mark style="color:blue;">`GET`</mark> `http://environment.com/services/plugin-liverig/collectors/storeConfiguration`

View the store.json file

#### Query Parameters

| Name                                        | Type    | Description                                                                                                                  |
| ------------------------------------------- | ------- | ---------------------------------------------------------------------------------------------------------------------------- |
| instance<mark style="color:red;">\*</mark>  | string  | Collector instance                                                                                                           |
| qualifier<mark style="color:red;">\*</mark> | string  | Collector qualifier                                                                                                          |
| force                                       | boolean | In case of `true`, it will ignore the caching and it will re-read the store configuration from the collector at remote site. |

{% tabs %}
{% tab title="200 The representational object of current store for the requested source" %}
```json
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
{% endtab %}
{% endtabs %}

## ?qualifier=qualifiers\&instance=instance\&force=true

<mark style="color:green;">`POST`</mark> `http://environment.com/services/plugin-liverig/collectors/storeConfiguration`

Add or edit the store.json file

#### Query Parameters

| Name                                        | Type    | Description                                                                                                                  |
| ------------------------------------------- | ------- | ---------------------------------------------------------------------------------------------------------------------------- |
| qualifier<mark style="color:red;">\*</mark> | string  | Collector qualifier                                                                                                          |
| instance<mark style="color:red;">\*</mark>  | string  | Collector instance                                                                                                           |
| force                                       | boolean | In case of `true`, it will ignore the caching and it will re-read the store configuration from the collector at remote site. |

#### Request Body

| Name     | Type    | Description                                                                                        |
| -------- | ------- | -------------------------------------------------------------------------------------------------- |
| purge    | string  | Set a period to purge tables                                                                       |
| limit    | integer | Set the size of the WITSML response                                                                |
| rigs     | string  | Set a list of rig objects, containing the `name`, `units`, `tags`, `types` and `timestamp` fields. |
| endpoint | string  | URL service used                                                                                   |
| database | string  | URL database used                                                                                  |

{% tabs %}
{% tab title="200 " %}

{% endtab %}
{% endtabs %}

### Body examples for POST

{% hint style="warning" %}
The inner fields `database`, `endpoint`, `limit` and `purge` are _optional_ and **may be set only if you need the** [**Protocol Conversion**](../../protocol-conversion.md) **feature**.
{% endhint %}

```json
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
