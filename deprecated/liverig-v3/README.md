# LiveRig 3.x / 2.x

{% hint style="warning" %}
This page for release notes is archived. Continues here just for historical purposes.&#x20;

Please see the [latest releases](../../whats-new/latest-releases/) for the most recent releases of LiveRig and Live Wells.
{% endhint %}

## [3.5.0 (September 3rd, 2021)](3.5.0.md)

### Fixes and improvements

* Cumulative fixes from 3.4.2, 3.3.1 and 3.2.2 stable versions
* Make "i" button transparent in chart zone value box

### New features

* Adds gradient fill option to area charts ([more](3.5.0.md#adds-gradient-fill-option-to-area-charts))
* Support addon curves and handlers on temporal chart
* Use intelie-ui sidebar component at the plugin-liverig
* Allow users to enable and disable sources from the collector screen using remote control

## 3.4.2 (September 3rd, 2021)

### Fixes and improvements

* Cumulative fixes from 3.3.1 and 3.2.2 stable versions
* Fix to remove unsupported options from standard widgets when fill between channels is enabled

## 3.3.1 (September 3rd, 2021)

### Fixes and improvements

* Cumulative fixes from 3.2.2 stable version

## 3.2.2 (September 3rd, 2021)

### Fixes and improvements

* \[fixed] Fix temporal widget axis box color

### New features

* \[API] Collectors`testSourceEndpoint` now supports probes for Modbus and WITS (client mode)
* Add "test access" button to Modbus and WITS source configuration screen (client mode)
* Fixes typos under Event Settings configuration

## 3.4.1 (August 24, 2021)

### Fixes and improvements

* UX improvement in Data Normalization event settings panel [(more)](../../administration/data-normalization/data-management/event-settings.md)
* Fix on channels charts crossed channels fill strategy in some usages of dashboard asset filters

## [3.4.0 (August 20, 2021)](3.4.0.md)

### New Features

* Channels charts add support to fill between channels, after they have crossed each other [(more)](3.4.0.md#channels-charts-fill-area-when-curves-are-crossed)
* Widget actions UI redesign to consolidate many options and better usability to multiple step configurations [(more)](3.4.0.md#new-features)

### Fixes and improvements

* Adds table ordering icon on Standard Channels
* Fixes the table ordering in Collectors page and review all other table ordering displays

## [3.3.0 (August 6, 2021)](https://app.gitbook.com/@intelie/s/live-drilling/release-notes/3.3.0)

### New Features

* Add CSV Source configuration screen [(more)](3.3.0.md#add-csv-source-configuration-screen)
* Hide Units [(more)](3.3.0.md#hide-units-feature)

### **Fixes and improvements**

* \[API] Change `updateSourceRequests`to allow update OPC Request via remote control [(more)](3.3.0.md#api-change-updatesourcerequeststo-allow-update-opc-request-via-remote-control)
* Hide mode selection at source configuration screen for protocols that only have one mode [(more)](3.3.0.md#hide-mode-selection-at-source-configuration-screen-for-protocols-that-only-have-one-mode)
* Improve source collector screen fallback icon [(more)](3.3.0.md#improve-source-collector-screen-fallback-icon)

## 3.**2**.1 (August 6, 2021)

* Cumulative fixes from 3.1.2 stable version

## 3.1.2 (August 6, 2021)

* Cumulative fixes from 3.0.7 stable version

## 3.0.7 (August 6, 2021)

* WITS Custom Mapping bug fixes [(more)](3.3.0.md#wits-custom-mapping-bug-fixes)

## [3.2.0 (July 19, 2021)](3.2.0.md)

### New Features

* Add WITS Source configuration screen [(more)](3.2.0.md#add-wits-source-configuration-screen)
* Cumulative fixes from 3.1.1 stable version

## 3.1.1 (July 19, 2021)

* Improve "Unit management tools" UX [(more)](3.2.0.md#improve-unit-management-tools-ux)
* Cumulative fixes from 3.0.6 stable version

## 3.0.6 (July 19, 2021)

* Fix partially visible color selector [(more)](3.2.0.md#fix-partially-visible-color-selector)
* Wrap option does not work when applied to more than one channel
* On a chart with two or more wrapped series, hiding one of them causes the wrapping to stop working
* Cumulative fixes from 2.29.7 stable version

## 2.29.7 (July 19, 2021)

* Cumulative fixes from 2.28.7 stable version

## 2.28.7 (July 19, 2021)

* Fix "Renormalization Throttle" save [(more)](3.2.0.md#fix-renormalization-throttle-save)
* Always show Channels Management 'unconfigured channels' [(more)](3.2.0.md#always-show-channels-management-unconfigured-channels)
* Fixes "import JSON" caret color when using Live 3.1.0 or higher  [(more)](3.2.0.md#fixes-import-json-caret-color-when-using-live-3-1-0-or-higher)
* Fixes "Data Quality" icon to not indicates an Override Input Unit (OIU) conversion error when it's OK [(more)](3.2.0.md#fixes-data-quality-icon-to-not-indicate-an-override-input-unit-oiu-conversion-error-when-its-ok)

## [3.1.0 (July 5, 2021)](3.1.0.md)

### New Features

* Change liverig-parser dependencies to protocols-parser
* Add Modbus source configuration screen [(more)](https://drilling.intelie.com/release-notes/3.1.0#add-modbus-source-configuration-screen)
* Add RAW source configuration screen [(more)](https://drilling.intelie.com/release-notes/3.1.0#add-raw-source-configuration-screen)
* Create API (CollectorResource and Service) to add and edit store.json [(more)](https://drilling.intelie.com/release-notes/3.1.0#create-api-collectorresource-and-service-to-add-and-edit-store-json)
* Create front-end interface to WITSML configured Null Values [(more)](../../administration/high-frequency-data/witsml-null-values.md#screen)
* Add cache to Additional Features configuration to improve performance
* Updated collector sources configuration screen layout [(more)](https://drilling.intelie.com/release-notes/3.1.0#updated-collector-sources-configuration-screen-layout)
* Integrate the new units conversion system into the Live [(more)](https://drilling.intelie.com/release-notes/3.1.0#integrate-the-new-units-conversion-system-into-the-live)
* Experiment with pure systemd unit instead of wrapper
* \[RFC] Allow plugins to register channels with arbitrary queries [(more)](https://drilling.intelie.com/release-notes/3.1.0#rfc-allow-plugins-to-register-channels-with-arbitrary-queries)

### Fixes and improvements

* [Fix Well parameters history does not display units correctly](3.1.0.md#fix-well-parameters-history-does-not-display-units-correctly)
* Autoswitch should not log every change to the normalizer
  * Autoswitch changes are no longer displayed at the Data Management version history, since, conceptually, they are all the same configuration. The only difference is the selected curve.
* Always close the Data Management "Create Template" modal after saving
* Makes the renormalization progress update compatible with async event iterators
* Improvements to WITSML Output Plugin
* \[API] Change `testSourceEndpoint` endpoint to use source object to test and don't call remote control to get the source [(more)](../../collector/remote-control/apis/test-source-endpoint-api.md)

## 3.0.5 (July 5, 2021)

* Cumulative fixes from 2.29.6 stable version

## 2.29.6 (July 5, 2021)

* Cumulative fixes from 2.28.6 stable version

## 2.28.6 (July 5, 2021)

* Cumulative fixes from 2.27.2 stable version
* Do not display a confirmation modal when using Data Management import functionality
* Hide Data Management import button if the user doesn't have "manage" permission

## 2.27.2 (July 5, 2021)

* Fixes "import JSON" font color when using Live 3.1.0 or higher (more)

## 3.0.4 (June 25, 2021)

* Cumulative fixes from 2.29.5 stable version

## 2.29.5 (June 25, 2021)

* Regression bug fix to ensure any changes made to the normalization config should call the observers with event\_type null if the normalization is disabled
* Cumulative fixes from 2.28.5 stable version

## 2.28.5 (June 25, 2021)

* Cumulative fixes from 2.27.1 stable version

## 2.27.1 (June 25, 2021)

* Fixes new asset search request not aborting previous requests
* Fixes intervention well attributes persistence
* LOT/FIT disable pressure loss calculation
* Fixes LOT/FIT error in stabilization pressure point and pressure loss calculation
* Fixes the legibility of depth span picker in dark mode
* Fixes wrapped series that was not allowing multiple channels
* Selecting only calculated curve does not enable "Chart" tab
* Wrapping algorithm should support any point value
* Wrapped series should be hidden / shown based on the original series state
* Chart zones only work in standard unit set
* Depth picker should update span if asset filter is changed and state is "Following asset"
* Fixes pressure test CSS to improve the UX at widget actions
* Fixes maven surefire plugin configuration to include any inner tests
* Fixes asset updates add assets that don't fit active search to list

## 3.0.3 (June 11, 2021)

* Cumulative fixes from 2.29.4 stable version

## 2.29.4 (June 11, 2021)

* Improvement in performance for asset lists by caching the asset normalization configurations
* Cumulative fixes from 2.28.4 stable version
  * Improved Well and Rig Page performance by preventing to re-render lists
  * Fix import at Data Management screen when empty JSON are used
  * Improvement in performance for temporal charts by removing additional calls for asset listing

## 2.28.4 (June 11, 2021)

* Improved Well and Rig Page performance by preventing to re-render lists
* Fix import at Data Management screen when empty JSON are used
* Improvement in performance for temporal charts by removing additional calls for asset listing

## 3.0.2 (June 02, 2021)

* Bugfix/remove unnecessary active intervention data fetching
* Bugfix/Data Management | Unable to save event settings if it's empty
* Fix asset updates adding assets that don't fit active search
* Fix kotlin dependencies - A plugin written in kotlin should be able to have plugin-liverig as a dependency
* Improve dependencies and reduce lib size
* Cumulative fixes from 2.28 stable version
  * Fix import at Data Management screen when empty JSON are used

## 2.29.3 (May 12, 2021)

* Fixes Depth Picker duplicate depth interval conversions
* Bop configuration at rig parameters
* Unit management improvements
  * Fix alias edit modal
  * Search for units should be case insensitive
  * Search for units don't work well after the scroll has already been used
  * Fix modal focus
* Cumulative fixes from 2.28 stable version
  * Improved Well and Rig Page performance by preventing to re-render lists

## 2.28.3 (April 28, 2021)

* Display default units at physical models configuration
* Fixes the edition of Additional Fields at Data Management tab of some assets (e.g Rigs, Crews)
* Fixes a HTTP 400 error when requesting WITSML tree using # in `sourceName`&#x20;
* Prevents dashboards crash in mobile mode when display units are active

## 3.0.1 (April 24, 2021)

* Fixed witsml encrypt integration

## [3.0.0 (April 23, 2021)](3.0.0.md)

* Improvements on Depth Grid wording and concept adherence ([more](../../features/data-visualization/channels-charts/depth-channels-chart.md#depth-grid))
* Improved integrations security with encoding strategy
* Added objectives table for formations by depth at well parameters ([more](../../static-data/well/well-design-overview.md))
* Improved well geometry data with casing information at well parameters  ([more](../../static-data/well/well-design-overview.md))
* Plugin spectrum to calculate FFT of a time domain signal ([more](../../whats-new/fft-spectrum-plugin.md))
* Added BOP configuration components and notes for status register ([more](../../whats-new/bop-schematic/bop-status-register.md))
* Fixed pressure tests performance queries
* WITS Custom Mapping ([more](../../administration/high-frequency-data/wits-custom-mapping.md))
* Improve "Depths auto update" in the "Additional Features" menu to allow the selection of values ​​to update hole depth and measured depth separately
* Allow searching for sources on Intelie Live Collectors screen
* New API for source endpoint validation in remote control of Intelie Live Collectors ([more](../../collector/remote-control/apis/test-source-endpoint-api.md))
* Fixed bugs at units conversion engine
  * Alias which points to a Unit Extensions are not being loaded after system initialization;
  * It is not possible to create a Unit Alias pointing to a Unit FixUp (gal\[US]/min, for example);
  * Converting a Unit Alias to its own source unit should work independently of its conversion factors.
* Fix and improve Asset status
  * When an asset has more than one collector associated it should show the asset status in this priority: online, backlog, all sources offline, offline, error
  * A problem was occurring when the asset was associated with more than one collector and one of the collectors had more than one source. In this case, when only one source of a collector was transmitting data, the status of the asset was being shown as offline and should be online.
* Cumulative fixes from 2.28 and 2.29 stable versions
  * Fixes the edition of Additional Fields at Data Management tab of some assets (e.g Rigs, Crews)
  * Fixes a HTTP 400 error when requesting WITSML tree using # in `sourceName`&#x20;
  * Prevents dashboards crash in mobile mode when display units are active
  * Bop configuration at rig parameters
  * Unit management improvements
    * Fix alias edit modal
    * Search for units should be case insensitive
    * Search for units don't work well after the scroll has already been used
    * Fix modal focus

## 2.29.2 (Mar 26, 2021)

* Fixes Depth Charts unlinking the depth interval from dashboard if configured span was not the same of the dashboard. This would affect the chart scales on depth dashboards.
* Fixes Calculated Channels having undefined names in chart legends.

## 2.29.1 (Mar 24, 2021)

### Fixes and improvements

* Fix Channel Widgets data export with Calculated channels and active Display unit

## [2.29.0 (Mar 12, 2021)](2.29.0.md)

* New units conversion system [(more)](2.29.0.md#new-units-conversion-system)
* New normalization engine [(more)](2.29.0.md#new-normalization-engine)
* \[Collector] Remote control OPC configuration [(more)](2.29.0.md#collector-remote-control-opc-configurantion)

### Fixes and improvements

* Performance improvements&#x20;
* \[fixed] Unable to save Additional fields at the Assets screen Data Management tab [(more)](2.29.0.md#improve-data-management-ui)
* Rest Output security improvement [(more)](2.29.0.md#rest-output-security-improvement)
* \[API] Async observers
* \[API] Data quality change notifier
* Display default units at physical models configuration

## 2.28.2 (Mar 03, 2021)

### Fixes and improvements

* \[fixed] Source configurations can be wrongly disabled for empty collectors
* Improve Rest Output configuration UI&#x20;
* Improve WITSML Output configuration UI

## 2.28.1 (Feb 12, 2021)

### Fixes and improvements

* \[fixed] Channels temporal and depth editors were not able to fetch data

## 2.28.0 (Feb 10, 2021)

* Sections runs representation for drilling and casing
* BHA&#x20;
  * Component representation at intervention sections
  * Witsml tubular importing
* Units for section attributes, bha, rigs and rigstate configuration
* Source configurations using the collector remote control
* Added support for Modbus protocol ([more](../../collector/protocols/modbus.md))
* Added support for tubular, wbGeomety, and mudlogs  objects in the WITSML output ([more](../witsml-output.md))
* Channels charts:
  * Added option to define baseline value for area series
  * Improved zones / area configuration
  * Export auto analysis PDF/PNG

### Fixes and improvements

* Allow use lot/fit tests with dashboard filters
* Fix well parameters table behavior
* Well json importing for lithology
* Operations initial date&#x20;
* Well parameters units fixes
* Improvements to the Depth Auto Update service
* Performance improvements on the WITSML Output
* \[Collector] WITS - allow override timestamp&#x20;

## 2.27.0 (Nov 5, 2020)

### New features

* Pressure Tests
  * LOT - Leak Off Test workflow ([more](../../whats-new/pressure-tests/lot-fit.md))
  * FIT - Formation Integrity Test workflow ([more](../../whats-new/pressure-tests/lot-fit.md))
  * Group correlated specific tests
  * Add-ons to enable/disable specific tests ([more](../../features/add-ons.md))
  * Disable pressure loss calculation at LOT/FIT
* Allow rig state calculation configuration by rig ([more](../../whats-new/rig-state-detection.md))
* Represent derrick data on rig parameters
* Import/Export well static JSON files ([more](../../features/import-export-well.md))
* WITSML configuration using the collector remote control
* "Wrap" series on charts axis
* Allow defining color zones by thresholds on charts

### Fixes and improvements

* UX improvements
* Renormalization throttle
* New standard/calculated curves UI
* Fix Gantt dashboard for custom intervention
* Fix Intervention permissions for completion column and sections
* Rig state calculation improvements
* FIT calculation&#x20;

{% hint style="info" %}
This version depends on [Live 2.28.0](https://platform.intelie.com/release-notes#2-28-0-aug-21-2020)
{% endhint %}

{% hint style="info" %}
There are new plugins on this version: plugin-ui-components and plugin-rig-state
{% endhint %}

## 2.26.3 (Oct 5, 2020)

### Fixes and improvements

* Fix colors of custom interventions on Gantt charts
* \[fixed] `pom.xml` project files were incorrect to be used as dependencies
* \[fixed] Errors when exporting calculated data

## 2.26.2 (Sep 17, 2020)

### Fixes and improvements

* UX improvements on charts and assets pages
* \[fixed] Crew - users with view permission should be able to see "operation status"

## 2.26.1 (Sep 11, 2020)

### Fixes and improvements

* \[fixed] OpenWells import issues
* \[fixed] Well pipe function for location
* \[fixed] Valves rules improvements in csb schematic&#x20;
* \[fixed] Unit selector history fixes
* \[fixed] Backlog querier should run only for time-based logs
* \[fixed] WITSML querier should be stateless
* UX improvements
* Support for UTF-16 on WITSML
* Completion columns improvements

## 2.26.0 (Aug 25, 2020)

### New features

* Gantt chart for planned interventions ([more](../../features/data-visualization/gantt.md))
* OpenWells integration
* CSB (Poço Web) integration
* API to edit hole and measured depth
* Depth picker - add "Entire depth" option
* Support for different units of measurement in well static data
* Backlog data request using collector remote control ([more](../../collector/remote-control/sources/backlog-sync.md))
* Retrieve WITSML tree and active configuration using collector remote control ([more](../../collector/remote-control/sources/witsml-object-explorer.md))
* Mark data gaps on line charts (depends on Live 2.28.0+)
* New options on pressure tests configurations
* Support for multiple completion columns

### Fixes and improvements

* \[fixed] WITSML request stuck with offset config
* \[fixed] WITSML parser ignores case-insensitive index curve
* Added support for new units of measurement

## 2.25.0 (Jul 2, 2020)

### New features

* Support for intervention planning scenarios;
* New intervention user interface, allowing users to set up one intervention per section;
* Added pipes functions to retrieve information about interventions;
* Make the liverig collector handle WITSML Store data edition;
* Allow backlog history to support wildcards on the collector;
* Support dynamic event type for raw data based on information like the well name, log, etc.; ([more](../../collector/configuration/tags-in-liverig-collector.md))
* Support reversed scale on charts.

### Fixes and improvements

* \[fixed] General fixes and improvements to the liverig collector;
* Improvements to chart data download;
  * Asset name and channels as download file name
  * Excel files have an additional description row with timezone and units of channels
* UX improvements to charts;
* Editable section names.

{% hint style="info" %}
This version depends on [Live 2.27.0](https://platform.intelie.com/release-notes#2-27-0-jul-2-2020)
{% endhint %}

## 2.24.1 (May 19, 2020)

### Fixes and improvements

* Added support to remote WITSML Store log modifications
* Added cache to timestamp resolution reduction
* \[fixed] Empty dashboards due to wrong permission check
* \[fixed] Issue in WITSML server mode authentication

## 2.24.0 (Apr 30, 2020)

### New features

* Inline dashboard on assets page
* More granular access permission levels to view and manage assets
* Specific permissions to view and manage collectors

### Fixes and improvements

* Faster storage queries
* Better handle full disk on collector
* UX improvements
* \[fixed] Security issues
* \[fixed] Calculated channels dependency errors

{% hint style="info" %}
This version depends on [Live 2.26.0](https://platform.intelie.com/release-notes#2-26-0-apr-30-2020)
{% endhint %}

## 2.23.0 (Mar 20, 2020)

### New features

* Depth based charts ([more](../../features/data-visualization/channels-charts/#depth-channels-chart))
* Depth values unit of measurement conversion on normalized events ([more](../../data-flow/data-normalization/data-enrichment.md#depth-based-sources))
* Option to reduce the normalized timestamp resolution, in `ms` by default, thus making storage queries faster
* Added sections information to intervention pipes function
* Tool joint drill pipe section
* Support for wildcard on WITSML object
* Support for ignoring invalid SSL certificates in OPC

### Fixes and improvements

* \[fixed] Re-normalization status never ended
* Performance improvements on assets page
* Warn on simultaneous editions of the data normalization page
* Allow to save normalization configuration without losing the page state
* UX improvements

{% hint style="info" %}
This version depends on [Live 2.25.17](https://platform.intelie.com/release-notes#2-25-17-mar-20-2020)
{% endhint %}

## 2.22.1 (Feb 18, 2020)

### Fixes and improvements

* \[fixed] Possible deadlock on operation mode configuration toggle
* General UX improvements on well parameters

## 2.22.0 (Feb 11, 2020)

### New features

* Lithology, geologic age and formations at well attributes (+16 fields indexed by elevation)
* Completion general data (+35 fields, 29 conditions)
* Completion production/injection string data (+7 fields, 2 conditions)
* Superior and Inferior completion column data (+18 fields)
* Stimulation data (+9 fields, 8 conditions)
* Abandonment general information (+16 fields, 14 conditions)
* Production adapter base and Christmas tree data (PAB/WTC) (+9 fields, 8 conditions)
* Perforation elements:
  * Pip tags (+4 fields)
  * Packers (+2 fields)
  * Perforating slots (+5 fields)
  * Remaining (+8 fields)
  * Cement Plugs (+7 fields)
* Poçoweb integration:
  * Completion and abandonment (\~100 fields)
  * Lithology (+16 fields indexed by elevation)
  * Rig (+10 fields)&#x20;
  * BOP (+7 fields)
  * Completion columns (+9 fields)
* Operations tab at drilling intervention sections (+7 fields)
* Get intervention by well with section attributes with function intervention("event\_type")
* Use different period to retrieve wildcard structure on the collector
* Normalization configuration trace on every event

### Fixes and improvements

* \[fixed] BHA selection at sections
* Performance improvements on charts

{% hint style="info" %}
This version depends on Live 2.25.13
{% endhint %}

## 2.21.3 (Feb 10, 2020)

### Fixes and improvements

* Performance improvements on Pronova integration
* Avoid saving some unnecessary data on SQL database
* \[fixed] A few seconds delay to render some widgets

## 2.21.2 (Jan 29, 2020)

### Fixes and improvements

* \[fixed] Specific WITSML mnemonics could not be parsed in the data normalization
* \[fixed] Assets pipes functions that use the timespan could not be used on datasources
* Allow that the axis limits and alerts thresholds are defined in different units based on the currently selected unit set
* Accept both `.` and `,` as decimal number separators on chart configuration forms

## 2.21.1 (Jan 24, 2020)

### Fixes and improvements

* \[fixed] Prevent a condition that makes the same data be collected several times
* Performance improvements on asset loading
* UX improvements on assets data management tab
* Allow to choose the WISTML version via the collector web interface
* Allow to choose the index type via collector web interface

## 2.21.0 (Jan 16, 2020)

### New features

* Data normalization input auto-switch based on data quality ([more](../../data-flow/data-normalization/auto-switch.md))
* Enhanced operation mode detection algorithm ([more](../../whats-new/rig-state-detection.md))
* Operation mode feed and auto detection for rigs and wells ([more](../../whats-new/rig-state-detection.md#operations-feed))
* Operation mode algorithms configuration interface ([more](../../whats-new/rig-state-detection.md#configuration))
* Ability to change units of measurement for a specific dashboard
* Ability to filter and search on the normalization channels mapping configuration
* A new plugin, plugin-assets, was created to centralize generic assets features and source code ([more](broken-reference))

### Fixes and improvements

* Several configurations were moved to outside of the administration page
* Added option to export units of measurement on REST output integrations
* Performance improvements on data collection
* Performance improvements on data visualization
* \[fixed] Collector's requests were not filtering logs requests by index type

{% hint style="info" %}
This version depends on Live 2.25.8
{% endhint %}

## 2.20.1 (Dec 18, 2019)

### Fixes and improvements

* UX improvements on standard channels and data normalization screens
* \[fixed] Collector would not correctly query the store for specific cases on WITSML 1.4.1.1
* \[fixed] Some pressure tests were not being performed
* \[fixed] Empty lines on some forms
* \[fixed] Issues on charts Y axis configuration

## 2.20.0 (Dec 9, 2019)

### New features

* Data normalization templates ([more](../../administration/data-normalization/data-normalization-templates.md))
* Support for regions, fields and countries configuration ([more](../../administration/static-data/regions-fields-and-countries.md))
* Support for intervention types configuration ([more](../../administration/static-data/intervention-types.md))
* Added intervention filters to rigs and wells lists
* Added well filter on rigs list
* Added rigs filter on wells list
* Added regions, fields and countries filter on wells and rigs lists
* Added support for tubular objects in WITSML
* Support for wildcards (\*) on more WITSML objects on the collector
* Support for different filters in requests and sources on the collector

### Fixes and improvements

* Live will now send an email to the administrators when any collector is close to run out of disk space
* UX improvements on normalization channels management ([more](../../administration/data-normalization/))
* Performance improvements on wells and rigs lists

## 2.19.1 (Nov 8, 2019)

### Fixes and improvements

* \[fixed] Concurrency issue that could make the backlog bandwidth limit on the collector affect the real time transmission
* Improvements on WITSML performance on the collector
* UX improvements on lists on mobile devices
* UX improvements on lithology widgets
* UX improvements on _Poço Web_ integration
* General UX improvements

## 2.19.0 (Oct 24, 2019)

### New features

* Support for well-based data normalization ([more](../../data-flow/data-normalization/))
* Allow to enable and disable the normalization for each asset ([more](../../administration/data-normalization/))
* Support for fluids and geometry in drilling intervention static data ([more](../../static-data/intervention/drilling-section-schema.md))
* Allow that channels are normalized without being configured if they match the standard names
* Display collector sources configuration details on Live web interface
* Display number of received channels and compression rate for each collector on Live web interface
* Integration with Intelie's _Poço Web_ to retrieve well project data
* Support for filters in WITSML wildcard configuration
* Support for WITSML version 1.4.1.1 in server mode on the collector ([more](../../collector/protocols/witsml.md))
* Support for ignoring invalid SSL certificates in WITSML ([more](../../collector/configuration/liverig.properties.md))
* Allow multiple null values in CSV protocol

### Fixes and improvements

* Performance improvements on WITSML data collection
* UX improvements on the asset page
* UX improvements on the collectors page

## 2.18.2 (Oct 7, 2019)

### Fixes and improvements

* \[fixed] Dashboard links on asset pages were not correctly generated when asset names had spaces

## 2.18.1 (Oct 3, 2019)

### Fixes and improvements

* Improvements on form text inputs
* Collector's data files now rotate at a fixed time every day, 4 AM by default

## 2.18.0 (Sep 16, 2019)

### New features

* Support for favorite wells on well list
* Extract daily logger to the top level of the well interface
* Add location information to the well interface
* Information about TLS/SSL on the collectors web interface

### Fixes and improvements

* Reduce header size to give more space to dashboards and other content
* Performance improvements on MongoDB storage provider
* Performance improvements on persistent queue write
* Support for using any SQL integration as a storage provider

{% hint style="info" %}
This version depends on Live 2.25.0
{% endhint %}

## 2.17.0 (Aug 16, 2019)

### New features

* Allow to filter charts content by rig ([more](../../features/data-visualization/channels-charts/))
* Allow to perform data renormalization in batch ([more](../../administration/data-normalization/))
* Standard identifiers for out-of-the-box analyses ([more](../../administration/standard-identifiers.md))
* Allow using SSL/TLS on the connection between Live and the collectors ([more](../../collector/security.md))
* Web interface for the collectors ([more](../../collector/monitoring.md))

### Fixes and improvements

* Provide the measured depth in the WITSML output
* Improvements on performance to load the remote WITSML tree

{% hint style="info" %}
This version depends on Live 2.24.5
{% endhint %}

## 2.16.0 (Jul 4, 2019)

### New features

* Wells interface, static parameters, interventions and daily operational reports
* PDF and PNG export on all charts
* Interface to monitor all Pipes queries
* Information about transmission status to help channels normalization management
* Download API support to many formats, such as XLSX

### Fixes and improvements

* More options available on temporal chart configuration, including the visualization mode
* Ability to filter query warnings by severity from the query
* Allow setting session timeout in the Live interface
* Enabled reordering on lookup tables list and added a search bar
* Admin users can now see the last login date of each user on the system
* Log in settings on system settings admin
* HTML Editor | Removing throttles and using recursive approach to update state
* New queries API (+ QueryObservers)
* User able to log in despite being disabled
* Auth provider NPE causes failure on start
* Widget lookup errors are not shown and resets filters
* Users without admin permission receiving error messages when saving standard or SVG widgets
* Channels temporal axis messing up asset names
* Axes disappearing on Temporal Channels Chart
* User without the proper level of permission being able to see dashboards list&#x20;
