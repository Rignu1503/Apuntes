package PatronesComportamiento.strategy.interfaces;

import PatronesComportamiento.strategy.analisis.AnalisisSimple;

public interface IEstrategia {
     
    void analizar();

    class AntivirusSimple extends AnalisisSimple {
        @Override
        void iniciar() {
            System.out.println("Antivirus Simple - Análisis simple iniciado");
        }

        @Override
        void saltarZip() {
            try {
                System.out.println("Analizando...");
                Thread.sleep(2500);
                System.out.println("No se pudo analizar archivos con extensión '.zip'");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        void detener() {
            System.out.println("Antivirus Simple - Análisis simple finalizado");
        }
    }
}
