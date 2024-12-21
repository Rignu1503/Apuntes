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

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] solution = new int[2];

        for(int i=0; i< nums.length; i++){

            int remainig = target - nums[i];
            if(map.containsKey(remainig)){
                solution[0] = i;
                solution[1] = map.get(remainig);
            }
            else{
                map.put(nums[i], i);
            }
        }
        return solution;
    }
}