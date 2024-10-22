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

    @Column(length = 40, nullable = false)
    private String location;

    @Column(length = 40, nullable = false)
    private String contact;



    /*
     * Cascade.All: Esepecificamos el tipo cascada, All quiere decir que tendremos todo los tipos de cascada
     * orphanRemoval ->  Espesifica que un objeto huerfano(Sin llave foranea) sera eliminado
     * MappedBy: debemos especisificar en donde o en que propiedad se mapeando en la otra entidad 
     * FetchType.EAGER ->  Espesifica que la relacion sera cargada de manera ansiosa
     * FetchType.LAZY ->  Espesifica que la relacion sera cargada de manera perezosa
     */
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false) 
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vacant> vacants;
  
    

}
