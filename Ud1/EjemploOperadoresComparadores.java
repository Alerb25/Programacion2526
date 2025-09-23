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
        //puedeIrDelante = altura >= 135 || edad >= 10;
        if (altura >= 135 || edad >= 10) {
            
            puedeIrDelante= true;
            System.out.println("La condicion puede ir delante es " + puedeIrDelante);

        } else {
            
            System.out.println("La condicion puede ir delante es " + puedeIrDelante);
        }

        

        teclado.close();

    }

}
