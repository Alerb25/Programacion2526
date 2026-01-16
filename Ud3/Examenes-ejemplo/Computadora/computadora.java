import java.util.ArrayList;

public class computadora {
    private String id;
    public String nombre;
    private int numComponentes;
    private String tipo;
    ArrayList<Componente> componentes; // se tiene que inicializar en le constructor

    // Atributos estaticos
    final static int TIPO_PORTATIL = 0;
    final static int TIPO_SERVIDOR = 1;
    final static int TIPO_GAMING = 2;

    // constructor vacio
    public computadora() {
        this.id = 0;
        this.nombre = "";
        this.numComponentes = (int) (Math.random() * 10);
        this.tipo = "";
    }

    // constructor con parametros
    public computadora(String id, String nombre, int numComponentes, String tipo, ArrayList<Componente> Componentes) {
        this.id = id;
        this.nombre = nombre;
        this.numComponentes = numComponentes;
        this.tipo = tipo;
        this.componentes = new ArrayList<Componente>();
        // creammos 10 computadoras aleatorios y los metemos en el equipo
        for (int i = 0; i < 10; i++) {
            Computadora compu = new Computadora();
            componentes.add(compu);
        }
    }

    // metodos get y set
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumComponentes() {
        return numComponentes;
    }

    public void setNumComponentes(int numComponentes) {
        this.numComponentes = numComponentes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    //-----PT2------
}
