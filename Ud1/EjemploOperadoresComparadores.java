package Ud1;

import java.util.Scanner;

public class EjemploOperadoresComparadores {

    public static void main(String[] args) {

        boolean puedeIrDelante = false;
        int altura = 0, edad = 0; // Tambien se puede definir asi

        // leer por teclado si se utiliza scanner hay que cerrarlo
        Scanner teclado = new Scanner(System.in);

        // lee la altura
        System.out.println("Introduce la altura del niño:");
        altura = teclado.nextInt();

        // lee la edad
        System.out.println("Introduce la edad del niño:");
        edad = teclado.nextInt();

        /*
         * asignamos una condicion a la variable
         * Si la condicion es cierta vale true y sino false
         */
        // puedeIrDelante = altura >= 135 || edad >= 10;
       
        if (altura >= 135 || edad >= 10) {

            puedeIrDelante = true;
            System.out.println("La condicion puede ir delante es " + puedeIrDelante);

        } else {

            System.out.println("La condicion puede ir delante es " + puedeIrDelante);
        }

        /*
         * EJercicio Practico
         * Icaro para poder volar de Creta a Atenas Necesitaba:
         * Pesar menos de 80.5 kg y cumplir una de las dos condiciones
         * Hacer caso a su padre(boolean) O tener mas de rango 5 en google fit (int)
         */

         float peso = 80.5f;
         boolean casoPadre = true;
         int rangoFit = 5;

         // || es OR && es AND
         //Para comparar una var y un valor unico utilizamos == 
         if (peso < 80.5 && (casoPadre == true || rangoFit > 5)){
                System.out.println("Icaro puede volar");

         } else {
            System.out.println("Icaro se cae");
         }

         /*
          * Para volver a por las llaves 
          * Tiene que hacerle caso a su padre Y pesar menos de 90kg 
          * O tener un nivel de google fit mayor de 10
          */

          //Por defecto siempre se hace el AND antes que el OR
          if (casoPadre == true && peso < 90 || rangoFit > 10){
                System.out.println("Puede pasar");
          } else {
            System.out.println("No pasa");
          }
        teclado.close();

    }

}
