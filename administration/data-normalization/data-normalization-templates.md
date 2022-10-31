# Data normalization templates

Intelie Live supports data normalization templates to speed up the configuration of the normalization. If assets have part of their sources configuration in common, e.g. the same service company, then a template can be used to define that configuration.

![Buttons to create a template from an asset and import a template into an asset.](<../../.gitbook/assets/image (322).png>)

Create template option will create a template with all channels configured in this asset. That is useful to save the same configuration and apply it for other assets.&#x20;

![Create template by asset example (checked rows will be included on saved template)](<../../.gitbook/assets/image (393).png>)

Import template option allows selection of an already saved template to import to this asset. Imported channels will be merged to already configured ones.

By selecting “Prioritize the channels selected on this template for the selected assets”, the template channels will be imported and selected. If this option is off, the selected channels will be the ones that already exists.

![](<../../.gitbook/assets/image (433).png>)

The templates can be managed on the system configuration.

![Example of templates configuration](<../../.gitbook/assets/image (295).png>)

{% hint style="info" %}
Be aware that the only fields saved are:&#x20;

* Target channel
* Input channel
* Priority
* Filter pipes
* Depth channel (if applicable )
{% endhint %}

