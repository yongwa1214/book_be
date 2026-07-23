package com.example.book.common.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
@Getter
public class WebClientConfig {

    private final GoogleBookProperties properties;

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl(properties.getBaseUrl())
                .build();
    }
}
