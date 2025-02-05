package org.rigo.mockitoapp.example;

public class stringReverse {

    public String reverseString(String originalString){

        String reversedString = "";

        for (int i = originalString.length() - 1; i >= 0; i--) {
            reversedString = reversedString + originalString.charAt(i);
            System.out.println(reversedString);
        }

        return reversedString;
    }

    public static void main(String[] args) {

        stringReverse stringReverse = new stringReverse();
        String originalString = "Hello World";

        String result = stringReverse.reverseString(originalString);
    }
}
