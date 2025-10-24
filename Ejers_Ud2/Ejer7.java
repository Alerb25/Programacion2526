

import java.util.Scanner;

public class Ejer7 {
   public static void main(String[] args) {
    /*
     * EL código pide que se lean 5 numeros enteros (int)
     * Se muestran el num mayor y el menor
     * luego de los tres sobrantes decir si son pares y mayores de 10 (utilizar el &&)
     */

     //Vamos a hacer un syso explicando como funciona el programa para el usuario
     System.out.println("Programa Mayor, Menor & co.");
     System.out.println("--------------------------------");
     System.out.println("");
     System.out.println("Deberá introducir 5 números enteros, el programa dirá el mayor, el menor y con los otros tres se mostrarán cuantos son pares y mayores de 10");
     System.out.println("");
     System.out.println("--------------------------------");

     //Definir variables
     Scanner sc = new Scanner(System.in);
     System.out.println("Introduzca el primer número: ");
     int number1 = sc.nextInt();
     System.out.println("Introduzca el segundo número:");
     int number2 = sc.nextInt();
     System.out.println("Introduzca el tercer número: ");
     int number3 = sc.nextInt();
     System.out.println("Introduzca el cuarto número: ");
     int number4 = sc.nextInt();
     System.out.println("Introduzca el quinto número: ");
     int number5 = sc.nextInt();
     String error1 = "Error de Sintaxis";
     int even = 0;
     int gt10 = 0; //acortacion de greater than 10
      
     //Sanear respuestas
     if (number1 < 0){
         System.out.println("El valor " +number1+ " no es válido.");
         System.err.println(error1);
      }else if (number2 < 0){
         System.out.println("El valor " +number2+ " no es válido.");
         System.err.println(error1);
      }else if (number3 < 0){
         System.out.println("El valor " +number3+ " no es válido.");
         System.err.println(error1);
      }else if (number4 < 0){
         System.out.println("El valor " +number4+ " no es válido.");
         System.err.println(error1);
      }else if (number5 < 0){
         System.out.println("El valor " +number5+ " no es válido.");
         System.err.println(error1);
      }else{
         
         //Comparamos todos los numeros para saber cual es el numero mayor y cual es el menor
         int min = Math.min(Math.min(Math.min(Math.min(number1, number2), number3), number4), number5);
         int max = Math.max(Math.max(Math.max(Math.max(number1, number2), number3), number4), number5);

         System.out.println("--------------------------------");
         System.out.println("El número mayor es: " +max);
         System.out.println("El número menor es: " +min);

         //Ahora con los otros tres tenemos que saber si son pares y mayores de 10
         if(number1 != min && number1!= max ) {
            if (number1%2 == 0 )even++;
            
            if (number1 > 10)gt10++;
            
         }
         if(number2 != min && number2!= max) {
            if ( number2%2 == 0)even++;
            
            if ( number2 > 10)gt10++;
         }
        
         if(number3 != min && number3!= max ) {
            if ( number3%2 == 0 )even++;
            
            if ( number3 > 10)gt10++;
         }
         if(number4 != min && number4!= max ) {
            if ( number4%2 == 0 )even++;
            
            if ( number4 > 10)gt10++;
         }
         if(number5 != min && number5!= max ) {
            if ( number5%2 == 0 )even++;
            
            if ( number5 > 10)gt10++;
         }

      
         System.out.println("Hay " + even+ " números pares.");
         System.out.println("Hay " +gt10+ " números mayores de 10.");
      } 

}

}
