import java.util.Scanner;

public class Ejer13 {
    public static void main(String[] args) {
        /*
         * Crear un programa conversor de monedas
         * se recibe la cantidad, la moneda origen y la moneda destino
         */

         //Le explicamos al usuario el programa
        System.out.println("Programa Conversor de Monedas."); 
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("El programa es un convertidor de monedas, podrá escoger entre Euros, Libras y Dólares.");
        System.out.println("Usted solo deberá introducir la cantidad, la moneda original y a la que quiere convertir.");
        System.out.println("");
        System.out.println("--------------------------------");

        //Ahora definimos las variables 
        double  coinDest=0, value=0;
        String nameOrigin, nameDest;
        
        Scanner sc = new Scanner(System.in);

        //Pedimos las variables al usuario
        System.out.println("Introduzca la cantidad: ");
        value = sc.nextInt();

        System.out.println("Introduzca la moneda origen: ");
        nameOrigin = sc.nextLine();
        

        System.out.println("Introduzca la moneda a convertir: ");
        nameDest= sc.nextLine();

        System.out.println("Claculando ....");
        //Empezamos con las conversiones  
        if ( nameOrigin.equalsIgnoreCase("euros") ){
            if (nameDest.equalsIgnoreCase("libras")){
                coinDest = value * 1.14;

            }else if (nameDest.equalsIgnoreCase("dolares")){
                coinDest = value * 1.16;
            }
        } 

        if ( nameOrigin.equalsIgnoreCase("libras") ){
            if (nameDest.equalsIgnoreCase("euros")){
                coinDest = value * 0.87;

            }else if (nameDest.equalsIgnoreCase("dolares")){
                coinDest = value * 1.33;
            }
        }
        
        if ( nameOrigin.equalsIgnoreCase("dolares") ){
            if (nameDest.equalsIgnoreCase("libras")){
                coinDest = value * 0.75;

            }else if (nameDest.equalsIgnoreCase("euros")){
                coinDest = value * 0.86;
            }
        } 
        System.out.println("");
        System.out.println("El valor de " + value +" en " +nameOrigin+ " pasandolos a "+ nameDest + " es de " + coinDest  );

        sc.close();

    }
}
