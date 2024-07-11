package PatronesCreacionales.prototype;

import PatronesCreacionales.prototype.service.CuentaAhorroImplement;

public class app {

    public static void main(String[] args) {

        CuentaAhorroImplement cuentaAhorro = new CuentaAhorroImplement();
        cuentaAhorro.setMonto(200);

        CuentaAhorroImplement cuentaAhorro2 = new CuentaAhorroImplement();

        CuentaAhorroImplement cuentaClonada = (CuentaAhorroImplement) cuentaAhorro.clonar();

        System.out.println(cuentaAhorro);
        System.out.println(cuentaAhorro2);
        System.out.println(cuentaClonada);

		/*if (cuentaClonada != null) {
			System.out.println(cuentaClonada);
		}

        //Da false porque apuntan a diferentes espacios de memoria 
		System.out.println(cuentaClonada == cuentaAhorro);*/

    }
}
