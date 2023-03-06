package com.example.hibiscopricing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    private static final String NAME = "Anca";
    private static final String GITHUB = "https://github.com/ancagabriela";
    private static final String CONTACT_EMAIL = "ancag.munteanu@gmail.com";
    private static final Contact DEFAULT_CONTACT = new Contact(NAME,
            GITHUB, CONTACT_EMAIL);
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Collections.singletonList("application/json"));

    @Bean
    public Docket docketConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.example.hibiscopricing.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .apiInfo(apiEndPointsInfo());
    }

    private static ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("hibisco - Pricing")
                .description("hibisco - Pricing REST API")
                .contact(DEFAULT_CONTACT)
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }
}
