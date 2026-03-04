public class DuendeCombateDAO extends CrudModel {

    public DuendeCombateDAO() {
        super(
            "duendeCombate",
            "id_Duende",
            List.of(
                "nombre",
                "apodoGuerra",
                "modelo",
                "agilidad",
                "nivelSarcasmo",
                "horasSombra",
                "tiempoBrilloCegador"
            )
        );
    }

     
        
       @Override
    public List<DuendeCombateDO> filtrar(String campo, Object valor) throws SQLException {
        String sql = "SELECT * FROM duendeCombate WHERE " + campo + " = ?";
        List<Map<String, Object>> rows = executeQuery(sql, valor);

        List<DuendeCombateDO> resultado = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            resultado.add(mapDuende(row));
        }
        return resultado;
    }

    //  Buscar — devuelve lista de DO en vez de lista de Map
    @Override
    public List<DuendeCombateDO> buscar(String campo, String comparador, String texto)
            throws SQLException {

        List<String> validos = List.of(">", "<", ">=", "<=", "!=", "like");
        if (!validos.contains(comparador.toLowerCase())) {
            throw new IllegalArgumentException("Comparador no permitido");
        }

        String sql;
        List<Map<String, Object>> rows;

        if (comparador.equalsIgnoreCase("like")) {
            sql = "SELECT * FROM duendeCombate WHERE " + campo + " LIKE ?";
            rows = executeQuery(sql, "%" + texto + "%");
        } else {
            sql = "SELECT * FROM duendeCombate WHERE " + campo + " " + comparador + " ?";
            rows = executeQuery(sql, texto);
        }

        List<DuendeCombateDO> resultado = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            resultado.add(mapDuende(row));
        }
        return resultado;
    }

    //  — buscar por ID devolviendo DO
    public DuendeCombateDO buscarPorId(int id) throws SQLException {
        Map<String, Object> row = FindById(id);
        if (row == null) return null;
        return mapDuende(row);
    }

    //  — listar todos devolviendo lista de DO
    public List<DuendeCombateDO> listarTodos() throws SQLException {
        List<Map<String, Object>> rows = FindAll();
        List<DuendeCombateDO> resultado = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            resultado.add(mapDuende(row));
        }
        return resultado;
    }

    //  — método privado que convierte Map → DO
    private DuendeCombateDO mapDuende(Map<String, Object> row) {
        DuendeCombateDO d = new DuendeCombateDO();
        d.setIdDuende((Integer) row.get("id_Duende"));
        d.setNombre((String) row.get("nombre"));
        d.setApodoGuerra((String) row.get("apodoGuerra"));
        d.setModelo((String) row.get("modelo"));
        d.setAgilidad((Integer) row.get("agilidad"));
        d.setNivelSarcasmo((Integer) row.get("nivelSarcasmo"));
        d.setHorasSombra((Double) row.get("horasSombra"));
        d.setTiempoBrilloCegador((Double) row.get("tiempoBrilloCegador"));
        return d;
    }

}