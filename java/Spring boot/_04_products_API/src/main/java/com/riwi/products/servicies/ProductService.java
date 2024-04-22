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
        // TODO Auto-generated method stub
        
    }

    @Override
    public Products findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Products> getAll() {
        // TODO Auto-generated method stub
        return this.productRepository.findAll();
    }

    @Override
    public Products save(Products products) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Products> search(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Products update(Products products) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
