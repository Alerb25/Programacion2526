import java.util.List;

public class TopoCombateDAO extends CrudModel {

    public TopoCombateDAO() {
        super(
                "topoCombate",
                "id_Topo",
                List.of(
                        "nombre",
                        "apodoGuerra",
                        "edad",
                        "modelo",
                        "fuerzaExcavacion",
                        "agudezaOlfativa",
                        "horasSuenno",
                        "tiempoTierraEnOjos"

                ));

    }

    String table = "topoCombate";

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
    // Cargar topos con tierra en ojos
    public ArrayList<TopoCombateDO> cargarToposConTierraEnOjos(int idGnomo)
            throws SQLException {

        String sql = "SELECT * FROM topoCombate WHERE idGnomo = ?";
        List<Map<String, Object>> rows = executeQuery(sql, idGnomo);

        ArrayList<TopoCombateDO> resultado = new ArrayList<>();

        for (Map<String, Object> row : rows) {

            int tiempo = ((Number) row.get("tiempoTierraEnOjos")).intValue();

            if (tiempo > 0) { // FILTRADO EN JAVA
                resultado.add(mapToDO(row));
            }
        }

        return resultado;
    }

    // cargar topos descansados
    public ArrayList<TopoCombateDO> cargarToposDescansados()
            throws SQLException {

        String sql = "SELECT * FROM topoCombate";
        List<Map<String, Object>> rows = executeQuery(sql);

        ArrayList<TopoCombateDO> resultado = new ArrayList<>();

        for (Map<String, Object> row : rows) {

            int horas = ((Number) row.get("horasSuenno")).intValue();

            if (horas >= 8) { // FILTRO EN JAVA
                resultado.add(mapToDO(row));
            }
        }

        return resultado;
    }

    // calcular promedio fuerza excavacion
    public double calcularPromedioFuerzaExcavacion(int idGnomo)
            throws SQLException {

        String sql = "SELECT * FROM topoCombate WHERE idGnomo = ?";
        List<Map<String, Object>> rows = executeQuery(sql, idGnomo);

        double suma = 0;
        int contador = 0;

        for (Map<String, Object> row : rows) {

            double fuerza = ((Number) row.get("fuerzaExcavacion")).doubleValue();

            suma += fuerza;
            contador++;
        }

        if (contador == 0)
            return 0;

        return suma / contador;
    }

    // cargar topos paginado
    public ArrayList<TopoCombateDO> cargarToposPaginado(int numElem, int numPag)
            throws SQLException {

        int offset = (numPag - 1) * numElem;

        String sql = "SELECT * FROM topoCombate LIMIT ? OFFSET ?";

        List<Map<String, Object>> rows = executeQuery(sql, numElem, offset);

        ArrayList<TopoCombateDO> resultado = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            resultado.add(mapToDO(row));
        }

        return resultado;
    }
}