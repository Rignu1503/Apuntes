package org.rigo.test.springboot.app.repositories;

import org.rigo.test.springboot.app.models.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BancoRepository extends JpaRepository<Banco, Long> {

    //List<Banco> findAll();
    //Banco findById(long id);
    //void update(Banco banco);
}
