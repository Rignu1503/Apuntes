package com.rigo.springboot.di.factura.springboot_factura;

import com.rigo.springboot.di.factura.springboot_factura.models.Item;
import com.rigo.springboot.di.factura.springboot_factura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;


@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppCofing {

    @Bean("default")
    List<Item> itemInvoice(){

        Product p1 = new Product("Camara canon", 2000);
        Product p2 = new Product("Memoria CD", 30);

        List<Item> items = Arrays.asList(new Item(p1,2), new Item(p2,3));

        return items;
    }

    @Bean
    @Primary
    List<Item> itemInvoiceOffice(){

        Product p1 = new Product("Monitor asus", 2000);
        Product p2 = new Product("Notebook", 30);
        Product p3 = new Product("escitorio", 30);

        List<Item> items = Arrays.asList(new Item(p1,2), new Item(p2,3), new Item(p3,1));

        return items;
    }
}
