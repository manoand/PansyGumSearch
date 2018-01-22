package com.MnP.demo.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class BeanConfig {
    @Bean
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[] { "/WEB-INF/tiles/tiles.xml" });
        return tiles;

    }

    @Bean
    public UrlBasedViewResolver viewResolver() {
        final UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }
}
