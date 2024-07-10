package PatronesCreacionales.abstractFactory.implement;

import PatronesCreacionales.abstractFactory.interfaces.IConexionBD;

public class ConexionVacia implements IConexionBD {
    @Override
    public void conectar() {
        System.out.println("NO SE ESPECIFICÓ PROVEEDOR");
    }

    @Override
    public void desconectar() {
        System.out.println("NO SE ESPECIFICÓ PROVEEDOR");
    }
}
