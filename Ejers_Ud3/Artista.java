public class Artista {
    private String nombreArtistico;
    private int generoMusical;
    private int nivel; // nivel de fama
    private int energia; // de 0 a 100
    private int seguidores;
    private ArrayList<Instrumento> instrumentos;
    boolean enGira;

    public static final int DEATH_METAL_COSMICO = 1, REGGAETON_MARCIANO = 2, JAZZ_CUANTICO = 3,
            POLKA_INTERGALACTICA = 4, TRAP_ESPACIAL = 5;
    public static final int MINIMA = 10, MAXIMA = 100;

    // constructor valores aleatorios (genero aleatorio, nivel 1, energia entre
    // 10-100, seguidores 0, instrumentos vacio, en gira false)
    public Artista() {
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = (int) (Math.random() * 5) + 1;
        this.nivel = 1;
        this.energia = (int) (Math.random() * (10 - 100 + 1)) + 10;
        this.seguidores = 0;
        this.instrumentos = null;
        this.enGira = false;
    }

    // constructor con parametros
    public Artista(String nombreArtistico, int generoMusical, int nivel, int energia, int seguidores,
            ArrayList<Instrumento> instrumentos, boolean enGira) {
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.nivel = nivel;
        this.energia = energia;
        this.seguidores = seguidores;
        this.instrumentos = instrumentos;
        this.enGira = enGira;
    }

    // setters
    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public void setGeneroMusical(int generoMusical) {
        this.generoMusical = generoMusical;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setEnergia(int energia) {
        if (energia >= 0) {
            this.energia = energia;
        }
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public void setInstrumentos(ArrayList<Instrumento> instrumentos) {
        this.instrumentos = instrumentos;
    }

    public void setEnGira(boolean enGira) {
        this.enGira = enGira;
    }

    // getters
    public String getNombreArtistico() {
        return this.nombreArtistico;
    }

    public int getGeneroMusical() {
        return this.generoMusical;
    }

    public int getNivel() {
        return this.nivel;
    }

    public int getEnergia() {
        return this.energia;
    }

    public int getSeguidores() {
        return this.seguidores;
    }

    public ArrayList<Instrumento> getInstrumentos() {
        return this.instrumentos;
    }

    public boolean getEnGira() {
        return this.enGira;
    }

    // metodo tocar instrumento
    public boolean tocarInstrumento(Instrumento i) {
        if (i.compatibilidad == true || i.getEnUso == false) {
            // la energia por encima de 20 sino no puede tocar
            if (energia >= 20) {
                // se añade el instrumento
                instrumentos.add();
                // se pone en true el uso
                instrumento.setEnUso(true);
                return true;
            }

        } else {
            return false;
        }
    }

    // metodo dejarInstrumento
    public Instrumento dejarInstrumento(String nombreInstrumento) {

        // Buscar el instrumento en la lista
        for (int i = 0; i < instrumentos.size(); i++) {
            Instrumento inst = instrumentos.get(i);

            // Si encuentra uno con ese nombre
            if (inst.getNombre().equals(nombreInstrumento)) {
                // Marcarlo como no en uso
                inst.setEnUso(false);

                // Eliminarlo de la lista
                instrumentos.remove(i);

                // Recuperar 10 de energía (sin pasarse de 100)
                this.energia = Math.min(this.energia + 10, 100);

                // Devolverlo
                return inst;
            }
        }

        return null;
    }

    // Método subirFama
    public void subirFama() {
        this.nivel++;
        this.energia = Math.min(this.energia + 20, MAXIMA);
        this.seguidores += 1000;
    }

    // Método darConcierto
    public void darConcierto(int asistentes) {
        // Sumar seguidores
        this.seguidores += (asistentes / 10);

        // Restar energía
        this.energia -= 30;

        // Si tiene suficientes seguidores, sube de fama
        if (this.seguidores >= 10000) {
            subirFama();
        }
    }

    // Método obtenerInstrumentosMarcianos
    public ArrayList<Instrumento> obtenerInstrumentosMarcianos() {
        return instrumentos.stream()
                .filter(inst -> inst.getRareza() == Instrumento.ENCONTRADO_EN_MARTE)
                .collect(Collectors.toList());
    }

    // Método calcularPoderEscenico
    public int calcularPoderEscenico() {
        // Sumar el volumen de todos los instrumentos usando streams
        int volumenTotal = instrumentos.stream()
                .mapToInt(inst -> inst.getVolumen())
                .sum();

        // Calcular el poder escénico
        return volumenTotal + (this.nivel * 50) + (this.energia * 2);
    }

}
