# Dashboard Configuration

## Unit Set on Dashboard

After defining a unit set it is possible to use it in a dashboard:

![](<../../.gitbook/assets/image (127).png>)

## Unit Set Types

The unit set has 3 categories:

* **Global units set:** Unit set built-in in Live, available for usage by all users
* **Customized Unit set:** Unit set for personal usage
* **Follow Asset Filter:** The dashboard will follow the units set of the first asset filter item of lookup table selected

### Global Unit Set

When opening the unit set modal in dashboard, it is possible to select the unit set saved in configuration previously. Selecting a global unit set for example Imperial would affect the channels on the dashboard configured for that unit set:

![](<../../.gitbook/assets/image (289).png>)

![](<../../.gitbook/assets/image (220).png>)

It is possible to duplicate a unit set:

![](<../../.gitbook/assets/image (469).png>)

### Personal Unit Set

It is possible to use a personal unit set by user on the dashboard:

![](<../../.gitbook/assets/image (246).png>)

### Follow Filter

If there are no assets in the filter, or the filter uses a lookup other than **lookup.asset\_name\_event\_type**, the filter option will be disabled.

![](<../../.gitbook/assets/image (182).png>)

The dashboard allow define multiple filters but the follow asset filter will use the first one:

![](https://lh6.googleusercontent.com/vHjZEQte0H5ZWgQQ-CEJaEFDkubaL0IinTRA\_BSuNZnhnoY9OrUtbeVVp2wOZ4gAAYh81\_lYfHHPk27TpnDERLE1CZJuEfIpcHOfvse7FCqzXifMhtz9NpDE5n3BZcv-xD7POM8U)

![](https://lh6.googleusercontent.com/l\_4DVFZvh8nJ1OSo2UK6GXo4WC5GsDQVWNp7YFPirHprW7rrfATb21QbYJVYcwW8jh5IlRxx1MINHJZDOdqR3a0F3xCQvDLciUjr36e-Fq5yiyfS\_VRp3fsRfsrGmVRodZQLVqr8)

Then, at the dashboard, a specific badge will be displayed informing that dashboard is now following the asset filter, which means the units will depend on the [Asset Configuration](per-asset-units.md).

![](../../.gitbook/assets/Screenshot\_select-area\_20220704205524.png)

If the asset **does not** have a defined set of units, the Global Units Set will be used as a fallback:

![](<../../.gitbook/assets/image (104).png>)
