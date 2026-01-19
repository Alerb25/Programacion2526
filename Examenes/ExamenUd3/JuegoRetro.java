//ALEJANDRA RUIZ BERMUDEZ
package ExamenUd3;

import java.util.*;

public class JuegoRetro {
    // ------------PT1---------
    // Atributos
    private String codigoJuego;
    public String titulo; // es publico
    private String consola;
    private int anioLanzamiento; // entre 1970-2000
    private double precioActual;
    private double puntuacionCritica; // entre 0 y 10
    private int tipo; // tiene atributos constantes
    private boolean esDigital;
    private ArrayList<String> caracteristicasEspeciales;

    // Atrbutos Estaticos
    public final static int J_PLATAFORMAS = 1;
    public final static int J_LUCHA = 2;
    public final static int J_AVENTURAS = 3;
    public final static int J_SHOOTER = 4;

    // Constructores
    // Constructor Vacio
    public JuegoRetro() {
        this.codigoJuego = "RET-" + ((int) Math.random() * 999) + 100;
        this.anioLanzamiento = ((int) Math.random() * 1999) + 1980;
        this.precioActual = Math.random() * 500.00 + 20.00;
        this.puntuacionCritica = Math.random() * 10.00 + 5.00;
        this.titulo = "";
        this.consola = "";
        this.esDigital = false;
        this.tipo = ((int) Math.random() * 4) + 1;
        this.caracteristicasEspeciales = new ArrayList<String>();
        // creammos 10 caracteristicas aleatorios y los metemos en el array
        for (int i = 0; i < 10; i++) {
            String Caracteristica = "";
            caracteristicasEspeciales.add(Caracteristica);
        }

    }

    // constructor completo
    public JuegoRetro(String titulo, String consola, int tipo, int anioLanzamiento, double precioActual,
            double puntuacionCritica, boolean esDigital, ArrayList<String> caracteristicasEspeciales) {
        this.codigoJuego = "RET-" + ((int) Math.random() * 999) + 100;
        this.titulo = titulo;
        if (anioLanzamiento >= 1970 && anioLanzamiento <= 2000) {
            this.anioLanzamiento = anioLanzamiento;
        } else {
            this.anioLanzamiento = 1970;
        }
        if (precioActual > 0.0) {
            this.precioActual = precioActual;
        } else {
            this.precioActual = 0.0;
        }
        if (puntuacionCritica > 0.00 && puntuacionCritica < 10.00) {
            this.puntuacionCritica = puntuacionCritica;
        } else {
            this.puntuacionCritica = 0.00;
        }
        this.consola = consola;
        if (tipo <= 4 && tipo >= 1) {
            this.tipo = tipo;
        } else {
            this.tipo = 1;
        }
        this.esDigital = esDigital;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }

    // metodos get y set
    public String getCodigoJuego() {
        return codigoJuego;
    }

    public void setCodigoJuego(String codigoJuego) {
        this.codigoJuego = codigoJuego;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public double getPuntuacionCritica() {
        return puntuacionCritica;
    }

    public void setPuntuacionCritica(double puntuacionCritica) {
        this.puntuacionCritica = puntuacionCritica;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean getEsDigital() {
        return esDigital;
    }

    public void setEsDigital() {
        this.esDigital = esDigital;
    }

    public ArrayList<String> getCaracteristicasEspeciales() {
        return caracteristicasEspeciales;
    }

    public void setCaracteristicasEspeciales(ArrayList<String> caracteristicasEspeciales) {
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }

    @Override
    public String toString() {
        String tipo = "";
        if (this.tipo == 1) {
            tipo = "Plataforma";
        } else if (this.tipo == 2) {
            tipo = "Lucha";
        } else if (this.tipo == 3) {
            tipo = "Aventuras";
        } else if (this.tipo == 4) {
            tipo = "Shooter";
        }

        return "Juego Retro: \n" + "<- \n" + " ** Código : " + this.codigoJuego + "\n" + "** Titulo: "
                + this.titulo + "\n" + "** Consola:" + this.consola + "\n" + "** Precio:" + this.precioActual + "\n"
                + "**Puntuacion :" + this.puntuacionCritica + "\n"
                + "** Tipo:" + tipo + "\n" + " ** Digital : " + this.esDigital + "\n" + " ** Caracteristicas : "
                + this.caracteristicasEspeciales.toString() + "\n";

    }

}
