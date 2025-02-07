package org.rigo.mockitoapp.example;

public class exercise5 {

    /*
    *Se le da una cadena s. Su tarea consiste en escribir una función que
    *  devuelva una cadena en la que se intercambien todos los pares de caracteres
    *  adyacentes de la cadena original. Si la cadena tiene una longitud impar, deje el último carácter como está.
    *
    * En esta tarea no está permitido utilizar funciones incorporadas en Java como reverse() o String.join(),
    * debes implementar la solución sin utilizarlas.
    *
    * Por ejemplo, si te dan la cadena «abcdef», tu función debe devolver «badcfe». Si la cadena es «hello»,
    * tu función debería devolver «ehllo».
    *
    *
    * */

    public String swapPairs(String s) {
        // TODO: implement the solution here
        String output = "";

        for(int i = 1; s.length() > i; i += 2){

            output += s.charAt(i);
            output += s.charAt(i - 1);

        }
        if (s.length() % 2 != 0 ) {
            output += s.charAt(s.length() -1);

        }

        return output;
    }

    public static void main(String[] args) {
        exercise5 ex = new exercise5();
        System.out.println(ex.swapPairs("hello"));
    }
}
