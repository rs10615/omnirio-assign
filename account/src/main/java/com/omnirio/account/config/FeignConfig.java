package com.omnirio.account.config.security;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignConfig {
    @Bean
    public Logger.Level configureLogLevel() {
        return Logger.Level.HEADERS;
    }
}