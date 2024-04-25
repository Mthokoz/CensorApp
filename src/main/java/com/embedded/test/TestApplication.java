package com.embedded.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//import org.springdoc.core.SpringdocUtils;


@SpringBootApplication
//@EnableSwagger2Doc
@ComponentScan(basePackages = {"com.embedded.test","com.embedded.test.controller","com.embedded.test.util.Message"})
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
/** 
	@Bean
    public SwaggerUiConfigParameters swaggerUiConfigParameters() {
        return SwaggerUiConfigParametersBuilder.builder()
                .url("/v3/api-docs")
                .build();
    }
	*/
}
