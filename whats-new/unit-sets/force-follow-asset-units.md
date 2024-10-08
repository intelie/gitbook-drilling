# Force Follow Asset Units

{% hint style="info" %}
Plugins required: \
\- plugin-assets-4.4.0+\
\- plugin-liverig-4.4.0+\
\- plugin-wells-5.3.0+&#x20;
{% endhint %}

### Force Follow Asset Filter

Live provides a feature flag to enable dashboards to follow the unit set of the asset of the selected filter on the dashboard:

![](<../../.gitbook/assets/image (183).png>)

Remind: the option to follow the asset filter will be available only if the dashboard is configured using the **lookup.asset\_name\_event\_type** (only this lookup is supported for now):

![](<../../.gitbook/assets/image (222).png>)

If the **force follow** feature flag is enabled the dashboards that has filters will automatically follow the unit set of the asset selected on filter:

![](<../../.gitbook/assets/image (406).png>)

A specific badge will be displayed at the dashboard informing that dashboard is following the asset filter, that means the units depend on the asset filtered:

![](../../.gitbook/assets/Screenshot\_select-area\_20220704205524.png)

If the force dashboard filter configuration flag is disabled than the dashboard will use the default unit set or previous configured:

![](<../../.gitbook/assets/image (68).png>)

![](<../../.gitbook/assets/image (233).png>)

Also it is possible to select the follow asset filter manually:

![](<../../.gitbook/assets/image (47).png>)
