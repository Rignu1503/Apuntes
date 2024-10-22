package com.riwi.beautySalon.api.dto.errors;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorsResp extends BaseErrorResponse {
    // Heredamos los "BaseErrorResponse" }

    //Creamos una lista para guardar todos los posibles errores que pueden salir
    private List<String> errors;
    
}
