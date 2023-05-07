package com.behlole.portfolio.Portfolio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AssetConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/images/**")  // URL pattern to access the assets
                .addResourceLocations("classpath:/images/");  // Location of the assets directory
    }

    // Other configuration methods...
}
