import java.util.ArrayList;

public class EquipoCiclista {
    //ciclista
    private String id;
    private String nombre;
    private int numCiclistas;
    private ArrayList<Ciclista> listaCiclistas;


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
        + "lista de Ciclistas: " + this.listaCiclistas.toString() +"\n" ;
    }

    //----------------PT2-----------------

    //metodo numCiclista (devuelve el num de ciclistas)
    public int numCiclsta(){
        return this.listaCiclistas.size();
    }

    //metodo maxPeso (devuelve el peso max de los ciclistas)
    public double maxPeso(){
        double max = 0;
         for(Ciclista ciclista : this.listaCiclistas){
            if (ciclista.getPeso() > max){
                max = ciclista.getPeso();
            }
         }
    
         return max;
         //con Stream (filtramos solo al peso (::) y lo compara )
         /*
            Ciclista ciclistaPesado = this.listaCiclista.stream().max(Comparator.comaringDouble(Ciclista::getPeso)).orElse(null);
            return ciclistaPesado.getPeso(); 
         */

         //Otra forma mas (convertimos a stream filtramos  el peso y calculamos el max)
         /*
            return listaCiclistas.stream().mapToDouble(Ciclista::getPeso).max().orElse(0.0);
         */
    }

    //metodo int numCiclistas(String especialidad) (devuelde el num Ciclista de la especialidad indicada)
    public int numCiclistas(int especialidad){
        int cantidadEspecialidad = 0;
        for (int i = 0; i<listaCiclistas.size(); i++){
            if(listaCiclistas.get(i).getEspecialidad() == especialidad){
                cantidadEspecialidad++;
            }
        }

        return cantidadEspecialidad ;

        //con Stream 
        /*
            return (int)listaCiclistas.stream().filter(c->c.getEspecialidad() == especialidad).count)();
        */
    }

    //metodo Ciclista buscarCiclista(String nombre) Buscará en el array de ciclistas un ciclista con el nombre que recibe cómo parámetro. Devolverá el ciclista o -1 si no lo encuentra.
    public Ciclista buscarCiclista(String nombre){
        Ciclista ciclistaEncontrado = this.listaCiclistas.stream().filter(ciclista.getnombre().equals(nombre));
        return ciclistaEncontrado;
        
    }






}
