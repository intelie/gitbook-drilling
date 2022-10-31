# Sample Page

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
