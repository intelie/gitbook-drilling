# Auto-Switch

The Auto-Switch can be managed on the system configuration.

![Example of Auto-Switch configuration](<../../.gitbook/assets/image (80).png>)

Auto-Switch configurations allow to enable/disable the feature and to customize both `gap` and `restored` parameters. See more details [here](../../data-flow/data-normalization/auto-switch.md).

If this feature is enabled, the Intelie Live platform will select the best input channel for each normalized channel.

{% hint style="info" %}
Auto-Switch engine only selects input channels with a priority defined.
{% endhint %}

These configurations can be overridden for each asset. So even if Auto-Switch is enabled, a specific asset can be configured to select each input channel manually.

![Auto-Switch configuration for each asset](<../../.gitbook/assets/image (266).png>)

However, if the Auto-Switch is disabled on the system configuration, it will be disabled for all assets.

![Asset configuration if the Auto-Switch is disabled](<../../.gitbook/assets/image (53).png>)
