package com.rigo.springboot.di.app.springboot_di.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rigo.springboot.di.app.springboot_di.models.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class ProductRepositoryJson implements ProductoRepository{

    private  List<Product> products;

    //Leer Json sin constructor
    public ProductRepositoryJson() {

        Resource resource = new ClassPathResource("json/product.json");
        readValueJson(resource);
    }

    //Leer Json mediante constructor
    public ProductRepositoryJson(Resource resource) {

        readValueJson(resource);
    }

    private void readValueJson(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            products = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {

        return products;
    }

    @Override
    public Product findById(Long id) {

        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }


}
