import java.util.Scanner;

public class Ejer13 {
    public static void main(String[] args) {
        /*
         * Crear un programa que actúe como conversor de monedas, recibiendo la cantidad, la moneda origen y la destino. 
         * El alumno elegirá tres monedas cualesquiera y podrá convertir entre cualquiera de ellas (pantallazo funcionando)
         */

         System.out.println("Programa Conversor de Monedas.");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("Este programa funciona de tal manera que el usuario introduce una cantidad, la moneda de origen y la moneda a la que se quiere convertir.");
        System.out.println("");
        System.out.println("--------------------------------");

        //Definimos variables
        int valOrigin=0, valDest=0;
        String coinOrigin, coinDest;
        //Definimos las conversiones dado a que solo son 3 monedas


        //pedimos la cantidad, y las dos monedas
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la cantidad: ");
        valOrigin = sc.nextInt();

        System.out.println("Introduzca la moneda Origen (Puede ser Euros, Libras o Dólares): ");
        coinOrigin = sc.nextLine();
        
        System.out.println("Introduzca la moneda a la que lo quiere convertir(Puede ser Euros, Libras o Dólares): ");
        coinDest=sc.nextLine();

        //Empezamos con los casos
        
        


        sc.close();
    }
}
