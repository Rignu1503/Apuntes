package org.rigo.mockitoapp.example;

public class Main {
    public static void main(String[] args) {

        /*
         * Crea un método en Java que:
         * 
         * Reciba un String
         * Retorne el mismo String pero invertido
         * 
         */

        System.out.println(invertedMethod("hola"));
        System.out.println(invertedMethod("Como estas"));
        System.out.println(invertedMethod("batman"));

    }

    public static String invertedMethod(String string) {

        StringBuilder textInverted = new StringBuilder();
        if (string == null) {
            return null;
        } else {

            for (int i = string.length() - 1; i >= 0; i--) {

                textInverted.append(string.charAt(i));

            }
        }

        return textInverted.toString();
    }

}