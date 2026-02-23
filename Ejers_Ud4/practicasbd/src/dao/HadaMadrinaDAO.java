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
                
            )
        );

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
}