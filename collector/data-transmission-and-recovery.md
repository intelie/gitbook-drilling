# Data transmission and recovery

After the data is gathered by the collector and saved locally, it is transmitted to Intelie Live.

The collector works with a _real-time high priority_ policy. That is, when the network recovers from any outage, the real time data is transmitted immediately and the backlog data is transmitted with low priority in a separate channel with limited bandwidth.

This separation between real-time and non-real-time data also occurs when the collector was just initialized.

{% hint style="info" %}
There are four channels transmitting the data from the collector to Intelie Live in parallel: control, realtime, retransmission, and remotecontrol.
{% endhint %}

### Outage recovery between the collector and Intelie Live

When the network recovers from an outage between the collector and Intelie Live, all the data that was not transmitted in real time is then transmitted with lower priority, respecting the maximum bandwith defined by the `resend_rate` parameter, in bytes per second.

As generally the collector and Intelie Live are on separate networks, this is a common situation.

### Outage recovery between the collector and the data sources

When there is a problem on the network between the collector and the data sources, the protocol must allow the retrieval of historical data. The WITSML protocol, for example, allows that.

When the network recovers, all the data that was not captured in real time is captured in reversed order (from the most recent to the oldest data samples). This capture is performed by the _backlog_ task. Those data is transmitted right after captured, with low priority, and marked as _non-realtime_.

{% hint style="info" %}
In any of the cases, the collector can be restarted without any data loss.
{% endhint %}

{% hint style="info" %}
Delayed data, both due to _backlog_ and _retransmission_ tasks, are treated as _non-realtime_.
{% endhint %}

{% hint style="info" %}
As the _retransmission_ tasks occur in an unpredictable order, there is no direct way to infer that all the data previous to a specific moment were transmitted.
{% endhint %}
