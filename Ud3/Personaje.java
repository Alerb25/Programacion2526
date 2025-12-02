package Ud3;

public class Personaje {

    private String nombre;
    private int vida;
    private int armadura;
    protected int creditos;

    //Constructor por defecto
    public Personaje() {
        this.nombre = "Aleatorio";
        this.vida = (int) (Math.random() * 100) +1;
        this.armadura = 100;
        this.creditos = 30;
    }

    //Constructor con parámetros
    public Personaje(String nombre, int vida, int armadura, int creditos) {
        this.nombre = nombre;
        this.vida = vida;
        this.armadura = armadura;
        this.creditos = creditos;
    }

   public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getcreditos() {
        return this.creditos;
    }

    @Override
    public String toString() {
        String salida = "Nombre: " + this.nombre + ", Vida: " + this.vida + ", Armadura: " + this.armadura + ", Creditos: " + this.creditos;

        return salida;
    }


    public int compareTo(Personaje p){

        if (this.vida == p.vida){
            return 0;
        }
        else if (this.vida < p.vida){
            return -1;
        }
        else {
            return 1;
        }
    }

}