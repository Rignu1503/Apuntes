package PatronesCreacionales.prototype.service;

import PatronesCreacionales.prototype.interfaces.Icuenta;

public class CuentaAhorroImplement implements Icuenta {

    private String tipo;
    private double monto;

    //Declaramos constructor y quemamos el tipo de cuenta
    public CuentaAhorroImplement() {
        tipo = "AHORRO";
    }
    @Override
    public Icuenta clonar() {

        //Declaramos la cuenta como nula
        CuentaAhorroImplement cuenta = null;

        try {
            /*
             El método clone devuelve un objeto de tipo Object, que es el tipo de retorno general para
             cualquier objeto clonado. Para poder asignar este objeto clonado a una variable de tipo CuentaAHImpl,
             se necesita un casting explícito.
            */
            cuenta = (CuentaAhorroImplement) clone();

        } catch (CloneNotSupportedException e) {
            //Si no se puede imprima el error
            e.printStackTrace();
        }
        //Retornamos la cuenta clonada
        return cuenta;
    }

    @Override
    public String toString() {
        return "CuentaAHImpl [tipo=" + tipo + ", monto=" + monto + "]";
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

}
