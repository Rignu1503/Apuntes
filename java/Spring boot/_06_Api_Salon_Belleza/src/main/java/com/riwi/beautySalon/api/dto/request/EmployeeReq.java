package com.riwi.beautySalon.api.dto.request;

import com.riwi.beautySalon.utils.enums.RoleEmployee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class EmployeeReq {

    // NotBlank -> Sirve para validar que la cadena no este vacia
    @NotBlank(message = "El nombre es requerido")
    private String firstName;

    @NotBlank(message = "El apellido es requerido")
    private String lastName;

    // Email -> Sirve para validar que el email sea valido
    @Email(message = "El email no es valido")
    // Size -> Sirve para validar que el email tenga entre 5 y 100 caracteres
    @Size(min = 5, max = 100, message = "El email debe tener entre 5 y 100 caracteres")
    private String email;

    @Size(min = 10, max = 20, message = "El telefono debe tener entre 10 y 20 caracteres")
    private String phone;

    // NotBlank -> Sirve para validar que la cadena no este vacia
    @NotBlank(message = "El rol es requerido")
    private RoleEmployee role;
}
