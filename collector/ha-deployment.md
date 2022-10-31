# HA Deployment

LiveRig can be deployed as a active-passive model using LinuxHA packages. We recommend pacemaker to service management and GFS2 for filesystem sync.

{% hint style="info" %}
It's also recommend use e dedicated NIC to heartbeat for best stabil
{% endhint %}

![LiveRig HA architecture](<../.gitbook/assets/LiveRig Architecture (3).png>)

When the passive instance detect something wrong on other node, it's starts the LiveRig collector and continue where the other node stopped.&#x20;

![LiveRig HA architecture on failed environment.](<../.gitbook/assets/LiveRig Architecture (4).png>)

{% hint style="info" %}
When a failed node is fixed, it's return as a passive node.&#x20;
{% endhint %}

