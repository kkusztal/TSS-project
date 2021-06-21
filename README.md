# TSS-project

##Setup
To run this project, add section below into server.xml:

```xml
<Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol"
         maxThreads="150" SSLEnabled="true"
			   scheme="https" secure="true" 
			   clientAuth="false" sslProtocol="TLS"
			   keyAlias="servercert"
			   keystoreFile="conf/pass_tomcat.keystore" keystorePass="tomcat" />
```

Set start URL as https://[your_host]:8443/WebApplication7KK/ .
