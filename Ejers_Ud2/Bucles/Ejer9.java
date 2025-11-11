package Bucles;
import java.util.Scanner;

public class Ejer9 {
    public static void main(String[] args) {
        /*
         * Tenemos un array 8x8 que representa un tablero de hundir la flota
         * debe comprobar si hay el numero de barcos correcto
         * permite disparar y controlara si las cordenada estan entre 1 y 8
         * Se respondera con Agua! o Tocado!
         */

        // SE le explica el programa al usuario
        System.out.println("Programa Hundir la flota");
        System.out.println("--------------------------------");
   
                
        Scanner sc = new Scanner(System.in);
        
        //Tablero 8x8 (0 = agua, 1 = barco, -1 = hit)
        int[][] board = {
            {0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };
        
        // contar el numero de barcos
        int numShips = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    numShips++;
                }
            }
        }
        
        
        System.out.println("Numero de casillas con barco: " + numShips);
        System.out.println();
        
       
        boolean playing = true;
        int shipsRemaining = numShips;
        
        while (playing) {
            System.out.println("Barcos restantes: " + shipsRemaining);
            System.out.println();
            
            // enseñar el tablero
            System.out.println("  1 2 3 4 5 6 7 8");
            for (int i = 0; i < 8; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] == -1) {
                        System.out.print("X "); // cuando le das un hit aparece una cruz
                    } else {
                        System.out.print("~ "); 
                    }
                }
                System.out.println();
            }
            System.out.println();
            
            // pedirle al usuario las coordenadas
            System.out.print("Introduce fila (1-8, 0 para salir): ");
            int row = sc.nextInt();
            
            if (row == 0) {
                System.out.println("Gracias por jugar!");
                playing = false;
                continue;
            }
            
            System.out.print("Introduce columna (1-8): ");
            int col = sc.nextInt();
            
            
            if (row < 1 || row > 8 || col < 1 || col > 8) {
                System.out.println("Error: Las coordenadas deben estar entre 1 y 8");
                System.out.println();
                continue;
            }
            
           
            int r = row - 1;
            int c = col - 1;
            
            // verificar si el usuario le ha dado
            if (board[r][c] == 1) {
                System.out.println("Tocado!");
                board[r][c] = -1; //marcar si si le ha dado
                shipsRemaining--;
                
                if (shipsRemaining == 0) {
                    System.out.println();
                    System.out.println("FELICIDADES! Has hundido todos los barcos!");
                    playing = false;
                }
            } else if (board[r][c] == -1) {
                System.out.println("Ya habias disparado aqui antes");
            } else {
                System.out.println("Agua!");
            }
            
            System.out.println();
        }
        
        sc.close();
    }
}