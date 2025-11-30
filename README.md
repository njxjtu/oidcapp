# OIDC App


## Development
 - Example application.properties

 ```
 
spring.application.name=OidcClientApp

# 1. Server Configuration
server.port=8454

# 2. SSL/TLS Configuration (Points to your PKCS12 file)
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-type=PKCS12
server.ssl.key-store-password=changeit
server.ssl.key-alias=spring-boot-app

# --- 3. OAuth 2.0 Client Registration (ID: cas) ---
spring.security.oauth2.client.registration.cas.client-id=77712150febc4a67b6df57b04deb074e
spring.security.oauth2.client.registration.cas.client-secret=gq5mjHn28AR_kY5awR8UDpfiwn43dA1uxE7pqPboB3c4ZWt5
spring.security.oauth2.client.registration.cas.client-name=oidc
spring.security.oauth2.client.registration.cas.scope=openid,profile,email
spring.security.oauth2.client.registration.cas.authorization-grant-type=authorization_code
# IMPORTANT: This redirect URI MUST be registered with your CAS OIDC Service!
spring.security.oauth2.client.registration.cas.redirect-uri={baseUrl}/login/oauth2/code/{registrationId}

# --- 4. OAuth 2.0 Provider Configuration (ID: cas - Must match registration ID) ---
# This single line enables OIDC Discovery for your CAS server.
spring.security.oauth2.client.provider.cas.issuer-uri=https://localhost:8443/cas

# Optional: CAS User Info Attribute Name
# The default is 'sub', but you can set this explicitly if needed.
spring.security.oauth2.client.provider.cas.user-name-attribute=sub

```

- Make sure this is accessible: curl -v --insecure https://localhost:8443/cas/.well-known/openid-configuration