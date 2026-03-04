// HadaMadrinaDAO.java
import java.util.*;
import java.sql.*;

public class HadaMadrinaDAO extends CrudModel {

    public HadaMadrinaDAO() {
        super(
            "hadaMadrina",  
            "id_Hada",
            List.of(
                "nombre",
                "apodoGuerra",
                "edad",
                "envergaduraAlas", 
                "nivelPasivoAgresivo",
                "polvoPurpurina"
            )
        );
    }

    //  Devuelve DO en vez de Map
    @Override
    public List<HadaMadrinaDO> filtrar(String campo, Object valor) throws SQLException {
        String sql = "SELECT * FROM hadaMadrina WHERE " + campo + " = ?";
        List<Map<String, Object>> rows = executeQuery(sql, valor);
        List<HadaMadrinaDO> resultado = new ArrayList<>();
        for (Map<String, Object> row : rows) resultado.add(mapHada(row));
        return resultado;
    }

    //  Devuelve DO en vez de Map
    @Override
    public List<HadaMadrinaDO> buscar(String campo, String comparador, String texto)
            throws SQLException {

        List<String> validos = List.of(">", "<", ">=", "<=", "!=", "like");
        if (!validos.contains(comparador.toLowerCase()))
            throw new IllegalArgumentException("Comparador no permitido");

        String sql;
        if (comparador.equalsIgnoreCase("like")) {
            sql = "SELECT * FROM hadaMadrina WHERE " + campo + " LIKE ?";
            List<Map<String, Object>> rows = executeQuery(sql, "%" + texto + "%");
            List<HadaMadrinaDO> resultado = new ArrayList<>();
            for (Map<String, Object> row : rows) resultado.add(mapHada(row));
            return resultado;
        } else {
            sql = "SELECT * FROM hadaMadrina WHERE " + campo + " " + comparador + " ?";
            List<Map<String, Object>> rows = executeQuery(sql, texto);
            List<HadaMadrinaDO> resultado = new ArrayList<>();
            for (Map<String, Object> row : rows) resultado.add(mapHada(row));
            return resultado;
        }
    }

   
    public ArrayList<DuendeCombateDO> cargarDuendes(int idHada) throws SQLException {
        String sql = "SELECT * FROM duendeCombate WHERE idHada = ?";
        List<Map<String, Object>> rows = executeQuery(sql, idHada);
        ArrayList<DuendeCombateDO> resultado = new ArrayList<>();

        DuendeCombateDAO duendeDAO = new DuendeCombateDAO(); 
        for (Map<String, Object> row : rows) {
            resultado.add(duendeDAO.mapDuende(row));
        }
        return resultado;
    }

    
    public double calcularPolvoPurpurinaTotal() throws SQLException {
        String sql = "SELECT * FROM hadaMadrina";
        List<Map<String, Object>> rows = executeQuery(sql);
        double total = 0;

        for (Map<String, Object> row : rows) {
            int nivel = ((Number) row.get("nivelPasivoAgresivo")).intValue();
            if (nivel > 3) {
                total += ((Number) row.get("polvoPurpurina")).doubleValue();
            }
        }
        return total;
    }

  
    public HadaMadrinaDO obtenerHadaMasVeterana() throws SQLException {
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

    
    public ArrayList<HadaMadrinaDO> cargarHadasConAlasPequennas(double envergaduraMaxima)
            throws SQLException {

        String sql = "SELECT * FROM hadaMadrina";
        List<Map<String, Object>> rows = executeQuery(sql);
        ArrayList<HadaMadrinaDO> resultado = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            double envergadura = ((Number) row.get("envergaduraAlas")).doubleValue();
            if (envergadura < envergaduraMaxima)
                resultado.add(mapHada(row));
        }
        return resultado;
    }

    //   — buscar por ID
    public HadaMadrinaDO buscarPorId(int id) throws SQLException {
        Map<String, Object> row = FindById(id);
        if (row == null) return null;
        return mapHada(row);
    }

    //  Método de mapeo Map  DO — cambiado a package-private para que cargarDuendes lo use
    HadaMadrinaDO mapHada(Map<String, Object> row) {
        HadaMadrinaDO h = new HadaMadrinaDO();
        h.setIdHada((Integer) row.get("id_Hada"));
        h.setNombre((String) row.get("nombre"));
        h.setApodoGuerra((String) row.get("apodoGuerra"));
        h.setEdad(((Number) row.get("edad")).intValue());
        h.setEnvergaduraAlas(((Number) row.get("envergaduraAlas")).doubleValue());
        h.setNivelPasivoAgresivo(((Number) row.get("nivelPasivoAgresivo")).intValue());
        h.setPolvoPurpurina(((Number) row.get("polvoPurpurina")).doubleValue());
        return h;
    }
}