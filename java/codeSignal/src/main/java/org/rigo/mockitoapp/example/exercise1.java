package org.rigo.mockitoapp.example;

import java.util.ArrayList;
import java.util.List;

public class exercise1 {

    /**
     *
     * Write a function that takes a string s, iterates through it, and collects all 0-based positions of vowels in it to a list.
     *
     * Note that you should not use any Java built-in string methods to solve this task.
     *
     * For example, System.out.println(new Solution().solution("Hello WORLD")); should output
     * [1, 4, 7]. Here, 'e' is a vowel, and its position in the string "Hello" is 1. 'o' is also
     * a vowel, and its position is 4. The last vowel is O at position 7.
     */

    public static List<Integer> solution(String s) {

        List<Integer> number = new ArrayList<>();
        String vocales = "AaEeIiOoUu";


        for( int i = 0; s.length() > i; i++){

            for( int j = 0; vocales.length() > j; j++){

                if(s.charAt(i) == vocales.charAt(j)){
                    number.add(i);

                }
            }

        }

        return number;
    }

    public static void main(String[] args) {
        String originalString = "HEllo World";

        List<Integer> result = exercise1.solution(originalString);
        System.out.println(result);

    }
}
