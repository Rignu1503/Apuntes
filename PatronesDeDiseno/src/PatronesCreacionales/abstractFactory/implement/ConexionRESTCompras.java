package PatronesCreacionales.abstractFactory.implement;

import PatronesCreacionales.abstractFactory.interfaces.IConexionREST;

public class ConexionRESTCompras implements IConexionREST {
    @Override
    public void leerURL(String url) {

        System.out.println("Conectándose a " + url);
    }
}
