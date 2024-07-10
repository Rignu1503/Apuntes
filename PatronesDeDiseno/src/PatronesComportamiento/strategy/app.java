package PatronesComportamiento.strategy;

import PatronesComportamiento.strategy.analisis.AntivirusAvanzado;
import PatronesComportamiento.strategy.analisis.AntivirusSimple;
import PatronesComportamiento.strategy.analisis.Contexto;

public class app {

    public static void main(String[] args) {
        Contexto contexto = new Contexto(new AntivirusAvanzado());
        contexto.ejecutar();
    }
}
