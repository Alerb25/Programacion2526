import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;
public class Instrumento {
    // Atributos según el enunciado
    private String nombre;
    private int tipo;
    private int volumen;
    private double nivelDistorision;
    private int rareza;
    private boolean enUso;

    // Atributos estáticos
    public static final int GUITARRA_LASER = 1;
    public static final int BATERIA_CUANTICA = 2;
    public static final int SINTETIZADOR_ESPACIAL = 3;
    public static final int KAZOO_LEGENDARIO = 4;
    public static final int THEREMIN_ATOMICO = 5;

    public static final int PRESTADO = 1;
    public static final int COMPRADO = 2;
    public static final int ROBADO = 3;
    public static final int ENCONTRADO_EN_MARTE = 4;

    // Constructor de todos los parametros
    public Instrumento(String nombre, int tipo, int volumen, double nivelDistorision, int rareza, boolean enUso) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.volumen = volumen;
        this.nivelDistorision = nivelDistorision;
        this.rareza = rareza;
        this.enUso = enUso;
    }

    // constructor con valores aleatorios (volumen entre 20-150, distorsion entre 0.0-10.0, uso = false)
    public Instrumento() {
        this.nombre = generarNombreAleatorio(); // CORREGIDO
        this.tipo = (int) (Math.random() * 5) + 1; // CORREGIDO
        this.volumen = (int) (Math.random() * (150 - 20 + 1)) + 20; // CORREGIDO
        this.nivelDistorision = (double) (Math.random() * 10.0); // CORREGIDO (0.0 a 10.0)
        this.rareza = (int) (Math.random() * 4) + 1;
        this.enUso = false;
    }
    
    // Método auxiliar para generar nombre aleatorio
    private String generarNombreAleatorio() {
        String[] nombres = {"Instrumento Galáctico", "Arma Sónica", "Dispositivo Musical", 
                           "Aparato Cósmico", "Objeto Sonoro"};
        int indice = (int) (Math.random() * nombres.length);
        return nombres[indice];
    }

    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public int getVolumen() {
        return volumen;
    }

    public double getNivelDistorision() {
        return nivelDistorision;
    }

    public int getRareza() {
        return rareza;
    }

    public boolean getEnUso() {
        return enUso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public void setNivelDistorision(double nivelDistorision) {
        this.nivelDistorision = nivelDistorision;
    }

    public void setRareza(int rareza) {
        this.rareza = rareza;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }

    // Método toString
    @Override
    public String toString() {
        return "Instrumento{" +
                "nombre='" + nombre + '\'' +
                ", tipo=" + tipoToString() +
                ", volumen=" + volumen +
                ", nivelDistorision=" + nivelDistorision +
                ", rareza=" + rarezaToString() +
                ", enUso=" + enUso +
                '}';
    }
    
    // Método para convertir tipo a String
    public String tipoToString() {
        switch (this.tipo) {
            case GUITARRA_LASER:
                return "Guitarra Laser";
            case BATERIA_CUANTICA:
                return "Bateria Cuantica";
            case SINTETIZADOR_ESPACIAL:
                return "Sintetizador Espacial";
            case KAZOO_LEGENDARIO:
                return "Kazoo Legendario";
            case THEREMIN_ATOMICO:
                return "Theremin Atomico";
            default:
                return "Tipo desconocido";
        }
    }
    
    // Método para convertir rareza a String (opcional pero útil)
    public String rarezaToString() {
        switch (this.rareza) {
            case PRESTADO:
                return "Prestado";
            case COMPRADO:
                return "Comprado";
            case ROBADO:
                return "Robado";
            case ENCONTRADO_EN_MARTE:
                return "Encontrado en Marte";
            default:
                return "Rareza desconocida";
        }
    }

    // metodo hackear
    public boolean hackear() {
        if (rareza == 4) {
            return false;
        } else {
            if (volumen < 150) {
                volumen = (int) (volumen * 1.25); // CORREGIDO: es multiplicar por 1.25, no sumar 0.25
                if (volumen > 150) {
                    volumen = 150;
                }
            }
            rareza = rareza + 1;
            return true;
        }
    }

    // compatibilidad
    public boolean compatibilidad(Artista artista) {
        int generoMusical = artista.getGeneroMusical(); // CORREGIDO: debe ser getGeneroMusical()

        switch (generoMusical) {
            case Artista.DEATH_METAL_COSMICO: // AÑADIDO: Artista. para las constantes
                return (this.tipo == GUITARRA_LASER || this.tipo == BATERIA_CUANTICA);

            case Artista.REGGAETON_MARCIANO:
                return (this.tipo == SINTETIZADOR_ESPACIAL || this.tipo == BATERIA_CUANTICA);

            case Artista.JAZZ_CUANTICO:
                return (this.tipo == THEREMIN_ATOMICO || this.tipo == SINTETIZADOR_ESPACIAL);

            case Artista.POLKA_INTERGALACTICA:
                return (this.tipo == KAZOO_LEGENDARIO || this.tipo == THEREMIN_ATOMICO);

            case Artista.TRAP_ESPACIAL:
                return (this.tipo == SINTETIZADOR_ESPACIAL || this.tipo == BATERIA_CUANTICA);

            default:
                return false;
        }
    }
}