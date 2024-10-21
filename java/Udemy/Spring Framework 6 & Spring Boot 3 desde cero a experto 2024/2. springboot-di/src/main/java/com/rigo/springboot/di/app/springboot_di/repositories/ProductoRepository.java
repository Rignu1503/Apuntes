package com.rigo.springboot.di.app.springboot_di.repositories;

import com.rigo.springboot.di.app.springboot_di.models.Product;

import java.util.List;

public interface ProductoRepository {

    List<Product> findAll();

    Product findById(Long id);
}
