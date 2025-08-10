package org.rigo.mockitoapp.example;

public class exercise11 {

    /*
    * Se te da un número entero n. La tarea consiste en determinar
    * si este número es un cuadrado perfecto o no. Un cuadrado
    * perfecto es un número que se puede expresar como el producto de un entero
    * consigo mismo. Por ejemplo, 1 = 1 * 1, 4 = 2 * 2, 9 = 3 * 3, y 16 = 4 * 4 son
    * cuadrados perfectos, pero 2, 3, 5y 6no lo son.
    *
    *Implemente una función isPerfectSquare(int n)que devuelva true si
    *  el número dado nes un cuadrado perfecto o falseen caso contrario.
    * */

    public boolean isPerfectSquare(long n) {

        if (0 > n) {
            return false;
        }
        long square = (long) Math.sqrt(n);

        if ((square * square) == n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        exercise11 ex = new exercise11();
        System.out.println(ex.isPerfectSquare(16)); // true
        System.out.println(ex.isPerfectSquare(14)); // false
        System.out.println(ex.isPerfectSquare(-4)); // false
    }

}
