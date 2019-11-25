package com.pritam.authorization;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.pritam.authorization.config.AppProperties;
import com.pritam.authorization.dao.RoleRepository;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class AuthorizationServerDemoApplication {

	@Autowired
	RoleRepository roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServerDemoApplication.class, args);
	}
	
	@Bean
    InitializingBean populateApplicationConttext() {
        return () -> {
          };
       }
	

}
