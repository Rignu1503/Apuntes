package com.riwi.primeraweb.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Entity: indica que esta clase será una entidad y podra ser mapeada(covertirla en tabalas sql)
@Entity
@Table(name = "coder") //Nombre de la tabla en la base de datos
public class Coder {

    /* Indica que este atributo siguiente será la clave primaria  */
    @Id 
    /* Indica que este atributo será autoincrementable  */
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private int age;
    private String clan;


    public Coder() {
    }


    public Coder(long id, String name, int age, String clan) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clan = clan;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getClan() {
        return clan;
    }


    public void setClan(String clan) {
        this.clan = clan;
    }


    @Override
    public String toString() {
        return "Coder [id=" + id + ", name=" + name + ", age=" + age + ", clan=" + clan + "]";
    }

    
    
    
}
