package com.riwi.beautySalon.api.dto.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//El DTO sirve para manejar las respuesta del servidor

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ServiceResp {
    
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

}
