package org.rigo.mockitoapp.example;

public class exercise12 {

    /*
    * Se le da un número entero, 1≤ n ≤ 10 Su tarea es escribir una
    * función nextPrime(n)que tome un entero ncomo entrada y devuelva
    * el número primo más pequeño mayor que n.
    * A continuación se muestran algunos ejemplos:
    * nextPrime(7)debería devolver 11, porque 11 es el siguiente número primo después de 7.
    * nextPrime(13)debería devolver 17, porque 17 es el siguiente número primo después de 13.
    * nextPrime(50)debería devolver 53, porque 53 es el siguiente número primo después de 50.
    * */
    public int nextPrime(int n) {

        int num = n + 1;

        while (!isPrime(num)) {
            num++;
        }
        return num;
    }

    public boolean isPrime(int n){

        int i = 2;

        while (n > i) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        exercise12 ex = new exercise12();
        System.out.println(ex.nextPrime(7));  // 11
        System.out.println(ex.nextPrime(13)); // 17
        System.out.println(ex.nextPrime(50)); // 53
    }
}
