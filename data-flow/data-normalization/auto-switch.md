# Auto-Switch

Auto-Switch selects the best input channel for each normalized channel. Intelie LIVE platform analyzes every one of those channels configured and create an individual status, that represents the data quality of that channel.

Every 20 seconds, the highest priority input channel with good status will be selected for each normalized channel.&#x20;

{% hint style="info" %}
A channel with priority 1 has a higher priority than a channel with priority 2.&#x20;

The priority **must** be unique

Auto-Switch engine only selects input channels with a priority defined.
{% endhint %}

To create this data quality measurement several metrics are taken into account, one of them is availability. To be considered as available, a channel must be transmitting for more than `restored` ms and without any gap greater than `gap` ms.

Both parameters, `gap` and `restored`, can be changed in the [system configuration](../../administration/data-normalization/auto-switch.md) and affect all assets. By default `gap` has the value 120000ms (2 minutes), and `restored` is equal to 120000ms (2 minutes)

## Examples

The asset configuration bellow will be used in all subsequent examples. `gap` and `restored` are equals to 1

![Input channels prioritized](<../../.gitbook/assets/image (305).png>)

### Example 1

![](<../../.gitbook/assets/Normalization diagram-Page-2 (5).png>)

In this example, the input channel with priority 1( ABC ) is available all the time, so there's no change made by the Auto-Switch and the normalized channel is created using the data from ABC.

### Example 2

![](<../../.gitbook/assets/Normalization diagram-Page-2 (6).png>)

Here ABC doesn't have data between 4 and 4.5, however, no change is made. Since `gap` is 1, ABC is considered available at this point. Because of that, the normalized channel reflects what happened with ABC and has a data gap between 4 and 4.5.

{% hint style="info" %}
`The minimun value for gap` and `restored`is 20000 ms (20 seconds)
{% endhint %}

### Example 3

&#x20;

![](<../../.gitbook/assets/Normalization diagram-Page-2.png>)

Channel ABC has a gap between 4 and 7. Here the Auto-Switch engine selects XYZ as a substitute at the time 5. Again, between 4 and 5, ABC is considered available because `gap` is 1.

At 7, ABC is recovered and once again there is data. Auto-Switch waits `restored` to select ABC as the main channel, which occurs at 8.

The normalized channel reflects ABC at the time 0-5 and 8-12. Between 5 and 8 the channel XYZ is used.

### Example 4

![](<../../.gitbook/assets/Normalization diagram-Page-2 (3).png>)

Channel ABC has a gap between 4 and 7. Here the Auto-Switch engine selects DEF as a substitute at the time 5. Again, between 4 and 5, ABC is considered available because `gap` is 1. XYZ isn't available since 4.

At 6, XYZ is recovered and once again there is data. Auto-Switch waits `restored` to select XYZ as the main channel, which occurs at 7. The same happens with ABC at 7, and at 8 it's chosen.

The normalized channel reflects ABC at the time 0-5 and 8-12. Between 5 and 6 the channel DEF is used. XYZ is used from 7 to 8.
