# WITSML Object Explorer

Once a WITSML source is configured in client mode, a tab called `Object Explorer` will display at the source details. This feature lists the WITSML objects tree and accelerate the user to configure the requests to be made by the remote control.

Alternatively, the user can configure WITSML requests in a more advanced mode with wildcards support against object ID and names at the `Requests` tab. See [WITSML Requests](./witsml-requests.md) for more details.

This page also shows the requests configured in the collector and which ones are configured.

![Modal for sources with mode client (Available only for WITSML) - Requests](<../../.gitbook/assets/image (391).png>)

When trying to get available WITSML tree information, a request will be sent for Liverig Collector plugin that will recover the available WITSML tree.

In case of an error, a new attempt can be made.

![Error message](<../../.gitbook/assets/image (411).png>)

When requesting the WITSML tree, Intelie Live will try to get the latest information available in an internal cache. The tree request date is displayed and it can be updated by clicking on the repeat icon.

![](<../../.gitbook/assets/image (520).png>)

When collector cryptography is not configured, the system will not be able to request the WITSML tree.

![Error when cryptography is disabled](<../../.gitbook/assets/image (335).png>)

An explanation of how to configure the cryptography is available clicking on the "Configure SSL" button.

![Information on how to configured cryptography](<../../.gitbook/assets/image (4).png>)

When the "remote control" is disabled in collector properties an error is displayed.

![Remote control disabled](<../../.gitbook/assets/image (292).png>)

The collector plugin needs to be at version 2.22 or above to request the tree of objects.
