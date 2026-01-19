//ALEJANDRA RUIZ BERMUDEZ
package ExamenUd3;

import java.util.*;

public class ExposicionRetro {
    // -------PT1------
    // Atributos
    private String idExposicion;
    public String nombreEvento;
    private ArrayList<JuegoRetro> juegosExhibidos;
    private String localizacion;
    private int entradasVendidas;
    private double precioEntrada;
    private boolean esCompetitivo;

    // Constructores
    // Constructor Vacio
    public ExposicionRetro() {
        this.idExposicion = "" + ((int) Math.random() * 9999) + 1000;
        this.entradasVendidas = ((int) Math.random() * 5000);
        this.precioEntrada = Math.random() * 50.00 + 10.00;
        this.juegosExhibidos = new ArrayList<JuegoRetro>();
        // creammos 10 juegos aleatorios y los metemos en el array
        for (int i = 0; i < 10; i++) {
            JuegoRetro juego = new JuegoRetro();
            juegosExhibidos.add(juego);
        }
    }

    // constructor Completo
    public ExposicionRetro(String idExposicion, String nombreEvento, ArrayList<JuegoRetro> juegosExhibidos,
            String localizacion, int entradasVendidasdouble, double precioEntrada, boolean esCompetitivo) {
        this.idExposicion = idExposicion;
        this.entradasVendidas = entradasVendidas;
        this.precioEntrada = precioEntrada;
        this.esCompetitivo = esCompetitivo;
        this.localizacion = localizacion;
        this.nombreEvento = nombreEvento;
        this.juegosExhibidos = juegosExhibidos;
    }

    // get y set (pone para todos asi que aunque el nombre sea publico tambien lo añado)
    public String getIdExposicion() {
        return idExposicion;
    }

    public void setIdExposicion(String idExposicion) {
        this.idExposicion = idExposicion;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public int getEntradasVendidas() {
        return entradasVendidas;
    }

    public void setEntradasVendidas(int entradasVendidas) {
        this.entradasVendidas = entradasVendidas;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public ArrayList<JuegoRetro> getJuegosExhibidos() {
        return juegosExhibidos;
    }

    public void setJuegosExhibidos(ArrayList<JuegoRetro> juegosExhibidos) {
        this.juegosExhibidos = juegosExhibidos;
    }

    public boolean getEsCompetitivo() {
        return esCompetitivo;
    }

    public void setEsCompetitivo(boolean esCompetitivo) {
        this.esCompetitivo = esCompetitivo;
    }

    // -------PT2------
    // Funciones (cada una tiene la letra que es pero ademas estan en orden)

    // A) metodo Calcular valor total 
    public double calcularValorTotal() {
        double total = 0;
        for (int i = 0; i < juegosExhibidos.size(); i++) {
            total+= juegosExhibidos.get(i).getPrecioActual();
            
        }

        if (total > 0) {
            return total;
        } else {
            return 0.0;
        }

    }

    // B) Buscar juegos por consola y rango NO TERMINADO
    public List<JuegoRetro> buscarJuegosPorConsolaYRango(String consola, double minPuntuacion, double maxPuntuacion) {

        return juegosExhibidos.stream().filter(c -> c.getConsola().equals(consola))
                .filter(b -> b.getPuntuacionCritica() >= minPuntuacion)
                .filter(a -> a.getPuntuacionCritica() <= maxPuntuacion).toList();

    }

    // C) cantidad de juegos baratos
    public int cantidadJuegosBaratos(String consola) {

        return (int) juegosExhibidos.stream().filter(c -> c.getConsola() == consola)
                .filter(b -> b.getPrecioActual() < 10.0).count();

    }

    // D) eliminar por tipo
    public int eliminarJuegosPorTipo(int tipoEliminar) {
        int contador = 0;
        Iterator<JuegoRetro> it = juegosExhibidos.iterator();
        while (it.hasNext()) {
            JuegoRetro juego = it.next();
            if (juego.getTipo() == tipoEliminar) {
                it.remove();
                contador++;
            }

        }
        return contador;
    }

    // E) Juego Retro mejor valorado
    public JuegoRetro juegoMejorValoracionConCaracteristicas(String caracteristicaBuscada) {
        JuegoRetro juegoMejorValorado = this.juegosExhibidos.stream()
                .filter(c -> c.getCaracteristicasEspeciales().toString().equals(caracteristicaBuscada))
                .max(Comparator.comparingDouble(JuegoRetro::getPuntuacionCritica)).orElse(null);
        return juegoMejorValorado;
    }

}
