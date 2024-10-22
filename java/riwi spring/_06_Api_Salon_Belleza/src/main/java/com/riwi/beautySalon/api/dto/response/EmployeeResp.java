package com.riwi.beautySalon.api.dto.response;

import com.riwi.beautySalon.utils.enums.RoleEmployee;

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
public class EmployeeResp {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private RoleEmployee role;
}
