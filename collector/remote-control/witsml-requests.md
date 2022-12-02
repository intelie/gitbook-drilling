{% hint style="info" %}
This feature is available on plugin liverig version 4.7.0 or above
{% endhint %}

When selecting a WITSML source in client mode, is possible to manually set the requests that are being made to the server, through the `Requests` tab:

![WITSML Requests page showing a request already set up](<../../.gitbook/assets/collector-remote-control-witsml-requests.png>)

Those changes made to a requests will be applied to the `sources.xml` file of the collector, specifically to the request tag of a source.

In this page is possible to create or edits requests, in a similar manner to how it's done through the collector's own page. When editing requests, every edited request will be marked with a yellow dot:

![WITSML Requests page showing edited requests in the sidebar with a yellow dot](<../../.gitbook/assets/collector-remote-control-witsml-editing.png>)

It's not possible to save two or more equal requests. When trying to save duplicated requests, a `Duplicated` tag will be shown on the duplicated requests at the sidebar, and a `THIS REQUEST IS DUPLICATED` tag will also appear at the request page. When clicking the icon, a list of every duplicated request is shown. Those requests listed can be clicked to view the request details:

![WITSML Requests page showing duplicated requests](<../../.gitbook/assets/collector-remote-control-witsml-duplicated-requests.png>)

![WITSML Requests page showing edited requests in the sidebar with a yellow dot](<../../.gitbook/assets/collector-remote-control-witsml-duplicated-requests-modal.png>)

It's also possible to delete witsml requests when needed. To do so, select the request that should be deleted, and in the upper right corner a `DELETE REQUEST` button should be visible. After clicking it, a confirmation modal will appear asking for confirmation. After clicking the `Delete` button on the confirmation modal, the request will be imediatelly deleted. There is no need to click on the save after the confirmation:

![WITSML Request confirmation modal when deleting a request](<../../.gitbook/assets/collector-remote-control-witsml-delete-modal.png>)

After clicking the "Save" button or deleting a request, some time is needed before the collector apply the modifications.