package PatronesComportamiento.observer.observer;

public abstract class Observador {

    //Tenemos como atributo el objeto
    protected Subjetc sujeto;

    //Tenemos la funcion actualizar para que el subjed cambie su estado
    public abstract void actualizar();

}