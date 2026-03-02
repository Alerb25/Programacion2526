import java.util.List;

public class HadaMadrinaDAO extends CrudModel {

    public HadaMadrinaDAO() {
        super(
                "hadaMadruba",
                "id_Hada",
                List.of(
                        "nombre",
                        "apodoGuerra",
                        "edad",
                        "envergaduraAlasa",
                        "nivelPasivoAgresivo",
                        "polvoPurpurina"

                ));

    }

    String table = "hadaMadrina";

    @Override
    public List<Map<String, Object>> filtrar(String campo, Object valor) throws SQLException {

        String sql = "SELECT * FROM " + table + " WHERE " + campo + " = ?";
        return executeQuery(sql, valor);
    }

    @Override
    public List<Map<String, Object>> buscar(String campo, String comparador, String texto)
            throws SQLException {

        List<String> validos = List.of(">", "<", ">=", "<=", "!=", "like");
        if (!validos.contains(comparador.toLowerCase())) {
            throw new IllegalArgumentException("Comparador no permitido");
        }

        if (comparador.equalsIgnoreCase("like")) {
            String sql = "SELECT * FROM " + table + " WHERE " + campo + " LIKE ?";
            return executeQuery(sql, "%" + texto + "%");
        } else {
            String sql = "SELECT * FROM " + table + " WHERE " + campo + " "
                    + comparador + " ?";
            return executeQuery(sql, texto);
        }
    }

    // FUNCIONES ADICIONALES
    // cargar duendes
    public ArrayList<DuendeCombateDO> cargarDuendes(int idHada)
            throws SQLException {

        String sql = "SELECT * FROM duendeCombate WHERE idHada = ?";

        List<Map<String, Object>> rows = executeQuery(sql, idHada);

        ArrayList<DuendeCombateDO> resultado = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            resultado.add(mapDuende(row));
        }

        return resultado;
    }

    // calcular polvo purpurina
    public double calcularPolvoPurpurinaTotal()
            throws SQLException {

        String sql = "SELECT * FROM hadaMadrina";
        List<Map<String, Object>> rows = executeQuery(sql);

        double total = 0;

        for (Map<String, Object> row : rows) {

            int nivel = ((Number) row.get("nivelPasivoAgresividad")).intValue();

            if (nivel > 3) { // FILTRO EN JAVA
                double polvo = ((Number) row.get("polvoPurpurina")).doubleValue();

                total += polvo;
            }
        }

        return total;
    }

    // obtener hada mas veterana
    public HadaMadrinaDO obtenerHadaMasVeterana()
            throws SQLException {

        String sql = "SELECT * FROM hadaMadrina";
        List<Map<String, Object>> rows = executeQuery(sql);

        HadaMadrinaDO masVeterana = null;
        int maxEdad = Integer.MIN_VALUE;

        for (Map<String, Object> row : rows) {

            int edad = ((Number) row.get("edad")).intValue();

            if (edad > maxEdad) {
                maxEdad = edad;
                masVeterana = mapHada(row);
            }
        }

        return masVeterana;
    }

    // hada con alas pequeñas
    public ArrayList<HadaMadrinaDO> cargarHadasConAlasPequeñas(
            double envergaduraMaxima) throws SQLException {

        // QUERY DINÁMICA
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ");
        sql.append("hadaMadrina");

        List<Map<String, Object>> rows = executeQuery(sql.toString());

        ArrayList<HadaMadrinaDO> resultado = new ArrayList<>();

        for (Map<String, Object> row : rows) {

            double envergadura = ((Number) row.get("envergaduraAlas")).doubleValue();

            if (envergadura < envergaduraMaxima) { // FILTRO JAVA
                resultado.add(mapHada(row));
            }
        }

        return resultado;
    }
}