# Configuring an OPC-UA Source

When using an OPC-UA server, we need to configure some files that are typically located at LiveRig `/opt/intelie/liverig/conf/` folder. These files are:
- [sources.xml](sources.xml.md) - the sources of opc-ua data.
- [store.json](store.json.md) - the variables that are being requested and their mappings.
- [liverig.properties](liverig.properties.md) - various configurations for the server, including the authentication mode with the opc-ua server.

## OPC-UA Server
You should know the endpoint of the server, which, in general, has the following form:

`opc.tcp://ip-address:port/some-service-name`

Here is an example using a local [Eclipse Milo server](https://github.com/eclipse/milo):

`opc.tcp://linux-tzyu:12686/milo`

## LiveRig

You must have LiveRig installed on your system. Developers granted access to source code can build a `rpm` or `deb` package and install it, alternatively. 

LiveRig software will be installed into `/opt/intelie/liverig` and a system service will be available on systemd. 
You may use `systemctl` commands to enable and start the service. 

Additionally, the [liverig-cli](../cli.md) command will be available, which is a CLI based program that allows you to connect to the server and get some information necessary for configuration.

### Check LiveRig CLI

`liverig-cli opcua help`

This command should list the available OPC-UA CLI commands. Most of them will leave their
output at `/opt/intelie/liverig/logs/liverig-cli.log`

### UA discovery

Most servers have a standard discovery endpoint at `/UADiscovery` which list the available endpoints. Example:

`liverig-cli opcua findservers opc.tcp://192.168.2.8:4840/UADiscovery`

The output at `liverig-cli.log` should list the available endpoints, example:

```
INFO 2019-01-31 10:46:24,505 [main][] net.intelie.liverig.protocols.opcua.cli.OpcuaCliRunner - ApplicationDescription{ApplicationUri=urn:PioneerMain-PC:UA Local Discovery Server, ProductUri=http://opcfoundation.org/UA/LocalDiscoveryServer, ApplicationName=LocalizedText{text=UA Local Discovery Server, locale=null}, ApplicationType=DiscoveryServer, GatewayServerUri=null, DiscoveryProfileUri=null, DiscoveryUrls=[opc.tcp://192.168.2.8:4840/UADiscovery, https://192.168.2.8:4843/UADiscovery, http://192.168.2.8:52601/UADiscovery/discovery]}
INFO 2019-01-31 10:46:24,506 [main][] net.intelie.liverig.protocols.opcua.cli.OpcuaCliRunner - ApplicationDescription{ApplicationUri=urn:pioneermain-pc:ICONICS:FrameWorX Server, ProductUri=http://iconics.com/UA/FwxServer, ApplicationName=LocalizedText{text=FrameWorX Server, locale=null}, ApplicationType=ClientAndServer, GatewayServerUri=null, DiscoveryProfileUri=null, DiscoveryUrls=[http://192.168.2.8:80/IcoFwxServer/discovery, opc.tcp://192.168.2.8:5011/IcoFwxServer]}
```

In this case, the endpoint we want is the one at `opc.tcp://192.168.2.8:5011/IcoFwxServer` since the others are not using
the schema `opc.tcp` or are the discovery endpoint.

Some important notes:
- Since the application will write data to the `/opt/intelie/liverig/logs` folder it is necessary to run with Administrative
  permissions.
- Usually, OPC-UA servers offer a discovery url that ends in UADiscovery, but you may try to run without that suffix and
  see if it returns the information.
- The returned `ApplicationUri` information should be used on the `liverig.properties`. This will be shown on [Step 2](#configuring-liverigproperties)

### Configuring `liverig.properties`

Each LiveRig Collector instance should have its own unique application URI, which is used as an identifier by the OPC-UA
server. This value has no default and has to be configured on the `liverig.properties` file. Example:

```properties
data_path=/opt/intelie/liverig
opcua.applicationuri=urn:server_12:liverig
```

Note that, although this is using the “urn:” URI schema, it does not correctly follow the URN standards.

Other important OPC-UA configuration properties:

```properties
opcua.securitymode.min=Sign
opcua.securitymode.max=
opcua.securitypolicy.min=Basic256Sha256
opcua.securitypolicy.max=
```

For more information, check the [liverig.properties](liverig.properties.md) page.

### Creating the application certificate

Each LiveRig Collector instance should have its own unique application certificate, identified by its Application URI.
To create it, you can use the following command line, replacing `<APPLICATION_URI>` with the found Application URI on [Step 1](#ua-discovery):

`keytool -selfcert -genkey -validity 360 -ext BC=ca:false -ext KeyUsage=digitalSignature,nonRepudiation,keyEncipherment,dataEncipherment,keyCertSign -ext ExtendedKeyUsage=clientAuth,serverAuth -ext SubjectAlternativeName=URI:<APPLICATION_URI> -keystore /opt/intelie/liverig/conf/opcua.jks -storetype PKCS12 -storepass liverig -keyalg RSA -keysize 2048 -alias opcua -keypass liverig -dname "cn=liverig, ou=Intelie, o=Intelie, l=Rio de Janeiro, st=Rio de Janeiro, c=BR"`

That is, for an application URI of `urn:server_12:liverig` the command should have `-ext SubjectAlternativeName=URI:urn:server_12:liverig`

Some of these parameters can be changed through `liverig.properties`, such as:
- `-keystore` (opcua.keystore);
- `-storetype` (opcua.storetype);
- `-storepass` (opcua.storepass);
- `-alias` (opcua.keyalias);
- `-keypass` (opcua.keypass).

- The values in the command line above are the defaults.

If you need to remove any previous certificate, you can use the following command

`keytool -delete -noprompt -keystore /opt/intelie/liverig/conf/opcua.jks -alias opcua -storepass liverig`

### Listing the available node IDs in the endpoint

After configuring the `liverig.properties` with the Application URI found on the [UA Discovery](#ua-discovery) step, you can browse
the available nodes for LiveRig Collector to query from. To do this, you can use the following LiveRig CLI command:

`liverig-cli opcua browse {endpoint} {username} {password} {concurrent-calls} {requests-per-call}`

**Example**:

`liverig-cli opcua browse opc.tcp://192.168.2.8:5011/IcoFwxServer username password 10 10`

**Example if there is no password**:

`liverig-cli opcua browse opc.tcp://opcplc:50000 "" "" 1 1`

The two numbers at the end (not available in the older “browse” subcommand) are the number of concurrent calls to the browse
service, and the number of requests on each call to the browse service.

Each endpoint has several alternatives with varying security modes, security policies, and token types. The minimum and
maximum security modes and policies are configured in `liverig.properties` as shown on the [Configuring `liverig.properties`](#configuring-liverigproperties) step.

Note that unless the security mode and policy chosen are `None`, the first browse attempt will fail, due to the certificate
validation on either side. It’s necessary to move the certificate from the “rejected” to the “trusted” directory (on `/opt/intelie/liverig/conf/opcua`),
or the equivalent on the server, before the connection will be allowed.

The result of the browse is recorded on `liverig-cli.log` in a tree-like format. The important part for each variable
(it should have a `V` instead of an `O`, only variables will have a value to be collected) is the node id, which is something
like `ns=0;i=85` or `ns=1;s=asdf`.

**Browse example**:

```
INFO 2021-01-26 18:04:44,033 [main][] net.intelie.liverig.protocols.opcua.cli.OpcuaBrowser -    (HasComponent) V ns=1;s=VendorServerInfo/OsVersion OsVersion 1:OsVersion
INFO 2021-01-26 18:04:44,033 [main][] net.intelie.liverig.protocols.opcua.cli.OpcuaBrowser -    (HasComponent) V ns=1;s=VendorServerInfo/ProcessCpuLoad ProcessCpuLoad 1:ProcessCpuLoad
INFO 2021-01-26 18:04:44,033 [main][] net.intelie.liverig.protocols.opcua.cli.OpcuaBrowser -    (HasComponent) V ns=1;s=VendorServerInfo/SystemCpuLoad SystemCpuLoad 1:SystemCpuLoad
INFO 2021-01-26 18:04:44,033 [main][] net.intelie.liverig.protocols.opcua.cli.OpcuaBrowser -    (HasComponent) V ns=1;s=VendorServerInfo/OpenFileDescriptors OpenFileDescriptors 1:OpenFileDescriptors
```

The items that start with a `V` are the values that can be retrieved, for example:

`V ns=1;s=VendorServerInfo/SystemCpuLoad SystemCpuLoad 1:SystemCpuLoad`

The identifier for `SystemCpuLoad` is `ns=1;s=VendorServerInfo/SystemCpuLoad` and we can retrieve some data from this node.

### Command-line subscribe

The following command will attempt to read the variables for a while, using the same mechanism as the collector would normally use:

`liverig-cli opcua subscribe {endpoint} {username} {password} {max-time} {interval}`

Use this to confirm that the node will work.

**Example**:

`liverig-cli opcua subscribe opc.tcp://linux-tzyu:12686/milo admin password2 5000 1000 'ns=1;s=VendorServerInfo/SystemCpuLoad'`

This example will request the server to send the changes to the `ns=1;s=VendorServerInfo/SystemCpuLoad` node variable,
at most one per second, for five seconds.

Here is how the result on the `liverig-cli.log` file would look like:

```
INFO 2021-01-25 11:40:03,083 [milo-shared-thread-pool-1][] net.intelie.liverig.protocols.opcua.OpcuaSubscription - Creating subscription for 1 monitored items
INFO 2021-01-25 11:40:04,167 [milo-shared-thread-pool-0][] net.intelie.liverig.protocols.opcua.cli.OpcuaCliRunner - 1611585604108 ns=1;s=VendorServerInfo/SystemCpuLoad 1611585603102 1611585603101 StatusCode{name=Good, value=0x00000000, quality=good} 100.0
INFO 2021-01-25 11:40:05,104 [milo-shared-thread-pool-0][] net.intelie.liverig.protocols.opcua.cli.OpcuaCliRunner - 1611585605099 ns=1;s=VendorServerInfo/SystemCpuLoad 1611585604107 1611585604106 StatusCode{name=Good, value=0x00000000, quality=good} 28.927680798004985
INFO 2021-01-25 11:40:06,107 [milo-shared-thread-pool-0][] net.intelie.liverig.protocols.opcua.cli.OpcuaCliRunner - 1611585606101 ns=1;s=VendorServerInfo/SystemCpuLoad 1611585605110 1611585605110 StatusCode{name=Good, value=0x00000000, quality=good} 36.80297397769516
INFO 2021-01-25 11:40:07,105 [milo-shared-thread-pool-0][] net.intelie.liverig.protocols.opcua.cli.OpcuaCliRunner - 1611585607100 ns=1;s=VendorServerInfo/SystemCpuLoad 1611585606113 1611585606113 StatusCode{name=Good, value=0x00000000, quality=good} 34.676434676434674
INFO 2021-01-25 11:40:08,108 [milo-shared-thread-pool-2][] net.intelie.liverig.protocols.opcua.cli.OpcuaCliRunner - 1611585608102 ns=1;s=VendorServerInfo/SystemCpuLoad 1611585607116 1611585607115 StatusCode{name=Good, value=0x00000000, quality=good} 32.747804265997495
```

After each line of information we have a value that represents the system cpu load for each cpu core. After configuring
the source and store files ([Configuring `sources.xml` and `store.json`](#configuring-sourcesxml-and-storejson) step), LiveRig will be able to save data locally.

### Configuring `sources.xml` and `store.json`

After the previous steps, you should have a functional OPC-UA endpoint and at least one node variable.
You then configure an OPC-UA Source with the found endpoint at the [sources.xml](sources.xml.md) file.
You should also configure the wanted node variables (tags) at the [store.json](store.json.md) file.
