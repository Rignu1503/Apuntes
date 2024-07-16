package PatronesComportamiento.observer;

import PatronesComportamiento.observer.observer.PesoARGObservador;
import PatronesComportamiento.observer.observer.PesoMXObservador;
import PatronesComportamiento.observer.observer.Subjetc;

public class App {
    public static void main(String[] args) {
        /* Crear el sujeto */
        Subjetc subject = new Subjetc();

        /* Crear y agregar observadores */
        new PesoARGObservador(subject);
        new PesoMXObservador(subject);

        /* Cambiar el estado del sujeto y notificar a los observadores */
        System.out.println("Si desea cambiar 10 dólares obtendrá : ");
        subject.setEstado(10);
        System.out.println("-----------------");
        System.out.println("Si desea cambiar 100 dólares obtendrá : ");
        subject.setEstado(100);
    }
}
