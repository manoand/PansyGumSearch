package com.MnP.demo.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*css/**").addResourceLocations("/WEB-INF/ressources/css");
        registry.addResourceHandler("/*js/**").addResourceLocations("/WEB-INF/ressources/js");
        registry.addResourceHandler("/*images/**").addResourceLocations("/WEB-INF/ressources/images");
        registry.addResourceHandler("/*fonts/**").addResourceLocations("/WEB-INF/ressources/fonts");
    }

}
