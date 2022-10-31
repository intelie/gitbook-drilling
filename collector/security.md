# Security

The connection between the LiveRig collector and the live plugin can optionally be encrypted with TLS (using the default Java settings). When encrypted, the collector authenticates the live plugin through its public key hash (public key pinning).

### Built-in cryptography

The status of the cryptography is shown on the collectors web interface.

![Cryptography status on the web interface](<../.gitbook/assets/image (478).png>)

### Deployment upon OpenVPN

Alternatively, we can use OpenVPN between the Live and the collector instances. An OpenVPN server would run close to the Intelie Live instance, and every collector would run an instance of an OpenVPN client on it.

![Connection using OpenVPN](<../.gitbook/assets/LiveRig Architecture (2).png>)

