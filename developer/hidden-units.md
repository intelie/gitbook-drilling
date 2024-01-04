# Hidden Units

{% hint style="info" %}
Available since the plugin-liverig [3.3.0](../deprecated/liverig-v3/3.3.0.md) release.
{% endhint %}

The `HideUnitsService` service delivers a filter capability to all current methods present in the UnitsResource (used by the frontend in many situations including dashboards and channels management).

This service is customizable since plugin-liverig `3.7.0`, hiding the Unit on all frontend (**HIDE\_ALL**) or maintaining the autocomplete feature on the channels management screen (**NOT\_INPUT\_CHANNEL**). The **HIDE\_ALL** type of filtering is the default type, even if it is not specified. This service is exposed to be used by any plugin.

This service provides two methods on `3.3.0` release:

* `hideUnits` - hide desired units
* `contains` - check whether a unit is already hidden

{% hint style="info" %}
This service provides five more methods on `3.7.0`release:
{% endhint %}

* `applyFilter` - returns a boolean that represents if a unit is being hidden on all frontend (**HIDE\_ALL**) or maintaining the autocomplete feature on the channels management screen (**NOT\_INPUT\_CHANNEL**).
* `filtersUOM` - returns a list containing all filtered units (only the unit).
* `filters` - returns a list containing all filtered units and their respective filterTyper (**HIDE\_ALL** or **NOT\_INPUT\_CHANNEL**).
* `filtersByUnit` - returns a UnitsFilter.Type if the filter list contains specified unit
* `filtersByType` - returns all filtered units by filter type (UnitsFilter.Type)

The following Groovy plugin example hides "**UGT**" and "**rad**" units on all frontend (**HIDE\_ALL**) and "**miUS2**" unit while maintaining the autocomplete feature on the channels management screen (**NOT\_INPUT\_CHANNEL**):

```groovy
//@liveplugin pluginHideThreeUnits@1.0.0
//@requirePlugins plugin-liverig

import net.intelie.live.Live
import net.intelie.liverig.plugin.units.HideUnitsService

//UnitsFilter package required to customize the filter type after live-rig 3.7.0
import net.intelie.liverig.plugin.units.UnitsFilter

HideUnitsService service = live.system().getPluginService(HideUnitsService.class)
service.hideUnits(live, "UGT")
service.hideUnits(live, UnitsFilter.Type.HIDE_ALL, "rad")
service.hideUnits(live, UnitsFilter.Type.NOT_INPUT_CHANNEL, "miUS2")

// how to hide an units collection
List<String> thousands = new ArrayList()
​for ( i in (0..1000).toArray() ) {
  thousands.add("example" + i)
}
​
// single method call will work with any number of units
service.hideUnits(live, thousands.toArray(new String[0]))
```

**Note:** This [Groovy code must be uploaded as a plugin to Live ](https://platform.intelie.com/developers/plugins#groovy-scripts)in administration page since it uses the `@requirePlugins`statement. [Groovy snippets doesn't support dependencies](https://platform.intelie.com/featured-plugins/groovy).

Hidden units will not be available in Live's autocomplete tools if the **HIDE\_ALL** type is used (like those available at the [Data Management](../administration/data-normalization/data-management/), [Asset parameters](../static-data/assets/), [Unit Management Tools](../administration/high-frequency-data/unit-management-tools.md), [Standard Channels](../administration/standard-identifiers.md) and [Display Units](../features/display-units/) screens). The **NOT\_INPUT\_CHANNEL** filter type will retain the autocomplete tools on the [Standard Channel](https://drilling.intelie.com/administration/standard-identifiers) screen.

It's expected the following behaviors in case an unit be hidden but was being used at:

It's expected the following behaviors in case an unit be hidden but was being used at:

* **Standard Channels**: the user will receive an warning
* **Display Units**: the user will be prevented from saving until they modify the hidden variable. This can break some widgets, just like when an alias or an unit extension is modified ([see more](../administration/high-frequency-data/unit-management-tools.md#side-effects-of-deleting-and-renaming))
* **Data Normalization** (either as the source or target channel unit): no warning is shown at the Data Management screen, and the normalization will be executed as the unit was visible.
* **Asset Parameters, Data Management or Unit Management Tools**: The user will receive no warning, but the unit will not be suggested by the autocomplete (**HIDE\_ALL**) or retain the suggestion by the autocomplete (**NOT\_INPUT\_CHANNEL**).
