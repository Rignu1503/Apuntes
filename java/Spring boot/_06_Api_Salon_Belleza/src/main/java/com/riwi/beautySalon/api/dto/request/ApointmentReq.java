package com.riwi.beautySalon.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Crea los getters, setters y toString
@Data
// builder -> crea patornes de diseños mas limpios
@Builder
// Crea nostructor lleno
@AllArgsConstructor
// Crea nostructor vacio
@NoArgsConstructor

public class ApointmentReq {

    //NotBlank -> Sirve para validar que la cadena no este vacia
    @NotBlank(message = "LA fecha y hora es requerida")
    private LocalDateTime dateTime;

    // Min y Max -> Sirve para validar que el valor este dentro de un rango
    @Min(value = 10, message = "La duracion no puede ser menor a 10")
    @Max(value = 720, message = "La duracion no puede ser mayor a 12 horas")
    private Integer duration;

    private String comments;

    // NotNull -> Sirve para validar que el valor no sea nulo
    @NotNull(message = "El idel cliente es obligatorio")
    private Long clienteId;

    @NotNull(message = "El empleado cliente es obligatorio")
    private Long employeeId;

    @NotNull(message = "El idel servicio es obligatorio")
    private Long serviceId;

}
