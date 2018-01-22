package com.MnP.demo.web.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomContainer implements EmbeddedServletContainerCustomizer {
    @Override
    public void customize(final ConfigurableEmbeddedServletContainer container) {

        container.setPort(38080);
    }
}
