

public class Sumatorios10 {
    public static void main(String[] args) {
        /*
         * Sacar por pantalla el sumatorio de todos los num del 1 al 10
         * siguiendo este patron:
         * suma hasta 1 = 1
         * suma hasta 2 = 1+2 = 3
         * suma hasta 3 = 1+2+3 = 6
         * hasta 10
         */

        // Aqui sin utilizar el for
        // while (i < 11){
        // suma += i;
        // System.out.println( "Hasta " + i + " = " + suma);
        // i ++;
        // }

        // Esta fue la solución propuesta por pablo utilizando el for
        // for(int num=0; num<11; i++ ){ //definicion de var; motivo de parada;
        // condicion
        // System.out.println("La suma de " + num + ": ");
        // //para cada valor de num realizamos la suma desde 1 hasta num
        // for (int j=2; j<=num; j++){
        // //vamos sumando en la var suma los valores de j que van desde 1 hasta el num
        // actual

        // if (j !=num) System.out.println("+");
        // System.out.print(j);
        // suma += j;
        // }

        // }

        int total = 0;

        for (int i = 1; i < 11; i++) {
            total += i;
            System.out.print("La suma hasta " + i + " : ");

            for (int j = 1; j <= i; j++) {
                System.out.print(j);

                if (j < i) {
                    System.out.print(" + ");
                }

            }

            System.out.println(" = " + total);

        }

    }
}
