# Connecting to Intelie Live

To accept connections from any collector, an instance of the `liverig-server` integration must be created on the Intelie Live web administration.

![Creating a liverig-server instance](<../.gitbook/assets/image (84).png>)

On the configuration of this integration, the user must define:

* the state path, which is the path where the re-transmission control data will be stored on the Intelie Live server;
* the local port, which is the port on which Intelie Live will listen for connections;
* cryptography keystore path and password;
* and the list of collector instances and their respective allowed rig names

{% hint style="info" %}
The username on the collector list correspond to the `instance` of the collector, which is defined on the `liverig.properties` configuration file.
{% endhint %}

![Setting the password and allowed rig names for each collector](<../.gitbook/assets/image (329).png>)

{% hint style="info" %}
It is important to define which rig names each collector may use, so that changing a collector from a rig to another does not mess the data. But if one wants no restriction on the rig name, this field can be left empty, which means that the server will accept data related to any rig name.
{% endhint %}

Once connected, the collector will show up on the [`Collectors`](monitoring.md) web interface.

{% hint style="info" %}
The TCP port defined on the `liverig-server` integration should be accessible remotely (for example, be open on all firewalls).
{% endhint %}
