# Data Normalization

During the normalization process, the data is related to an asset, that can be a `Rig` or a `Well`. The identification of this relationship is the `event type` of the generated data.

The normalization occurs in 5 steps:

1. Filtering the data related to each asset and to each data source ([more](../../administration/data-normalization/))
2. Synchronizing the clock ([more](clock-syncronization.md))
3. Converting the names to the standard mnemonics
4. Converting the units of measurement to the standard set of units
5. Enriching domain-specific information ([more](data-enrichment.md))

After that, the normalized data is generated and can be used on visualization, algorithms and alerts.

{% hint style="info" %}
The data parse is performed by the Intelie Live platform. The collector only parses the data for some specific reasons such as iterating on the date or depth when using WISTML, for example.
{% endhint %}

Data from different sources, either onshore or offshore, can be merged into the same asset during the normalization process.

{% hint style="info" %}
All the original data is processed and saved as is, and is also used in many analyses.
{% endhint %}

A [guide](../../administration/data-normalization/) on how to configure the data normalization in Intelie Live is provided on the System Administration section.
