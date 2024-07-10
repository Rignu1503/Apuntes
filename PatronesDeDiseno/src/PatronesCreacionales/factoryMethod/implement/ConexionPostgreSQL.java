package PatronesCreacionales.factoryMethod.implement;

import PatronesCreacionales.factoryMethod.interfaces.Iconexion;

public class ConexionPostgreSQL implements Iconexion {

    private String host;
    private String puerto;
    private String usuario;
    private String contrasena;

    public ConexionPostgreSQL() {
        this.host = "localhost";
        this.puerto = "5433";
        this.usuario = "postgres";
        this.contrasena = "123";
    }

    @Override
    public void conectar() {
        // Aqui puede ir código JDBC
        System.out.println("Se conectó a PostgreSQL");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconectó de PostgreSQL");
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
