package org.rigo.mockitoapp.example;

public class execise9 {

    public int countMin(int[] numbers) {

        if (numbers.length == 0) return 0;

        int small = numbers[0];
        int repeated = 0;

        for(int i: numbers){
            if (i < small) {
                small = i;
            }
        }

        for (int i : numbers) {
            if (small == i) {
                repeated++;
            }
        }

        return repeated;
    }

    public static void main(String[] args) {
        execise9 ex = new execise9();
        System.out.println(ex.countMin(new int[]{ 2, 3, 1, 1, 4, 5}));
    }
}
