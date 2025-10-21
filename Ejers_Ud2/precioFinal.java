package Ejers_Ud2;

import java.util.Scanner;

public class precioFinal {
    public static void main(String[] args) {
        /*
         * El programa tiene que calcular el precio final de una entrada de cine con las
         * siguientes reglas:
         * precio base 12€
         * si es miercoles y es menor de 25 20% descuento
         * si es mayor de 65 o estudiante con carnet 15% descuento
         * Si compra 2 o más entradas y es fin de semana, aplica 10% adicional sobre el
         * total.
         * Si es día festivo, no aplica ningún descuento
         * Solo se aplica el mayor descuento posible, excepto el del “fin de semana +
         * múltiples entradas”, que se suma al principal si aplica.
         * Si el cliente tiene discapacidad acreditada, la entrada es gratuita.
         * (Debes usar variables como: edad, esEstudiante, esFestivo, diaSemana,
         * numEntradas, tieneDiscapacidad)
         * 
         */

        // Para empezar vamos a explicar lo que hace el programa
        System.out.println("Programa Precio Final.");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("Usted está comprando una entrada de cine cuyo precio base es 12€, pero, ofrecemos descuentos si cumple con las condiciones requeridas.");
        System.out.println("El dependiente es un poco despistado así que le hará muchas preguntas.");
        System.out.println("");
        System.out.println("--------------------------------");

        //Definimos variables
        int edad, numEntradas;
        String esEstudiante,  tieneDiscapacidad;
        String diaSemana, esFestivo;
        float precio = 12;

        //le hacemos todas las preguntas al usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántas entradas quieres?");
        numEntradas= sc.nextInt();
        System.out.println("Por favor, introduce tu edad");
        edad = sc.nextInt();
        System.out.println("¿Hoy es festivo?");
        esFestivo = sc.nextLine();
        System.out.println("¿Es estudiante?");
        esEstudiante = sc.nextLine();
        System.out.println("¿Qué día de la semana es hoy?");
        diaSemana = sc.nextLine();
        System.out.println("¿Tiene discapacidad?");
        tieneDiscapacidad = sc.nextLine();

        //Empezamos con los casos utilizaré tanto el switch como el if para que sea más cómodo
        //si es festivo no se aplica nada así que no se cambia el precio.
        if (esFestivo != "Si"){
            //si se compra mas de una entrada en finde se aplica 10% de descuento pero es acumulable
            if (numEntradas > 1){
                switch (diaSemana) {
                    case "Sábado":
                        //se aplica el 10% de descuento
                        precio = 10.8f;
                        break;
                    case "Domingo":
                        precio = 10.8f;
                        break;
                    default:
                        //no se aplica descuento
                        break;
                }
            }

            //si es miercoles y eres menor de 25 se aplica el 25%
            if (edad < 25 && diaSemana == "Miercoles" || edad < 25 && diaSemana == "Miércoles" ){
                //Se le aplica 25% de descuento
                precio = 9;
                 switch (diaSemana) {
                    case "Sábado":
                        //se aplica el 10% de descuento
                        precio = 8.1f;
                        break;
                    case "Domingo":
                        precio = 8.1f;
                        break;
                    default:
                        //no se aplica descuento
                        break;
                }
                System.out.println("El precio es " + precio + " euros.");
            }
            //Si es mayor de 60 o estudiante tiene 15% descuento
            if (edad > 60 || esEstudiante == "Si"){
                precio = 10.20f;
                switch (diaSemana) {
                    case "Sábado":
                        //se aplica el 10% de descuento
                        precio = 9.18f;
                        break;
                    case "Domingo":
                        precio = 9.18f;
                        break;
                    default:
                        //no se aplica descuento
                        break;
                }
                System.out.println("El precio es " + precio + " euros.");
            }
           
            //si tiene discapacidad es gratis
            if (tieneDiscapacidad == "Si"){
                System.out.println("La entrada es gratis.");
            }
        } else {
            System.out.println("El precio es " + precio + "euros");
        }

    }
}
