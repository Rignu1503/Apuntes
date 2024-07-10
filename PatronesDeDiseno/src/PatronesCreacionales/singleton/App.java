package PatronesCreacionales.singleton;

import PatronesCreacionales.singleton.Model.Conexion;

public class App {

    public static void main(String[] args) {
        /*
        Instantiation por constructor prohíbido por ser "private" no es posible por el costructor privado
        Conexion c = new Conexion();
        */

        /* en c guardamos la referencia de memoria*/
        Conexion c = Conexion.getInstancia();
        c.conectar();
        c.desconectar();

        /* Verifica si c es una instancia de Conxion */
        boolean rpta = c instanceof Conexion;

        System.out.println(rpta);
    }
}
