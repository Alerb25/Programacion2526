public class Ciclista {
    //ciclista
    private int id;
    private String nombre;
    private int edad;
    private String modeloBici;
    private double peso;
    private int posicion;
    private int especialidad;

    //atributos estaticos
    public final int ESP_TODOTERRENO =0; 
    public final int ESP_MONTANA =1; 
    public final int ESP_CONTRARELOJ=2; 

    //constructor vacio que genera los datos aleatoriamenteq
    public Ciclista(){
    
        this.id = (int) (Math.random()*100)+1;
        this.nombre = "";
        this.edad=(int) (Math.random()*90)+18;
        this.modeloBici = "" ;
        this.peso =  Math.random()*80+40 ;
        this.posicion = (int) (Math.random()*100)+1;
        this.especialidad = (int) (Math.random()*3);
    
    }

    //constructor que recibe los parametros
        public Ciclista(int id, String nombre, int edad, String modeloBici, double peso, int posicion, int especialidad){
    
        this.id = id;
        this.nombre = nombre;
        this.edad= edad;
        this.modeloBici = modeloBici ;
        this.peso = peso;
        this.posicion = posicion;
        this.especialidad = especialidad;
    
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
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getModeloBici() {
        return modeloBici;
    }
    public void setModeloBici(String modeloBici) {
        this.modeloBici = modeloBici;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getPosicion() {
        return posicion;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public int getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }
    
 
    @Override
    public String toString(){
        return"ID: " + this.id +"\n"
        + "nombre: " + this.nombre +"\n"
        + "edad " + this.edad +"\n"
        + "Modelo Bici: " + this.modeloBici +"\n"
        + "peso: " + this.peso +"\n"
        + "posicion: " + this.posicion +"\n"
        + "especialidad: " + this.especialidad +"\n";
    }

}
