package PatronesCreacionales.factoryMethod;

import PatronesCreacionales.factoryMethod.interfaces.Iconexion;

public class app {

    public static void main(String[] args) {
        ConexionFabrica fabrica = new ConexionFabrica();

        Iconexion cx1 = fabrica.getConexion("ORACLE");
        cx1.conectar();
        cx1.desconectar();

        Iconexion cx2 = fabrica.getConexion("MYSQL");
        cx2.conectar();
        cx2.desconectar();

        Iconexion cx3 = fabrica.getConexion("H2");
        cx3.conectar();
        cx3.desconectar();
    }
}
