import java.util.Scanner;

public class EjemploTriangulo {
    public static void main(String[] args) {
        /*
         * Leer la base del triángulo 
         */
        int base;
        Scanner sc = new Scanner(System.in);

        System.out.println("La base del triangulo: ");
        base =  sc.nextInt();

        //Dibujamos el triangulo
        for (int i = 0; i<base; i++){
            for (int j = 0; j < i; j++){
                System.out.println("*");
            }
            System.out.println("");
        }

        sc.close();
    }
}
