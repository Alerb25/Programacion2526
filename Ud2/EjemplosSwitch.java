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


        //Se genera aleatoria mente un num entre el 1 y el 7 y se dice que dia de la semana es pero el 6 y 7 son fin de semana
            int dia = (int) (Math.random()*7+1);
            String diaEscrito;
            switch (dia) {
                case 1:
                    diaEscrito = "Lunes";
                    break;
                case 2:
                    diaEscrito = "Martes";
                    break;
                case 3:
                    diaEscrito = "Miercoles";
                    break;
                case 4:
                    diaEscrito = "Jueves";
                    break;
                case 5:
                    diaEscrito = "Viernes";
                    break;
                
                default:
                    diaEscrito = "Fin de Semana";
                    break;
            }

            if ( diaEscrito != "Fin de Semana"){
            System.out.println("Hoy es " + diaEscrito);
            } else {
                System.out.println("Estamos en " + diaEscrito);
            }
        
            teclado.close();
    }
}
