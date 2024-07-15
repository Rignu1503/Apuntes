package PatronesComportamiento.memento.memento;

import java.util.ArrayList;

public class Caretaker {

    private ArrayList<Memento> mementos = new ArrayList<>();

    /* Recibe el objeto que se guarda en originator para agregarlo en una lista y usarlo como punto de restauración */
    public void addMemento(Memento m) {
        mementos.add(m);
    }

    /* Sirve para recuperar el punto de restauración guardado en la lista */
    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}
