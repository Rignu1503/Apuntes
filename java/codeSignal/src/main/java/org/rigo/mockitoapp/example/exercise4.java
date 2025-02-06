package org.rigo.mockitoapp.example;

public class exercise4 {
    /**
     *
     * Dada una cadena inputString, devuelve una nueva cadena en la que todas
     * las apariciones del carácter c1 en la cadena original se sustituyen por c2.
     * En Java no se puede utilizar ningún método o función de cadena incorporado, como replace().
     */
    public String replaceCharacter(String inputString, char c1, char c2) {

        String output = "";
        boolean pass = true;

        for(int i = 0; inputString.length() > i; i++){
            pass = true;
            if (inputString.charAt(i) == c1) {
                output += c2;
                pass = false;
            }
            if (pass) {
                output += inputString.charAt(i);
            }

        }
        System.out.println(output);

        return output;
    }

    public static void main(String[] args) {
        exercise4 ex = new exercise4();
        System.out.println(ex.replaceCharacter("jovo", 'o', 'a'));
    }
}
