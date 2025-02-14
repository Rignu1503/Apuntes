package org.rigo.mockitoapp.example;

public class exercise7 {

    /*
    *Se le da una matriz de enteros. Su tarea es escribir una función findMinElement,
    *  que devuelve el número mínimo de la matriz sin utilizar los métodos incorporados
    * de Java como Arrays.stream().min().
    *
    * Si la matriz está vacía, la función debe devolver null.
    *
    * */
    public Integer findMinElement(int[] array) {

        if (array.length == 0) return null;
        Integer min = array[0];

        for (int i: array) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        exercise7 ex = new exercise7();
        System.out.println(ex.findMinElement(new int[]{1, 2, 3, 4, 5}));
    }

}
