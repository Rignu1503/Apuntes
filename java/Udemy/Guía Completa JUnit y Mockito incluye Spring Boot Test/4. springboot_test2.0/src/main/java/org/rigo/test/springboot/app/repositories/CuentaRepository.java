package org.rigo.test.springboot.app.repositories;

import org.rigo.test.springboot.app.models.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    @Query("SELECT c FROM Cuenta c WHERE c.persona = ?1")
    Optional<Cuenta> findByPersona(String persona);


    //List<Cuenta> findAll();
    //Cuenta findById(long id);
    //void update(Cuenta newCuenta);


}
