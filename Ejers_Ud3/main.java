import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println(" FESTIVAL INTERGALÁCTICO DE MÚSICA ");
        
        // Crear instrumentos
       
        Instrumento guitarra = new Instrumento("Stratocaster Galáctica", 
            Instrumento.GUITARRA_LASER, 120, 8.5, Instrumento.ROBADO, false);
        System.out.println(" Guitarra creada: " + guitarra.getNombre());
        
        Instrumento kazoo = new Instrumento("Kazoo del Destino", 
            Instrumento.KAZOO_LEGENDARIO, 80, 3.2, Instrumento.ENCONTRADO_EN_MARTE, false);
        System.out.println(" Kazoo creado: " + kazoo.getNombre());
        
        // Crear artista
        
        Artista metalero = new Artista("Ozzy del Espacio", 
            Artista.DEATH_METAL_COSMICO, 5, 80, 0, new ArrayList<Instrumento>(), false);
        System.out.println(" Artista creado: " + metalero.getNombreArtistico());
        System.out.println("  Nivel: " + metalero.getNivel());
        System.out.println("  Energía: " + metalero.getEnergia());
        System.out.println("  Seguidores: " + metalero.getSeguidores());
        
        // Tocar instrumentos
       
        boolean resultado1 = metalero.tocarInstrumento(guitarra);
        System.out.println("¿Puede tocar la guitarra? " + resultado1); // true
        
        boolean resultado2 = metalero.tocarInstrumento(kazoo);
        System.out.println("¿Puede tocar el kazoo? " + resultado2); // false (no compatible)
        
        System.out.println("Instrumentos del artista: " + metalero.getInstrumentos().size());
        
        // Crear escenario
        
        Escenario principal = new Escenario("Escenario Saturno", 
            Escenario.PRINCIPAL, 5, true);
        System.out.println(" Escenario creado: " + principal.getNombre());
        System.out.println("  Tipo: " + principal.getTipoEscenario());
        System.out.println("  Aforo máximo: " + principal.getAforoMax());
        System.out.println("  Efectos especiales: " + principal.getEfectosEspeciales());
        
        // Subir al escenario
        
        boolean subio = principal.subirAlEscenario(metalero);
        System.out.println("¿Subió al escenario? " + subio);
        
        // Dar concierto
       
        System.out.println("Seguidores antes del concierto: " + metalero.getSeguidores());
        System.out.println("Energía antes del concierto: " + metalero.getEnergia());
        
        metalero.darConcierto(5000); // gana 500 seguidores
        
        System.out.println("Seguidores después del concierto: " + metalero.getSeguidores());
        System.out.println("Energía después del concierto: " + metalero.getEnergia());
        
        // Calcular poder escénico
        
        int poder = metalero.calcularPoderEscenico();
        System.out.println("Poder escénico del artista: " + poder);
        
        // Calcular espectacularidad del escenario
        int espectacularidad = principal.calcularEspectacularidad();
        System.out.println("Espectacularidad del escenario: " + espectacularidad);
        
        // Obtener géneros del escenario
        
        HashSet<Integer> generos = principal.obtenerGenerosEnEscenario();
        System.out.println("Géneros presentes: " + generos);
        
        // Filtrar artistas cansados
        
        ArrayList<Artista> agotados = principal.obtenerArtistasAgotados();
        System.out.println("Número de artistas agotados (energía < 30): " + agotados.size());
        for (Artista a : agotados) {
            System.out.println("  - " + a.getNombreArtistico() + " (Energía: " + a.getEnergia() + ")");
        }
        
        // Dejar instrumento
        
        System.out.println("Energía antes de dejar el instrumento: " + metalero.getEnergia());
        Instrumento devuelto = metalero.dejarInstrumento("Stratocaster Galáctica");
        if (devuelto != null) {
            System.out.println(" Instrumento devuelto: " + devuelto.getNombre());
            System.out.println("Energía después de dejar el instrumento: " + metalero.getEnergia());
            System.out.println("¿Instrumento en uso? " + devuelto.getEnUso());
        }
        
        // Crear más artistas para pruebas adicionales
        
        Artista reggaetonero = new Artista("Bad Bunny Espacial", 
            Artista.REGGAETON_MARCIANO, 3, 25, 5000, new ArrayList<Instrumento>(), false);
        System.out.println(" Artista creado: " + reggaetonero.getNombreArtistico());
        
        Artista jazzista = new Artista("Miles del Universo", 
            Artista.JAZZ_CUANTICO, 7, 90, 15000, new ArrayList<Instrumento>(), false);
        System.out.println(" Artista creado: " + jazzista.getNombreArtistico());
        
        // Subir más artistas
        principal.subirAlEscenario(reggaetonero);
        principal.subirAlEscenario(jazzista);
        
        // Obtener géneros actualizados
        
        generos = principal.obtenerGenerosEnEscenario();
        System.out.println("Géneros presentes ahora: " + generos);
        
        // Filtrar artistas agotados actualizados
       
        agotados = principal.obtenerArtistasAgotados();
        System.out.println("Número de artistas agotados: " + agotados.size());
        for (Artista a : agotados) {
            System.out.println("  - " + a.getNombreArtistico() + " (Energía: " + a.getEnergia() + ")");
        }
        
        // Obtener artistas por género
       
        ArrayList<Artista> metaleros = principal.obtenerArtistaPorGenero(Artista.DEATH_METAL_COSMICO);
        System.out.println("Artistas de Death Metal Cósmico: " + metaleros.size());
        for (Artista a : metaleros) {
            System.out.println("  - " + a.getNombreArtistico());
        }
        
        // Bajar del escenario
        
        boolean bajo = principal.bajarDelEscenario("Bad Bunny Espacial");
        System.out.println("¿Se bajó del escenario? " + bajo);
        
      
    }
}