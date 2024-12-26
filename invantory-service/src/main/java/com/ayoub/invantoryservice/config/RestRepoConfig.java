package com.ayoub.invantoryservice.config;

import com.ayoub.invantoryservice.entities.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestRepoConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry corsRegistry) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, corsRegistry);
        config.exposeIdsFor(Product.class);
    }
}
