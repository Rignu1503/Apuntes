package com.riwi.beautySalon.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Nombre que va tener la tabla en la base de datos
@Entity(name = "client")
// Crea los getters, setters y toString
@Data
// builder -> crea patornes de diseños mas limpios
@Builder
// Crea nostructor lleno
@AllArgsConstructor
// Crea nostructor vacio
@NoArgsConstructor

public class ClientEntity {

    // Para aclarar que es el id
    @Id
    // Para que sea autoincrementable el ID en DDBB
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    // column -> Indicaciones de crea la tabla: decimos que tiene como max 100
    // caracteres y no puede ser null

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    private String email;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Appointment> appointment;

}
