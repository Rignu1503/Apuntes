package PatronesEstructurales.facade2;

import PatronesEstructurales.facade2.FacadeFile.CasaInteligenteFacade;

public class app {

    public static void main(String[] args) {
        CasaInteligenteFacade casaInteligente = new CasaInteligenteFacade();

        System.out.println("=====MODO DIA=====");
        casaInteligente.activarModoDia();
        System.out.println("=====MODO NOCHE=====");
        casaInteligente.activarModoNoche();
    }
}
