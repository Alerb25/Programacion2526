package Ud2;

import java.util.Scanner;

public class adivinador {
    public static void main(String[] args) {
        /*
         * Programa que genera un numero aleatorio del 1 al 100
         * el usuario tiene que acertar el num, tendra 5 intentos
         * y se le ira indicando si el numero es mayor o menor
         */

         //definir variables
         int numAleatorio = (int) (Math.random()*100+1);
         int intentos = 5;
         int respuesta;
         boolean encontrado=false;

         while (intentos>0 && !encontrado){
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce tu respuesta! : ");
            respuesta = sc.nextInt();

                       
            if (respuesta == numAleatorio){
                System.out.println("Correcto!");
                encontrado = true;
            }else{
                System.out.println("Vueve a intentarlo");
                if (numAleatorio > respuesta){
                    System.out.println("Dame un número más alto");
                }else{
                    System.out.println("Dame un número más bajo");
                }
            }

            intentos --;
            System.out.println("Te quedan " + intentos + " intentos");
          
         }

         if (intentos == 0){
            System.out.println("Te has quedado sin intentos :c");
            System.out.println("El numero era " +numAleatorio);
         }

         
    }
}
