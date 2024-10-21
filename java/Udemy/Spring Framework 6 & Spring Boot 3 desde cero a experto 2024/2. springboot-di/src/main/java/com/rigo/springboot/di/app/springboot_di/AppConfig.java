package com.rigo.springboot.di.app.springboot_di;

import com.rigo.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;
import com.rigo.springboot.di.app.springboot_di.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Value("classpath:json/product.json")
    private Resource resource;

    @Bean("productJson")
    @Primary
    public ProductoRepository produtoRepositoryjson(){
        return new ProductRepositoryJson(resource);
    }
}
