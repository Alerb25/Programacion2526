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

    // constructor con valores aleatorios (volumen entre 20-150, distorsion entre
    // 0.0-10.0, uso = false)
    public Instrumento() {
        this.nombre = (int) (Math.random() * 5) + 1;
        this.tipo = tipo;
        this.volumen = (int) (Math.random() * (20 - 150 + 1)) + 20;
        this.nivelDistorision = (double) (Math.random() * 10.0) + 1.0;
        this.rareza = (int) (Math.random() * 4) + 1;
        this.enUso = false;
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

    // metodo hackear
    public boolean hackear() {
        if (rareza == 4) {
            return false;
        } else {

            if (volumen < 150) {
                volumen = volumen * 0.25 + volumen;
                if (volumen >= 150) {
                    volumen = 150;
                }
            }
            rareza = rareza + 1;
            return true;
        }
    }

    // compatibilidad
    public boolean compatibilidad(Artista artista) {
        int generoMusical = artista.getGenero();

        switch (generoMusical) {
            case DEATH_METAL_COSMICO:
                return (this.tipo == GUITARRA_LASER || this.tipo == BATERIA_CUANTICA);

            case REGGAETON_MARCIANO:
                return (this.tipo == SINTETIZADOR_ESPACIAL || this.tipo == BATERIA_CUANTICA);

            case JAZZ_CUANTICO:
                return (this.tipo == THEREMIN_ATOMICO || this.tipo == SINTETIZADOR_ESPACIAL);

            case POLKA_INTERGALACTICA:
                return (this.tipo == KAZOO_LEGENDARIO || this.tipo == THEREMIN_ATOMICO);

            case TRAP_ESPACIAL:
                return (this.tipo == SINTETIZADOR_ESPACIAL || this.tipo == BATERIA_CUANTICA);

            default:
                return false;
        }
    }
}
