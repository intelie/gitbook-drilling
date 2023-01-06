When selecting an OPC-UA or OPC-DA source, it is possible to set the objects being retrieved by the OPC requests in the `Requests` tab. This page let the user remotelly configure the [store.json file](./../configuration/store.json.md). It is possible to configure this file manually, for more information, check its page.

![OPC Request page](<../../.gitbook/assets/collector-remote-control-opc-tags.png>)

This page is used to remotely modify the `store.json` file. To do so, it is necessary to specify the tag, alias, unit of measurement, and data type of each object being requested.

When adding a new object, the `Alias` and `Tag` fields are mandatory. In the case where an object does not have any of those fields, a message will appear after trying to save:

![OPC Request page with missing values](<../../.gitbook/assets/collector-remote-control-opc-tags-missing-values.png>)

Also, it is not possible to save the new request with duplicated alias or tags:

![OPC Request page with missing values](<../../.gitbook/assets/collector-remote-control-opc-tags-repeated-values.png>)

The list of units of measurement is the same as used by live, so it's possible that some units could be hidden or customized units could be shown through customization of the platform.

The `type` field is only required when the OPC to WITSML converter is being used.

Besides modifying the objects themselves, it is also possible to alter the period in which those objects are retrieved from the server.

After saving the new objects, it takes some time to the collector to apply those changes.