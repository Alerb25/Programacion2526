package Ud2;

public class CuentaAtras {
    public static void main(String[] args) {
        /*
         * Vamos a hacer un programa que haga cuenta atrás de un cohete
         * Contará desde 10 hasta 1 y después dirá ignicion, cuando sea 3 ademas
         * mostrara
         * el mensaje "preparados", en el dos "listos" y en el uno "rezad mucho"
         */

        int contador = 10;

        while (contador >= 1) {
            System.out.println(contador);
            contador--;

            if (contador == 2) {
                System.out.println("Preparados");
            } else if (contador == 1) {
                System.out.println("Listosss");
            } else if (contador == 0) {
                System.out.println("¡Rezad mucho!");

            }
        }

        //el cero no entra en el bucle por eso va fuera
        System.out.println("Ignnicion");
        
    }
}
