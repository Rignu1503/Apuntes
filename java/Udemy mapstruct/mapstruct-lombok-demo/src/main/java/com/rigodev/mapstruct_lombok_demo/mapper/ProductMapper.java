package com.rigodev.mapstruct_lombok_demo.mapper;


import com.rigodev.mapstruct_lombok_demo.dto.GetProduct;
import com.rigodev.mapstruct_lombok_demo.entity.Product;
import org.mapstruct.*;

import java.util.List;

/*
* @Mapper -> Es la anotación de MapStruct que se usa para definir una interfaz de mapper se utiliza para generar el mapeo.
*MappingConstants ->  contiene constantes relacionadas con el mapeo
* */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    /*
    *Mappings ->  se utiliza para agrupar varios @Mapping en un solo lugar para un método de mapeo
    * Mapping -> Aquí se especifica que el campo id de la clase de origen se debe asignar al campo id en la clase de destino
     * */
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "creation_date", target = "creation_date",  dateFormat = "yyyy-MM-dd")
    })
    // La clase de origen que proviene de la entidad Product
    GetProduct toGetDTO(Product product);


    @InheritConfiguration
    Product toEntity(GetProduct getProduct);


    //----------------Mapear lista-----------------------
    List<GetProduct> toGetDTO(List<Product> products);
    
    List<Product> toEntity(List<GetProduct> getProducts);
}
