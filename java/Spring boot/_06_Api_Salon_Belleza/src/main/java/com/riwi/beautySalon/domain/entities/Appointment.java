package com.riwi.beautySalon.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    // Para aclarar que es el id
    @Id
    // Para que sea autoincrementable el ID en DDBB
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    
    // Column -> nos permite definir valores en las columnas de la base de datos
    @Column(nullable = false)
    private Integer duration;

    @Lob
    private String comments;

    /* RELACIONES */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            // Nombre de la relacion
            name = "client_id",
            // Bombre del atributo para hacer la relacion
            referencedColumnName = "id")
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "service_id",
            referencedColumnName = "id")
    private ServiceEntity service;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "employee_id",
            referencedColumnName = "id")
    private Employee employee;
}
