# Certificate-based authentication for WITSML HTTPS sources



Starting with version 4.7.0 it is possible to configure the collector to connect to WITSML sources that use HTTPS, thus requiring authentication using certificates.

The [collector configuration is done through properties (`liverig.properties`) ](liverig.properties.md)that define where are the files containing the required certificates and their respective passwords so that the software can have access to the necessary data. The setup procedure is described in the following steps:

1. Create and configure the following properties:
   1. `witsml.certificates` - the path where the WITSML certificates are. It is not mandatory and have a default value defined as `$data_path/conf/witsml`, where `data_path` is a property in `liverig.properties` file;
   2. `witsml.keystore` - the name of the WITSML client keystore file. This file should contain the client's private key and the certificate to be used to authenticate. The default value is `witsml.jks`;
   3. `witsml.keypass` - the keystore password. This password is used to read the keystore. The default value is `liverig`;
   4. `witsml.truststore` the name of the WITSML truststore file. This file should contain the certificates the client can trust. The default value is `witsml-trust.jks`. To disable the validation of server certificates, set the property `ignore_invalid_witsml_certificate` to `true`.
   5. `witsml.trustpass` - the truststore password. This password is used to read the truststore and has `liverig` as default value.
2.  Import the client certificate and key into the keystore file using the commands bellow. In this example the certificate and key are provided within a `PEM` file (`client.pem`)

    ```
    $ openssl pkcs12 -export -in client.pem -inkey client.pem -name client > client.p12
    $ keytool -importkeystore -srckeystore client.p12 -destkeystore witsml.jks -srcstoretype pkcs12 -alias client
    ```
3. [Configure the `sources.xml`](sources.xml.md), adding the WITSML client source using the HTTPS endpoint which demands certificate-based authentication.
