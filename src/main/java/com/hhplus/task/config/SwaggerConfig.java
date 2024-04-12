package com.hhplus.task.config;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openApi(){
        Info info = new Info()
                .title("Concert API")
                .version("1.0.0")
                .description("CONCERT API");

        return new OpenAPI()
                .info(info);
    }

}