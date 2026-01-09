import java.util.ArrayList;

public class EquipoCiclista {
    //ciclista
    private String id;
    private String nombre;
    private int numCiclistas;
    private ArrayList<Ciclista> listaCiclistas;

    //atributos estaticos
    public final int ESP_TODOTERRENO =0; 
    public final int ESP_MONTANA =1; 
    public final int ESP_CONTRARELOJ=2; 

    //constructor vacio que genera los datos aleatoriamenteq
    public EquipoCiclista(){
    
        this.id =  letraAleatoria() + String.valueOf((int) (Math.random()*100)+1);
        this.nombre = "";
        this.numCiclistas=(int) (Math.random()*90)+18;
       for (int i = 0; i<10; i++){
            Ciclista ciclista = new Ciclista();
            listaCiclistas.add(ciclista);
       }
    
    }

    //constructor que recibe los parametros
        public EquipoCiclista(String id, String nombre, int numCiclistas){
    
        this.id = id;
        this.nombre = nombre;
        this.numCiclistas= numCiclistas;
    
    }

    //get y set
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  

        //metodo para obtener letras aleatorias
        public static String letraAleatoria() {
             String letras = "abcdefghijklmnñopqrstuvwxyz";
             int posicion = (int) (Math.random() * letras.length());

            return String.valueOf(letras.charAt(posicion));
        }
    
 
    @Override
    public String toString(){
        return"ID: " + this.id +"\n"
        + "nombre: " + this.nombre +"\n"
        + "numero Ciclistas: " + this.numCiclistas +"\n"
        +"\n";
    }

}
