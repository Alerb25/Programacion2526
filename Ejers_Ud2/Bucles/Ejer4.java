package Bucles;

import java.util.Scanner;

public class Ejer4 {
    public static void main(String[] args) {
        // Tragaperras
        /*
         * simulador de tragaperras con 3 rodillos
         * mostrar 🍒(1), 🍋(2), 🔔(3), ⭐(4), 💎(5), 7️⃣(7).
         * El jugador tiene 100 monedas
         * cada tirada cuesta 5 monedas
         * Premios: 3 iguales = valor×10 monedas, 2 iguales = valor×2 monedas
         * Después de cada tirada, debe de mostrar al jugador el resultado y si ha
         * ganado algo,
         * también el dinero restante que le queda. Le preguntará si quiere continuar.
         * el juego continúa hasta que el jugador se quede sin monedas o escriba "salir"
         */

        // explicamos el codigo
        System.out.println("Programa Tragaperras.");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println(
                "Igual que una máquina tragaperras vamos a ver como ruedan los rodillos y a ver si hay suerte");
        System.out.println("Usted empieza con 100 monedas y cada tirada cuesta 5 monedas");
        System.out.println("");
        System.out.println("--------------------------------");

        // definimos variables
        int money = 100, premio = 0;
        String answer;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("¿Quiere tentar a la suerte? (Si o Salir)");
            answer = sc.nextLine();

            // Si quiere salir se le muestra un mensaje de ida y sus monedas restantes
            if (answer.equalsIgnoreCase("salir")) {
                System.out.println("Buena elección");
                System.out.println("Se queda con " + money + "monedas");
                break;
            }

            System.out.println("");
            // Aqui le tenemos que restar 5 a las monedas y hacer las tiradas
            money -= 5;

            // Para las tiradas, tiene que ser del 1-4 y el 7 / se repite 3 veces
            
                int r1 = (int) (Math.random() * 6 + 1);
                int r2 = (int) (Math.random() * 6 + 1);
                int r3 = (int) (Math.random() * 6 + 1);
                switch (r1) {
                    case 1:
                        System.out.print("🍒(1)");
                        break;
                    case 2:
                        System.out.print("🍋(2)");
                        break;
                    case 3:
                        System.out.print("🔔(3)");
                        break;
                    case 4:
                        System.out.print("⭐(4)");
                        break;
                    case 5:
                        System.out.print("💎(5)");
                        break;
                    case 6:
                        System.out.print("7️⃣(7)");
                        break;

                }
                switch (r2) {
                    case 1:
                        System.out.print("🍒(1)");
                        break;
                    case 2:
                        System.out.print("🍋(2)");
                        break;
                    case 3:
                        System.out.print("🔔(3)");
                        break;
                    case 4:
                        System.out.print("⭐(4)");
                        break;
                    case 5:
                        System.out.print("💎(5)");
                        break;
                    case 6:
                        System.out.print("7️⃣(7)");
                        break;

                }

                switch (r3) {
                    case 1:
                        System.out.print("🍒(1)");
                        break;
                    case 2:
                        System.out.print("🍋(2)");
                        break;
                    case 3:
                        System.out.print("🔔(3)");
                        break;
                    case 4:
                        System.out.print("⭐(4)");
                        break;
                    case 5:
                        System.out.print("💎(5)");
                        break;
                    case 6:
                        System.out.print("7️⃣(7)");
                        break;

                }
        System.out.println("");

                
                //comprobar premios
                if (r1 == r2  && r3 == r2){
                    premio = r1 * 10; 
                    System.out.println("Felicidades! ganas "+ premio+ " monedas.");
                    money += premio;
                } else if (r1 == r2 || r1 == r3 || r2 == r3){
                   premio = (r1 == r2 ? r1 : r3) * 2;
                   money += premio;
                   System.out.println("Dos iguales! ganas " + premio + " monedas.");
                }else {
                    System.out.println("Prueba otra vez");
                }

            System.out.println("Te quedan " + money +" monedas."); 

            
        } while (money > 5 && answer.equalsIgnoreCase("Si"));

        sc.close();
    }
}
