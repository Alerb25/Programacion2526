

public class numMayor {
    public static void main(String[] args) {
        /*
         * Programa lee o genera aleatoriamente 3 numeros y sacar por pantalla
         * muestra por pantalla el mayor de los 3
         */

         //PAra utilizar los parametros utilizamos args -> variable = args[0];
         //los parametros siempre serán string si queremos otro formato hay que convertirlo ej: Integer.parseInt(args[0])

         //Definir las variables
         int num1 = (int) (Math.random()*10+1);
         int num2 = (int) (Math.random()*10+1);
         int num3 = (int) (Math.random()*10+1);

         //Las sacamos por pantalla sin ordenar todavia
         System.out.println("Los números que han salido son: " +num1+ ", " +num2+" y "+num3);

         if (num1>=num2 && num1>=num3){
            System.out.println("El mayor es "+ num1);
         } else if (num2 >= num3){
            System.out.println("El mayor es " + num2);
         } else {
            System.out.println("El mayor es " + num3);
        }
        
    
    }
}
