{% hint style="info" %}
This feature is only available for collector versions equal or above 3.0.0
{% endhint %}

Inside the `Properties` tab in the Intelie Live `Collectors` tab is possible to change the properties of an online Collector with SSL enabled. This page is only available for admin users:

![Properties page](<../../.gitbook/assets/collector-remote-control-properties.png>)

It's possible to filter the properties by name or value type (if it's in its default state or customized). When searching, if the resulting property depends on another one that should be filtered out, it still will be shown, but will be grayed out:

![Filtered properties with some of them grayed out to preserve dependency hierarchy](<../../.gitbook/assets/collector-remote-control-properties-filter.png>)

When clicking in the edit button is possible to edit every property. Some properties that were customized will have a button to revert the value to its default state. After editing the properties, when clicking the Save button a modal will appear showing every property modified and allowing the user to revert those changes if necessary:


![Properties page in edit mode](<../../.gitbook/assets/collector-remote-control-properties-editing.png>)

![Confirmation modal when clicking to revert a property to its default value](<../../.gitbook/assets/collector-remote-control-properties-default.png>)

![Confirmation modal that appears after clicking the save button](<../../.gitbook/assets/collector-remote-control-properties-confirmation.png>)

After saving the properties, the changes made will take some time to be applied, as the collector needs to restart to apply the new properties values. 