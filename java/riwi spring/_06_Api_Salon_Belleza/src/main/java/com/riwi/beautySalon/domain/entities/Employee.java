package com.riwi.beautySalon.domain.entities;

import com.riwi.beautySalon.utils.enums.RoleEmployee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// Crea los getters, setters y toString
@Data
// builder -> crea patornes de diseños mas limpios
@Builder
// Crea nostructor lleno
@AllArgsConstructor
// Crea nostructor vacio
@NoArgsConstructor

public class Employee {
    // Para aclarar que es el id
    @Id
    // Para que sea autoincrementable el ID en DDBB
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // column -> Indicaciones de crea la tabla: decimos que tiene como max 100 caracteres y no puede ser null
    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(nullable = false, length = 50)
    // Enumerated -> Decimos que va a ser tipo enumerado y recibira los roles en
    // string(Nombre creados en los enum)
    @Enumerated(EnumType.STRING)
    private RoleEmployee role;
}
