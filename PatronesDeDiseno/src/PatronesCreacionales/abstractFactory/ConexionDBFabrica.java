package PatronesCreacionales.abstractFactory;

import PatronesCreacionales.abstractFactory.implement.ConexionMySQL;
import PatronesCreacionales.abstractFactory.implement.ConexionOracle;
import PatronesCreacionales.abstractFactory.implement.ConexionPostgreSQL;
import PatronesCreacionales.abstractFactory.implement.ConexionVacia;
import PatronesCreacionales.abstractFactory.interfaces.FabricaAbstracta;
import PatronesCreacionales.abstractFactory.interfaces.IConexionBD;
import PatronesCreacionales.abstractFactory.interfaces.IConexionREST;



public class ConexionDBFabrica implements FabricaAbstracta {


    @Override
    public IConexionBD getBD(String motor) {

        if (motor == null) {
            return new ConexionVacia();
        }
        if (motor.equalsIgnoreCase("MYSQL")) {
            return new ConexionMySQL();
        } else if (motor.equalsIgnoreCase("ORACLE")) {
            return new ConexionOracle();
        } else if (motor.equalsIgnoreCase("POSTGRE")) {
            return new ConexionPostgreSQL();
        } else if (motor.equalsIgnoreCase("SQL")) {
            return new ConexionOracle();
        }

        return new ConexionVacia();

    }

    @Override
    public IConexionREST getREST(String area) {
        return null;
    }
}
