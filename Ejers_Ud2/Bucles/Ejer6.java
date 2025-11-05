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
        String answer= "", infoString = "";
        int infoInt = 0;



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
                    String names[] = new String[0];
                    String newNames [] = new String[ names.length +1];
                    String genres[] = new String[0];
                    String newGenres[] = new String[ genres.length +1];
                    int seasons[] = new int[0];
                    int newSeasons [] = new int[ seasons.length +1 ];
                    int score[] = new int[0];
                    int newScore[] = new int[ score.length +1];
                    int year[] = new int[0];
                    int newYear[] = new int[ year.length +1];

                    //Se lo pedimos al usuario
                    System.out.println("Introduzca el nombre de la serie: ");
                    infoString = sc.nextLine();
                    //copiar datos metidos en names a newNames para poder ñadir mas datos
                    for (int i = 0; i < names.length ; i++){
                        newNames[i] = names [i];
                    }

                    //añadir nuevos datos en newNAes
                    newNames[names.length] = infoString;

                    //convertimos newnames a names
                    names = newNames;

                    //Repetir con todas las preguntas
                    //Genero de las series
                    System.out.println("Introduzca el género de la serie: ");
                    infoString = sc.nextLine();
                    //copiar datos metidos en names a newNames para poder ñadir mas datos
                    for (int i = 0; i < genres.length ; i++){
                        newGenres[i] = genres [i];
                    }

                    //añadir nuevos datos en newNAes
                    newGenres[genres.length] = infoString;

                    //convertimos newnames a names
                    genres = newGenres;
                    
                    //temporadas
                     System.out.println("Introduzca el numero de temporada de la serie: ");
                    infoString = sc.nextLine();
                    //copiar datos metidos en names a newNames para poder ñadir mas datos
                    for (int i = 0; i < seasons.length ; i++){
                        newSeasons[i] = seasons[i];
                    }

                    //añadir nuevos datos en newNAes
                    newSeasons[seasons.length] = infoInt;

                    //convertimos newnames a names
                    seasons = newSeasons;

                    break;
            
                default:
                System.err.println("Opcion no valida");
                    break;
            }
        }while(!answer.equalsIgnoreCase("Salir"));



    }

}
