# Introduction

INTELIE LiveRig Collector is a component of the INTELIE Live solution designed to collect data from drilling rigs, and send it to be processed by INTELIE LIVE. It is usually installed on a dedicated computer or virtual machine on each drilling rig, but it can also be installed in a central location to request data from a service company.

{% hint style="info" %}
When installed at the rig site, it has many advantages, such as high priority real-time transmission, high compression rates, and clock synchronization.
{% endhint %}

![](https://lh4.googleusercontent.com/MPecYS1S-WZ17EFA3fEhUms05m8FrdLzYm\_aRKAv0tMTSgML\_5N0xeIeRkePRDS29SLjgoDcE4b853K22V5F-Lq0EPhpL281ientTVuImNFakZJuGdH43LWie6MMGRmpEkNnZNVM)

The collector primarily obtains data through the WITSML protocol to request log, trajectory and other object data from service companies. WITSML versions 1.3.1.1, 1.4.1.1 and 2.0 are supported. 

Industry-standard protocols like OPC-UA, OPC-DA and Modbus are also supported. As a fallback for legacy system integrations, LiveRig Collector also can obtain data in WITS (level 0) through TCP/IP, CSV and Raw data through TCP/IP or serial ports.

Each data point obtained by the collector receives several timestamps, recording the start and end of the data capture, as well as the start and end of each transmission to INTELIE Live. Additionally, the collector calculates an estimate of the drift between the clock of the data source and of the collector, which is applied by the plugin as an optional adjustment during the data normalization process.
