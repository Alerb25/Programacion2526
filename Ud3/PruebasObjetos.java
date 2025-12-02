package Ud3;

import Ud3.Personaje;

public class PruebasObjetos {
    public static void main(String[] args) {

        /*
        * Para crear un objeto de una clase, se utiliza la palabra new
        * primero ponemos el nombre de la clase (Personaje) y luego el nombre del objeto (Fran)
        * 
        * Para poder usar un obeto de una clase, primero tenemos que crearlo, para ello se utiliza la palabra reservada new
        * seguida del nombre de la clase y paréntesis.
        * 
        * Esto llamaa al constructor de la clase, que es un método especial que se utiliza para inicializar los objetos de la clase.
        */
        Personaje fran = new Personaje(); //Personaje por defecto
        Personaje maria = new Personaje("Maria", 95, 0, 50); //Personaje con parametros

        System.out.println("Nombre por defecto: " + fran.getNombre());

        fran.setNombre("Francisco");
        fran.setVida(80);



        System.out.println("El personaje " + fran.getNombre() + " tiene " + fran.getVida() + " puntos de vida.");
        
        fran.setVida(fran.getVida()+20);
        
        System.out.println("El personaje " + fran.getNombre() + " tiene " + fran.getVida() + " puntos de vida.");
        System.out.println("Datos del personaje: " + fran);

    }
}