package com.embedded.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springdoc.core.GroupedOpenApi;
//import org.springdoc.core.SwaggerUiConfigParameters;
//import org.springdoc.core.api.ApiResource;
//import org.springdoc.core.api.OpenApiResource;
import java.util.List;

@Configuration
public class SwaggerConfig {
/** 
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public OpenApiResource openApiResource(SwaggerUiConfigParameters swaggerUiConfigParameters) {
        return new OpenApiResource()
                .swaggerUiConfigParameters(swaggerUiConfigParameters);
    }

    @Bean
    public SwaggerUiConfigParameters swaggerUiConfigParameters() {
        return SwaggerUiConfigParametersBuilder.builder()
                .url("/v3/api-docs")
                .build();
    }
    **/
}
