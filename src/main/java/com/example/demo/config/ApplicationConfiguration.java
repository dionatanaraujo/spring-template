package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ApplicationConfiguration {

    @Bean(name = "messageSource")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("messages/messages");
        source.setUseCodeAsDefaultMessage(true);

        return source;
    }
}
