import java.util.*;
import java.sql.*;

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
            )
        );
    }

    //  Devuelve DO en vez de Map
    @Override
    public List<TopoCombateDO> filtrar(String campo, Object valor) throws SQLException {
        String sql = "SELECT * FROM topoCombate WHERE " + campo + " = ?";
        List<Map<String, Object>> rows = executeQuery(sql, valor);
        List<TopoCombateDO> resultado = new ArrayList<>();
        for (Map<String, Object> row : rows) resultado.add(mapToDO(row));
        return resultado;
    }

    //  Devuelve DO en vez de Map
    @Override
    public List<TopoCombateDO> buscar(String campo, String comparador, String texto)
            throws SQLException {

        List<String> validos = List.of(">", "<", ">=", "<=", "!=", "like");
        if (!validos.contains(comparador.toLowerCase()))
            throw new IllegalArgumentException("Comparador no permitido");

        String sql;
        if (comparador.equalsIgnoreCase("like")) {
            sql = "SELECT * FROM topoCombate WHERE " + campo + " LIKE ?";
            List<Map<String, Object>> rows = executeQuery(sql, "%" + texto + "%");
            List<TopoCombateDO> resultado = new ArrayList<>();
            for (Map<String, Object> row : rows) resultado.add(mapToDO(row));
            return resultado;
        } else {
            sql = "SELECT * FROM topoCombate WHERE " + campo + " " + comparador + " ?";
            List<Map<String, Object>> rows = executeQuery(sql, texto);
            List<TopoCombateDO> resultado = new ArrayList<>();
            for (Map<String, Object> row : rows) resultado.add(mapToDO(row));
            return resultado;
        }
    }

    //  Sin cambios funcionales — ya usaba mapToDO y DO correctamente
    public ArrayList<TopoCombateDO> cargarToposConTierraEnOjos(int idGnomo)
            throws SQLException {

        String sql = "SELECT * FROM topoCombate WHERE idGnomo = ?";
        List<Map<String, Object>> rows = executeQuery(sql, idGnomo);
        ArrayList<TopoCombateDO> resultado = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            int tiempo = ((Number) row.get("tiempoTierraEnOjos")).intValue();
            if (tiempo > 0)
                resultado.add(mapToDO(row));
        }
        return resultado;
    }

   
    public ArrayList<TopoCombateDO> cargarToposDescansados() throws SQLException {
        String sql = "SELECT * FROM topoCombate";
        List<Map<String, Object>> rows = executeQuery(sql);
        ArrayList<TopoCombateDO> resultado = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            int horas = ((Number) row.get("horasSuenno")).intValue();
            if (horas >= 8)
                resultado.add(mapToDO(row));
        }
        return resultado;
    }

   
    public double calcularPromedioFuerzaExcavacion(int idGnomo) throws SQLException {
        String sql = "SELECT * FROM topoCombate WHERE idGnomo = ?";
        List<Map<String, Object>> rows = executeQuery(sql, idGnomo);

        double suma = 0;
        int contador = 0;

        for (Map<String, Object> row : rows) {
            suma += ((Number) row.get("fuerzaExcavacion")).doubleValue();
            contador++;
        }

        return contador == 0 ? 0 : suma / contador;
    }

   
    public ArrayList<TopoCombateDO> cargarToposPaginado(int numElem, int numPag)
            throws SQLException {

        int offset = (numPag - 1) * numElem;
        String sql = "SELECT * FROM topoCombate LIMIT ? OFFSET ?";
        List<Map<String, Object>> rows = executeQuery(sql, numElem, offset);
        ArrayList<TopoCombateDO> resultado = new ArrayList<>();

        for (Map<String, Object> row : rows) resultado.add(mapToDO(row));
        return resultado;
    }

    //   — buscar por ID
    public TopoCombateDO buscarPorId(int id) throws SQLException {
        Map<String, Object> row = FindById(id);
        if (row == null) return null;
        return mapToDO(row);
    }

    //  Método privado de mapeo Map DO
    private TopoCombateDO mapToDO(Map<String, Object> row) {
        TopoCombateDO t = new TopoCombateDO();
        t.setIdTopo((Integer) row.get("id_Topo"));
        t.setNombre((String) row.get("nombre"));
        t.setApodoGuerra((String) row.get("apodoGuerra"));
        t.setEdad(((Number) row.get("edad")).intValue());
        t.setModelo((String) row.get("modelo"));
        t.setFuerzaExcavacion(((Number) row.get("fuerzaExcavacion")).doubleValue());
        t.setAgudezaOlfativa(((Number) row.get("agudezaOlfativa")).doubleValue());
        t.setHorasSuenno(((Number) row.get("horasSuenno")).intValue());
        t.setTiempoTierraEnOjos(((Number) row.get("tiempoTierraEnOjos")).intValue());
        return t;
    }
}