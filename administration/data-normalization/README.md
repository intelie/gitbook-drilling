# Data Normalization

The [data normalization](../../data-flow/data-normalization/) process is applied to any event received by INTELIE Live that follows the raw format and has a related asset configured.

## First step: Standard Channels configuration

To perform this process, one must define a set of Standard Channels, or Standard Curves, in which will be defined the mnemonic and the unit of measurement for each channel, independently of its source (well, rig or service company).

![Standard channels configuration in INTELIE Live](<../../.gitbook/assets/image (372).png>)

## Second step: Asset configuration

### Data filtering

The next step is to define, for each rig or each well, one or more possible sources for each channel. Only one source will be considered at a time to be used by the normalization process. Configurations of additional sources are only kept to make it easier to change the active source in the future.

Each source is defined by two levels of filters. The first filter mandatory, It is at the asset level and limits all the data that will be matched with this asset, as the image below shows.

![Filter the data that will be matched to an asset](<../../.gitbook/assets/image (265).png>)

Although generally a simple filter is used to match the data to the asset, complex filters can also be used, such as

```
raw_well_1_offshore | raw_well_1_onshore
```

or

```
raw_all_wells liverig__object->log_name:Time*
```

The second one is optional, and is defined for each of the source's mnemonics. It is important for disambiguation, specially in the case that different sources generate similar mnemonics.

![Example of usage of the same mnemonic on different sources](<../../.gitbook/assets/image (30).png>)

An examples of that filter is:

```
liverig__object->name:Time*
```

### Name conversion

Each source must obligatorily define a mnemonic. When the normalized event is generated, its mnemonic will be defined by the standard channel configuration.

![Example of mnemonics on the sources](<../../.gitbook/assets/image (387).png>)

### Unit conversion

The unit conversion is automatic. When the event is received, if it defines a unit in the `uom` field, the value will be automatically converted to match the standard channel unit.

![The target unit is defined on the standard channels](<../../.gitbook/assets/image (510).png>)

Take a look [here](../../data-flow/data-normalization/unit-conversion.md) to find out the supported units.

### Clock synchronization

Whenever possible, the normalized events will have the `adjusted_index_timestamp` field. It represents the moment that the data point was generated on the source system, after some fixes are applied to the value that was reported by the service companies ([more](../../data-flow/data-normalization/clock-syncronization.md)).

## Third step: Using the data

{% hint style="info" %}
All the data, both raw and normalized, are stored and can be used to generate any type of analysis. Using normalized data guarantee that any analysis can be reused on any other data.
{% endhint %}

Raw data is represented by events that contain, on their root, mnemonics as keys pointing to maps, that contain the unit of measurement (uom) and value for each of the measurements.\
Raw data events also contain some metadata fields, called `liverig__index__timestamp`, `liverig__metadata` and `liverig__object`.

![](https://lh6.googleusercontent.com/u-TKpqbXwIczzhpdXvPvL7PmNwe345NQBP51h5ToWvn3\_RardRf9xib106glBj0YGQ18NJF-H5\_martweMgVe3oT4HSKGecDT6ek6kdAaEgVemSn7PO2lMtNNdOzmKP6fqhf3But)

Each event that represents raw data is transformed into a set of normalized data. Each of the normalized events contains a field called value and another called **uom** (unit of measure), from which their values represent the measurements converted to the standard unit of measurement. Each event also contains references to the raw data.

{% hint style="info" %}
Although raw data has a fixed event format, the mnemonics, units of measurement and clock may vary depending on several factors, being influenced mainly by the service company where the data was collected from.
{% endhint %}

![](https://lh4.googleusercontent.com/W9MA0qpdo-Er4Vi7IGvAPAs5RIl0HMOvTQoe4ExCWg2aBQ5w2g6XMinG8IIIVktTJIrgnH8ciKD4d8\_ces0JuoLqC0Pl95qYc7ZPXEXyrZlll-00BSw0cjJXFNmqRIornBeJpRBV)

{% hint style="info" %}
If it is not possible to convert a value, the errors field will describe any possible reasons
{% endhint %}

![](https://lh5.googleusercontent.com/lqDkD91lGPUbCd0sybpspb6LhZ295C62j3AlpiK0RSMrWDtH1bSu0TRIxkxE7EypNnJvx8z2iA8p0y\_zzkKqDswMVx8zId8tyJCglFlXf4XEQjzb8gauGbec4DDRbAVRIkskaCq0)

Since version 2.19.0, the normalization can be enabled or disabled for each asset, using the toggle shown on the image below.

![Toggle to disable or enable data normalization for one asset](<../../.gitbook/assets/image (509).png>)

### Renormalization

Sometimes a re-normalization is needed, for example, to fix data generated with a wrong normalization configuration.

![Renormalization entry at High Frequency Data section at Configurations menu](<../../.gitbook/assets/image (349).png>)

For this goal, there is a re-normalization option on the Configurations menu, which allows this process to be executed for a batch of assets simultaneously, and provides a full status of all the executions.

![Renormalization web interface enables the reprocessing of raw data in batches for multiple assets and organized by selected channels](<../../.gitbook/assets/image (241).png>)

Starting at LiveRig 4.0 and Wells 5.0, renormalizations can be performed by depth criteria instead of date-time ordering.
