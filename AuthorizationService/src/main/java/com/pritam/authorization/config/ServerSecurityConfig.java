package com.pritam.authorization.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
//	@Autowired
//	private PasswordEncoder userPasswordEncoder;

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);//.passwordEncoder(userPasswordEncoder);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off

//    			http
//    				.headers().frameOptions().disable().and()
//    				.authorizeRequests()
//    				.antMatchers("/", "/**").permitAll()
//    				.antMatchers("/user",SECURED_PATTERN).authenticated();
		// @// @formatter:off
		 
		 http.requestMatchers()
		 .antMatchers("/login", "/oauth/**")
		 .and()
		 .authorizeRequests()
		 .anyRequest().authenticated()
		 .and()
		 .formLogin().permitAll();
		// @formatter:on


//		http.cors().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf()
//				.disable().formLogin().disable().httpBasic().disable().exceptionHandling()
//				.authenticationEntryPoint(new RestAuthenticationEntryPoint()).and().authorizeRequests()
//				.antMatchers("/", "/error", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg", "/**/*.jpg",
//						"/**/*.html", "/**/*.css", "/**/*.js")
//				.permitAll().antMatchers("/auth/**", "/oauth2/**").permitAll().anyRequest().authenticated().and()
//				.oauth2Login().authorizationEndpoint().baseUri("/oauth2/authorize")
//				.authorizationRequestRepository(cookieAuthorizationRequestRepository).and().redirectionEndpoint()
//				.baseUri("/login/oauth2/code/*").and().userInfoEndpoint().userService(customOAuth2UserService).and()
//				.successHandler(oAuth2AuthenticationSuccessHandler).failureHandler(oAuth2AuthenticationFailureHandler);

		// @formatter:on
	}

}
