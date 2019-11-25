package com.pritam.authorization.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * Configures the authorization server. The @EnableAuthorizationServer
 * annotation is used to configure the OAuth 2.0 Authorization Server mechanism,
 * together with any @Beans that implement AuthorizationServerConfigurer (there
 * is a handy adapter implementation with empty methods).
 */
//@Configuration
//@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private PasswordEncoder oauthClientPasswordEncoder;

	@Bean
    public TokenStore tokenStore() {
       // return new JdbcTokenStore(dataSource);
		return new InMemoryTokenStore();
    }
    @Bean
    public OAuth2AccessDeniedHandler oauthAccessDeniedHandler() {
        return new OAuth2AccessDeniedHandler();
    }
	
	/**
	 * Setting up the endpointsconfigurer authentication manager. The
	 * AuthorizationServerEndpointsConfigurer defines the authorization and token
	 * endpoints and the token services.
	 * 
	 * @param endpoints
	 * @throws Exception
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		 endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager).userDetailsService(userDetailsService);
	}

	/**
	 * Setting up the clients with a clientId, a clientSecret, a scope, the grant
	 * types and the authorities.
	 * 
	 * @param clients
	 * @throws Exception
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("client").authorizedGrantTypes("client_credentials", "password", "refresh_token")
				.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT", "ROLE_USER").scopes("read", "write", "trust")
				.resourceIds("oauth2-resource").accessTokenValiditySeconds(5000).refreshTokenValiditySeconds(50000)
				.secret("secret");
		  //clients.jdbc(dataSource);
	}

	/**
	 * We here defines the security constraints on the token endpoint. We set it up
	 * to isAuthenticated, which returns true if the user is not anonymous
	 * 
	 * @param security
	 *            the AuthorizationServerSecurityConfigurer.
	 * @throws Exception
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
//				.passwordEncoder(oauthClientPasswordEncoder);
    }

}
