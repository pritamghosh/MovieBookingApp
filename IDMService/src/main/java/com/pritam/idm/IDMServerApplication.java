package com.pritam.idm;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.pritam.idm.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class IDMServerApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(IDMServerApplication.class, args);
	}
	
	@Bean
    InitializingBean populateApplicationConttext() {
        return () -> {
          };
       }
	

}
