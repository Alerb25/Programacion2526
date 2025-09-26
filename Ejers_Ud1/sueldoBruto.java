package Ejers_Ud1;

import java.util.Scanner;

public class sueldoBruto {
    //EJer 11
    /*Realiza un programa un programa que lea un sueldo bruto y los impuestos 
    * y devuelva un texto del tipo: Cobras XXX pero hacienda se lleva xxx por lo cual te quedan unos miseros xxx 
    */

    public static void main(String[] args) {
        //Definimos las variables
        float sueldo, immpuestos, resultado, diferencia;
        Scanner teclado = new Scanner(System.in);

        //Explicamos al usuario lo que tiene que hacer y pedimos los datos
        System.out.println("El programa funciona de tal manera que usted introduce sus sueldo bruto, y los impuestos que se le aplican, y se le devuelve el resultado");
        System.out.print("Introduzca su sueldo: ");
        sueldo = teclado.nextFloat();
        System.out.print("Intrpduzca los impuestos que se le aplican(de forma numerica): ");
        immpuestos = teclado.nextFloat();

        //Hacemos las operaciones
        resultado = sueldo * immpuestos;
        diferencia = sueldo - resultado;
        System.out.println( "Cobras " + sueldo + "pero hacienda te quita " + diferencia + "por lo cual te quedan unos miseros " + resultado);
        
        teclado.close();
        
    }
}
