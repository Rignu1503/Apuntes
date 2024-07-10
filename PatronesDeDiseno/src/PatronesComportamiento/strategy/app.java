package PatronesComportamiento.strategy;

import PatronesComportamiento.strategy.analisis.Contexto;
import PatronesComportamiento.strategy.interfaces.IEstrategia;

public class app {

    public static void main(String[] args) {
        Contexto contexto = new Contexto(new IEstrategia.AntivirusSimple());
        contexto.ejecutar();
    }
}
