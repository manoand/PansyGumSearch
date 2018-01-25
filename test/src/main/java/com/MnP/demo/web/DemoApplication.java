package com.MnP.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.MnP.demo.web.service.BonbonService;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    @Autowired
    private BonbonService bonbonService;

    @SuppressWarnings("rawtypes")
    private static Class applicationClass = DemoApplication.class;

    public static void main(final String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

}
