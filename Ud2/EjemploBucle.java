package Ud2;

public class EjemploBucle {
     public static void main(String[] args) {
     /* 
        int dado=10;
    while (dado<25) {
        System.out.println("Una tirada pasable, has sacado: " + dado);
        dado++;
    }
    */

    int num = (int) (Math.random()*10+1);
    int bucle = 0;
    while (bucle < 11 ){
        System.out.println( num + " * " +bucle+ " = " + (num *bucle));
        bucle++;
    }
    }
}
