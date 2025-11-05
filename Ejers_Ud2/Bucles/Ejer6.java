package Bucles;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejer6 {
    public static void main(String[] args) {
        /*
         * Sistema de recomendacion de Netflix
         * Crear programa que gestione listas de series con los siguientes datos
         * - Nombre, genero, temporadas, puntuacion, año (se lee por teclado)
         * Encontrar la serie mas larga
         * calcular el promedio de puntuacion por género
         * Crear maraton perrfecto seleccionar series que sumen exactamente X horas
         * mostrar joyas ocultas (puntuacion sea > 8 pero con menos de 3 temporadas)
         */

        // Le explicamos el programa al usuario
        System.out.println("Programa Sistema de recomendación.");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("En este programa usted deberá añadir las series que quiera, respondiendo a las preguntas, se le mostrará un menu dode tendrá diferentes opciones.");
        System.out.println("");
        System.out.println("--------------------------------");

        //Definimos variables
        Scanner sc = new Scanner(System.in);
        String answer= "", info = "";



        do {
            System.out.println("");
            System.out.println("1. Añadir serie.");
            System.out.println("2. Encontrar la serie más larga.");
            System.out.println("3. Calclar promedio por género.");
            System.out.println("4. Crear Maraton perfecto.");
            System.out.println("5. Mostrar Joyas Ocultas");
            System.out.println("Salir");
            System.out.println("");
            answer = sc.nextLine();
            //Creamos el menu de inicio con switch
            switch (answer) {
                case "1":
                    //Haremos varios Arrays para poder guardar varios datos en un mismo sitio
                    ArrayList<String> names = new ArrayList<>();
                    ArrayList<String>  genres = new ArrayList<>();
                    int seasons[], score[], year[];

                    //Se lo pedimos al usuario
                    System.out.println("Introduzca el nombre de la serie: ");
                    info = sc.nextLine();
                    names.add(info);

                     
                    break;
            
                default:
                System.err.println("Opcion no valida");
                    break;
            }
        }while(!answer.equalsIgnoreCase("Salir"));



    }

}
