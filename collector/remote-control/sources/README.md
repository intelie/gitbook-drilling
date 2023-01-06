# Sources

Inside the `Sources` tab in the Intelie Live `Collectors` tab is possible to add sources for an online Collector with SSL enabled,  a button will be available at the bottom of sources list as shown below:

![List of sources configured for a Collector](<../../../.gitbook/assets/collector-remote-control-sources.png>)

When clicking the `Create new source` button, there's a form that should be filled with sources information, like name, service company, protocol, mode, rig name and some store access information. The [protocols](../../protocols/) available are: WITSML (versions 1.3.1.1, 1.4.1.1 and 2.0), WITS, OPC-DA, OPC-UA, Modbus, CSV and RAW (JSON).

![List of protocols available to configure a new source](<../../../.gitbook/assets/image (164).png>)

On the Access section, some protocols (example: WITSML and OPC) support the **Test Access** button to check the availability.

![](<../../../.gitbook/assets/image (142).png>)



After saving the new source, you may wait for a while as the collector sources list is updated, then you can access more features for the created source by clicking on it's name.

![Choose a source to edit, then new tabs will display if the protocol supports](<../../../.gitbook/assets/collector-remote-control-sources-new-source.png>)

On the source page, the **configurations** tab will allow you to update the configured event type and store access information, saving those changes may take a while to update as well.

Dependent upon the protocol type, additional tabs can be displayed. For example, sources for WITSML allow the configuration of [requests](./witsml-requests), [backlog sync](./backlog-sync) and [object explorer](./witsml-object-explorer).

![](<../../../.gitbook/assets/collector-remote-control-witsml-tabs.png>)
