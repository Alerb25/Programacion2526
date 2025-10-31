

import java.util.Scanner;

public class sieteYMedia {
    public static void main(String[] args) {
        /*
         * Simulara el juego de las 7 y 1/2
         * el jugador sacara cartas hasta que el jugador diga "para"
         * si se pasa de 7 y media pierde
         * se suman las cartas 
         * 
         * Si el jugador no pierde pasa a jugar el programa que funciona igual
         * la banca siempre querra mas cartas  si su suma es menor de 5
         * si una carta es mayor de 7 es 1/2
         */

         double cartasJ = (double) (Math.random()*10+1), cartasB = (double) (Math.random()*10+1) , sumaJ = 0, sumaB = 0;
         boolean pierde = false;
         String parar; 
         Scanner sc = new Scanner(System.in);

         while (pierde == false){
            parar = sc.nextLine();
                if (parar != "Para"){
                    sumaJ += cartasJ;
                   
                }
            }
         }

    }

