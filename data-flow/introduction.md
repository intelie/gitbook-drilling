# Introduction

Generally, the real-time data that Live uses for its analyses is collected from third-party services, that run either at the rig site or on the central infrastructure. The collector sends to Live the data almost as it is, that is, in WITSML, WITS or OPC format, for example. The collector enriches the original data with some metadata about the source of the data and how it was collected. This enriched original data is called raw data.

![Data flow in INTELIE Live](<../.gitbook/assets/image (24).png>)

All the data received by INTELIE Live can be used in their raw version, that is, with the original names and units of measurement, or in their normalized version, with a common set of names and units, independently of their source.

We highly recommend that the normalized data is used whenever possible, because it allows to port any visualization or algorithm between different assets (wells or rigs) without any modification.

We describe the normalization process in the next chapters.
