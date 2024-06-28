package com.ages.doacaobackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedMethods(getAllowedMethods());
    }

    private String[] getAllowedMethods() {
        String[] allowedMethods = new String[HttpMethod.values().length];

        return Arrays.stream(HttpMethod.values()).map(HttpMethod::toString).collect(Collectors.toList()).toArray(allowedMethods);
    }
}
