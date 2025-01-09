---
description: >-
  Major release delivers improvements on OPC-UA request configurations, new Modbus capabilities, and data traffic optimization.
---

# LiveRig 5

## 5.3 series

### 5.3.0

* Support changes to realtime span on zoom action
* Zoom in and out in multi-channel temporal widgets
* Feature flag to save TimescaleDB for OPC-UA protocol

## 5.2 series

### 5.2.0

* Change header orientation of temporal channels chart
* Add validation to the filter pipes field on data normalization
* Use Live Tooltip instead of OverlayTrigger and Tooltip from react-bootstrap
* Add possibility to ignore or define date position in CSV protcol
* Tooltip improvements

## 5.1 series

### 5.1.0

* Add new resource to convert a set of units in a single request
* Create service to retrieve default units and store display unit associated with asset
* Improvement to mark wrapped-series as auxiliary series
* Add TCP client mode for CSV source ([more](../../collector/protocols/csv.md))
* Add source filter to sources tab on new collector screen

## 5.0 series

### 5.0.0

**API Breaks**:

* Add support for retrieving complex OPC-UA objects' fields as values. This allows declaring in the OPC-UA tag configuration which field is expected to be retrieved when its source is queried on the server. Detailed information can be found at [store json documentation](../../collector/configuration/store.json.md#liverig-collector-5.0.0-or-above).
* Add a new layout for Modbus configuration to allow multi-channel retrieval per event. Detailed information can be found in [modbus configuration](../../collector/configuration/modbus.json.md) section.
* Add support for Modbus multi-register values. The Modbus protocol can represent values by merging the results of multiple contiguous registers. An example of this capability is the data type _Int32_, which makes use of 2 registers to represent values. From this version, it is possible to configure these bigger data types on the [modbus configuration](../../collector/configuration/modbus.json.md).
* Change the semantics of the field `count` on the [modbus configuration](../../collector/configuration/modbus.json.md) to represent the number of contiguous data (possibly multi-register data) instead of the number of registers. This improvement allows retrieving a collection of multi-register values.
* New layout for the `internal` event to reduce data traffic. The internal event was identified as responsible for a considerable amount of bandwidth consumption between Live and the Liverig Collector. Aiming to reduce data traffic, it was added an opt-in flag to send the `internal` event containing the sources' configuration data only in its first occurrence after the LiveRig Collector initialization. Since the collector is restarted after a configuration change, the up-to-date configuration is sent in the first `internal` event after.
* Add the `internal` event field to send the collector configuration files' hash codes. This allows cache invalidation, which relies on the hash code of each configuration's file.

**Features and improvements**:

* Add a patch approach for updating the collector's configuration files. This feature aims to reduce the data traffic between the Liverig Collector and the Plugin Liverig by sending just the incremental difference when an update operation is requested by the user.
* Reduce the remote control data traffic by adding caches to hold the configuration files’ content at the Plugin Liverig side. The remote control is frequently used to retrieve information about sources, properties, and additional configurations (modbus.json and store.json). Most of the time, it is not necessary to retrieve the data from the collector because they may not be changed after the last retrieval.
* General refactoring of the collector daemon runner code. This aims to improve readability and maintainability.
