package PatronesComportamiento.strategy.analisis;

import PatronesComportamiento.strategy.interfaces.IEstrategia;

public abstract class AnalisisAvanzado implements IEstrategia {
    @Override
    public void analizar() {

        iniciar();
        analizarMemoria();
        analizarKeyloggers();
        analizarRootKits();
        descomprimirZip();
        detener();
    }
    abstract void iniciar();

    abstract void analizarMemoria();

    abstract void analizarKeyloggers();

    abstract void analizarRootKits();

    abstract void descomprimirZip();

    abstract void detener();
}
