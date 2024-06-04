package com.riwi.vacants.entities;

import com.riwi.vacants.entities.utils.enums.StatusVacant;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "vacant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String description;
  @Enumerated(EnumType.STRING)// cuando se declara un atributo de tipo enum se usa @Enumerated para declarar de que tipo sera el valor ingresado (String en este caso)
  private StatusVacant status;
  
  
  
  @ManyToOne(fetch = FetchType.LAZY) // @ManyToOne: Muchos a uno
  @JoinColumn(name = "company_id", referencedColumnName = "id")
  // el name: es para el nombre que tendrá en MySQL
  // referencedColumnName se coloca el id de la clase (en este caso Company)
  private Company company;
}
