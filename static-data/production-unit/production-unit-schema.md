# Production Unit Schema

### Production Unit

| Field | Type    |
| ----- | ------- |
| id    | string  |
| name  | string  |
| type  | string  |

### ProductionUnit.Attributes

| Field        | Type                     |
| ------------ | ------------------------ |
| location     | ProductionUnit.Location  |
| description  | ProductionUnit.Info      |

### ProductionUnit.Location

| Field      | Type                           |
| ---------- | ------------------------------ |
| country    | string                         |
| latitude   | string                         |
| longitude  | string                         |
| units      | ProductionUnit.Location.Units  |

### ProductionUnit.Location.Units

| Field      | Type    |
| ---------- | ------- |
| latitude   | string  |
| longitude  | string  |

### ProductionUnit.Info

| Field    | Type    |
| -------- | ------- |
| company  | string  |

### ProductionUnit.LinkedWells

| Field  | Type                                    |
| ------ | --------------------------------------- |
| wells  | List\<ProductionUnit.LinkedWells.Well>  |

### ProductionUnit.LinkedWells.Well

| Field             | Type    |
| ----------------- | ------- |
| wellId            | string  |
| wellName          | string  |
| interventionId    | string  |
| interventionName  | string  |
| interventionGoal  | string  |
