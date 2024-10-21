package com.rigo.springboot.di.app.springboot_di.services;

import com.rigo.springboot.di.app.springboot_di.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
}
