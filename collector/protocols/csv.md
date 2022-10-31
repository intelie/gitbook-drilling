# CSV

LiveRig collector supports the pushing of CSV payloads in order to convert them into Live events.&#x20;

That is a very simple alternative to input data from third-party software through a LiveRig collector instance, typically co-located at operational sites.

### Configuration by remote control

Once the [Remote Control](../remote-control/) feature is enabled, the user can configure a new CSV source remotely as follows:

<figure><img src="../../.gitbook/assets/image (100).png" alt=""><figcaption><p>Overview of CSV source configuration options</p></figcaption></figure>

#### Null values

As a textual representation, CSV typically carries some standard number that needs to be interpreted as **null values**. The CSV source enables you to specify your typical values and drop them from the actual event representation for the channels.

#### Date time pattern

The date time pattern can be customized to detect seconds, milliseconds or textual samples of information like months, AM/PM marks, or either some fixed strings in the rows which represent the timestamp of each data measurement.

<figure><img src="../../.gitbook/assets/image (132).png" alt=""><figcaption><p>Date time custom format configuration rules</p></figcaption></figure>

Each column in the CSV file will be interpreted as a channel value and the first column will be the date time index for each row in the dataset.

#### Access endpoint

The CSV source always executes in **server mode** only. Third parties applications may push data into the LiveRig CSV source endpoint.

Starting at LiveRig 4.7.0, the access configuration supports both TCP and Serial ports:

<div>

<figure><img src="../../.gitbook/assets/liverig-source-configuration-connectors-tcp (1).png" alt=""><figcaption><p>TCP port configuration for CSV source endpoint</p></figcaption></figure>

 

<figure><img src="../../.gitbook/assets/liverig-source-configuration-connectors-serial.png" alt=""><figcaption><p>Serial port configuration for CSV source endpoint</p></figcaption></figure>

</div>

In case, any older LiveRig Collector is used in the edge installation, the selection for Serial ports will be unavailable since only TCP endpoints are allowed up to 4.6 series.

<figure><img src="../../.gitbook/assets/image (121).png" alt=""><figcaption><p>Warning the lack of support for serial port connections at local sites</p></figcaption></figure>
