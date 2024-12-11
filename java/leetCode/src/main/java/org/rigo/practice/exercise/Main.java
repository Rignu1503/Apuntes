package org.rigo.practice.exercise;


import org.rigo.practice.exercise.array.TwoSum;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear un array de prueba y un target para el test
        int[] nums = {2, 7, 11, 15};
        int target = 9;


        TwoSum twoSum = new TwoSum(nums, target);

        // Llamar al método twoSum
        int[] result = twoSum.twoSum(nums, target);

        // Mostrar el resultado
        System.out.println("Índices: " + Arrays.toString(result));

    }
}