package Bucles;

import java.util.Scanner;

public class Ejer8 {
    public static void main(String[] args) {
        /*
         * Escribir un algoritmo que lea dos numeros n y d
         * Realizara la suma de todos los numeros desde 1 hasta n realizando saltos de posiciones
         * el objetivo es que la suma de como resultado d
         */

         //explicamos el programa al usuario
        System.out.println("Programa Algoritmo Suma");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("Usted deberá introducir dos números (n y d). ");
        System.out.println("");
        System.out.println("--------------------------------");
        

        //Definimos las variables
        int d = 0; int n = 0; 
        int add = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca n: ");
        n = sc.nextInt();
        System.out.println("Introduzca d: ");
        d = sc.nextInt();
        //queremos que se sumen todos los numeros que hay desde el 1 hasta n
        //Pero si el resultado es mayor que d se salte

        for (int i = d; i<n ; i=i+d){
            add += i;
            System.out.print(i);
            if (i<(n-d)){
                System.out.print("+");
            }
            
        }  
          System.out.print(" = " +add);
    }
}
