package PatronesEstructurales.proxy;

import PatronesEstructurales.proxy.cuentaProxy.CuentaProxy;
import PatronesEstructurales.proxy.interfaces.Icuenta;
import PatronesEstructurales.proxy.model.Cuenta;
import PatronesEstructurales.proxy.service.CuentaBancoBImpl;

public class App {
    public static void main(String[] args) {
        Cuenta c = new Cuenta(1, "mitocode", 100);

        Icuenta cuentaProxy = new CuentaProxy(new CuentaBancoBImpl());
        cuentaProxy.mostrarSaldo(c);
        c = cuentaProxy.depositarDinero(c, 50);
        c = cuentaProxy.retirarDinero(c, 20);
        cuentaProxy.mostrarSaldo(c);

    }
}
