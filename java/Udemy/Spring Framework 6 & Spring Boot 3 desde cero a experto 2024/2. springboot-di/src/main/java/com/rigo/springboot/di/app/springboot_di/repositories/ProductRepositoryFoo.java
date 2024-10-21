package com.rigo.springboot.di.app.springboot_di.repositories;

import com.rigo.springboot.di.app.springboot_di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Collections;
import java.util.List;

@RequestScope
@Repository
public class ProductRepositoryFoo implements ProductoRepository{
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Intel i9", 2L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Intel i9", 2L);
    }
}
