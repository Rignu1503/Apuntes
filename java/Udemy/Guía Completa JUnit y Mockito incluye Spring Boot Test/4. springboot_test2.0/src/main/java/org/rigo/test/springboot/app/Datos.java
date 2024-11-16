package org.rigo.test.springboot.app;

import org.rigo.test.springboot.app.models.Banco;
import org.rigo.test.springboot.app.models.Cuenta;

import java.math.BigDecimal;
import java.util.Optional;

public class Datos {

    public static final Cuenta CUENTA_001 = new Cuenta(1L, "Rigo", new BigDecimal("1000"));
    public static final Cuenta CUENTA_002 = new Cuenta(1L, "Jesus", new BigDecimal("23000"));
    public  static final Banco BANCO = new Banco(1L, "Bancolombia", 0);

    public static Optional<Cuenta> createCuenta001() {
        return Optional.of(CUENTA_001);
    }

    public static  Optional<Cuenta> createCuenta002() {
        return Optional.of(CUENTA_002);
    }

    public static Optional<Banco> createBanco() {
        return Optional.of(BANCO);
    }


}
