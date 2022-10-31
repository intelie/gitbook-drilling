# Getting Started

**liverig-collector** should be installed on each monitored asset (rig, platform, fleet, and so on) on a CentOS or RH 7.x linux. The package is basead on RPM files.

{% hint style="info" %}
**Minimal Requirements**

* 2 vCPU or compartible hardware
* 4Gb (8GB recomended)
* 256GB Disc
{% endhint %}

After download the liverig file install

```
rpm -i liverig-collector-<version>.rpm
```

{% hint style="info" %}
All files will be installed on `/opt/intelie/liverig/`
{% endhint %}

To start the service use

```
systemctl start liverig
```

After that, the LiveRig collector will be available on `http://<host>:8000 and` the default username and password is located on `/opt/intelie/liverig/conf/login.properties`

{% hint style="info" %}
To remotely connect to the collector web Interface, the port tcp/8000 (default) should be accessible
{% endhint %}
