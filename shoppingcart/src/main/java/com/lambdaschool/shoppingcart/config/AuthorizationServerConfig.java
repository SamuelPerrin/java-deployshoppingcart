package com.lambdaschool.shoppingcart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final String CLIENT_ID = System.getenv("OAUTHCLIENTID");
    private final String CLIENT_SECRET = System.getenv("OAUTHCLIENTSECRET");

    private final String GRANT_TYPE_PASSWORD = "password";
    private final String AUTHORIZATION_CODE = "authorization_code";
    private final String SCOPE_READ = "read";
    private final String SCOPE_WRITE = "write";
    private final String SCOPE_TRUST = "trust";

    /*
     * The int here describes in seconds how long the access token is valid.
     * To make a token that never expires, use -1
     */
    private final int ACCESS_TOKEN_VALIDITY_SECONDS = -1;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        configurer.inMemory()
                .withClient(CLIENT_ID)
                .secret(encoder.encode(CLIENT_SECRET))
                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE)
                .scopes(SCOPE_READ, SCOPE_WRITE, SCOPE_TRUST)
                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager);
        endpoints.pathMapping("/oauth/token", "/login");
    }
}
