package PatronesCreacionales.abstractFactory.implement;

import PatronesCreacionales.abstractFactory.interfaces.IConexionREST;

public class ConexionRESTNoArea implements IConexionREST {
    @Override
    public void leerURL(String url) {

        System.out.println("AREA NO ELEGIDA");
    }
}
