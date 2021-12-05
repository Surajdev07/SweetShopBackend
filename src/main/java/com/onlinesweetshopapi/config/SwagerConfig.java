package com.onlinesweetshopapi.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwagerConfig {

	@Bean
	public Docket productApi() {
		
		//Configure Swagger and return Docket instace
		return new Docket(DocumentationType.SWAGGER_2)		
				.select().apis(RequestHandlerSelectors.basePackage("com.onlinesweetshopapi.web"))
				.paths(PathSelectors.regex("/api.*"))				
				.build()
				.apiInfo(metoInfo());
	}

	private ApiInfo metoInfo() {
		// Customize the Swagger output
		ApiInfo apiInfo = new ApiInfo(
				"Online Sweet Shop API", 
				"Online Sweet Shop API Created by Group 4", 
				"1.0", 
				"Terms of Service", 
				new Contact("Group 4", "https://www.xyz.com/", "xyz@gmail.com"), 
				"XYZ Licence v.1.0", 
				"https://www.xyz.in/", new ArrayList<>());
		return apiInfo;
	}
}