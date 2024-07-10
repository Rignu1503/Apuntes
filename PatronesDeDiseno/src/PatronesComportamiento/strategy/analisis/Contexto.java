package PatronesComportamiento.strategy.analisis;

import PatronesComportamiento.strategy.interfaces.IEstrategia;

public class Contexto {


    private IEstrategia estrategia;

    public Contexto(IEstrategia estrategia) {
        this.estrategia = estrategia;
    }

    public void ejecutar() {
        this.estrategia.analizar();
    }
}
