package Ud2;

import java.util.Scanner;

public class EjemplosSwitch {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Se lee por teclado codigo postal y te dice la comunidad autonoma
        int codPostal = 0;
        System.out.println("Introduzca los dos primeros digitos del código postal: ");
        codPostal = teclado.nextInt();

        switch (codPostal) {
            case 28 :
                System.out.println("Madrid");
                break;
            case 8:
                System.out.println("Barcelona");
                break;
            case 51:
                System.out.println("Ceuta");
                break;
            case 11:
                System.out.println("Cadiz");
                break;
            case 52:
                System.out.println("Melilla");
                break;
            case 1:
                System.out.println("Álava");
                break;
                
            default:
                System.out.println("No lo se");
                break;
        }


        teclado.close();
    }
}
