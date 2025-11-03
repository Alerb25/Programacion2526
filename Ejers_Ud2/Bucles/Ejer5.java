package Bucles;

public class Ejer5 {
    public static void main(String[] args) {
        /*
         * Carrera de caracoles
         * 3 caracoles
         * cada turno avanzan una cantidad aleatoria (0-3 espacios)
         * la pista tiene 30 espacios
         * mostrar la posicion de cada caracol con caracteres @_______________[Meta]
         * eventos especiales:
         * si saca dos seguidos:
         * 0 -> se duerme (un turno sin jugar)
         * 3 -> turbo (avanza 2 extra)
         * despues de cada turno debe mostrar tres lineas la posicion de los tres
         * caracoles hasta que uno llegue a la meta
         */
        // explicamos el programa al usuairo
        System.out.println("Programa Carrera de caracoles.");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println( "Veamos como compiten los caracoles");
        System.out.println("");
        System.out.println("--------------------------------");

        // Declaramos variables
        // Posiciones de los caracoles
        int snail1Position = 0;
        int snail2Position = 0;
        int snail3Position = 0;

        // Movimientos anteriores para detectar eventos especiales
        int snail1PreviousMove = -1;
        int snail2PreviousMove = -1;
        int snail3PreviousMove = -1;

        // Estados de sueño (turnos restantes durmiendo)
        int snail1Sleeping = 0;
        int snail2Sleeping = 0;
        int snail3Sleeping = 0;

        int trackLength = 30;
        int turn = 0;
        boolean raceFinished = false;

        System.out.println("CARRERA DE CARACOLES");
        System.out.println("====================");
        System.out.println();

        // Bucle principal de la carrera
        while (!raceFinished) {
            turn++;
            System.out.println("--- TURNO " + turn + " ---");

            // CARACOL 1
            int snail1Move = 0;
            if (snail1Sleeping > 0) {
                System.out.println("Caracol 1: Durmiendo...");
                snail1Sleeping--;
                snail1PreviousMove = -1;
            } else {
                snail1Move = (int) (Math.random() * 4);

                // Detectar evento especial
                if (snail1Move == snail1PreviousMove) {
                    if (snail1Move == 0) {
                        System.out.println("Caracol 1: Se durmio!");
                        snail1Sleeping = 1;
                    } else if (snail1Move == 3) {
                        System.out.println("Caracol 1: TURBO!");
                        snail1Move += 2;
                    }
                }

                snail1Position += snail1Move;
                if (snail1Position > trackLength) {
                    snail1Position = trackLength;
                }
                snail1PreviousMove = snail1Move;
            }

            // CARACOL 2
            int snail2Move = 0;
            if (snail2Sleeping > 0) {
                System.out.println("Caracol 2: Durmiendo...");
                snail2Sleeping--;
                snail2PreviousMove = -1;
            } else {
                snail2Move = (int) (Math.random() * 4);

                if (snail2Move == snail2PreviousMove) {
                    if (snail2Move == 0) {
                        System.out.println("Caracol 2: Se durmio!");
                        snail2Sleeping = 1;
                    } else if (snail2Move == 3) {
                        System.out.println("Caracol 2: TURBO!");
                        snail2Move += 2;
                    }
                }

                snail2Position += snail2Move;
                if (snail2Position > trackLength) {
                    snail2Position = trackLength;
                }
                snail2PreviousMove = snail2Move;
            }

            // CARACOL 3
            int snail3Move = 0;
            if (snail3Sleeping > 0) {
                System.out.println("Caracol 3: Durmiendo...");
                snail3Sleeping--;
                snail3PreviousMove = -1;
            } else {
                snail3Move = (int) (Math.random() * 4);

                if (snail3Move == snail3PreviousMove) {
                    if (snail3Move == 0) {
                        System.out.println("Caracol 3: Se durmio!");
                        snail3Sleeping = 1;
                    } else if (snail3Move == 3) {
                        System.out.println("Caracol 3: TURBO!");
                        snail3Move += 2;
                    }
                }

                snail3Position += snail3Move;
                if (snail3Position > trackLength) {
                    snail3Position = trackLength;
                }
                snail3PreviousMove = snail3Move;
            }

            System.out.println();

            // Mostrar pista del caracol 1
            System.out.print("Caracol 1: ");
            for (int i = 0; i < snail1Position; i++) {
                System.out.print("_");
            }
            System.out.print("@");
            for (int i = snail1Position; i < trackLength; i++) {
                System.out.print("_");
            }
            System.out.println("[Meta]");

            // Mostrar pista del caracol 2
            System.out.print("Caracol 2: ");
            for (int i = 0; i < snail2Position; i++) {
                System.out.print("_");
            }
            System.out.print("@");
            for (int i = snail2Position; i < trackLength; i++) {
                System.out.print("_");
            }
            System.out.println("[Meta]");

            // Mostrar pista del caracol 3
            System.out.print("Caracol 3: ");
            for (int i = 0; i < snail3Position; i++) {
                System.out.print("_");
            }
            System.out.print("@");
            for (int i = snail3Position; i < trackLength; i++) {
                System.out.print("_");
            }
            System.out.println("[Meta]");

            System.out.println();

            // Verificar si algun caracol llego a la meta
            if (snail1Position >= trackLength || snail2Position >= trackLength || snail3Position >= trackLength) {
                raceFinished = true;
                System.out.println("CARRERA TERMINADA!");
                if (snail1Position >= trackLength) {
                    System.out.println("El CARACOL 1 ha ganado!");
                }
                if (snail2Position >= trackLength) {
                    System.out.println("El CARACOL 2 ha ganado!");
                }
                if (snail3Position >= trackLength) {
                    System.out.println("El CARACOL 3 ha ganado!");
                }
            }
        }
    }
}