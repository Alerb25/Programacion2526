package Bucles;

import java.util.Scanner;

public class Ejer2 {
    /*
     * Dados mágicos
     * simular tirada de dados, pone cuantos dados quiere tirar y de cuantas caras
     * hay que mostrar las tiradas individuales
     * poner cuando es critico
     * poner cuando la tirada es epica (todos los dados sacan el mismo num)
     */

     public static void main(String[] args) {

    //Explicamos el programa
    System.out.println("Programa Dados Mágicos.");
     System.out.println("--------------------------------");
     System.out.println("");
     System.out.println("Buenas Joven aventurero! Soy el Dungeon Master y tengo una prueba para ti.");
     System.out.println("Voy a ser bueno y voy a dejarte elegir cuantos dados quieres tirar para superar la prueba.");
     System.out.println("");
     System.out.println("--------------------------------");

     //Definimos las variables
     int numDice=0, dfaces=0;
     //le pedimos las tiradas: 
     Scanner sc = new Scanner(System.in);
     System.out.println("¿Cuantos dados vas a sacar?");
     numDice = sc.nextInt();

     System.out.println("¿Cuantas Caras?");
     dfaces = sc.nextInt();

     //Ahora que ya tenemos los dados y las caras podemos calcular las tiradas
     


        
     }
}
