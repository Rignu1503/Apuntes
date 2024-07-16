package PatronesComportamiento.observer.observer;

import java.util.ArrayList;
import java.util.List;

public class Subjetc {

    //Aqui vamos a tener el objeto en observacion

    //Tenemos lista de observadores
    private List<Observador> observadores = new ArrayList<>();
    //Atributo para ir cambio el estado
    private int estado;

    //Metodos de accesos
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
        //Cuando el estado sea cambiando notificara a todos los observcadores que esten suscrito a este sujeto
        notificarTodosObservadores();
    }

    //Agregartemos suscriptore a a este sujeto
    public void agregar(Observador observador) {
        observadores.add(observador);
    }

    //Con este metodo rerremos la lista para hacer la operacion ctualizar
    public void notificarTodosObservadores() {
        observadores.forEach(x -> x.actualizar());
    }

}
