package com.hhplus.task.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openApi(){
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo(){
        return new Info().title("E-commerce API")
                .description("CONCERT API")
                .version("1.0.0");
    }

//    @Bean
//    public Docket api(){
//        String version = "1.0.0";
//        String title = "CONCERT API " + version;
//
//        return new Docket(DocumentationType.OAS_30)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hhplus.task"))
//                .paths(PathSelectors.any()) // 모든 경로를 문서화
//                .build()
//                .apiInfo(apiInfo());
//    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("CONCERT API")
//                .description("이 API는 CONCERT에 관한 기능을 제공합니다.")
//                .version("1.0.0")
////                .contact(new Contact("Your Name", "your-website-url.com", "your-email@example.com"))
//                .build();
//    }
}