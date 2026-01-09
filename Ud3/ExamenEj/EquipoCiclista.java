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
        this.listaCiclistas = new ArrayList<Ciclista>(); //imp definirlo primero para poder utilizarlo
       //creammos 10 ciclistas aleatorios y los metemos en el equipo
        for (int i = 0; i<10; i++){
            Ciclista ciclista = new Ciclista();
            listaCiclistas.add(ciclista);
       }
    
    }

    //constructor que recibe los parametros
        public EquipoCiclista(String id, String nombre, int numCiclistas, ArrayList<Ciclista> listaCiclistas){
    
        this.id = id;
        this.nombre = nombre;
        this.numCiclistas= numCiclistas;
        this.listaCiclistas = listaCiclistas;
    
    }

    //get y set
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

    public int getNumCiclistas() {
        return numCiclistas;
    }

    public void setNumCiclistas(int numCiclistas) {
        this.numCiclistas = numCiclistas;
    }

    public ArrayList<Ciclista> getListaCiclistas() {
        return listaCiclistas;
    }
    public void setListaCiclistas(ArrayList<Ciclista> listaCiclistas) {
        this.listaCiclistas = listaCiclistas;
    }

  

        //metodo para obtener letras aleatorias
        public static String letraAleatoria() {
             String letras = "abcdefghijklmnñopqrstuvwxyz";
             int posicion = (int) (Math.random() * letras.length());

            return String.valueOf(letras.charAt(posicion));
        }
    
 
    @Override
    public String toString(){
        return"Equipo Ciclista \n"+"ID: " + this.id +"\n"
        + "nombre: " + this.nombre +"\n"
        + "numero Ciclistas: " + this.numCiclistas +"\n"
        + "lista de Ciclistas: " + this.listaCiclistas.toString() +"\n";
    }

}
