package com.pritam.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableConfigurationProperties
@EnableResourceServer
public class AuthorizationServerDemoApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServerDemoApplication.class, args);
	}
}
