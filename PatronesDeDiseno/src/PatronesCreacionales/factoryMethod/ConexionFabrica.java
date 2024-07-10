package PatronesCreacionales.factoryMethod;

import PatronesCreacionales.factoryMethod.implement.*;
import PatronesCreacionales.factoryMethod.interfaces.Iconexion;

public class ConexionFabrica {


    public Iconexion getConexion(String motor) {
        if (motor == null) {
            return new ConexionVacia();
        }
        if (motor.equalsIgnoreCase("MYSQL")) {
            return new ConexionMySQL();
        } else if (motor.equalsIgnoreCase("ORACLE")) {
            return new ConexionOracle();
        } else if (motor.equalsIgnoreCase("POSTGRE")) {
            return new ConexionPostgreSQL();
        }

        return new ConexionVacia();
    }
}
