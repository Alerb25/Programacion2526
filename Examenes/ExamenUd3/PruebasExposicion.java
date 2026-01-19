//ALEJANDRA RUIZ BERMUDEZ
package ExamenUd3;

import java.util.ArrayList;

public class PruebasExposicion {
   public static void main(String[] args) {
      
      JuegoRetro juego1 = new JuegoRetro();
      JuegoRetro juego2 = new JuegoRetro();
      JuegoRetro juego3 = new JuegoRetro();
      JuegoRetro juego4 = new JuegoRetro();
      JuegoRetro juego5 = new JuegoRetro();
      JuegoRetro juego6 = new JuegoRetro();
      JuegoRetro Juegocompleto = new JuegoRetro("Spyro", "Ps2", 3, 2005, 20, 10, false, new ArrayList<String>());
      JuegoRetro Juegocompleto2 = new JuegoRetro("Crash Bandicout", "Ps2", 3, 2005, 8, 10, false,
            new ArrayList<String>());
      juego1.toString();
      juego2.toString();

      ExposicionRetro expo1 = new ExposicionRetro("ID_00", "evento to' chulo", new ArrayList<JuegoRetro>(), "Cadi", 25,
            10.00, false);
      ExposicionRetro expo2 = new ExposicionRetro();
      expo2.calcularValorTotal();
      expo2.eliminarJuegosPorTipo(1);
      expo2.cantidadJuegosBaratos("");
      expo2.juegoMejorValoracionConCaracteristicas("");
      expo2.buscarJuegosPorConsolaYRango("", 2, 8);

      expo1.buscarJuegosPorConsolaYRango("ps2", 5, 10);
      expo1.calcularValorTotal();
      expo1.cantidadJuegosBaratos("ps2");
      expo1.juegoMejorValoracionConCaracteristicas("");
      expo1.eliminarJuegosPorTipo(3);
   }
}
