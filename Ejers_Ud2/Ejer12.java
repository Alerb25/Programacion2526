package Ejers_Ud2;

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

        //Las tiradas se tienen que ver siempre
        System.out.println("El jugador 1 ha sacado: "+ dice1 +", "+dice2+" y " +dice3);
        System.out.println("El jugador 2 ha sacado: "+ dice4 +", "+dice5+" y " +dice6);

         //Empezamos con los casos para ganar
         //Teniendo en cuenta que los dados del 1 al 3 son del juagador 1 y del 4 al 6 son del jugador 2

         //Detectamos los trios
         boolean threesm1 = (dice1 == dice2 && dice1 == dice3);
         boolean threesm2 = (dice4 == dice5 && dice4 == dice6);
         int valThrsm1= threesm1 ? dice1 : 0;
         int valThrsm2= threesm2 ? dice4 : 0;

         //Detectamos pareja 
         boolean pair1 = !threesm1 && (dice1 == dice2 || dice2 == dice3 || dice1 == dice3);
         boolean pair2 = !threesm2 && (dice4 == dice5 || dice5 == dice6 || dice4 == dice6);
         int valPair1 = 0;
         int valPair2 = 0;

         
    }
}
