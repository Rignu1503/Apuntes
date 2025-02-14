package org.rigo.mockitoapp.example;

import java.util.Arrays;

public class exercise8 {

    /**
     * Se le da una matriz de enteros. Su tarea es devolver el recuento de
     * enteros pares e impares en la matriz dada sin utilizar ningún método Java incorporado.
     *
     * Su función debe devolver una matriz en el formato {even_count, odd_count},
     * donde even_count representa el número de enteros pares y odd_count representa
     * el número de enteros impares en la matriz proporcionada.
     */

    public int[] solution(int[] nums) {

        int even = 0;
        int odd = 0;

        for (int i : nums) {
            if (i % 2 == 0) {
                even += 1;
            }else{
                odd += 1;
            }
        }
        int[] number = {even, odd};

        return number;
    }

    public static void main(String[] args) {
        exercise8 ex = new exercise8();
        System.out.println(Arrays.toString(ex.solution(new int[]{1, 2, 3, 4, 5})));
    }
}
