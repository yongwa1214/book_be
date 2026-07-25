package com.example.book.common.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@RequiredArgsConstructor
@Getter
@ConfigurationProperties(prefix = "google.books")
public class GoogleBookProperties {
    private final String baseUrl;
    private final String apiKey;
}
