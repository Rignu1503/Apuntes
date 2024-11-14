package org.rigo.test.springboot.app.repositories;

import org.rigo.test.springboot.app.models.Cuenta;

import java.util.List;

public interface CuentaRepository {

    List<Cuenta> findAll();
    Cuenta findById(long id);
    void update(Cuenta newCuenta);


}
