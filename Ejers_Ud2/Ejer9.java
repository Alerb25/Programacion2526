
import java.util.Scanner;

public class Ejer9 {
    public static void main(String[] args) {
        /*
         * Calcular precio final de una entrada de cine
         * base 12€
         * Si es miércoles y el cliente tiene menos de 25 años, descuento del 20%.
         * Si tiene más de 60 años o es estudiante con carnet, descuento del 15%.
         * Si compra 2 o más entradas y es fin de semana, aplica 10% adicional sobre el total.
         * Si es día festivo, no aplica ningún descuento.
         * Solo se aplica el mayor descuento posible, excepto el del “fin de semana + múltiples entradas”, que se suma al principal si aplica.
         * Si el cliente tiene discapacidad acreditada, la entrada es gratuita.
         */

        System.out.println("Programa Precio Final.");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("Usted está comprando una entrada de cine cuyo precio base es 12€, pero, ofrecemos descuentos si cumple con las condiciones requeridas.");
        System.out.println("El dependiente es un poco despistado así que le hará muchas preguntas.");
        System.out.println("");
        System.out.println("--------------------------------");

        //Definimos las variables (como lo dicen en el enunciado)
        int edad, numEntradas;
        String esEstudiante, tieneDiscapacidad;
        String diaSemana, esFestivo;
        float precioUnitario = 12;
        float precioFinal;

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántas entradas quieres?");
        numEntradas = sc.nextInt();
        System.out.println("Por favor, introduce tu edad");
        edad = sc.nextInt();
        sc.nextLine(); 
        System.out.println("¿Hoy es festivo? (Si/No)");
        esFestivo = sc.nextLine();
        System.out.println("¿Es estudiante? (Si/No)");
        esEstudiante = sc.nextLine();
        System.out.println("¿Qué día de la semana es hoy?");
        diaSemana = sc.nextLine();
        System.out.println("¿Tiene discapacidad? (Si/No)");
        tieneDiscapacidad = sc.nextLine();

        // Si tiene discapacidad, entrada gratis
        if (tieneDiscapacidad.equalsIgnoreCase("Si")) {
            System.out.println("La entrada es GRATUITA.");
        } else if (esFestivo.equalsIgnoreCase("Si")) {
            // Si es festivo, no hay descuentos
            precioFinal = precioUnitario * numEntradas;
            System.out.println("El precio total es " + precioFinal + " euros.");
        } else {
            // Calcular el descuento principal (solo el mayor)
            float descuentoPrincipal = 0;

            // Miércoles y menor de 25: 20% descuento
            if (diaSemana.equalsIgnoreCase("Miercoles") && edad < 25) {
                descuentoPrincipal = 0.20f;
            }
            // Mayor de 65 o estudiante: 15% descuento
            else if (edad > 65 || esEstudiante.equalsIgnoreCase("Si")) {
                descuentoPrincipal = 0.15f;
            }

            // Aplicar descuento principal
            precioUnitario = precioUnitario * (1 - descuentoPrincipal);

            // Calcular precio total
            precioFinal = precioUnitario * numEntradas;

            // Si compra 2+ entradas y es fin de semana, 10% adicional sobre el total
            if (numEntradas >= 2 && (diaSemana.equalsIgnoreCase("Sabado") || 
                                      diaSemana.equalsIgnoreCase("Sábado") || 
                                      diaSemana.equalsIgnoreCase("Domingo"))) {
                precioFinal = precioFinal * 0.90f;
            }

            System.out.println("El precio total es " + precioFinal + " euros.");
        }

        sc.close();
    }
}