public class Artista {
    String nombreArtistico;
int generoMusical;
int nivel; 	 // nivel de fama
int energia;  // de 0 a 100
int seguidores;
ArrayList<Instrumento> instrumentos; 
 boolean enGira;

 public static final int DEATH_METAL_COSMICO 	= 1, REGGAETON_MARCIANO = 2, 	JAZZ_CUANTICO = 3, POLKA_INTERGALACTICA 	= 4, TRAP_ESPACIAL = 5;
 public static final int MINIMA = 10, MAXIMA 	= 100;

 //constructor valores aleatorios (genero aleatorio, nivel 1, energia entre 10-100, seguidores 0, instrumentos vacio, en gira false)
 public Artista(){
     this.nombreArtistico = nombreArtistico;
     this.generoMusical = (int) (Math.random() * 5) + 1;
     this.nivel = 1;
     this.energia = (int) (Math.random() * (10 - 100 + 1)) + 10;
     this.seguidores = 0;
     this.instrumentos = null;
     this.enGira = false;
 }

 //constructor con parametros
 public Artista(String nombreArtistico, int generoMusical, int nivel, int energia, int seguidores, ArrayList<Instrumento> instrumentos, boolean enGira){
     this.nombreArtistico = nombreArtistico;
     this.generoMusical = generoMusical;
     this.nivel = nivel;
     this.energia = energia;
     this.seguidores = seguidores;
     this.instrumentos = instrumentos;
     this.enGira = enGira;
 }
}
