package org.rigo.test.springboot.app.services;

import org.rigo.test.springboot.app.models.Banco;
import org.rigo.test.springboot.app.models.Cuenta;
import org.rigo.test.springboot.app.repositories.BancoRepository;
import org.rigo.test.springboot.app.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService{

    private CuentaRepository cuentaRepository;
    private BancoRepository bancoRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, BancoRepository bancoRepository) {
        this.cuentaRepository = cuentaRepository;
        this.bancoRepository = bancoRepository;
    }

    @Override
    @Transactional
    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cuenta findById(long id) {
        return cuentaRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        cuentaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public int revisarTotalTranferencia(long BancoId) {

        Banco banco = bancoRepository.findById(BancoId).orElseThrow();

        return banco.getTotalTranferencia();
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal revisarSaldo(long cuentaId) {

        Cuenta cuenta = cuentaRepository.findById(cuentaId).orElseThrow();

        return cuenta.getSaldo();
    }

    @Override
    @Transactional
    public void tranferir(Long numCuentaOrigen, Long numCuentaDestino, BigDecimal valor, Long bandoId) {

        Cuenta cuentaOrigen = cuentaRepository.findById(numCuentaOrigen).orElseThrow();
        cuentaOrigen.debito(valor);
        cuentaRepository.save(cuentaOrigen);

        Cuenta cuentaDestino = cuentaRepository.findById(numCuentaDestino).orElseThrow();
        cuentaDestino.credito(valor);
        cuentaRepository.save(cuentaDestino);

        Banco banco = bancoRepository.findById(bandoId).orElseThrow();
        int totalTranferencias = banco.getTotalTranferencia();
        banco.setTotalTranferencia(++totalTranferencias);
        bancoRepository.save(banco);
    }
}
