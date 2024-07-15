package PatronesComportamiento.command;

import PatronesComportamiento.command.model.Cuenta;
import PatronesComportamiento.command.service.DepositarImpl;
import PatronesComportamiento.command.service.Invoker;
import PatronesComportamiento.command.service.RetirarImpl;

public class app {


    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(1, 200);

        DepositarImpl opDepositar = new DepositarImpl(cuenta, 100);
        RetirarImpl opRetirar = new RetirarImpl(cuenta, 50);

        Invoker ivk = new Invoker();
        ivk.recibirOperacion(opDepositar);
        ivk.recibirOperacion(opRetirar);

        ivk.realizarOperaciones();
    }
}
