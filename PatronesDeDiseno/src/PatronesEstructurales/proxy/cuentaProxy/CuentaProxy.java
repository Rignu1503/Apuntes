package PatronesEstructurales.proxy.cuentaProxy;

import PatronesEstructurales.proxy.interfaces.Icuenta;
import PatronesEstructurales.proxy.model.Cuenta;
import PatronesEstructurales.proxy.service.CuentaBancoAImpl;

import java.util.logging.Logger;

public class CuentaProxy implements Icuenta {
    private Icuenta cuentaReal;
    private final static Logger LOGGER = Logger.getLogger(CuentaProxy.class.getName());

    public CuentaProxy(Icuenta cuentaReal) {
        this.cuentaReal = cuentaReal;
    }

    @Override
    public Cuenta retirarDinero(Cuenta cuenta, double monto) {
        LOGGER.info("----Cuenta Proxy - Retirar Dinero----");
        if (cuentaReal == null) {
            cuentaReal = new CuentaBancoAImpl();
            return cuentaReal.retirarDinero(cuenta, monto);
        } else {
            return cuentaReal.retirarDinero(cuenta, monto);
        }
    }

    @Override
    public Cuenta depositarDinero(Cuenta cuenta, double monto) {
        LOGGER.info("----Cuenta Proxy - Depositar Dinero----");
        if (cuentaReal == null) {
            cuentaReal = new CuentaBancoAImpl();
            return cuentaReal.depositarDinero(cuenta, monto);
        } else {
            return cuentaReal.depositarDinero(cuenta, monto);
        }
    }

    @Override
    public void mostrarSaldo(Cuenta cuenta) {
        LOGGER.info("----Cuenta Proxy - Mostrar Dinero----");
        if (cuentaReal == null) {
            cuentaReal = new CuentaBancoAImpl();
            cuentaReal.mostrarSaldo(cuenta);
        } else {
            cuentaReal.mostrarSaldo(cuenta);
        }
    }
}
