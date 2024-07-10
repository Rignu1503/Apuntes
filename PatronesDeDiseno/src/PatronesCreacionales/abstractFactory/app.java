package PatronesCreacionales.abstractFactory;

import PatronesCreacionales.abstractFactory.interfaces.FabricaAbstracta;
import PatronesCreacionales.abstractFactory.interfaces.IConexionBD;
import PatronesCreacionales.abstractFactory.interfaces.IConexionREST;

public class app {

    public static void main(String[] args) {

        //Indicamos que nos vamos a conectar a la base de datos
        FabricaAbstracta fabricaBD = FabricaProductor.getFactory("BD");

        //Indicamos que nos vamos a conectar a la base de datos MySQL
        IConexionBD cxBD1 = fabricaBD.getBD("MYSQL");

        //Llamamos al metodo conectar
        cxBD1.conectar();

        //Indicamos que vamos a conectarnos al ApiREST
        FabricaAbstracta fabricaREST = FabricaProductor.getFactory("REST");
        //Indicamos que vamos al API de compras
        IConexionREST cxRS1 = fabricaREST.getREST("COMPRAS");

        //Intanciamos el metodo "leerURL"
        cxRS1.leerURL("https://www.youtube.com/subscription_center?add_user=mitocode");
    }
}
