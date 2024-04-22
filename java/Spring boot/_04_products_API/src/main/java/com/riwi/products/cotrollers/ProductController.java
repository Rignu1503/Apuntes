package com.riwi.products.cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.products.entities.Products;
import com.riwi.products.servicies.service_abstract.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    @Autowired
    private final IProductService productService;


    @GetMapping
    public ResponseEntity<List<Products>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }
}
