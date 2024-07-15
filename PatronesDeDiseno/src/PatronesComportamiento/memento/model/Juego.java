package PatronesComportamiento.memento.model;

public class Juego {

    /* Atributos */
    private String nombre;
    private int checkpoint;

    /* Getters y setters */
    public int getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(int checkpoint) {
        this.checkpoint = checkpoint;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* Método toString */
    @Override
    public String toString() {
        return "Juego [nombre=" + nombre + ", checkpoint=" + checkpoint + "]";
    }
}
