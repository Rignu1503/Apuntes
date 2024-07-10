package PatronesCreacionales.abstractFactory;

import PatronesCreacionales.abstractFactory.interfaces.FabricaAbstracta;

public class FabricaProductor {

    public static FabricaAbstracta getFactory(String tipoFabrica) {

        if (tipoFabrica.equalsIgnoreCase("BD")) {
            return new ConexionDBFabrica();

        } else if (tipoFabrica.equalsIgnoreCase("REST")) {
            return new ConexionRESTFabrica();
        }

        return null;
    }

}

