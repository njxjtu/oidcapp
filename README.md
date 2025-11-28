# OIDC App


## Development
 - Example application.properties

 ```
 spring.application.name=OidcClientApp

# 1. Server Configuration
server.port=8454

# 2. SSL/TLS Configuration (Points to your PKCS12 file)
# The file must be in src/main/resources/
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-type=PKCS12
server.ssl.key-store-password=changeit
server.ssl.key-alias=spring-boot-app

# 3. OAuth 2.0 Client Configuration for CAS
spring.security.oauth2.client.registration.cas.client-id=77712150febc4a67b6df57b04deb074e
spring.security.oauth2.client.registration.cas.client-secret=gq5mjHn28AR_kY5awR8UDpfiwn43dA1uxE7pqPboB3c4ZWt5
spring.security.oauth2.client.registration.cas.client-name=oidc
spring.security.oauth2.client.registration.cas.scope=openid,profile,email
spring.security.oauth2.client.registration.cas.authorization-grant-type=authorization_code
# IMPORTANT: This redirect URI MUST be registered with your CAS OIDC Service!
# The format is {baseUrl}/login/oauth2/code/{registrationId}
spring.security.oauth2.client.registration.cas.redirect-uri={baseUrl}/login/oauth2/code/{registrationId}

# 4. OAuth 2.0 Provider Configuration for CAS
# Assuming your local CAS is running on default https port 8443
# spring.security.oauth2.client.provider.cas.issuer-uri=https://localhost:8443/cas/oidc

# ADD these manual configuration lines:
spring.security.oauth2.client.provider.cas.authorization-uri=https://localhost:8443/cas/oidc/authorize
spring.security.oauth2.client.provider.cas.token-uri=https://localhost:8443/cas/oidc/token
spring.security.oauth2.client.provider.cas.user-info-uri=https://localhost:8443/cas/oidc/profile
spring.security.oauth2.client.provider.cas.jwk-set-uri=https://localhost:8443/cas/oidc/jwks
spring.security.oauth2.client.provider.cas.user-name-attribute=sub
```