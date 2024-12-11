package org.rigo.practice.exercise.array;

import java.util.HashMap;

public class TwoSum {

    public TwoSum(int[] nums, int target) {
    }

    public int[] twoSum(int[] nums, int target) {
        // Crear un mapa para almacenar cada número y su índice correspondiente.
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // Crear un array para almacenar la solución (índices de los números que suman el objetivo).
        int[] solution = new int[2];

        // Recorrer el array de números.
        for (int i = 0; i < nums.length; i++) {
            // Calcular el número que se necesita para alcanzar el objetivo.
            int remainig = target - nums[i];

            // Comprobar si el número necesario ya está en el mapa.
            if (map.containsKey(remainig)) {
                // Si se encuentra el número necesario, almacenar los índices en el array de solución.
                solution[0] = i; // Índice actual.
                solution[1] = map.get(remainig); // Índice del número necesario en el mapa.
            } else {
                // Si no se encuentra, agregar el número actual y su índice al mapa.
                map.put(nums[i], i);
            }
        }

        // Retornar el array con los índices de los números que suman el objetivo.
        return solution;
    }

}
