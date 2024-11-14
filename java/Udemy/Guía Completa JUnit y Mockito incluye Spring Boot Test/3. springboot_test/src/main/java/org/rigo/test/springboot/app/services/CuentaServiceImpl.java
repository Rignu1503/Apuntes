package org.rigo.test.springboot.app.services;

import org.rigo.test.springboot.app.models.Banco;
import org.rigo.test.springboot.app.models.Cuenta;
import org.rigo.test.springboot.app.repositories.BancoRepository;
import org.rigo.test.springboot.app.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaServiceImpl implements CuentaService{

    private CuentaRepository cuentaRepository;
    private BancoRepository bancoRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, BancoRepository bancoRepository) {
        this.cuentaRepository = cuentaRepository;
        this.bancoRepository = bancoRepository;
    }

    @Override
    public Cuenta findById(long id) {
        return cuentaRepository.findById(id);
    }

    @Override
    public int revisarTotalTranferencia(long BancoId) {

        Banco banco = bancoRepository.findById(BancoId);

        return banco.getTotalTranferencia();
    }

    @Override
    public BigDecimal revisarSaldo(long cuentaId) {

        Cuenta cuenta = cuentaRepository.findById(cuentaId);

        return cuenta.getSaldo();
    }

    @Override
    public void tranferir(Long numCuentaOrigen, Long numCuentaDestino, BigDecimal valor, Long bandoId) {

        Cuenta cuentaOrigen = cuentaRepository.findById(numCuentaOrigen);
        cuentaOrigen.debito(valor);
        cuentaRepository.update(cuentaOrigen);

        Cuenta cuentaDestino = cuentaRepository.findById(numCuentaDestino);
        cuentaDestino.credito(valor);
        cuentaRepository.update(cuentaDestino);

        Banco banco = bancoRepository.findById(bandoId);
        int totalTranferencias = banco.getTotalTranferencia();
        banco.setTotalTranferencia(++totalTranferencias);
        bancoRepository.update(banco);
    }
}
