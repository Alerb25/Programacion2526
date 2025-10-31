import java.util.Scanner;

public class EjemploTrianguloTwo {
    public static void main(String[] args) {
        /*
         * Leer la base del triángulo 
         * ahora no queremos un triangulo rectangulo sino un equilatero
         */
        int base;
        Scanner sc = new Scanner(System.in);

        System.out.println("La base del triangulo: ");
        base =  sc.nextInt();

        //Dibujamos el triangulo
        for (int i = 0; i<base; i++){
            for (int j = 0; j < (1+2*i); j++){
                System.out.println("*");
            }
            System.out.println("");
        }

        sc.close();
    }
}
