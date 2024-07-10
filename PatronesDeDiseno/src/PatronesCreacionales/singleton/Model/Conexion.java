package PatronesCreacionales.singleton.Model;

public class Conexion {

    /* Declaración de la instancia estática */
    private static Conexion instancia;

    /* Constructor privado para evitar la instanciación desde fuera de la clase
     mediante el operador "new"  */
    private Conexion() {
        /* Inicialización de la conexión */
    }

    /* Método público estático para obtener la instancia única */
    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    /* Método de prueba */
    public void conectar() {
        System.out.println("Me conecté a la BD");
    }

    /* Método de prueba */
    public void desconectar() {
        System.out.println("Me desconecté de la BD");
    }

}
