# Introduction

Intelie LiveRig Collector is a component of the Intelie Live solution designed to collect data from drilling rigs, and send it to be processed by Intelie LIVE. It is usually installed on a dedicated computer or virtual machine on each drilling rig, but it can also be installed in a central location to request data from a service company.

{% hint style="info" %}
When installed at the rig site, it has many advantages, such as high priority real-time transmission, high compression rates, and clock synchronization.
{% endhint %}

![](https://lh4.googleusercontent.com/MPecYS1S-WZ17EFA3fEhUms05m8FrdLzYm\_aRKAv0tMTSgML\_5N0xeIeRkePRDS29SLjgoDcE4b853K22V5F-Lq0EPhpL281ientTVuImNFakZJuGdH43LWie6MMGRmpEkNnZNVM)

The collector primarily obtains data through the WITSML protocol; requesting log data from several service companies. Versions 1.3.1.1, 1.4.1.1 and 2.0 are supported. There is also support for the WITS protocol through TCP/IP or serial port, OPC-UA and OPC-DA.

Each data point obtained by the collector receives several timestamps, recording the start and end of the data capture, as well as the start and end of each transmission to Intelie Live. Additionally, the collector calculates an estimate of the drift between the clock of the data source and of the collector, which is applied by the plugin as an optional adjustment during the data normalization process.
