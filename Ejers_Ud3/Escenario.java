import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Escenario {
    //atributos
    private String nombre;
    private int tipoEscenario;
    private int aforoMax;
    private boolean efectosEspeciales;
    private ArrayList<Artista> artistas; 

    //Atributos estaticos
    public static final int PRINCIPAL = 1, SECUNDARIO = 2, ACUSTICO = 3, UNDERGROUND = 4;

    //Constructor con todos los parámetros
    public Escenario(String nombre, int tipoEscenario, int aforoMax, boolean efectosEspeciales){
      this.nombre = nombre;
      this.tipoEscenario = tipoEscenario;
      this.aforoMax = aforoMax;
      this.efectosEspeciales = efectosEspeciales;
      this.artistas = new ArrayList<Artista>();
    }

    //constructor con nombre, tipo y aforo
    public Escenario(String nombre, int tipoEscenario, int aforoMax){
      this.nombre = nombre;
      this.tipoEscenario = tipoEscenario;
      this.aforoMax = aforoMax;
      this.efectosEspeciales = false;
      this.artistas = new ArrayList<Artista>(); 
    }
     
    //getters y setters
    public String getNombre(){
        return nombre;
    }
    public int getTipoEscenario(){
        return tipoEscenario;
    }
    public int getAforoMax(){
        return aforoMax;
    }
    public boolean getEfectosEspeciales(){
        return efectosEspeciales;
    }

    
    // Método subirAlEscenario
    public boolean subirAlEscenario(Artista a) {
        // Si el artista ya está en el escenario
        if (artistas.contains(a)) {
            return false;
        }
        
        // Si el número de artistas >= aforoMaximo
        if (artistas.size() >= aforoMax) {
            return false;
        }
        
        // Si no, lo añade y return true
        artistas.add(a);
        return true;
    }
    
    // Método bajarDelEscenario
    public boolean bajarDelEscenario(String nombreArtista) {
        // Usando removeIf (más simple)
        return artistas.removeIf(artista -> artista.getNombreArtistico().equals(nombreArtista));
        
        /* Alternativa usando Iterator:
        Iterator<Artista> it = artistas.iterator();
        while (it.hasNext()) {
            Artista artista = it.next();
            if (artista.getNombreArtistico().equals(nombreArtista)) {
                it.remove();
                return true;
            }
        }
        return false;
        */
    }
    
    // Método obtenerArtistaPorGenero
    public ArrayList<Artista> obtenerArtistaPorGenero(int genero) {
        return artistas.stream()
            .filter(artista -> artista.getGeneroMusical() == genero)
            .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Método obtenerGenerosEnEscenario
    public HashSet<Integer> obtenerGenerosEnEscenario() {
        HashSet<Integer> generos = new HashSet<Integer>();
        
        for (Artista artista : artistas) {
            generos.add(artista.getGeneroMusical());
        }
        
        return generos;
    }
    
    // Método calcularEspectacularidad
    public int calcularEspectacularidad() {
        // Suma el poder escénico de todos los artistas
        int sumaTotal = artistas.stream()
            .mapToInt(artista -> artista.calcularPoderEscenico())
            .sum();
        
        // Si hay efectos especiales, multiplicar por 1.5
        if (efectosEspeciales) {
            sumaTotal = (int) (sumaTotal * 1.5);
        }
        
        return sumaTotal;
    }
    
    // Método obtenerArtistasAgotados (con ordenación para los puntos extra)
    public ArrayList<Artista> obtenerArtistasAgotados() {
        return artistas.stream()
            .filter(artista -> artista.getEnergia() < 30)
            .sorted((a1, a2) -> Integer.compare(a1.getEnergia(), a2.getEnergia()))
            .collect(Collectors.toCollection(ArrayList::new));
    }
}