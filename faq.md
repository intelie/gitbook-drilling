# FAQ

## **What does the field "Maximum water depth" on the rig parameters stand for?**

This field represents a rig characteristic. It means the maximum water depth that the rig can operate.

## **What does the field "Maximum drilled depth" on the rig parameters stand for?**

It represents the maximum depth that the rig has already drilled.

## **What does the field "Mud pumps max HP" on the rig parameters stand for?**

It means the sum of horse powers for all pumps.

## **What does the field "Max pressure mud system" on the rig parameters stand for?**

It represents how much pressure the standpipe supports.

## **What information do I need to setup new data connections to the collector?**

For the WITSML protocol:

* Whether INTELIE's collector will act as the client or the server
  * If the collector is on client mode:
    * The url, username, password to access the WITSML Store
    * The list of wells and wellbores
    * The list of objects (logs, mudLogs, trajectories, and so on) to be retrieved
  * If the collector is on server mode, we should provide the URL, username and password (that can be configured at the web interface or at the [configuration file](collector/configuration/sources.xml.md)). No extra information is needed in that case.
* A brief description of each mnemonic on the WITSML Store

For the WITS protocol:

* Whether the connection is serial or TCP and whether the collector will act as the client or as the server
* If the connection is serial, the physical address of the port
* If the connection is TCP, the network address of the WITS system

For the OPC-DA protocol:

* The host, path, and progId
* The username and password
* The list of tags to be retrieved and their descriptions

For the OPC-UA protocol:

* The endpoint address
* The authentication method (and credentials depending on the method)
* The list of tags to be retrieved and their descriptions

