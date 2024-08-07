package PatronesCreacionales.abstractFactory.implement;

import PatronesCreacionales.abstractFactory.interfaces.IConexionBD;

public class ConexionMySQL implements IConexionBD {

    private String host;
    private String puerto;
    private String usuario;
    private String contrasena;

    public ConexionMySQL() {
        this.host = "localhost";
        this.puerto = "3306";
        this.usuario = "root";
        this.contrasena = "123";
    }

    @Override
    public void conectar() {
        // Aqui puede ir código JDBC
        System.out.println("Se conectó a MySQL");
    }

    @Override
    public void desconectar() {
        System.out.println("Se desconectó de MySQL");
    }

    @Override
    public String toString() {
        return "conexionMySQL" + '\n'+
                "host= " + host + '\n' +
                ", puerto= " + puerto + '\n' +
                ", usuario= " + usuario + '\n' +
                ", contrasena='" + contrasena;
    }
}
