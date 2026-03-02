import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GnomoDAO extends CrudModel {

    public GnomoDAO() {
        super(
                "gnomo",
                "id_Gnomo",
                List.of(
                        "nombre",
                        "apodoGuerra",
                        "edad",
                        "alturaBarba",
                        "nivelCascarrabias",
                        "energiaRefunfunno"));
    }

    // cambiar la tabla porque sino vamos mal
    String table = "gnomo";

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
    // Devuelve una lista de topos liderados por el gnomo del id
    public ArrayList<TopoCombateDO> cargarTopos(int id_Gnomo) {
        String sql = "SELECT * FROM topoCombate WHERE fk_Gnomo = ?";
        ArrayList<String> topos = new ArrayList<>();

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, id_Gnomo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String apartado = rs.getString("fk_Gnomo");
            lista.add(apartado);
        }

        for (String topo : topos) {
            System.out.println(topo);
        }

    }

    // Devuelve la suma de energia de refunfuño de todos los gnomos con nivel
    // cascarrabias > 5
    // HAY QUE UTILIZAR UN BUCLE PARA RECORRER Y SUMAR O USAR SQL
    public int calcularEnergiaRefunfunnoTotal() {
        int total = 0;
        int sumaTotal = 0;
        String sql = "SELECT COUNT(*) FROM gnomo WHERE nivelCascarrabias > ?";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, 5);

        ResultSet rs = ps.executeQuery(); // se ejecuta sql

        if (rs.next()) {
            total = rs.getInt(1); // primera columna (el COUNT)

            sumaTotal += total;
        }

        return sumaTotal;

    }

    // Devuelve el gnomo con mayor nivel de cascarrabias (USAR BUCLE EN JAVA)
    public Map<String, Object> obtenerGnomoMasCascarrabias() throws SQLException {

        List<Map<String, Object>> gnomos = findAll();

        Map<String, Object> gnomoMasCascarrabias = null;
        int maxNivel = Integer.MIN_VALUE;

        for (Map<String, Object> gnomo : gnomos) {

            int nivel = ((Number) gnomo.get("nivelCascarrabias")).intValue();

            if (nivel > maxNivel) {
                maxNivel = nivel;
                gnomoMasCascarrabias = gnomo;
            }
        }

        return gnomoMasCascarrabias;
    }

    // Genera un informe usando stringBuilder
    // Genera un informe usando StringBuilder
    public String generarInforme() throws SQLException {

        List<Map<String, Object>> gnomos = findAll();

        StringBuilder informe = new StringBuilder();

        informe.append("===== INFORME DE GNOMOS =====\n");

        for (Map<String, Object> gnomo : gnomos) {

            informe.append("Nombre: ")
                    .append(gnomo.get("nombre"))
                    .append("\n");

            informe.append("Edad: ")
                    .append(gnomo.get("edad"))
                    .append("\n");

            informe.append("Nivel Cascarrabias: ")
                    .append(gnomo.get("nivelCascarrabias"))
                    .append("\n");

            informe.append("----------------------------\n");
        }

        informe.append("Total gnomos: ")
                .append(gnomos.size());

        return informe.toString();
    }

}