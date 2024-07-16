package PatronesComportamiento.observer.observer;

/* Clase que representa un observador concreto para el peso argentino */
public class PesoARGObservador extends Observador {

    /* Valor fijo de la moneda para el tipo de cambio */
    private double valorCambio = 29.86;

    /* Constructor que recibe el sujeto y lo agrega a su lista de observadores */
    public PesoARGObservador(Subjetc sujeto) {
        this.sujeto = sujeto;
        this.sujeto.agregar(this);
    }

    /* Método que se llama cuando el estado del sujeto cambia */
    @Override
    public void actualizar() {
        /* Calcula y muestra el valor en pesos argentinos */
        System.out.println("ARG: " + (sujeto.getEstado() * valorCambio));
    }
}
