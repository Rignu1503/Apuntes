package org.rigo.mockitoapp.example;

/**
 *Se le da una matriz de números enteros. Su tarea consiste en escribir
 *  una función en Java que devuelva el número de veces que aparece el
 *  elemento más pequeño en la matriz.
 *
 * Tenga en cuenta que en esta tarea no se deben utilizar métodos integrados
 * como Collections.min() o Collections.frequency(). El objetivo es realizar esta
 * tarea iterando manualmente sobre los elementos del array. Intente resolver
 * la tarea realizando un único recorrido por el array.
 */

public class exercise9 {

    public int countMin(int[] numbers) {

        if (numbers.length == 0) return 0;

        int small = numbers[0];
        int repeated = 0;

        for(int i: numbers){
            if (i < small) {
                small = i;
                repeated = 0;

            }if (small == i) {
                repeated++;
            }
        }
        return repeated;
    }

    public static void main(String[] args) {
        exercise9 ex = new exercise9();
        System.out.println(ex.countMin(new int[]{ 2, 3, 1, 1, 4, 5}));
    }
}
