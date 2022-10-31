# Drilling Section Schema

{% hint style="success" %}
At the plugin-wells 2.28.0 the structure of sections has changed from the structure **InterventionDrillingSection** to **InterventionDrillingSectionRuns** described below.&#x20;
{% endhint %}

### InterventionDrillingSection

| Field      | Type                                   |
| ---------- | -------------------------------------- |
| `sections` | list\<InterventionDrillingSectionData> |

### InterventionDrillingSectionRuns

| Field      | Type           |
| ---------- | -------------- |
| `sections` | list\<RunData> |

### RunData

| Field   | Type                            |
| ------- | ------------------------------- |
| `run`   | list\<DrillingRun \| CasingRun> |
| `units` | InterventionSection.RunUnits    |

### DrillingRun

| Field             | Type                                   |
| ----------------- | -------------------------------------- |
| `id`              | string                                 |
| `name`            | string                                 |
| `type`            | "Drilling" \| "Casing"                 |
| `start_timestamp` | long                                   |
| `end_timestamp`   | long                                   |
| `active`          | boolean                                |
| `migrated`        | boolean                                |
| `well_bores`      | list\<InterventionSection.WellBore>    |
| `drill_strings`   | list\<InterventionSection.DrillString> |
| `BHAs`            | list\<InterventionSection.BHA>         |
| `drilling_fluids` | list\<InterventionSection.Fluid>       |
| `operations`      | list\<InterventionSection.Operation>   |
| `units`           | InterventionSection.RunUnits           |

### CasingRun

| Field               | Type                                   |
| ------------------- | -------------------------------------- |
| `id`                | string                                 |
| `name`              | string                                 |
| `type`              | "Drilling" \| "Casing"                 |
| `start_timestamp`   | long                                   |
| `end_timestamp`     | long                                   |
| `active`            | boolean                                |
| `migrated`          | boolean                                |
| `casings`           | list\<InterventionSection.Casing>      |
| `work_columns`      | list\<InterventionSection.WorkColumn>  |
| `centralizers`      | list\<InterventionSection.Centralizer> |
| `casing_fluids`     | list\<InterventionSection.Fluid>       |
| `casing_operations` | list\<InterventionSection.Operation>   |
| `units`             | InterventionSection.RunUnits           |

### InterventionDrillingSectionData

| Field             | Type                                   |
| ----------------- | -------------------------------------- |
| `well_bores`      | list\<InterventionSection.WellBore>    |
| `drill_strings`   | list\<InterventionSection.DrillString> |
| `BHAs`            | list\<InterventionSection.BHA>         |
| `drilling_fluids` | list\<InterventionSection.Fluid>       |
| `operations`      | list\<InterventionSection.Operation>   |
| `units`           | InterventionSection.SectionUnits       |

### InterventionCasingSectionData <a href="#interventiondrillingsectiondata-1" id="interventiondrillingsectiondata-1"></a>

| Field               | Type                                   |
| ------------------- | -------------------------------------- |
| `casings`           | list\<InterventionSection.Casing>      |
| `work_columns`      | list\<InterventionSection.WorkColumn>  |
| `centralizers`      | list\<InterventionSection.Centralizer> |
| `casing_fluids`     | list\<InterventionSection.Fluid>       |
| `casing_operations` | list\<InterventionSection.Operation>   |
| `units`             | InterventionSection.SectionUnits       |

## Drilling definitions

### InterventionSection.WellBore

| Field            | Type   |
| ---------------- | ------ |
| `type`           | string |
| `start_md`       | double |
| `final_md`       | double |
| `inner_diameter` | double |
| `outer_diameter` | double |
| `linear_weight`  | double |

### InterventionSection.DrillString

| Field            | Type                 |
| ---------------- | -------------------- |
| `component_type` | string               |
| `component_id`   | string               |
| `length`         | double               |
| `inner_diameter` | double               |
| `outer_diameter` | double               |
| `linear_weight`  | double               |
| `tool_joint`     | ToolJointsTypeConfig |

### InterventionSection.BHA

| Field            | Type    |
| ---------------- | ------- |
| `component_type` | string  |
| `component_id`   | string  |
| `length`         | double  |
| `inner_diameter` | double  |
| `outer_diameter` | double  |
| `linear_weight`  | double  |
| `tfa`            | double  |
| `description`    | string  |
| `quantity`       | integer |
| `topMD`          | double  |
| `baseMD`         | double  |

### InterventionSection.Fluid

