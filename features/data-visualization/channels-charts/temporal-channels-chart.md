---
description: View channels in a time interval
---

# Temporal Channels Chart



![Example of a temporal chart](<../../../.gitbook/assets/image (190).png>)

Many visual options are available on the `Chart` tab, as shown on the image below.

![Example of chart configuration](<../../../.gitbook/assets/image (431).png>)

## Plot fills between multiple channels

In case of multiple channels (even from multiple assets) in the same widget, it's possible to specify to fill the area between the curves when they get crossed, in both positive and negative values. This feature can be helpful to enlighten the user about the difference between the values.



![Solid fill between multiple channels curves when they cross each other](https://gblobscdn.gitbook.com/assets%2F-Lno5CP\_Y4IUtBWLlJZl%2F-MhaV1fVYUIkDpTv0uqa%2F-MhaYyG42cSMX\_0Ny\_we%2Fimage.png?alt=media\&token=97fdcf6c-465f-40ac-b8ff-243fa2629a59)

The configuration for the other channel to be compared and how to fill the positive and negative differences is available in **Widget Chart Options** menu at right top of each widget.

![](<../../../.gitbook/assets/image (407).png>)

## Stacked area charts

A stacked area chart displays the evolution of a numeric variable for several groups of a dataset. Each group is displayed on top of each other, making it easier to read the evolution of the total.

Comparing the heights of each segment of the curve allows us to get a general idea of how each subgroup compares to the other in their contributions to the total.



![Example of a stacked area chart](<../../../.gitbook/assets/image (261).png>)

On the **Widget Chart Options** menu, after clicking on the stacked chart icon, the following option is available:

* Stroke style and width: Sets different stroke styles and widths for the current channel.

![Chart type option menu](<../../../.gitbook/assets/image (70).png>)

{% hint style="warning" %}
Important note:

Channels with different units can be added on the same stacked chart, but the user will receive a warning message.
{% endhint %}

![Warning message](<../../../.gitbook/assets/image (345).png>)

Different types of charts can be added on the same visualization, as shown on the image below:

![Stacked charts + line chart](<../../../.gitbook/assets/image (286).png>)



{% hint style="warning" %}
Important note:&#x20;

As this chart type focus on the relative comparison between the channels, the channel ordering functionality is not available on stacked charts.
{% endhint %}

