

import java.util.Scanner;

public class Ejer10 {
    public static void main(String[] args) {
        /*
         * El programa lee 2 numeros y un resultado y muestra la operación utilizada
         * pueden ser suma, resta, multiplicación, división, resto, raíz cuadrada,
         * potencia de 2 o indefinida.
         * En caso de que no sea ninguna de las anteriores deberá de mostrar un mensaje
         * de que es una operación indefinida.
         * Se mostrará por pantalla el mensaje una sóla vez
         */

        // Definimos las variables
        Scanner sc = new Scanner(System.in);
        double operator1 = 0, operator2 = 0, result = 0, add = 0, subs = 0, mult = 0, div = 0, sqrt1 = 0, sqrt2 = 0,
                power1 = 0, power2 = 0, remain = 0;

        // Le explicamos al usuario el programa
        System.out.println("Programa Calculadora.");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("El programa leerá dos números y un resultado.");
        System.out.println(
                "Las operaciones pueden ser suma, resta, multiplicación, división, resto, raíz cuadrada, potencia de 2 o indefinida.");
        System.out.println("");
        System.out.println("--------------------------------");

        // Le pedimos al usuario los numeros y el resultado
        System.out.println("Introduzca el primer operador:");
        operator1 = sc.nextDouble();
        System.out.println("Introduzca el segundo operador:");
        operator2 = sc.nextDouble();
        System.out.println("Introduzca el resultado:");
        result = sc.nextDouble();

        // Hacemos las operaciones para que despues podamos compararlas
        add = operator1 + operator2;
        subs = operator1 - operator2;
        mult = operator1 * operator2;
        div = operator1 / operator2;
        sqrt1 = Math.sqrt(operator1);
        sqrt2 = Math.sqrt(operator2);

        // hacemos las comparaciones para saber que operacion es
        if (result == add) {
            System.out.println("La operación es una suma:");
            System.out.println(operator1 + " + " + operator2 + " = " + result);
        } else if (result == subs) {
            System.out.println("La operación es una resta:");
            System.out.println(operator1 + " - " + operator2 + " = " + result);
        } else if (result == mult) {
            System.out.println("La operación es una multiplicación:");
            System.out.println(operator1 + " * " + operator2 + " = " + result);
        } else if (result == div) {
            System.out.println("La operación es una división:");
            System.out.println(operator1 + " / " + operator2 + " = " + result);
        } else if (result == sqrt1) {
            System.out.println("La operación es la raiz cuadrada del primer número:");
        } else if (result == sqrt2) {
            System.out.println("La operación es la raiz cuadrada del segundo número:");
        } else if (result == power1) {
            System.out.println("La operación es la potencia de 2 del primer número:");
            System.out.println(operator1 + "^2 = " + result);
        } else if (result == power2) {
            System.out.println("La operación es la potencia de 2 del segundo número:");
            System.out.println(operator2 + "^2 = " + result);
        } else if (result == remain) {
            System.out.println("La operación es el resto:");
            System.out.println(operator1 + " % " + operator2 + " = " + result);
        } else {
            System.out.println("Operación indefinida");
        }

        sc.close();
    }
}
