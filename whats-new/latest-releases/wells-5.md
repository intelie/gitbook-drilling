---
description: >-
  Major release delivers a new unit handling capabilities for assets and
  compatibility to LiveRig v4
---

# Wells 5

## 5.6 series

**5.6.0**

* Operation by depth chart - real time bit depth render
* Operation by depth chart - Improve performance and enable historical hole depth layer
* Operation by depth chart - Download and export final well report
* Dataset - Add option to select a different datetime format
* \[fixed] Operations by depth chart - Annotations list and plotband are frozen in view mode
* \[fixed] Fix section table behavior when removing lines

## 5.5 series

**5.5.0**

* Add trash button to well design overview row.
* Operations by depth chart - remove annotations actions.
* Operations by depth chart - Add option to see days of the year instead of accumulated time.

## 5.4 series

**5.4.0**

* Operations by depth chart - Annotations Feature ([more](../operations-in-time-by-depth-chart.md))
* Operations by depth chart - Filter operations and annotations cards when zooming the chart
* Add feature follow ahead
* \[fixed] Operations by depth chart - Fix indexOutOfBoundsException
* \[fixed] Operatinos by depth chart - Fix empty run operations

## 5.3 series

**5.3.0**

* Improving asset part service performance
* Improves and fixes final well report visualizations and render
* Unit sets - Force follow asset filter ([more](../unit-sets/force-follow-asset-units.md))
* Improve Unit sets modal performance
* Fix freeze of intervention screen on loading completion component

## 5.2 series

**5.2.0**

* \[fixed] Final well report - Fix null pointer when the section has no operations.
* \[fixed] Improve unitset modal performance
* Download: Events with the same name across multiple queries are not prefixed
* Autoswitch | create gap/restore parameters for renormalization
* Add MD/TVD label to depth header
* Add viscometer readings
* Include riser OD/ID at rig parameters

## 5.1 series

**5.1.1**

* Measured depth still does not show any unit set
* Hole depth field does not follow the unit set
* Missing units in runs

**5.1.0**

* Unit set UI for interventions ([more](../unit-sets/))
* Final Well Report
  * operations
* New models parameters (released at 5.0.8):
  * `hookLoadWithoutBlockWeight`&#x20;
  * `minimumSpeed`
* [Depth support for Batch Renormalization](wells-5.md#depth-support-for-batch-renormalizations)
* Compatible with new auto-switch and channels-activity plugins as part of the changes at LiveRig 4.0 series
* Compatible with LiveRig 4.x series

### Depth support for Batch Renormalization

Previously in LiveRig v3 series, the only way was to reprocess the entire data set to recalculate the depth channels. Now is easy to configure the criteria to inquiry depth data and renormalize only them.

![](<../../.gitbook/assets/image (114).png>)

{% hint style="warning" %}
The Wells 5.0 beta series are also documented on this page, and if you have any 4.0 installed, please upgrade it to the 5.1 Wells series. They are compatible between then.
{% endhint %}
