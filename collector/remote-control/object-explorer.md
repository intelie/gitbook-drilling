# Requests

When source has mode client, there is a tab called `Object Explorer` on source modal. In this feature, the witsml tree, showing available objects, can be requested from remote control.

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

![Information on how to configured cryptography](../../.gitbook/assets/image.png)

When the "remote control" is disabled in collector properties an error is displayed.

![Remote control disabled](<../../.gitbook/assets/image (292).png>)

The collector plugin needs to be at version 2.22 or above to request the tree of objects.
