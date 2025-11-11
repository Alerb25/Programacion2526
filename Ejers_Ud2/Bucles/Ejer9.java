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
        
        // Board 8x8 (0 = water, 1 = ship, -1 = hit)
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
        
        // Count number of ships
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
        
        // Main game loop
        boolean playing = true;
        int shipsRemaining = numShips;
        
        while (playing) {
            System.out.println("Barcos restantes: " + shipsRemaining);
            System.out.println();
            
            // Show board (hidden)
            System.out.println("  1 2 3 4 5 6 7 8");
            for (int i = 0; i < 8; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] == -1) {
                        System.out.print("X "); // Hit
                    } else {
                        System.out.print("~ "); // Water (hides ships)
                    }
                }
                System.out.println();
            }
            System.out.println();
            
            // Ask for coordinates
            System.out.print("Introduce fila (1-8, 0 para salir): ");
            int row = sc.nextInt();
            
            if (row == 0) {
                System.out.println("Gracias por jugar!");
                playing = false;
                continue;
            }
            
            System.out.print("Introduce columna (1-8): ");
            int col = sc.nextInt();
            
            // Validate coordinates
            if (row < 1 || row > 8 || col < 1 || col > 8) {
                System.out.println("Error: Las coordenadas deben estar entre 1 y 8");
                System.out.println();
                continue;
            }
            
            // Convert to array indices (0-7)
            int r = row - 1;
            int c = col - 1;
            
            // Check shot
            if (board[r][c] == 1) {
                System.out.println("Tocado!");
                board[r][c] = -1; // Mark as hit
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