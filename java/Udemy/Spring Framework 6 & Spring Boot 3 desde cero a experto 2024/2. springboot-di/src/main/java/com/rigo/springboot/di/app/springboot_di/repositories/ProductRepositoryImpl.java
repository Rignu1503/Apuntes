package com.rigo.springboot.di.app.springboot_di.repositories;

import com.rigo.springboot.di.app.springboot_di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("productList")
public class ProductRepositoryImpl implements ProductoRepository {

   private List<Product> data;

   public ProductRepositoryImpl() {
       this.data = List.of(
               new Product(1L, "memoria", 300L),
               new Product(2L, "Computador", 3000L),
               new Product(3L, "teclado", 150L)
       );
   }

   @Override
   public Product findById(Long id){
       return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
   }

   @Override
    public List<Product> findAll(){
        return this.data;
    }

}
