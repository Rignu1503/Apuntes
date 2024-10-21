package com.rigo.springboot.di.app.springboot_di.controllers;

import com.rigo.springboot.di.app.springboot_di.models.Product;
import com.rigo.springboot.di.app.springboot_di.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class SomeControllerImpl {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> list(){
        return service.findAll();

    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return service.findById(id);
    }
}
