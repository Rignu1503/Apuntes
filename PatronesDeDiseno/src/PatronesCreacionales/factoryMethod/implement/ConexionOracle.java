package PatronesCreacionales.factoryMethod.implement;

import PatronesCreacionales.factoryMethod.interfaces.Iconexion;

public class ConexionOracle implements Iconexion {


    private String host;
    private String puerto;
    private String usuario;
    private String contrasena;

    public ConexionOracle() {
        this.host = "localhost";
        this.puerto = "1521";
        this.usuario = "admin";
        this.contrasena = "123";
    }

    @Override
    public void conectar() {
        // Aqui puede ir código JDBC
        System.out.println("Se conectó a Oracle");
    }

    @Override
    public void desconectar() {

        System.out.println("Se desconectó de Oracle");
    }

    @Override
    public String toString() {
        return "conexionOracle" + '\n'+
                "host= " + host + '\n' +
                ", puerto= " + puerto + '\n' +
                ", usuario= " + usuario + '\n' +
                ", contrasena='" + contrasena;
    }
}
