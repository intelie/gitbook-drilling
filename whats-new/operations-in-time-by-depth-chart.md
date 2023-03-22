---
description: >-
  Live provides a chart of operations over time by depth to compare drilling
  plans and execution data
---

# Operations in Time by Depth Chart

{% hint style="warning" %}
plugin-liverig, plugin-assets, plugin-liverig-vis required 4.1.0,

plugin-wells required 5.3.0
{% endhint %}

The Operations by depth chart provides a visualization of a well drilling based on its interventions and operations. The graph shows the hole depth over time and also details of each operation that contributes to the drilling based on the selected interventions.

On the dashboard on edit mode it is possible to select the operation in time by depth chart:

![](<../.gitbook/assets/image (371).png>)

After configure the chart will be rendered considering the interventions operations of selected well:

![](<../.gitbook/assets/image (38).png>)

### Operations by depth report options

In the edit mode is possible to select a well and its Finished or Active interventions to be used in the report. Select a well in the menu on the left and choose one or more interventions.

![](<../.gitbook/assets/image (508).png>)

Note that all the operations of the selected interventions will be listed on the right as planned and executed operations. Each card shows a summary of one operation:

![](<../.gitbook/assets/image (499).png>)

When the mouse is over the operation card, its point is highlighted in the chart:

![](<../.gitbook/assets/image (56).png>)

Also, clicking on the card more details are displayed:

![](<../.gitbook/assets/image (346).png>)

{% hint style="info" %}
The annotation feature was included on plugin-wells version 5.4.0:\
plugin-annotations 3.7.0+ required;\
plugin-presuretests 3.6.0+, plugin-petrobras 3.7.0+, plugin-liverig-vis 4.3.0+ and plugin-bop 1.2.0 are optional according to the annotations you want to display.
{% endhint %}

The annotations of the drilling period are also displayed on the chart and listed at the Annotation's tab, on the right. Auto Analysis (plugin-liverig-vis), Pressure tests (plugin-presuretests), Activity log (plugin-petrobras) and BOP Status (plugin-bop) are the available annotations for now.

![](<../.gitbook/assets/image (336).png>)

By clicking the annotation card more details are displayed:

![](<../.gitbook/assets/A (1).png>)

{% hint style="info" %}
The real time hole depth data was released on version 5.4.0
{% endhint %}

If the drilling is on going, is possible to show the **real time hole depth** using the standard channel @@channels.hole\_depth.

### Chart Customization

To change the color, width or style of a line, or even to hide executed or planned operations and the hole depth channel, access the chart configurations:

![](<../.gitbook/assets/image (408).png>)

Furthermore is possible to enable/disable annotations related to the drilling, and customize colors.

![](<../.gitbook/assets/image (327).png>)

### Operations by depth report data

To see any data in the Operations by depth is necessary to input well Interventions data and its sections and respective operations as well. The chart considers only active and finished interventions.

To input these data access the intervention tabs of the Well and add a Finished or an active intervention:

![](<../.gitbook/assets/image (6).png>)

Then click the intervention you created, add the sections and their operations:

![](<../.gitbook/assets/image (348).png>)

The operations should have the dates and depths defined to be properly displayed on the graph, as in the image below:

![](<../.gitbook/assets/image (388).png>)
