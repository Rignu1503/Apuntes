package PatronesComportamiento.strategy.analisis;

import PatronesComportamiento.strategy.interfaces.IEstrategia;

public abstract class AnalisisSimple implements IEstrategia {

    public void analizar() {
            iniciar();
            saltarZip();
            detener();
    }

    abstract void iniciar();

    abstract void saltarZip();

    abstract void detener();

}
