package Bucles;

import java.util.Scanner;

public class Ejer2 {
    public static void main(String[] args) {
        /*
         * Dados mágicos
         * Programa que simule el lanzamiento de dados para un juego de rol
         * el usuario introduce cuantos dados va a tirar y de cuantas caras son cada uno
         * mostrar las tiradas 
         * calcular la suma total de la tirada
         * contar cuantos críticos hay
         * y si hay tiradas épicas (que todos los dados den el mismo numero)
         */

     //Le explicamos el programa al usuario
     System.out.println("Programa Dados Mágicos.");
     System.out.println("--------------------------------");
     System.out.println("");
     System.out.println("Buenas Aventurer@! Soy el Dungeon Master en esta partida.");
     System.out.println("Voy a ser bueno, voy a dejar que elijas los dados que quieras para esta tirada.");
     System.out.println("");
     System.out.println("--------------------------------");

    Scanner sc  = new Scanner(System.in);
    
    //Definimos las variables necesarias
    int numDice=0, faces=0;
    
    System.out.println("¿Cuántos dados?");
    numDice = sc.nextInt();
    
    //Pido por cada dado el numero de caras
    for ( int i = 0 ; i < numDice; i++ ){
        System.out.println("De cuanto es el valor del dado " + (i+1));
        faces = sc.nextInt();

        int diceRoll = (int) (Math.random()*faces+1);
    }


    }
}
