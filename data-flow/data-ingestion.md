# Data Ingestion

INTELIE Live can ingest data from many different sources simultaneously. Those sources can be received from sensors, from integrations to other systems or manually (either dynamic or static).

The most common sources of data are the rig sensors, and generally this data is received through integrations that use WITSML, WITS, OPC-DA, or OPC-UA protocols.

To collect those data, the most common solution is to use the [INTELIE LiveRig Collector](../collector/introduction.md).

### [LiveRig Collector](../collector/introduction.md)

Liverig-collector is a standalone application that can be either installed at the rig site, or on the same local network where INTELIE Live resides. Installing it at the rig site has many advantages, such as high priority **real-time transmission, high compression rates**, and **clock synchronization**.

The collector is responsible to connect to remote data sources, gather the data, save it locally and send a compressed version of it to INTELIE Live.

The collector can handle data from remote systems using the protocols [WITSML](../collector/protocols/witsml.md), [WITS](../collector/protocols/wits.md), [OPC-DA](../collector/protocols/opc-da.md), [OPC-UA](../collector/protocols/opc-ua.md), and other protocols and formats. More details on those formats can be found on the Data Ingestion section.

### Other sources

It is also possible to receive data from many other sources, such as external applications and databases. On these cases, generally a INTELIE Live plugin will be used to connect directly to the system and grab the data using many possible protocols and formats.
