package PatronesCreacionales.factoryMethod.implement;

import PatronesCreacionales.factoryMethod.interfaces.Iconexion;

public class ConexionVacia implements Iconexion {
    @Override
    public void conectar() {
        System.out.println("NO SE ESPECIFICÓ PROVEEDOR");
    }

    @Override
    public void desconectar() {
        System.out.println("NO SE ESPECIFICÓ PROVEEDOR");
    }
}
