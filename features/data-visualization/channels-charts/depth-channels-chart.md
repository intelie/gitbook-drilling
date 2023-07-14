---
description: View channels in a depth interval
---

# Depth Channels Chart

### **Configurations**

The same configurations found on [Temporal Channels Chart](temporal-channels-chart.md) is also found here.&#x20;

Channels depth comes with a **Depth selector** instead of Time selector and have a **Depth Grid** configuration:

### **Depth Selector**

{% hint style="warning" %}
This chart only shows channels that were originally [indexed by depth](../../../data-flow/data-normalization/data-enrichment.md#depth-based-sources). The chart uses the property `index_value` that represents the depth on the normalized events.

The units of measurement used for the depth on the normalized events can be configured as show in the [data indexes](../../../data-flow/data-normalization/data-enrichment.md#depth-based-sources) section.
{% endhint %}

Depth based charts can be used to visualize a fixed depth range identified by the **Exact Depth** option, or update dynamically, identified by **Relative to asset option.**

![Exact depth](<../../../.gitbook/assets/image (212).png>)

<div align="center">

<img src="../../../.gitbook/assets/image (319).png" alt="Relative to asset">

</div>

### Depth Grid

{% hint style="info" %}
Documentation for version 2.30.0 or greater
{% endhint %}

Depth grid allow a depth interval highlighting using a predefined example, or any custom interval between **Micro**, **Minor** and **Major** grid lines.

<div align="center">

<img src="../../../.gitbook/assets/image (86).png" alt="An example of Custom Configuration">

</div>

{% hint style="info" %}
Note that this configuration is **unit free**. You're configuring depth units interval regardless of the current **unit of measurement** of the depth index.
{% endhint %}

**Visualization for the above configuration (25/50/100)**

<div align="center">

<img src="../../../.gitbook/assets/image (432).png" alt="Starting with Major line at 400 depth, Micro at 425, Minor at 450">

</div>







