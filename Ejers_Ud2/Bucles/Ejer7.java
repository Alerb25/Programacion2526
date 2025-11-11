package Bucles;

import java.util.Scanner;

public class Ejer7 {
    public static void main(String[] args) {
            /*
     * Escribir un programa que lea un numero y diga todos sus divisores impares
     */

     //explicar el programa al ususario
        System.out.println("Programa Divisores Impares");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("Usted deberá introducir un número y el programa le dirá todos sus divisores impares. ");
        System.out.println("");
        System.out.println("--------------------------------");
        
        //Definir variables
        Scanner sc = new Scanner(System.in);
        int answer = 0; int result = 0; 
        

        System.out.println("Introduzca el número: ");
        answer=sc.nextInt();
        //para que un numero sea divisor de otro el resto debe dar 0
        System.out.println("Los divisores de " +answer+ " son: ");
        for (int i =1; i <= answer; i++){
            if ( i%2 != 0){
                if (answer%i == 0){
                    System.out.println(i);
                }
            }
        }
       
    }
    
}
