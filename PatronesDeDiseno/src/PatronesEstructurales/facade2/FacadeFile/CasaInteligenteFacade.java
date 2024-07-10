package PatronesEstructurales.facade2.FacadeFile;

import PatronesEstructurales.facade2.hogar.Calefaccion;
import PatronesEstructurales.facade2.hogar.Luces;
import PatronesEstructurales.facade2.hogar.Seguridad;

public class CasaInteligenteFacade {

    private Luces luces;
    private Calefaccion calefaccion;
    private Seguridad seguridad;

    public CasaInteligenteFacade() {
        this.luces = new Luces();
        this.calefaccion = new Calefaccion();
        this.seguridad = new Seguridad();
    }

    public void activarModoDia() {
        luces.encender();
        calefaccion.apagar();
        seguridad.desactivar();
    }

    public void activarModoNoche() {
        luces.apagar();
        calefaccion.encender();
        seguridad.activar();
    }
}
