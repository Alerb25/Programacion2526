package Ud1;

public class EjemploAleatorios {
    public static void main(String[] args) {
        /*
         * PAra generar un num aleatorio samos el math.random 
         * eso genera un num aleatorio entre 0 y 1 tipo float
         * para que este en el rango que queramos lo multiplicamos por el max
         */

        int edad = (int) (Math.random()*25)+1; //el +1 es para que empiece en 1 y no en 0
        int edad2 = 18 + (int) (Math.random()*8); // para que sea entre 18 y 25
        String nivelEdducativo = (edad > 16 ? "Bach" : "ESO"); //esto es una operacion ternaria, es decir, es como si fuera un if pero en una linea, el ? marca el final de la condicion y el : el else

        System.out.println("La edad ha salido: " + edad);
        System.out.println("Estas en " + nivelEdducativo);
        System.out.println("Edad interrail : " + edad2);
    }
}
