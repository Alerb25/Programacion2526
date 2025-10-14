package Ud2;

public class contarPares {
    public static void main(String[] args) {
        //generar 20 num aleatorios y verificará si son pares o impares
        //Se mostrará un mensaje del tipo num x es par/impar
        //Despues sacaremos la cantidad de cada tipo y el procentaje


        for ( int i = 1; i<= 20; i++){
             int numAleatorio = (int) (Math.random()*100+1);

             if (numAleatorio%2 == 0){
                System.out.println("el número " + numAleatorio + " es par");

             } else {
                 System.out.println("el número " + numAleatorio + " es impar");
             }
        }

    }
}
