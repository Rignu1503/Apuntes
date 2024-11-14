package org.rigo.test.springboot.app.repositories;

import org.rigo.test.springboot.app.models.Banco;

import java.util.List;

public interface BancoRepository {

    List<Banco> findAll();
    Banco findById(long id);
    void update(Banco banco);
}
