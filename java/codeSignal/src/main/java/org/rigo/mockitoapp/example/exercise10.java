package org.rigo.mockitoapp.example;

/**
 * Se le da una matriz de números enteros. Su tarea es escribir una función
 * Java para encontrar el segundo mayor número entre estos enteros. Si la
 * matriz tiene menos de dos números únicos, devuelve null.
 *
 * No puede utilizar ningún método Java incorporado para ordenar
 * o encontrar máximos (por ejemplo, Arrays.sort, Collections.max).
 * En su lugar, debe implementar la tarea utilizando operaciones
 * básicas con matrices.
 */

public class exercise10 {

    public Integer secondMax(int[] nums) {

        if (nums == null || nums.length < 2) {
            return null;
        }

        Integer max = null;
        Integer secondMax = null;

        for (int num : nums) {
            if (max == null || num > max) {
                // El segundo mayor se convierte en el antiguo mayor
                secondMax = max;
                max = num;
            } else if (num != max && (secondMax == null || num > secondMax)) {
                // Actualiza solo si es distinto del mayor y mayor que el segundo
                secondMax = num;
            }
        }

        return secondMax;
    }

    public static void main(String[] args) {
        exercise10 ex = new exercise10();
        System.out.println(ex.secondMax(new int[]{3, 2, 1}));
    }
}
