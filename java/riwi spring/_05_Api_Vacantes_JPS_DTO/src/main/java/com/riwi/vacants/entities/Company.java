package com.riwi.vacants.entities;

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
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  @Column(length = 40, nullable = false)
  private String name;
  @Column(length = 60, nullable = false)
  private String location;
  @Column(length = 15, nullable = false)
  private String contact;

  //OneToMany uno a muchos
  // orphanRemoval -> Especificar que un objeto huerfano (sin llave foranea) sera eliminado *** on delete cascade en mySQL***
  // mappedBy debemos especificar en que propiedad se esta mapeando en la otra entidad
  @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  @ToString.Exclude
  // se debe ignorar el toString porque vancates ya tiene toString 
  @EqualsAndHashCode.Exclude
  // se igonaran las clases Vacants internas respecto a toString y propiedades dentro de la lista 
  private List<Vacant> vacant;
}
