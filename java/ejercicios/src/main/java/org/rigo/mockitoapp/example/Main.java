package org.rigo.mockitoapp.example;

import java.util.Scanner;
import java.util.Vector;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Vector<Integer> numeros = new Vector<>();

        int i = 0;

        System.out.print("Cuantos numero quiere ingresar? ");
        int ingresados = scanner.nextInt();
        scanner.nextLine();
        while (ingresados > i) {

            System.out.print("ingrese un numero ");
            int numeroIngresado = scanner.nextInt();
            numeros.add(numeroIngresado);
            i++;
        }

        int mayor = numeros.get(0);
        int menor = numeros.get(0);


        scanner.close();
        for (int j = 0; j < numeros.size(); j++) {

            if (numeros.get(j) > mayor) {
                mayor = numeros.get(j);
            }
            if (numeros.get(j) < menor) {
                menor = numeros.get(j);
            }
        }

        System.out.println("Numero mayor: " + mayor);
        System.out.println("Numero menor: " + menor);

    }
}