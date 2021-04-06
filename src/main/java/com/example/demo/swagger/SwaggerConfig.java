package com.example.demo.swagger;

import java.util.Collections;
import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	// link : http://localhost:8081/swagger-ui.html

		@Bean
		public Docket productApi() {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.example.demo")).build()
					.apiInfo(apiInfo());
		}
		
		private ApiInfo apiInfo() {
		    return new ApiInfo(
		      "Agadir Appication", 
		      "spring boot application ", 
		      "API TOS", 
		      "Terms of service", 
		      new Contact("moughite", "www.example.com", "hanafi_moughite@yahoo.fr"), 
		      "License of API", "API license URL", Collections.emptyList());
		}

	
}
