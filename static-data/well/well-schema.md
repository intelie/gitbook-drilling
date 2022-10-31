# Well Schema

### Well

| Field          | Type              |
| -------------- | ----------------- |
| `description`  | Well.Description  |
| `location`     | Well.WellLocation |
| `sections`     | Well.Sections     |
| `pressures`    | Well.Pressures    |
| `trajectories` | Well.Trajectories |
| `temperatures` | Well.Temperatures |
| `lithology`    | Well.Lithology    |
| `objectives`   | Well.Objectives   |

### Well.Description

| Field             | Type                   |
| ----------------- | ---------------------- |
| `name`            | string                 |
| `type`            | string                 |
| `water_depth`     | string                 |
| `final_depth`     | string                 |
| `production_unit` | string                 |
| `goal`            | RichTextData           |
| `units`           | Well.Description.Units |

### Well.Description.Units

| Field         | Type   |
| ------------- | ------ |
| `water_depth` | string |
| `final_depth` | string |

### Well.Pressures

| Field      | Type                           |
| ---------- | ------------------------------ |
| `pore`     | list\<Well.Pressures.Pressure> |
| `fracture` | list\<Well.Pressures.Pressure> |
| `units`    | Well.Pressures.Units           |

### Well.Pressures.Pressure

| Field      | Type   |
| ---------- | ------ |
| `quota`    | double |
| `md`       | double |
| `pressure` | double |

### Well.Pressures.Units

| Field      | Type   |
| ---------- | ------ |
| `quota`    | string |
| `md`       | string |
| `pressure` | string |

### Well.Sections

| Field      | Type                         |
| ---------- | ---------------------------- |
| `sections` | list\<Well.Sections.Section> |
| `units`    | Well.Sections.Units          |

### Well.Sections.Section

| Field                 | Type   |
| --------------------- | ------ |
| `bit_diameter`        | string |
| `casing_diameter`     | string |
| `final_md`            | double |
| `md_casing_shoe`      | double |
| `top_of_cement`       | double |
| `liner_top_of_cement` | double |
| `liner_hanger_md`     | double |
| `fluid_weight`        | double |

### Well.Sections.Units

| Field            | Type   |
| ---------------- | ------ |
| `bit_diameter`   | string |
| `final_md`       | string |
| `md_casing_shoe` | string |
| `top_of_cement`  | string |

### Well.Temperatures

| Field         | Type                                 |
| ------------- | ------------------------------------ |
| `profile`     | list\<Well.Temperatures.Temperature> |
| `water_depth` | list\<Well.Temperatures.Temperature> |
| `units`       | Well.Temperatures.Units              |

### Well.Temperatures.Temperature

| Field         | Type   |
| ------------- | ------ |
| `quota`       | double |
| `md`          | double |
| `temperature` | double |

### Well.Temperatures.Units

| Field         | Type   |
| ------------- | ------ |
| `quota`       | string |
| `md`          | string |
| `temperature` | string |

### Well.Trajectories

| Field        | Type                                |
| ------------ | ----------------------------------- |
| `trajectory` | list\<Well.Trajectories.Trajectory> |
| `units`      | Well.Trajectories.Units             |

### Well.Trajectories.Trajectory

| Field                    | Type   |
| ------------------------ | ------ |
| `md`                     | double |
| `inclination`            | double |
| `azimuth`                | double |
| `tvd`                    | double |
| `horizontalDisplacement` | double |

### Well.Trajectories.Units

| Field                    | Type   |
| ------------------------ | ------ |
| `md`                     | string |
| `inclination`            | string |
| `azimuth`                | string |
| `tvd`                    | string |
| `horizontalDisplacement` | string |

### Well.WellLocation

| Field       | Type   |
| ----------- | ------ |
| `country`   | string |
| `region`    | string |
| `field`     | string |
| `latitude`  | string |
| `longitude` | string |

### Well.Lithology

| `Field`    | Type                                 |
| ---------- | ------------------------------------ |
| rocks      | list\<Well.Lithology.RockData>       |
| ages       | list\<Well.Lithology.GeologyAgeData> |
| formations | list\<Well.Lithology.FormationData>  |

### Well.Lithology.RockData

| Field           | Type   | Description    |
| --------------- | ------ | -------------- |
| top\_elevation  | double |                |
| base\_elevation | double |                |
| top\_md         | double |                |
| base\_md        | double |                |
| name            | string | Lithology rock |

### Well.Lithology.GeologyAgeData

| Field           | Type   | Description  |
| --------------- | ------ | ------------ |
| top\_elevation  | double |              |
| base\_elevation | double |              |
| top\_md         | double |              |
| base\_md        | double |              |
| name            | string | Geologic Age |

### Well.Lithology.FormationData

| Field           | Type   | Description |
| --------------- | ------ | ----------- |
| top\_elevation  | double |             |
| base\_elevation | double |             |
| top\_md         | double |             |
| base\_md        | double |             |
| name            | string | Formation   |
| classification  | string | Properties  |

### Well.Objectives

| Field     | Type                  |
| --------- | --------------------- |
| `targets` | list\<Well.Target>    |
| `units`   | Well.Objectives.Units |

### Well.Objectives.Units

| Field            | Type   |
| ---------------- | ------ |
| `top_elevation`  | string |
| `base_elevation` | string |
| `top_md`         | string |
| `base_md`        | string |
| `utm_north`      | string |
| `utm_east`       | string |

### Well.Target

| Field            | Type   |
| ---------------- | ------ |
| `typeTarget`     | string |
| `formationName`  | string |
| `hcExpected`     | string |
| `description`    | string |
| `top_elevation`  | double |
| `base_elevation` | double |
| `top_md`         | double |
| `base_md`        | double |
| `utm_north`      | double |
| `utm_east`       | double |
