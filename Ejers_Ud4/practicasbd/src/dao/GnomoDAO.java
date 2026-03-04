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

        String sql;
        List<Map<String, Object>> rows;

        if (comparador.equalsIgnoreCase("like")) {
            sql = "SELECT * FROM " + table + " WHERE " + campo + " LIKE ?";
            rows = executeQuery(sql, "%" + texto + "%");
        } else {
            sql = "SELECT * FROM " + table + " WHERE " + campo + " "
                    + comparador + " ?";
            rows = executeQuery(sql, texto);
        }

        List<GnomoDO>resultado = new ArrayList<>();
        for (Map<String, Object> row : rows ){
            resultado.add(mapGnomo(row));
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
    public int calcularEnergiaRefunfunnoTotal() { // TO DO:  VIDEO
        String sql = "SELECT SUM(energiaRefunfunno) FROM gnomo WHERE nivelCascarrabias > ?";

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, 5);

        ResultSet rs = ps.executeQuery(); // se ejecuta sql

       return rs;
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

        //  — método privado que convierte Map → DO
    private GnomoDO mapGnomo(Map<String, Object> row) {
        GnomoDO g = new GnomoDO();
        d.setIdGnomo((Integer) row.get("id_Gnomo"));
        d.setNombre((String) row.get("nombre"));
        d.setApodoGuerra((String) row.get("apodoGuerra"));
        d.setEdad((int) row.get("edad"));
        d.setAlturaBarba((Integer) row.get("alturaBarba"));
        d.setNivelCascarrabias((Integer) row.get("nivelCascarrabias"));
        d.setEnergiaRefunfunno((int) row.get("energiaRefunfunno"));
        return g;
    }

}