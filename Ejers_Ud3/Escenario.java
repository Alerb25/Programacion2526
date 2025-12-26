public class Escenario {
    //atributos
    private String nombre;
    private int tipoEscenario;
    private int aforoMax;
    private boolean efectosEspeciales;

    //Atributos estaticos
    public static final int PRINCIPAL = 1, SECUNDARIO = 2, ACUSTICO = 3, UNDERGROUND = 4;

    //Constructor vacio
    public Escenario(String nombre, int tipoEscenario, int aforoMax, boolean efectosEspeciales){
      this.nombre = nombre;
      this.tipoEscenario = tipoEscenario;
      this.aforoMax = aforoMax;
      this.efectosEspeciales = efectosEspeciales;
    }

    //constructor con nombre, tipo y aforo
    public Escenario(String nombre, int tipoEscenario, int aforoMax){
      this.nombre = nombre;
      this.tipoEscenario = tipoEscenario;
      this.aforoMax = aforoMax;
      this.efectosEspeciales = false;
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

    

}
