package PatronesComportamiento.memento.memento;

import PatronesComportamiento.memento.model.Juego;

public class Originator {

    /* Según la teoría, esta clase sabe cómo guardar el objeto */

    /* Atributo juego */
    private Juego estado;

    /* Get y set para poder guardar el estado del juego */
    public void setEstado(Juego estado) {
        this.estado = estado;
    }

    public Juego getEstado() {
        return estado;
    }

    /* Cuando se llame al método guardar, se creará una nueva instancia del objeto Memento con el estado que queremos guardar */
    public Memento guardar() {
        return new Memento(estado);
    }

    /* Método para restaurar el estado del juego desde un Memento */
    public void restaurar(Memento m) {
        this.estado = m.getEstado();
    }
}
