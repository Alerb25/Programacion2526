package Bucles;

import java.util.Scanner;

public class Ejer3 {
    /*
     * Una pizzeria quiere repartir N pizzas entre sus empleados de forma justa
     * Lee el numero de pizzas
     * el numero de empleados
     * Se da Cuantas pizzas reciben cada empleado y si sobran
     */

    public static void main(String[] args) {
        //Le explicamos el programa al usuario
     System.out.println("Programa Repartidor de Pizza.");
     System.out.println("--------------------------------");
     System.out.println("");
     System.out.println("En esta pizzeria somos generosos y nos gusta compartir, queremos que todos nuestros empleados tengan pizza por partes iguales");
     System.out.println("Este programa se va a dedicar a dividir las pizzas que hay entre los empleados");
     System.out.println("");
     System.out.println("--------------------------------"); 
    
     //Definimos las variables
        Scanner sc = new Scanner(System.in);
     int employee = 0, pizzas=0, div=0;

     System.out.println("¿Cuantos empleados hay?");
     employee = sc.nextInt();
     System.out.println("¿Cuantas pizzas hay?");
     pizzas = sc.nextInt();

     if (pizzas > employee){
        div = pizzas / employee;
        
     }

    }

}
