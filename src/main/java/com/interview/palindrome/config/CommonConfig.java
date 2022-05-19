package com.interview.palindrome.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
