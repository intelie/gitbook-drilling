# Well casing shoe schematic

{% hint style="info" %}
plugin-casing-shoe 1.2.0 and plugin-wells 4.0.0 minimum versions required
{% endhint %}

The casing shoe schematic chart provides a visualization of the transversal section of a well, illustrating the well construction and previewing the bit depth position in real time. The schematic shows casing structures such as liners, slotted liners, lithology,  target formations by depth of the casing string.



![Preview of casing shoe schematic chart with phases and lithology by depth](<../.gitbook/assets/image (124).png>)

{% hint style="warning" %}
The casing-shoe chart consumes static data from well design overview information at the well parameters tab and the bit depth real time standard channel
{% endhint %}

Static data used to render the casing shoe schematic at well parameters tab:

![Well design overview static information used to plot the chart](<../.gitbook/assets/image (257) (1).png>)

Advantages **:**\
****

* Preview well design phase information such as casing diameters, bit depth, lithology, and target formations, and casing structure including liners, screen, slotted liners or open hole by depth
* Go along with the real time bit depth position using the standard configured channel&#x20;
* Use well casing shoe chart for different wells with dashboards filters or a predefined well
* Plan ahead knowing where it is advantageous to set the casing, defining where important formations are located

To include the chart go to edit mode at the dashboard and the option for casing shoe schematic widget will be available:

![Casing shoe schematic widget at the dashboard](<../.gitbook/assets/image (288).png>)

It is possible configure the chart to select the well by available wells list or with dashboard filter:

![Casing shoe well configuration ](<../.gitbook/assets/image (340).png>)

Also it is possible to configure which visualization will be displayed at the dashboard and the section details at long or short format:

![Casing shoe chart configuration](<../.gitbook/assets/image (427).png>)

If the configuration is selected with dashboard filter it is possible to select the asset at the dashboard:

![well selection mode with dashboard filter](<../.gitbook/assets/image (71).png>)

![Well selected with dashboard filter](<../.gitbook/assets/image (192).png>)

To show the bit position in real time the bit depth standard channel must be configured and with the data management enabled for the used well:

![Bit depth standard channels configuration](<../.gitbook/assets/image (437).png>)

![Bit depth channel at data management](<../.gitbook/assets/image (174).png>)

![Bit depth channel receiving values](<../.gitbook/assets/image (492).png>)

Then by hovering the mouse over the bit it will show the depth position:

![Bit depth position visualization](<../.gitbook/assets/image (203).png>)

It is possible to configure the objectives at the well parameters tab to preview by depth in the chart:

![Objectives configuration](<../.gitbook/assets/image (452).png>)

![Preview of objectives and formation in chart](<../.gitbook/assets/image (9).png>)

If the well is configured as onshore the surface is displayed instead of water depth:

![Onshore well visualization](<../.gitbook/assets/image (449).png>)

![Onshore well configured at well parameters tab](<../.gitbook/assets/image (290).png>)

It is possible to configure a well design to compare execution and planned well schematic versions:

![](https://lh5.googleusercontent.com/7JiFe-oPJREmDfLqVy6Xxj9dp2VXb2Cdr7diFAV4MZZh\_gZgSG0bitH4cwQ\_-q9pC326Cfb4Mi\_5\_AaziHOIdTK4v3PxVSjudutZaCkFk4P1eAvOReccFvGnVGxwydLX73u87fe\_a7\_D1raDyA)

Comparison between execution and phase planning data for a well on a dashboard.

![](https://lh6.googleusercontent.com/GqW0AKuVAdfBNdTdvXD6KTM4rJW8pgO-XM0TH9IGEdeiARuylncmNOVzuG026fOdt5\_Y3MTk6YIFQ9atvlEeWwdrSMfV53l3nzgrPtSUoa3Qb\_4Idt9z4S43fEGOaSIV1K71WbN8hWD6YubHKQ)

