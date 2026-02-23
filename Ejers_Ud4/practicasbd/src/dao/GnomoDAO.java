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
                "energiaRefunfunno"
            )
        );
    }

      //cambiar la tabla porque sino vamos mal
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

    //FUNCIONES ADICIONALES
    //Devuelve una lista de topos liderados por el gnomo del id
    public ArrayList<TopoCombateDO>cargarTopos(int id_Gnomo){

    }

    //Devuelve la suma de energia de refunfuño de todos los gnomos con nivel cascarrabias > 5
    //HAY QUE UTILIZAR UN BUCLE PARA RECORRER Y SUMAR O USAR SQL
    public int calcularEnergiaRefunfunnoTotal(){
        int total = 0;

        return total;
    }

    //Devuelve el gnomo con mayor nivel de cascarrabias (USAR BUCLE EN JAVA)
    public GnomoDAO obtenerGnomoMasCascarrabias(){

    }

    //Genera un informe usando stringBuilder
}