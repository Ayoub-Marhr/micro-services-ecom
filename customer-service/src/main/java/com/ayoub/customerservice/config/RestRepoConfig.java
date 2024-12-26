package com.ayoub.customerservice.config;

import com.ayoub.customerservice.entities.Customer;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
@Configuration
public class RestRepoConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry corsRegistry) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, corsRegistry);
        config.exposeIdsFor(Customer.class);
    }
}
