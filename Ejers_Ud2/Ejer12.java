

public class Ejer12 {
    public static void main(String[] args) {
        /*
         * Simular un juego donde 2 jugadores lanzan 3 dados al azar
         * se muestra la tirada por pantalla  
         * Reglas:
         * 1. por trio gana el trio mas alto (Ej 666>555)
         * 2. Si uno tiene trio y el otro no gana el del trio
         * 3. Si uno tiene pareja y el otro no gana el que tenga pareja (sin trios)
         * 4. Si no hay ni parejas ni trios gana el que tenga la suma mas alta
         * 5. Si hay empate -> "Empate técnico"
         */

         // Definimos las variables, utilizaremos 6 dados para los dos juagores
         int dice1=(int) (Math.random()*6+1), dice2=(int) (Math.random()*6+1), dice3=(int) (Math.random()*6+1), dice4=(int) (Math.random()*6+1), dice5=(int) (Math.random()*6+1), dice6=(int) (Math.random()*6+1);
         int add1= dice1 + dice2 + dice3;
         int add2= dice4+ dice5 +dice6;

        System.out.println("Simulación de Juego.");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("El programa siula dos jugadores jugando a los dados, cada jugador lanza 3 dados y gana o bien el que saque un trío o una pareja o el que tenga la suma más alta.");
        System.out.println("");
        System.out.println("--------------------------------");


        //Las tiradas se tienen que ver siempre
        System.out.println("El jugador 1 ha sacado: "+ dice1 +", "+dice2+" y " +dice3);
        System.out.println("El jugador 2 ha sacado: "+ dice4 +", "+dice5+" y " +dice6);

         //Empezamos con los casos para ganar
         //Teniendo en cuenta que los dados del 1 al 3 son del juagador 1 y del 4 al 6 son del jugador 2

         //Detectamos los trios
         boolean threesm1 = (dice1 == dice2 && dice1 == dice3);
         boolean threesm2 = (dice4 == dice5 && dice4 == dice6);
         
         //Le damos valor para poder compararlos en caso en el que ambos jugadores saquen trio
         int valThrsm1= threesm1 ? dice1 : 0;
         int valThrsm2= threesm2 ? dice4 : 0;

         //Detectamos pareja 
         //Nota: en el ejer no se habla nada si ambos jugadores tienen pares pero voy a aplicar la misma logica si sacaran 2 trios
         boolean pair1 = threesm1 == false && (dice1 == dice2 || dice2 == dice3 || dice1 == dice3);
         boolean pair2 = threesm2 == false && (dice4 == dice5 || dice5 == dice6 || dice4 == dice6);
         int valPair1 = 0;
        
         //Identificamos cual es la pareja y le damos un valor. 
         if (pair1 == true){
            if (dice1 == dice2){
                valPair1 = dice1;
            } else if (dice2 == dice3){
                valPair1 = dice2;
            } else if (dice1 == dice3){
                valPair1 = dice3;
            }
         }

         int valPair2 = 0;
          if (pair2 == true){
            if (dice4 == dice5){
                valPair1 = dice4;
            } else if (dice5 == dice6){
                valPair1 = dice5;
            } else if (dice4 == dice6){
                valPair1 = dice6;
            }
         }

        //Empezamos con los casos para ganar 2 trio, 2 pareja y luego si no hay ninguna la suma de los dados

        if ( threesm1 == true && threesm2 == true){
            if (valThrsm1 > valThrsm2){
                System.out.println( "El ganador es el Jugador 1 porque ha sacado un trío mayor.");
            }else if (valThrsm1 < valThrsm2){
                System.out.println( "El ganador es el Jugador 2 porque ha sacado un trío mayor.");
            }
        }

        if (pair1 == true && pair2 == true){
            if (valPair1 > valPair2){
                System.out.println( "El ganador es el Jugador 1 porque ha sacado una pareja mayor.");
            } else if (valPair1 < valPair2){
                System.out.println( "El ganador es el Jugador 2 porque ha sacado una pareja mayor.");
            }
        }

        if ( threesm1 == false && threesm2 == false && pair1 == false && pair2 == false){
            if (add1 >  add2){
                System.out.println( "El ganador es el Jugador 1 porque ha sacado un total más alto.");
            } else if (add1 < add2){
                System.out.println( "El ganador es el Jugador 2 porque ha sacado un total más alto.");
            }
        }
        
        if ( threesm1 == true && threesm2 == false){
            System.out.println( "El ganador es el Jugador 1 porque ha sacado un trío.");
        }else if (threesm2 == true && threesm1 == false){
            System.out.println( "El ganador es el Jugador 2 porque ha sacado un trío.");
        }

        if ( pair1 == true && pair2 == false){
            System.out.println( "El ganador es el Jugador 1 porque ha sacado una pareja.");
        }else if (pair2 == true && pair1 == false){
            System.out.println( "El ganador es el Jugador 2 porque ha sacado una pareja.");
        }
         
    }
}