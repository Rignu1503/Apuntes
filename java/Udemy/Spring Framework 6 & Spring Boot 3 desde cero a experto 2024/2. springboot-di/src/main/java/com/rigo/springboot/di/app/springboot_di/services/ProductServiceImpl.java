package com.rigo.springboot.di.app.springboot_di.services;

import com.rigo.springboot.di.app.springboot_di.models.Product;
import com.rigo.springboot.di.app.springboot_di.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductoRepository productRepository;

    @Autowired
    private Environment environment;

    public ProductServiceImpl( ProductoRepository productRepository) {
        this.productRepository = productRepository;
    }



    public List<Product> findAll() {
        return productRepository.findAll().stream().map(p ->{
            Double priceTax = p.getPrice() * environment.getProperty("cofig.price.tax", Double.class);
            //Product newProd = new Product( p.getId(), p.getName(),priceTax.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;

        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return productRepository.findById(id);
    }
}
