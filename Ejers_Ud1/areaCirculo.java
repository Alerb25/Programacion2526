package Ejers_Ud1;

import java.util.Scanner;

public class areaCirculo {
    
    public static void main(String[] args) {
        // Pide calcular el area de un circulo leyendo por teclado los valores
        //Defino las variables sabiendo que el area es pi por el radio al cuadrado
        float radio;
        float area;
        Scanner teclado = new Scanner(System.in);

        //Lee el radio
        System.out.println("Introduzca el radio del circulo:");
        radio= teclado.nextFloat();

        //Calculamos el area
        area = 3.14f *(radio*radio);
        System.out.println("El area es: " + area + "cm2");
        teclado.close();
    }
}
