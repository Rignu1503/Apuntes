package com.riwi.products.servicies.service_abstract;

import java.util.List;

import com.riwi.products.entities.Products;

public interface IProductService {

    public Products save(Products products);

    public List<Products> getAll();

    public Products findById(Long id);

    public void delete(Long id);

    public Products update(Long id, Products products);

    public List<Products> search(String name);

}
