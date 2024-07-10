package PatronesCreacionales.abstractFactory.interfaces;

public interface FabricaAbstracta {

    IConexionBD getBD(String motor);
    IConexionREST getREST(String area);
}
