package de.coronavirus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Set<String> PRODUCES_AND_CONSUMES = new HashSet<>(
            Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));
    private static Contact CONTACT = new Contact(
            "Online Melderegister",
            "online-melderegister.de",
            "info@online-fallregister.de");
    private static ApiInfo API_INFO = new ApiInfo(
            "Online Melderegister",
            "Ein Melderegister zur schnellen Anmeldung und Übermittlung von Krankheitsfällen innerhalb Deutschlands",
            "0.0.01",
            "tos",
            CONTACT,
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
            Collections.emptyList());

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(API_INFO)
                .produces(PRODUCES_AND_CONSUMES)
                .consumes(PRODUCES_AND_CONSUMES)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("de.coronavirus.application"))
                .build()
                .genericModelSubstitutes(Optional.class);
    }
}
