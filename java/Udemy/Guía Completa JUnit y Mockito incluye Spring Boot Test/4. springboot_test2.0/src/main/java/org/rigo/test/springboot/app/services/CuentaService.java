package org.rigo.test.springboot.app.services;

import org.rigo.test.springboot.app.models.Cuenta;

import java.math.BigDecimal;
import java.util.List;

public interface CuentaService {

    List<Cuenta> findAll();
    Cuenta findById(long id);
    Cuenta save(Cuenta cuenta);
    int revisarTotalTranferencia(long BancoId);
    BigDecimal revisarSaldo(long cuentaId);
    void tranferir(Long cuentaOrigen, Long cuentaDestino, BigDecimal valor, Long bandoId);

}
