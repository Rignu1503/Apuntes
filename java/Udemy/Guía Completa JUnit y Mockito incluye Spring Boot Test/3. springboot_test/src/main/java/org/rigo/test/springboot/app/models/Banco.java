package org.rigo.test.springboot.app.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Banco {
    private Long id;
    private String nombre;
    private int totalTranferencia;

    public Banco() {
    }
    public Banco(Long id, String nombre, int totalTranferencia) {
        this.id = id;
        this.nombre = nombre;
        this.totalTranferencia = totalTranferencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalTranferencia() {
        return totalTranferencia;
    }

    public void setTotalTranferencia(int totalTranferencia) {
        this.totalTranferencia = totalTranferencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return totalTranferencia == banco.totalTranferencia && Objects.equals(id, banco.id) && Objects.equals(nombre, banco.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, totalTranferencia);
    }
}
