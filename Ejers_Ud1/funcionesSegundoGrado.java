package Ejers_Ud1;

import java.util.Scanner;

public class funcionesSegundoGrado {
    //Ejercicio 12
    //Realiza un programa que resuelva una ecuación de segundo grado grado de tipo ax²+bx+c, recibiendo a,b y c y que devuelva el resultado
    public static void main(String arg[]){
        //Defino las variables y lo pongo para resgistre las respuestas por teclado
        double a,b,c; 
        double resultado; //float no es compatible con el resultado de Math()
        Scanner teclado = new Scanner(System.in);

        //Explico el programa y pido que el usuario introduzca los parametros
        System.out.println("El programa calcula el resultado de la ecuación de segundo grado grado de tipo ax²+bx+c");
        System.out.print("Por favor, introduzca el primer valor: ");
        a = teclado.nextFloat();
        System.out.print("Por favor, introduzca el segundo valor: ");
        b = teclado.nextFloat();
        System.out.print("Por favor, introduzca el tercer valor: ");
        c = teclado.nextFloat();

        //Para sacar el resultado usamos la formula y para las raices cuadrdadas utilizamos el .math()
        resultado = (-b + Math.sqrt((b*b)-4*a*c))/(2*a);
        //En el caso que no se pueda resolver lo indico
        if ( Double.isNaN(resultado)){
            System.out.println("No se puede resolver");
        }else{
        System.out.println("El resultado es: " + resultado);
        }

        teclado.close();
    }
}
