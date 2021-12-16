package com.estoke.web.config;

import io.swagger.models.HttpMethod;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author vitor.alves
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.estoke")
@EntityScan("com.estoke")
@ComponentScan(basePackages = "com.estoke")
@PropertySources(@PropertySource("classpath:application.properties"))
public class EstokeConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*")
                        .allowedMethods(HttpMethod.GET.name(), HttpMethod.HEAD.name(), HttpMethod.POST.name(),
                                HttpMethod.PUT.name(), HttpMethod.DELETE.name(), HttpMethod.PATCH.name())
                        .exposedHeaders(HttpHeaders.CONTENT_DISPOSITION);
            }
        };
    }
}
