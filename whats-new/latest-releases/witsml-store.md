---
description: A fully-compliant WITSML Store server made upon Live Wells 5 and LiveRig 4
---

# WITSML Store


## 1.8 series

**1.8.4**

* Improvements
  * Load most recently changelog objects

* Bugfixes
  * Fixes a parsing error in toolErrorTermSet object when sequence has size of 1 element
  * Fixes a parsing error in toolErrorModel object when sequence has size of 1 element
  * Fixes a parsing error in Trajectory object when sequence has size of 1 element
  * Fixes a parsing error in MudLog object when sequence has size of 1 element

**1.8.3**

* Improvements
  * Query Performance Improvements

* Bugfixes
  * Fixes a parsing error in Tubular object when sequence has size of 1 element
  * Fixes a parsing error in Target object when sequence has size of 1 element
  * Refactor FormationMarker object to reduce complexity
  * Fixes a parsing error in ObjectGroup object when sequence has size of 1 element
  * Fixes a parsing error in wbGeometry object when sequence has size of 1 element
  * Fixes a parsing error in FluidsReport object when sequence has size of 1 element
  * Fixes a parsing error in SurveyProgram object when sequence has size of 1 element
  * Fixes a parsing error in DrillReport object when sequence has size of 1 element
  * Fixes a parsing error in ConvCore object when sequence has size of 1 element
  * Fixes cascade delete function when deleting wells
  * Fixes a parsing error in BhaRun object when sequence has size of 1 element
  * Fixes a parsing error in OpsReport object when sequence has size of 1 element
  * Fixes a parsing error in CementJob object when sequence has size of 1 element
  * Fixes a parsing error in StimJob  object when sequence has size of 1 element
  * Fixes a parsing error in Rig object when sequence has size of 1 element
  * Fixes Log object to correct update his name when UpdateInStore function is executed

**1.8.1**

* Bugfixes
  * Fixes Well object to display kind tag correctly 
  * Fixes an error in sidewallCore objects to show multiple sequence tags
  * Fixes an error in message objects to show multiple param tags
  * Fixes an error in attachment objects to show multiple param tags
  * Fixes normalized mnemonics listing
  * Fixes missing tags in drillReport object
  * Fixes AddToStore function to avoid lose data and duplicate objects
  * Fixes AddToStore function avoiding objects with the same uid in the same well and wellbore
  * Fixes to add missing mudClass and ph tags in fluidObject object
  * Fixes to avoid adding changeLog objects using the AddToStore function
  * Fixes drillReport object to avoid Missing/duplicated tags
  * Fixes  UpdadeInStore function to avoid losing data

**1.8.0**

* New features
  * Some improvements for open-queries using 'dTimLastChange' as filter 
  * Added 'changeDetectionPeriod' to the functional capabilities 
  * Now the relationship with Live Asset Well is through the Witsml Object Wellbore 

* Bugfixes
  * Fixes an error when adding Attachment objects with empty 'extensionNameValue' element 
  * Fixes an error when adding Attachment objects with empty 'param' element 
  * Error to get the Message object and show the following elements: objectReference, subObjectReference, detailActivity and params 


## 1.7 series

**1.7.0**

* New features
  * Mechanism to update the old Changelog event types in the storage to new structure
  * Implementation of the ChangeLog object was changed the to use a single collection instead of many collections
  * Support for removing a single field (XML element) from the Mudlog object
  * Support ChangeLog data-object for Well and Wellbore
  * Support the latest-change-only funcionality
  * Support for removing a single curve (mnemonic) from the Log object
  * Support for removing a single field (XML element) for all objects (except Log)

* Bugfixes
  * Some query improvements
  * Fixed Update operation to not duplicating objects 
  * Fixed GetFromStore operation that was not working for some Mudlogs 
  * Fixed Query by UID that was not working for Changelog objects
  * Changelog object synchronization was removed 
  * Fixed Update operation on empty tag name in MudLog objects 
  


## 1.6 series

**1.6.0**

* Support decreasing for depth logs&#x20;
* Support for WITSML changelog object to audit editions about any objects (some known issues to fix against well and wellbore)
* Object growing support for trajectories

## 1.5 series

**1.5.0**

* JWT authentication token support&#x20;
* Support for `requestLatestValues` and `maxReturnNodes`
* Implement `cascadedDelete` feature&#x20;
* Create automatic storage index for non-witsml store objects&#x20;

## 1.3 series

**1.3.0**

* Performance improvements to object filtering
  * Caching for well and wellbore objects to accelerate queries
  * Other minor improvements Sync engine to allow data sharing between multiple WITSML stores
* WITSML objects availability
  * for native wells
  * for other wells
  * All 26 objects for WITSML 1.4.1.1 protocol version
  * 20 objects for WITSML 1.3.1.1 protocol version
* Normalization Features
  * Automatic data normalization configuration when a native well is added
  * Normalized data display using date-time and depth logs
  * for native wells (added through the WITSML store)
  * for other wells (collected by the LiveRig Collector, for example)
* Well Asset selection for legacy compatibility
* Fine adjustments
  * Maximum parallel requests processing
  * Queue size for parallel requests waiting
* Channel-limits detection for raw log objects
* Object details displayed as requested query
* Minor bugs fixing
* Replaying feature to reprocess audited requested queries
