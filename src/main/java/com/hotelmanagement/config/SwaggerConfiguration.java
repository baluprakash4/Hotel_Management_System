package com.hotelmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	
	@Bean
	Docket createSwaggerDocument() {
		return new Docket (DocumentationType.SWAGGER_2)
				        //  .groupName("HotelManagementSystem-Swagger")
				          .select()
				          .apis(RequestHandlerSelectors.basePackage("com.hotelmanagement.Controller"))
				        //  .paths(PathSelectors.any())
				          .build();
	}

}
