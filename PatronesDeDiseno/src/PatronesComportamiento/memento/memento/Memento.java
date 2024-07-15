package PatronesComportamiento.memento.memento;

import PatronesComportamiento.memento.model.Juego;

public class Memento {

    /* Atributo */
    private Juego estado;

    /* Constructor que recibe el estado del juego para guardarlo en el atributo */
    public Memento(Juego estado) {
        this.estado = estado;
    }

    /* Método para poder recuperarlo más adelante */
    public Juego getEstado() {
        return estado;
    }
}
