package com.riwi.products.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.products.entities.Products;
import com.riwi.products.repositories.ProductRepository;
import com.riwi.products.servicies.service_abstract.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    //Cuando tenemos la palabra final en un atributo, estamos diciendo que no se puede cambiar el valor de ese atributo y nos obliga hacer un constructor
    private final ProductRepository productRepository;

    @Override
    public void delete(Long id) {
        this.productRepository.findById(id).orElseThrow();
        this.productRepository.deleteById(id);
    }

    @Override
    public Products findById(Long id) {

        return this.productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Products> getAll() {

        return this.productRepository.findAll();
    }

    @Override
    public Products save(Products products) {

        return this.productRepository.save(products);
    }

    @Override
    public List<Products> search(String name) {

        return null;
    }

    @Override
    public Products update(Long id, Products objProducts) {

        this.productRepository.findById(id).orElseThrow();
        objProducts.setId(id);

        return this.productRepository.save(objProducts);
    }
    
}
