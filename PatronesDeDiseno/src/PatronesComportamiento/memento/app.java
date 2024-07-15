package PatronesComportamiento.memento;

import PatronesComportamiento.memento.memento.Caretaker;
import PatronesComportamiento.memento.memento.Originator;
import PatronesComportamiento.memento.model.Juego;

public class app {

    public static void main(String[] args) {
        String nombreJuego = "Crash Bandicoot";

        /* Creamos un nuevo objeto */
        Juego juego = new Juego();

        /* Guardamos el nombre */
        juego.setNombre(nombreJuego);
        /* Guardamos el checkpoint 1 */
        juego.setCheckpoint(1);

        /* Instanciamos lo que nos va a permitir guardar en memento */
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        juego = new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(2);
        originator.setEstado(juego);

        juego = new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(3);
        originator.setEstado(juego);

        caretaker.addMemento(originator.guardar()); /* ESTADO POSICIÓN 0 */

        juego = new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(4);

        originator.setEstado(juego);
        caretaker.addMemento(originator.guardar()); /* ESTADO POSICIÓN 1 */

        juego = new Juego();
        juego.setNombre(nombreJuego);
        juego.setCheckpoint(5);
        originator.setEstado(juego);
        caretaker.addMemento(originator.guardar()); /* ESTADO POSICIÓN 2 */

        originator.setEstado(juego);
        originator.restaurar(caretaker.getMemento(1));

        juego = originator.getEstado();
        System.out.println(juego);
    }
}
