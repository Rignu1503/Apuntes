package com.riwi.beautySalon.api.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// builder -> crea patornes de diseños mas limpios
@Builder
// Crea nostructor lleno
@AllArgsConstructor
// Crea nostructor vacio
@NoArgsConstructor
public class ServiceReq {

    //NotBlank -> Sirve para validar que la cadena no este vacia
    @NotBlank(message = "El nombre del servicio es requerido")
    private String name;

    private String description;

    // DecimalMin -> Sirve colocar un minimo al valor que se va a recibir 
    @NotNull(message = "El precio es requerido")
    @DecimalMin(value = "0.01", message = "EL valor del serivicio debe ser mayor a 0")
    private BigDecimal price;
}
