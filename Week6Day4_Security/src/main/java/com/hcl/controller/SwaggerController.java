package com.hcl.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost:8085/swagger-ui.html To access Swagger UI

@Configuration   //project settings
@EnableSwagger2  //activate swagger file in the background
public class SwaggerController 
{
		@Bean  //from the start of project running to the end
		public Docket libraryApi()   //pluggable
		{  
			return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(apiInfo())
					.groupName("Product-API")
					.select().apis(RequestHandlerSelectors.basePackage("com.hcl.controller"))  //whose methods do you want to add
					.build();
					
					
		}
		private ApiInfo apiInfo()
		{
			return new ApiInfoBuilder().title("Product Shopping API")
					.description("Shopping Cart Spring Boot Swagger")
					.license("Company License")
					.licenseUrl("http://www.yahoo.in")
					.termsOfServiceUrl("http://www.google.co.in")
					.build();
		}
	
}
