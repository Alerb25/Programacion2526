package Ud1;

public class EjemploOperadores {

    public static void main(String[] args) {

        // Valores de ejemplo
        int edadHijo = 9;
        int edadPadre = 37;

        // operaciones básicas
        int sumaEdades = 0;
        sumaEdades = edadHijo + edadPadre;
        int diferenciaEdades = edadPadre - edadHijo;
        int media = sumaEdades / 2;
        int dobleHijo = edadHijo * 2;

        /*
         * El operador % es el resto de ka duvusuón entera,
         * en este caso 33/5 son y sobra 3, es decir, el resto son 3
         */
        int resto = 33 % 5;

        // Imprimiendo en la terminal
        System.out.println("La suma de las edades es: " + sumaEdades);
        System.out.println("La diferencia de edad es: " + diferenciaEdades);
        System.out.println("La media de las edades es: " + media);
        System.out.println("El doble de la edad del Hijo es: " + dobleHijo);

        /*
         * La siguientes operaciones son equivalentes:
         * hace que se le sume lo que haya en la parte derecha
         */

        edadHijo = edadHijo + 10;
        edadHijo += 10;

        // cuando los ++ se ponen a la izq pone la edad y demues le suma 1
        System.out.println("Edad de Padre: " + edadPadre++);
        // si se pone a la derecha se suma y depues se muestra por pantalla
        System.out.println("Edad de Padre: " + ++edadPadre);

    }

}
