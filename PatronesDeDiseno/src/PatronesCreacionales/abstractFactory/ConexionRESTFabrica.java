package PatronesCreacionales.abstractFactory;

import PatronesCreacionales.abstractFactory.implement.ConexionRESTCompras;
import PatronesCreacionales.abstractFactory.implement.ConexionRESTNoArea;
import PatronesCreacionales.abstractFactory.implement.ConexionRESTVentas;
import PatronesCreacionales.abstractFactory.interfaces.FabricaAbstracta;
import PatronesCreacionales.abstractFactory.interfaces.IConexionBD;
import PatronesCreacionales.abstractFactory.interfaces.IConexionREST;

public class ConexionRESTFabrica implements FabricaAbstracta {
    @Override
    public IConexionBD getBD(String motor) {
        return null;
    }

    @Override
    public IConexionREST getREST(String area) {

        if (area == null) {
            return new ConexionRESTNoArea();
        }
        if (area.equalsIgnoreCase("COMPRAS")) {
            return new ConexionRESTCompras();
        } else if (area.equalsIgnoreCase("VENTAS")) {
            return new ConexionRESTVentas();
        }

        return new ConexionRESTNoArea();
    }
}
