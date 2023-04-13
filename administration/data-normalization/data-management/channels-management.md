---
description: >-
  Channels Management can be accessed from the data management tab (which is
  located at Asset Pages)
---

# Channels Management

## Auto-Switch indicator

{% hint style="info" %}
If you don't know what is the Auto-Switch feature, consider these readings:\
\- [Data flow > Auto-Switch](../../../data-flow/data-normalization/auto-switch.md)\
\-[ Administration > Auto-Switch](../auto-switch.md)
{% endhint %}

Indicates if the Auto-Switch feature is enabled, considering if this feature is on and enabled for the current Asset.

![](<../../../.gitbook/assets/image (323).png>)

If the Auto-Switch is disabled for the Asset (in the [Event Settings](event-settings.md) card) or if it's disabled for the entire Live (via the menu Configurations > Additional Features > Auto-Switch), the indicator will be OFF:\\

![Auto-switch OFF](<../../../.gitbook/assets/image (339).png>)

If the Auto-switch is ON, but the normalization is OFF to the Asset, a warning will be displayed:\\

![Auto-switch is ON, but not working since there normalization is OFF](<../../../.gitbook/assets/image (488).png>)

## Buttons

### Create Template

Intelie Live supports data normalization templates to speed up the configuration of the normalization. If assets have part of their sources configuration in common, e.g. the same service company, then a template can be used to define that configuration.

![Buttons to create a template from an asset and import a template into an asset.](<../../../.gitbook/assets/image (322).png>)

Create template option will create a template with all channels configured in this asset. That is useful to save the same configuration and apply it for other assets.

![Create template by asset example (checked rows will be included on saved template)](<../../../.gitbook/assets/image (393).png>)

### Import Template

Import template option allows the selection of an already saved template to import to this asset. Imported channels will be merged to already configured ones.

By selecting “Prioritize the channels selected on this template for the selected assets”, the template channels will be imported and selected. If this option is off, the selected channels will be the ones that already exist.

![](<../../../.gitbook/assets/image (433).png>)

The templates can be managed on the system configuration.

![Example of templates configuration](<../../../.gitbook/assets/image (295).png>)

{% hint style="info" %}
Be aware that the only fields saved are:

* Target channel
* Input channel
* Priority
* Filter pipes
* Depth channel (if applicable )
{% endhint %}

### Not Configured Channels

Clicking at the "Not Configured Channels" button the user can visualize a list of channels that were not yet used as input channels.

This list represents the raw events filtered by the Event Settings > Pipes filter (see [Data Filtering](https://drilling.intelie.com/administration/data-normalization#data-filtering)).

### Expand

![](<../../../.gitbook/assets/image (396).png>)

Shows the "Data Management" card in full-screen mode.\\

![](<../../../.gitbook/assets/image (480).png>)

###

### Edit

Toggles the Channels Management edit mode. During the edit mode, input and target channels status and value are not updated.

## Target Channel

### Data Quality

![Not normalizing, not configured or unknown data quality](<../../../.gitbook/assets/image (456) (1) (2).png>)

![Invalid generated event type](<../../../.gitbook/assets/image (464).png>)

![OK](<../../../.gitbook/assets/image (473).png>)

![No data received in time window. The time window can be configured at Configurations > Additional Features > Auto-Switch > Substitute channels that have not transmitted for more than.](<../../../.gitbook/assets/image (460).png>)

![Override Input Unit error](<../../../.gitbook/assets/image (400).png>)

### Target Channel

A standard Channel

### Current Value

The current value of the normalized channel. This is the input channel value converted to the target channel's unit.

### Priority

Selected input channel priority

### Source

Selected input channel source

### Input Channel

Selected input channel. If the Auto-Switch is OFF, the selected channel is was defined manually by the user.

### Filter (pipes)

Selected input channel filter

## Input Channel

### Status

![No data received in time window. The time window can be configured at Configurations > Additional Features > Auto-Switch > Substitute channels that have not transmitted for more than.](<../../../.gitbook/assets/image (430).png>)

![OK](<../../../.gitbook/assets/image (66).png>)

!["Override Input Unit" conversion error](<../../../.gitbook/assets/image (60).png>)

![Conversion error](<../../../.gitbook/assets/image (59).png>)

### Priority

A numeric field that is used to define the priority of the curve. It's not possible to define duplicated priorities or negative numbers. It's used by the Auto-switch (see [Data flow > Auto-Switch](../../../data-flow/data-normalization/auto-switch.md), and [Administration > Auto-Switch](../auto-switch.md))

### Source

Optional field used for notes. An asset that uses the Channels Management can choose between displaying this field to the user or not.

### Input Channel

The channel to be normalized. This field has an autocomplete feature, that shows the possible input channels (the same ones displayed at "[not configured channels](channels-management.md#not-configured-channels)").

### Current Value

Input Channel's current value together with its unit.

### Override Input Unit

This functionality allows the user to overwrite the unit received in the input channel. It can be really useful when the input channel is misconfigured, or when the unit is represented differently from what is defined in Live.

Take as an example an input channel that receives value in `meters`:

![](<../../../.gitbook/assets/image (10).png>)

As Live does not understand `meters` , only `m`, there will be a unit conversion error in normalization. To solve that, the user can define the Override Input Unit as `m`. This way, Live will treat the received data as `m`, and not `meters`.\
\
Please note that the override input unit does not perform any conversion. As the name suggests, it only overrides the unit. It's also important to mention that the Override Input Unit field is compatible (i.e. can be converted to) with the Target Channels' unit.

{% hint style="info" %}
If you want the `meters` unit (or any other) to be recognized by the hole Live, consider creating an alias or a unit extension in the [Unit Management Tools screen](../../high-frequency-data/unit-management-tools.md).
{% endhint %}

### Filter (pipes)

`under construction`

### Depth Channel

`under construction`
