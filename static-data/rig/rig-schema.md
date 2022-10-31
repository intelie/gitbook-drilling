# Rig Schema



{% hint style="info" %}
In version 2.27.0 of plugin-wells, derrick parameters were migrated from RigDescription to DerrickInfo and also included the PhysicalModelParameters new part
{% endhint %}

### Rig

| Field                     | Type                        |
| ------------------------- | --------------------------- |
| `description`             | Rig.Description             |
| `BOPInfo`                 | Rig.BOPInfo                 |
| `DerrickInfo`             | Rig.DerrickInfo             |
| `PhysicalModelParameters` | Rig.PhysicalModelParameters |
| `extra`                   | Map\<String, Object>        |

### Rig.Description

| Field                       | Type                  |
| --------------------------- | --------------------- |
| `name`                      | string                |
| `type`                      | string                |
| `company`                   | string                |
| `airGap`                    | string                |
| `maxWaterDepth`             | string                |
| `maxDrilledDepth`           | string                |
| `derrickHeight`             | string                |
| `derrickBase`               | string                |
| `rotaryTableCapacity`       | string                |
| `rotaryTableMaxTorque`      | string                |
| `mudPumps`                  | string                |
| `maxMudPumpsSystemPressure` | string                |
| `topDriveWeight`            | string                |
| `topDriveMaxTorque`         | string                |
| `topDriveCapacity`          | string                |
| `pumpMaxPressure`           | string                |
| `travellingBlockCapacity`   | string                |
| `travellingBlockWeight`     | string                |
| `riserDiameter`             | string                |
| `units`                     | Rig.Description.Units |

### Rig.Description.Units

| Field                       | Type   |
| --------------------------- | ------ |
| `airGap`                    | string |
| `maxWaterDepth`             | string |
| `maxDrilledDepth`           | string |
| `derrickHeight`             | string |
| `derrickBase`               | string |
| `rotaryTableCapacity`       | string |
| `rotaryTableMaxTorque`      | string |
| `mudPumps`                  | string |
| `maxMudPumpsSystemPressure` | string |
| `topDriveWeight`            | string |
| `topDriveMaxTorque`         | string |
| `topDriveCapacity`          | string |
| `pumpMaxPressure`           | string |
| `travellingBlockCapacity`   | string |
| `travellingBlockWeight`     | string |
| `riserDiameter`             | string |

### Rig.BOPInfo

| Field                         | Type              |
| ----------------------------- | ----------------- |
| `model`                       | string            |
| `maxPressure`                 | string            |
| `annularPreventerMaxPressure` | string            |
| `floatingStackBOPWeight`      | string            |
| `BOPStackHeight`              | string            |
| `LMRPFloatingWeight`          | string            |
| `LMRPFloatingHeight`          | string            |
| `units`                       | Rig.BOPInfo.Units |

### Rig.BOPInfo.Units

| Field                         | Type   |
| ----------------------------- | ------ |
| `maxPressure`                 | string |
| `annularPreventerMaxPressure` | string |
| `floatingStackBOPWeight`      | string |
| `BOPStackHeight`              | string |
| `LMRPFloatingWeight`          | string |
| `LMRPFloatingHeight`          | string |

### Rig.DerrickInfo

| Field                   | Type                  |
| ----------------------- | --------------------- |
| derrickHeight           | string                |
| derrickBaseWidth        | string                |
| derrickBaseLength       | string                |
| travellingBlockCapacity | string                |
| travellingBlockWeight   | string                |
| topDriveWeight          | string                |
| topDriveMaxTorque       | string                |
| topDriveCapacity        | string                |
| standLength             | string                |
| pipeLength              | string                |
| `units`                 | Rig.DerrickInfo.Units |

### Rig.DerrickInfo.Units

| Field                   | Type   |
| ----------------------- | ------ |
| derrickHeight           | string |
| derrickBaseWidth        | string |
| derrickBaseLength       | string |
| travellingBlockCapacity | string |
| travellingBlockWeight   | string |
| topDriveWeight          | string |
| topDriveMaxTorque       | string |
| topDriveCapacity        | string |
| standLength             | string |
| pipeLength              | string |

### Rig.PhysicalModelParameters

| Field                             | Type           |
| --------------------------------- | -------------- |
| minimumFlowRate                   | Double         |
| connectionTimeout                 | Double         |
| minimumAngularVelocity            | Double         |
| minimumWeightOnBit                | Double         |
| bottomDepthTolerance              | Double         |
| minimumWeightOnHook               | Double         |
| hookLoadRatioThresholdForDecrease | Double         |
| hookLoadRatioThresholdForIncrease | Double         |
| movementThreshold                 | Double         |
| reciprocatingThreshold            | Double         |
| velocitiesDifferenceTolerance     | Double         |
| disabledModels                    | Array\<string> |
