# Intervention Schema

### Intervention

| Field              | Type                          |
| ------------------ | ----------------------------- |
| `rigId`            | string                        |
| `wellId`           | string                        |
| `wellIntervention` | Intervention.WellIntervention |

### Intervention.WellIntervention

| Field         | Type   |                                          |
| ------------- | ------ | ---------------------------------------- |
| `status`      | string | active, finished, planned                |
| `goal`        | string |                                          |
| `type`        | string | i.e: drilling, completion, workover, etc |
| `responsible` | string |                                          |
| `rotaryTable` | double |                                          |
| `letDown`     | double |                                          |
| `begin`       | long   | Initial timestamp                        |
| `end`         | long   | Final timestamp                          |
