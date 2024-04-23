package com.riwi.products.cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<Products>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Products> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Products> insert(@RequestBody Products objProduct) {
        return ResponseEntity.ok(this.productService.save(objProduct));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Products> update(@PathVariable Long id, @RequestBody Products objProduct) {
        return ResponseEntity.ok(this.productService.update(id, objProduct));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
