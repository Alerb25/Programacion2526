package Ud1;

import java.util.Scanner;

public class EjemploOperadoresComparadores {

    public static void main(String[] args) {

        boolean puedeIrDelante = false;
        int altura = 0;

        //leer por teclado si se utiliza scanner hay que cerrarlo 
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce la altura del niño:");
        altura =teclado.nextInt();

        puedeIrDelante = altura >=  135;

        System.out.println("La condicion puede ir delante es " + puedeIrDelante);

        teclado.close();

    }

}

