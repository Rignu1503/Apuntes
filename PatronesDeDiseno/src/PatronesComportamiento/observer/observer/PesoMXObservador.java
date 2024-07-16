package PatronesComportamiento.observer.observer;

/* Clase que representa un observador concreto para el peso mexicano */
public class PesoMXObservador extends Observador {

    /* Valor de cambio de la moneda */
    private double valorCambio = 19.07;

    /* Constructor que recibe el sujeto y lo agrega a su lista de observadores */
    public PesoMXObservador(Subjetc sujeto) {
        this.sujeto = sujeto;
        this.sujeto.agregar(this);
    }

    /* Método que se llama cuando el estado del sujeto cambia */
    @Override
    public void actualizar() {
        /* Calcula y muestra el valor en pesos mexicanos */
        System.out.println("MX: " + (sujeto.getEstado() * valorCambio));
    }
}
