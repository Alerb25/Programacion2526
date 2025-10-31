import java.util.Scanner;

public class EjemploOpcionCorrecta {
    public static void main(String[] args) {
        /*
         * Se realizara un men para preguntar cual es el destino final de la raza humana
         * tendra 4 opciones
         * si el usuario elige la op correcta mostrara un mensaje tipo has salvado el mundo
         * sino se pondra un mensaje tipo cataclismo zombie vuelve a elegir 
         * pista usar switch, el usuario responde con una letra 
         */

         String op;
         Scanner sc = new Scanner(System.in);
         
         boolean correct = false;

         do{
            System.out.println("A. salvar el mundo");
            System.out.println("B. No salvar el mundo");
            System.out.println("C. Apocalipsis Zombie");
            System.out.println("D. Muerte y destruccion");
            System.out.println("Dame una respuesta: ");
            op = sc.nextLine();
                   
            switch (op) {
                case "a":
                case "A":
                System.out.println("Bien! Has salvado el mundo");
                correct = true;
                break;
                case "B":
                case "b":
                    System.out.println("No has salvado el mundo :c"); 
                    break;
                case "C":
                case "c":
                    System.out.println("Hay un apocalipsis Zombie :c");
                break;

                case "D":
                case "d":
                System.out.println("¿Porque eligirias eso? :/");
                break;
            
                default:
                    System.err.println("No deberias ver esto");
                    break;
                    
            }
           
         }while ( correct == false);
        
               
         
    }
}
