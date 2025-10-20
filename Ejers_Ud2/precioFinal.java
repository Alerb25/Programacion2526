package Ejers_Ud2;

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
        System.out.println("");
        System.out.println("--------------------------------");

        //Definimos variables
        int edad, numEntradas;
        boolean esEstudiante, esFestivo, tieneDiscapacidad;
        String diaSemana;

    }
}
