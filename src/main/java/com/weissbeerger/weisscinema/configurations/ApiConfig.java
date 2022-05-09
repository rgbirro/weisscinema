package com.weissbeerger.weisscinema.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class ApiConfig {
    private final String API_URL = "http://www.omdbapi.com/";

    @Bean
    public WebClient omdbApiClient () {
        return WebClient.create(API_URL);
    }
}
