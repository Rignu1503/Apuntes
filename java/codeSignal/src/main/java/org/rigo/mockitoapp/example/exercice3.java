package org.rigo.mockitoapp.example;

public class exercice3 {

    /**
     *
     * Dada una cadena inputString, su tarea consiste en escribir un método que transforme todas
     * las letras minúsculas en mayúsculas y todas las letras mayúsculas en minúsculas. Si el
     * carácter no es una letra, no lo transforme.
     *
     * La transformación debe hacerse sin utilizar ningún método Java incorporado como
     * toLowerCase(), toUpperCase(), o similares en su código.
     *
     * Por ejemplo, para la cadena de entrada «HelLo WoRld 123», la salida debería ser «hELlO wOrLD 123».
     */

    public String transformString(String inputString) {

        String lowerCaseAlp = "abcdefghijklmnopqrstuvwxyz";
        String screamingCaseAlp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean pass = true;

        String output = "";

        for (int i = 0; inputString.length() > i; i++){
            pass = true;
            for(int j = 0; lowerCaseAlp.length() > j; j++){

                if (inputString.charAt(i) == lowerCaseAlp.charAt(j)) {

                    output += screamingCaseAlp.charAt(j);
                    pass = false;
                    break;
                }
                if (inputString.charAt(i) == screamingCaseAlp.charAt(j)) {

                    output += lowerCaseAlp.charAt(j);
                    pass = false;
                    break;
                }

            }
            if (pass) {
                output += inputString.charAt(i);
            }

        }
        return output;
    }
    public static void main(String[] args) {
        exercice3 test = new exercice3();
        System.out.println(test.transformString("Hello World"));
    }
}
