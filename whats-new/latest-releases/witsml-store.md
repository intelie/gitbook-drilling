---
description: A fully-compliant WITSML Store server made upon Live Wells 5 and LiveRig 4
---

# WITSML Store

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
