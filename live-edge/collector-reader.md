---
description: >-
  Live provides collector reader plugin to collect and ingest data between a
  cloud and edge instance
---

# Collector Reader

### Edge architectures overview

Live plugin to read data being ingested by a LiveRig Collector at the same machine, or at least in the same filesystem. LiveRig Collector data.log files will be monitored, parsed and will create local events to represent the same information. This plugin enables the installation of an additional Live instance at the Edge environments to use the events locally without any impact on the ordinary LiveRig Collector data flow tasks for the central site.

![](https://lh5.googleusercontent.com/XX09tzG0ylzs24Dfwns4xV4onHb6m6DMcPsvZDG3s40MLhW5Y2a3-8E3Zt7IjNZWYUrWyJ05d82vcnFfIlsOg9zyZ-Qzp0dKQ-Ug90jiHptGkCWw0TcV9Os7iAmlHi8rKmWcCN63jVkv0\_uTuA)

{% hint style="warning" %}
This plugin **must not** be installed in a Live which already receives data from the same LiveRig Collector (by TCP), otherwise name clashes will occur and the remote control capabilities from the ordinary LiveRig Collector instance will not work due to ambiguous internal events.
{% endhint %}

### Installation&#x20;

Download the plugin collector reader available at INTELIE marketplace:

{% embed url="https://marketplace.intelie.com/artifact/plugin-collector-reader" %}

Verify that the plugin-collector-reader is valid at the plugins page:

![](https://lh3.googleusercontent.com/O8N4BKByKoyv3CZH2yIr3LWIlZv9pk4imYQMYc8efZ6gpIBreXoCZWi31j9YMdGYCLFMuDnXfOy-wokMlhv\_Ki3Bdj788ZsRchwttj4ztGxiUY4Kr41PabUjp1FnVy-UooWMw1FMj7-nVhAkZA)

### Configuration

Search for "collector reader" on Live integrations administration page.

A typical configuration for a LiveRig collector installed by RPM package will use the folder `/opt/intelie/liverig` as explained in  [Collector configuration](../collector/configuration/).

The Collector Reader plugin needs to be configured to consume the same data folder than LiveRig Collector will use to store temporary the data being ingested.

![](https://lh6.googleusercontent.com/GHhcwdUbzM0lhvsm-Rxob3QJGv23OtBWKnsDtgxRzipobDUjtruT-2X\_MOyUDyuaeDZ6Mz5CXVCFqJt2bLWGgcEDOYGan6dp6ySUwb3EBwfvGxEzrwhpjVIhM3Bm9K0ZA1frXsH9QQXiGKbSZQ)

In this case, the folder is **`/opt/intelie/liverig/data`**, please confirm the **`data_path`** at the **`liverig.properties`** file of the LiveRig Collector installation.&#x20;

This plugin delivers an Extension Type in Live, which enables an arbitrary number of instances for it, so potentially you can monitor the data flow for any number of collectors since they run locally in the same filesystem.

### **Receiving events**

In the example below are two environments configured, side by side, one represented by cloud (left) and the other represented by edge (right) with the plugin-live-collector-reader installed.

![](https://lh5.googleusercontent.com/CfAH6GaxrWNyGyvxH06O9BY7b69o2rWu9RbQoh1Hg8wXQfjYPGUYT42jCBAzaafT\_5UXL81TZq5M1aChMhbGz4iW00UJce6rc-BRC5GJFQMElZlSc9hDtm-11ic-yrttVI80\_90BEclt0L4pvA)

The cloud environment is receiving data from a configured collector:

![](https://lh6.googleusercontent.com/KEbVJwNZQxe9joD6aN59QYjiYWDDDOQU484y9aZ4FROcWiyeLJiwE17R-dugP5y4cDGtFGf0DV1rkgusEAS2dFl8l9zwlFnd52nB6OQp-R9BweORbGp74lQzfjji7BPtDOfztOoe8djOSH4XdQ)

On the image below it is possible to see the online [collector source](../collector/remote-control/sources/README.md) active:

![](https://lh3.googleusercontent.com/XZL8l9V15jk3O18\_b2bDjrxymttCzVUm8Zmpu0lEoArFxW6\_EXb744LANYWFtfXW30jpS4rjIm-6uB1JYoUfOpSx0eCXmwKFzjmxsR-PuiCCtLlIYPDBDzAIvFwaVtN8cqtS2pb5z7F3jWAmow)

An example of [WITSML](../collector/protocols/witsml.md) source configuration:

![Typical WITSML source configuration](https://lh5.googleusercontent.com/eIHidImbtrltYR0A5sI3iB\_nEwv3MI4oPa-eNHjSeHPLZK-t85HIOlgrouoJzlFtJSLs4uLzs\_1Vpu3sXyVYZ1WsqS8qvqFpUYImU3q8sYANgH6r1WWy3B0E3a1RK8m2F30SfCsEwsyXZE-KpQ)



Without configuring the plugin-live-collector-reader it is not expected to receive any data on edge side by executing the query:

`__src:(liverig|collector)*`

![Demonstrating the data arrival in cloud-only environments](https://lh5.googleusercontent.com/kNHuFQMQRRDPIlpinr-wzPy7N8fzF9tpqdD9dUtZykwVtJN-QkKjpZMH8LOdb1MiqVr6yHFEGs561Rf45teIPXeXjwT2p5xVbDXF4ke\_mDte8Z8PADio9w9kl8r294oth08kVba63A51DvY3Lg)

After configuring the integration instance as long as the collector you are pointing to start receiving events those events will be replicated inside live with the field `__src` set to `collector-reader/<qualifier of the instance>`.



For example, if your instance's qualifier was set to **Rig 01** then you could test the instance is working by running the following pipes query:

`__src:"collector-reader/Rig 01"`

![Ensures the Collector Reader instance is working fine and receiving data](https://lh6.googleusercontent.com/dZnF8wSnF1B50-Har0LuvnwVynBo7SBhL8-3NN8C3STTTsy2J7WEe9tIaN0qi7i6d0kI6Xr7-zHNzJ1X5Yu7CsRmH2DlXrYo3t6yOwswl5OOmlS6bbsAs-ACAgXrE3nvuhzRsguMgNM3BhSWpw)

