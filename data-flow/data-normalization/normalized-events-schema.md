# Normalized events schema

## Normalized events basic schema

| Field                                                                                                                                    | Type   |
| ---------------------------------------------------------------------------------------------------------------------------------------- | ------ |
| `__type`                                                                                                                                 | string |
| The event type that identifies the asset.                                                                                                |        |
| `mnemonic`                                                                                                                               | string |
| The abbreviation of the channel.                                                                                                         |        |
| `value`                                                                                                                                  | double |
| The value converted to the standard unit of measurement.                                                                                 |        |
| `uom`                                                                                                                                    | string |
| The unit of measurement after the conversion                                                                                             |        |
| `timestamp`                                                                                                                              | long   |
| The date of reception of the measurement. It can change if the data is re-normalized. It should **not** be used as the measurement date. |        |

As we will see in the [next chapter](data-enrichment.md), the index of each measurement may vary according to the context, basically if the date and/or the depth can be inferred for each data source.

## Debug mode

If the option `Include raw fields` is marked on the asset normalization configuration, an extra set of fields is added to each event. This is useful for troubleshooting and audit reasons.

| Field                                                                                                                            | Type   |
| -------------------------------------------------------------------------------------------------------------------------------- | ------ |
| `raw_value`                                                                                                                      | double |
| The original value.                                                                                                              |        |
| `raw_uom`                                                                                                                        | string |
| The original unit of measurement.                                                                                                |        |
| `raw_mnemonic`                                                                                                                   | string |
| The original mnemonic (abbreviation for the channel name).                                                                       |        |
| `converted_value`                                                                                                                | double |
| The value after conversion. This can be different from the `value` if the option `Ignore unit conversion errors` is not enabled. |        |
| `capture_timestamp`                                                                                                              | long   |
| The date that the event was received by the collector (while `timestamp` is the date that it was received by INTELIE Live).      |        |

## Errors

If any error occurs in the normalization the normalized event will contain an **errors** field. This field will be a list of all the related errors, please see below the possible values&#x20;

| Flag                 | Reason                                                                                                                       |
| -------------------- | ---------------------------------------------------------------------------------------------------------------------------- |
| `missing_src_value`  | Raw data is missing the value                                                                                                |
| `missing_src_unit`   | Raw data is missing the unit                                                                                                 |
| `unknown_src_unit`   | Raw data have an unknown unit                                                                                                |
| `unknown_dst_unit`   | Target channel has an unknown unit                                                                                           |
| `base_unit_mismatch` | It's not possible to do the unit conversion                                                                                  |
| `off_scale_low`      | After the conversion, the value is too low                                                                                   |
| `off_scale_high`     | After the conversion, the value is too high                                                                                  |
| `broken_src_unit`    | Raw data unit has an error, however, LIVE was able to fix it (see [below](normalized-events-schema.md#unit-automatic-fixes)) |
| `broken_src_value`   | Raw data value isn't a valid number                                                                                          |
| `broken_depth_value` | It was not possible to normalize the `depth_value`                                                                           |
| `broken_index_value` | It was not possible to normalize the `index_value`                                                                           |
| `broken_unit`        | Unit error, however, LIVE was able to fix it (see [below](normalized-events-schema.md#unit-automatic-fixes))                 |

## Unit automatic fixes

The normalization process tries to fix the unit automatically when either the source unit or the target unit are not one of those described by the [Energistics standard](https://www.energistics.org/energistics-unit-of-measure-standard) dictionary.&#x20;

The default unit conversions supported by Live are described in the [unit conversion](unit-conversion.md) page. Additional conversions are also supported by customizing the unit management tools:

1. [Unit alias](https://drilling.intelie.com/administration/high-frequency-data/unit-management-tools#unit-alias)
2. [Unit extension](https://drilling.intelie.com/administration/high-frequency-data/unit-management-tools#unit-extension)
3. [Unit unchained conversion](https://drilling.intelie.com/administration/high-frequency-data/unit-management-tools#unchained-unit-conversion)

## Additional fields

Normalized event contains some additional compressed fields in order to save space. They may be expanded as following:

| Field    | Pipes function        | Meaning                                                   |
| -------- | --------------------- | --------------------------------------------------------- |
| `config` | `normalizer_config()` | Expand the normalization configuration at that moment     |
| `extra`  | `curve_extra()`       | Expand the normalization channels mapping at that moment  |

Usage example:

```
rig_01
=> config:normalizer_config() as config, extra:curve_extra() as extra
```

Results:

```
CONFIG:
{
  "include_extra_fields": false,
  "wellbore_name": "",
  "ignore_missing_units": false,
  "ignore_unit_errors": true,
  "targetMessageMnemonic,name": "MSG",
  "enabled": true,
  "event_type,name": "rig_01",
  "filter": "raw_rig_01",
  "has_default_depth_mnemonic": false,
  "merge_standard_curves_with_normalization_curves": false,
  "curves": "{\"CHANNEL_01\":{\"source\":\"XPTO Services 01\",
      \"mnemonic\":\"MNEMONIC_01\",\"options\":[{\"source\":\"Rig\",
      \"filter\":\"liverig__object-\\u003name:\\u0027Section 1 - Time\\u0027\",
      \"mnemonic\":\"MNEMONIC_01\"},{\"source\":\"Global\",
      \"filter\":\"liverig__object-\\u003name:\\u0027GENERAL TIME-BASED\\u0027\",
      \"mnemonic\":\"STGG\"}]}}",
  "include_raw_fields": false,
  "name": "RIG 01",
  "well_name": "WELL-1",
  "enableAutoSwitch": false
}

EXTRA:
{
  "CURVE_01": {
    "uom": "psi",
    "description": "CURVE base",
    "value": "11000"
  },
  "well": {
    "value": {
      "id": "130",
      "name": "My Bay - Brazil"
    }
  },
  "intervention": {
    "value": "6e5d5a3d-79c0-408e-ac18-f5de970eacfa"
  }
}
```
