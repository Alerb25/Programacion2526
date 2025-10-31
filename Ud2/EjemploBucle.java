

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

    //Leer edades de 100 personas, se lee por pantalla el num de cada persona
    int edad = 0;
    int sumaEdad = 0;
    int i = 1;
   

    while (i < 11){
        //Genero la edad aleatoria
        edad = (int) ((Math.random()*65+17)+1);
        System.out.println("La edad de la persona número "+ i + " es "+ edad);
        i++;
        //para calcular la media de las edades
        sumaEdad = sumaEdad + edad;
    }
    int mediaEdad = sumaEdad / 10;
    System.out.println("La media de edad es: " + mediaEdad);

    //Ejerv2
    //Leer edades de 10 personas, que deben estar entre 18 y 65. 
    //se saca por pantalla si esta jubiladoo si es mayor de edad
    
    while (i < 11){
        //Genero la edad aleatoria
        edad = (int) ((Math.random()*100)+1);
        System.out.println("La edad de la persona número "+ i + " es "+ edad);
        i++;
        
        if (edad < 65){
            System.out.println("Eres mayor de edad");
        }else if (edad > 18) {
            System.out.println("Eres menor de edad");
        } else {
            System.err.println("Estas Jubilado");
        }
    
    }

    }
}
