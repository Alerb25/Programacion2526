public class Instrumento {
    //Atributos según el enunciado
    private String nombre;
    private int tipo;
    private int volumen;
    private double nivelDistorision;
    private int rareza;
    private boolean enUso;

    //Atributos estáticos
    public static final int GUITARRA_LASER = 1;
    public static final int BATERIA_CUANTICA = 2;
    public static final int SINTETIZADOR_ESPACIAL = 3;
    public static final int KAZOO_LEGENDARIO = 4;
    public static final int THEREMIN_ATOMICO = 5;

    public static final int PRESTADO = 1;
    public static final int COMPRADO = 2;
    public static final int ROBADO = 3;
    public static final int ENCONTRADO_EN_MARTE = 4;


    //Constructor de todos los parametros vacio
    public Instrumento(String nombre, int tipo, int volumen, double nivelDistorision, int rareza, boolean enUso){
        this.nombre = nombre;
        this.tipo = tipo;
        this.volumen = volumen;
        this.nivelDistorision = nivelDistorision;
        this.rareza = rareza;
        this.enUso = enUso;

    }
    
    //constructor con valores aleatorios (volumen entre 20-150, distorsion entre 0.0-10.0, uso = false)


}