| Field                                | Type    |
| ------------------------------------ | ------- |
| `name`                               | string  |
| `type`                               | string  |
| `density`                            | double  |
| `compressible`                       | boolean |
| `rheological_power_law_exponent`     | double  |
| `rheological_flow_consistency_index` | double  |
| `oil_concentration`                  | double  |
| `water_concentration`                | double  |
| `solids_concentration`               | double  |
| `salt_concentration`                 | double  |
| `salt_type`                          | string  |
| `active`                             | boolean |
| `complements`                        | string  |
| `observations`                       | string  |
| `rheological_yield_point`            | double  |
| `specific_heat`                      | double  |
| `thermal_conductivity`               | double  |

### InterventionSection.Operation

| Field             | Type   |
| ----------------- | ------ |
| `name`            | string |
| `start_md`        | number |
| `end_md`          | number |
| `start_date`      | string |
| `start_time`      | string |
| `end_date`        | string |
| `end_time`        | string |
| `start_timestamp` | long   |
| `end_timestamp`   | long   |
| `timezone`        | string |

## Casing definitions

### InterventionSection.Casing

| Field            | Type   |
| ---------------- | ------ |
| `component_type` | string |
| `component_id`   | string |
| `length`         | double |
| `inner_diameter` | double |
| `outer_diameter` | double |
| `linear_weight`  | double |

### InterventionSection.WorkColumn

| Field            | Type                 |
| ---------------- | -------------------- |
| `component_type` | string               |
| `component_id`   | string               |
| `length`         | double               |
| `inner_diameter` | double               |
| `linear_weight`  | double               |
| `tool_joint`     | ToolJointsTypeConfig |

### InterventionSection.Centralizer

| Field             | Type   |
| ----------------- | ------ |
| `component_id`    | string |
| `description`     | string |
| `outer_diameter`  | double |
| `weight`          | double |
| `length`          | double |
| `friction_torque` | double |
| `friction_drag`   | double |
| `running_force`   | double |
| `start_md`        | double |
| `final_md`        | double |

## Units definitions

### InterventionSection.SectionUnits

| Field             | Type                                 |
| ----------------- | ------------------------------------ |
| `well_bores`      | InterventionSection.WellBoreUnits    |
| `drill_strings`   | InterventionSection.DrillStringUnits |
| `BHAs`            | InterventionSection.BHAUnits         |
| `drilling_fluids` | InterventionSection.FluidUnits       |

### InterventionSection.RunUnits

| Field             | Type                                  |
| ----------------- | ------------------------------------- |
| `well_bores`      | InterventionSection.WellBoreUnits     |
| `drill_strings`   | InterventionSection.DrillStringUnits  |
| `BHAs`            | InterventionSection.BHAUnits          |
| `drilling_fluids` | InterventionSection.FluidUnits        |
| `casings`         | InterventionSection.CasingUnits       |
| `work_columns`    | InterventionSection.WorkColumnsUnits  |
| `centralizers`    | InterventionSection.CentralizersUnits |
| `casing_fluids`   | InterventionSection.FluidUnits        |

### InterventionSection.DrillStringUnits

| Field            | Type   |
| ---------------- | ------ |
| `length`         | string |
| `inner_diameter` | string |
| `outer_diameter` | string |
| `linear_weight`  | string |

### InterventionSection.BHAUnits

| Field            | Type   |
| ---------------- | ------ |
| `length`         | string |
| `inner_diameter` | string |
| `outer_diameter` | string |
| `linear_weight`  | string |
| `tfa`            | string |
| `topMD`          | string |
| `baseMD`         | string |

### InterventionSection.WellBoreUnits

| Field            | Type   |
| ---------------- | ------ |
| `start_md`       | string |
| `final_md`       | string |
| `inner_diameter` | string |
| `outer_diameter` | string |
| `linear_weight`  | string |
|                  |        |

### InterventionSection.CasingUnits

| Field            | Type   |
| ---------------- | ------ |
| `length`         | string |
| `inner_diameter` | string |
| `outer_diameter` | string |
| `linear_weight`  | string |

### InterventionSection.WorkColumn

| Field            | Type                 |
| ---------------- | -------------------- |
| `length`         | double               |
| `inner_diameter` | double               |
| `linear_weight`  | double               |
| `tool_joint`     | ToolJointsTypeConfig |

### InterventionSection.Centralizer

| Field             | Type   |
| ----------------- | ------ |
| `outer_diameter`  | string |
| `weight`          | string |
| `length`          | string |
| `friction_torque` | string |
| `friction_drag`   | string |
| `running_force`   | string |
| `start_md`        | string |
| `final_md`        | string |

### InterventionSection.FluidUnits

| Field                                | Type   |
| ------------------------------------ | ------ |
| `density`                            | string |
| `rheological_power_law_exponent`     | string |
| `rheological_flow_consistency_index` | string |
| `oil_concentration`                  | string |
| `water_concentration`                | string |
| `solids_concentration`               | string |
| `salt_concentration`                 | string |
| `rheological_yield_point`            | string |
| `specific_heat`                      | double |
| `thermal_conductivity`               | double |

