##Key Generation
keytool -genkey -alias https-example -storetype JKS -keyalg RSA -keysize 2048 -validity 365 -keystore https-example-ks.jks

##Key List
keytool -list -v -keystore https-example-ks.jks