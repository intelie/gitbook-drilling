---
description: >-
  Major release delivers a new normalization framework and improved unit handle
  capabilities
---

# LiveRig 4

{% hint style="warning" %}
The LiveRig 4.0 beta series are also documented on this page, and if you have any 4.0 installed, please upgrade it to the 4.1 LiveRig series or above. They are compatible between them.
{% endhint %}

## 4.11 series

**4.11.0**

* Add TCP client mode for CSV source
* Add source filter to sources tab on new collector screen

## 4.10 series

**4.10.0**

* Allow disabling highlight points feature programatically to avoid addons side-effects
* Add visibility menu for Unit Sets feature
* Graphic is rendered for each character typed in the configurations

## 4.9 series

**4.9.0**

* Support for grid on X axis for multichannel temporal widget
* Customize the number of ticks for axis with automatic limits in multichannel temporal widget

## 4.8 series

**4.8.0**

* New layout for collectors page
* Add monitoring tab for the collector page layout
* Support deletions of WITSML requests in collector page
* New screen for the remote control configuration of liverig properties
* Make it possible to edit the uids fields of a WITSML Request
* Informs source ID as part of collector summary in frontend API
* Improve the UX when configuring channels visualizations in pipeless widgets
* New endpoint in liverig remote control API to save collector properties
* Create a JSON Schema to validate and describe AppProperties JSON documents
* Compatibility with Intelie Design System: migrate buttons, search bars, inputs and modals component in Normalization Template page

## 4.7 series

**4.7.0**

* Add identified curve mnemonic to channel config
* New metadata enrichment for normalized events to identify source service company (for liverig collector transmissions)
* Support to read data from COM ports for [RAW](../../collector/protocols/raw.md#access-endpoint), [CSV](../../collector/protocols/csv.md#access-endpoint), and [WITS](../../collector/protocols/wits.md#client-mode-configuration) protocols
* New liverig-collector property to customize the rate of internal events ([more](../../collector/configuration/liverig.properties.md))
* Provide support to HTTPS connection using certificate for WITSML client source ([more](../../collector/configuration/certificate-based-authentication-for-witsml-https-sources.md))
* Create manual mode for collector WITSML requests
* Add NTP status to collector status screen
* \[fixed] Sort and filtering for unit set channels configuration
* \[fixed] Start using the new liverig-common project as dependency
* \[fixed] Reduce the number of WarnOnTimeout threads
* \[fixed] Improve source UI to display the endpoint configuration for all protocols supported

## 4.6 series

**4.6.0**

* Add OPC Source configuration screen
* Add OPC Requests at remote control
* Add OPC Source configuration test button and link fixes
* Add an Endpoint to fetch OPC Tags and minor OPC QoL changes
* Update OPC sources ensuring unique keys
* Allow backlog sync history querier to use depth log
* Allow backlog sync to select time
* Implement stacked area chart in temporal multichannel widget
* Improve the error message when Store.json Not Found
* Block systemd watchdog when InternalEventSource gets stuck
* Log exception when macro exists but is not valid
* Rename "Unit Management Tools" from "Item validator" to "Conversion validator"
* Adding endpoints to handle the liverig properties file

## 4.5 series

**4.5.0**

* Filter channels in pipeless widget configuration
* Show/hide all points markers by clicking on it in pipeless temporal charts
* Optimize plugin started time
* Fixes "unit set is not set correctly when plugin-header-navigation is used"
* Fix unit set is not following while refreshing
* Fix batch renormalization invalid date
* Fix render at VerticalMenuScroll
* Need to change the display format of the Additional Features page
* Fix batch renormalization invalid date
* Add endpoint to list all parts from key
* \[API] testSourceEndpoint: add support for Raw

## 4.4 series

**4.4.0**

* Unit sets - Force follow asset filter ([more](../unit-sets/force-follow-asset-units.md))
* Fixes and improves on follow filter behavior
* Improve compatibility of Collector and Source backlog icons with dark mode

## 4.1 series

* Redesign of plugin dependencies at LiveRig Kit
  * Channels activity and Auto-switch extracted to separated plugins
  * Removed UI components plugin in favor of `@intelie/ui` NPM toolkit
  * Data management frontend API was moved to plugin-assets
* New Modbus data layout to ease channels mapping configuration
* New normalization API
* [New batch renormalization UI \*\*\*\* ](liverig-4.md#new-batch-renormalization-ui)\*\*\*\*
* New unit sets API ([more](../unit-sets/))
* Moved object list service into a new plugin
* Replaced log4j with logback
* UI components unified into `@intelie/ui` NPM package:
  * Moved from `plugin-liverig/shared/components`
    * `ProgressBar`
  * Moved from `plugin-ui-components/shared/components`
    * `EmptyData`
    * `IconMessage`
    * `RadioGroupCard`
  * Replaced by other components from `@intelie/ui`
    * `Alert` component replaced by `InformationToken`
* Removed Plugin-UI components
  * Some UI components and services are now provided by LiveRig plugin under the following namespace:
    * `plugin-liverig/shared/components`
      * `ImportExport`
      * `InputWithDropdown`
    * `plugin-liverig/shared/services`
      * `import-export-service`
  * The following UI components were moved into the LiveRig plugin, and should not be used by other plugins. If you need any of them, please contact the responsible team for guidance.
    * `plugin-liverig/components/Highlight`
    * `plugin-liverig/hooks/useClickOutside`
    * `plugin-liverig/wits-custom-mapping/SuperSheet`

### New batch renormalization UI

The batch renormalization UI was updated to support the new normalization API.

The renormalization of time-series data typically will reprocess date-time information in order to create the normalized channels. However, for drilling applications, the plugins also need to deliver a renormalization by depth (see the [depth renormalization feature at Live Wells v5 series](wells-5.md#depth-support-for-batch-renormalizations)).

The renormalization now supports recalculating a single channel. Previously, at LiveRig v3 series, batch renormalization only could reprocess the entire dataset.

New feature flags to **use source timestamp** and **sort by source timestamp** were added.

![New option to start a batch renormalization](<../../.gitbook/assets/image (516).png>)

![Full history of renormalizations executed in the platform](<../../.gitbook/assets/image (434).png>)
