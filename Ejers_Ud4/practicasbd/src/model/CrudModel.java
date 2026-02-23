package com.practicasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public abstract class CrudModel {

    private Connection con;
    private String table;
    private List<String> columns;

    public CrudModel() {
        conectar();
    }

    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Al crear el dotenv cargamos todas las variables
            Dotenv dotenv = Dotenv.load();

            // Asigno las variables desde el fichero .env
            String host = dotenv.get("DB_HOST");
            String port = dotenv.get("DB_PORT");
            String dbName = dotenv.get("DB_NAME");
            String user = dotenv.get("DB_USER");
            String password = dotenv.get("DB_PASSWORD");

            // Creamos la url de conexion con el formato para mysql
            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

            con = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM ";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("No tenemos el driver instalado");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }
    }

    // METODOS IMPLEMENTADOS
    // Insertar Registro, devuelve ID
    public int insert(Map<String, Object> data) {
        ResultSet rs = null;
        Map registro = null;
        try {

            StringBuilder sql = new StringBuilder("INSERT INTO " + table + " (");
            StringBuilder values = new StringBuilder(" VALUES (");

            boolean first = true;
            for (String column : columns) {
                if (data.containsKey(column)) {
                    if (!first) {
                        sql.append(", ");
                        values.append(", ");
                    }
                    sql.append(column);
                    values.append("?");
                    first = false;
                }
            }

            sql.append(")");
            values.append(")");
            sql.append(values);

            PreparedStatement stmt = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            int index = 1;
            for (String column : columns) {
                if (data.containsKey(column)) {
                    stmt.setObject(index++, data.get(column));
                }
            }

            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();
            return rs.next() ? rs.getInt(1) : -1;

        } catch (ClassNotFoundException e) {
            System.out.println("No tenemos el driver instalado");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

    }

    // FIND BY ID
    public Map<String, Object> FindById(Object id) {
        ResultSet rs = null;
        Map registro = null;

        try {

            String sql = "SELECT * FROM " + table + " WHERE " + primaryKey + " = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setObject(1, id);

            rs = stmt.executeQuery();
            if (!rs.next())
                return null;

            registro = new HashMap<>();
            registro.put(primaryKey, rs.getObject(primaryKey));

            for (String column : columns) {
                registro.put(column, rs.getObject(column));
            }

            return registro;

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

    }

    // FIND ALL
    public List<Map<String, object>> FindAll() {
        ResultSet rs = null;
        Map listado = null;
        try {
            List<Map<String, Object>> lista = new ArrayList<>();
            String sql = "SELECT * FROM " + table;

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, Object> registro = new HashMap<>();
                registro.put(primaryKey, rs.getObject(primaryKey));
                for (String column : columns) {
                    registro.put(column, rs.getObject(column));
                }
                lista.add(registro);
            }
            return lista;

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

    }

    // Actualizar Registros
    public boolean update(Object id, Map<String, Object> data) {
        ResultSet rs = null;
        try {

            String query = "update proyecto set ";
            boolean primero = true;
            for (Map.Entry<String, String> column : columns.entrySet()) {
                if (primero) {
                    primero = false;
                } else {
                    query += ",";
                }
                query += column.getKey() + "=?";

                PreparedStatement stmt = con.prepareStatement(query);
                // Rellenamos los huecos
                int posicion = 1;
                for (Map.Entry<String, String> columEntry : columns.entrySet()) {
                    // Según el campo, seteamos como String o como Int
                    if (column.getKey().equals("") || campo.getKey().equals("")) {
                        stmt.setString(posicion, column.getValue());
                    } else {
                        stmt.setInt(posicion, Integer.valueOf(colun.getValue()));
                    }
                    posicion++;
                }

                stmt.setInt(posicion, id);
                rs = stmt.executeUpdate();

            }

        } catch (ClassNotFoundException e) {
            System.out.println("No tenemos el driver instalado");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }
        return rs;
    }

    // Eliminar por ID
    public boolean delete(Object id) {
        ResultSet rs = null;
        try {

            String sql = "DELETE FROM " + table + " WHERE " + primaryKey + " = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setObject(1, id);

            return stmt.executeUpdate() > 0;

        } catch (ClassNotFoundException e) {
            System.out.println("No tenemos el driver instalado");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

    }

    // Paginación
    public List<Map<String, Object>> findAll(int page, int size) {
        ResultSet rs = null;
        try {
            // Formula del offset
            int offset = (page - 1) * size;

            // Limit = cuantos mostramos || desde cual empezamos
            String sql = "SELECT * FROM " + table + " LIMIT ? OFFSET ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            // Rellenar los huecos
            stmt.setInt(1, size);
            stmt.setInt(2, offset);

            rs = stmt.executeQuery();
            List<Map<String, Object>> lista = new ArrayList<>();

            // Creamos la lista de manera que siga las instrucciones del numero de pagina y
            // el tamaño
            while (rs.next()) {
                Map<String, Object> registro = new HashMap<>();
                registro.put(primaryKey, rs.getObject(primaryKey));
                for (String column : columns) {
                    registro.put(column, rs.getObject(column));
                }
                lista.add(registro);
            }
            return lista;

        } catch (ClassNotFoundException e) {
            System.out.println("No tenemos el driver instalado");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

    }

    // Contar Registros
    public int count() {
        String sql = "SELECT COUNT(*) FROM " + table;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        return rs.getInt(1);
    }

    // METODOS ABSTRACTOS
    // Filtrado simple
    public abstract List<Map<String, Object>> filtrar(String campo, Object valor) throws SQLException;

    // Buscar con comparador: > < >= <= != like
    public abstract List<Map<String, Object>> buscar(
            String campo,
            String comparador,
            String texto) throws SQLException;

    // METODO AUXILIAR protegido
    protected List<Map<String, Object>> executeQuery(String sql, Object... params) throws SQLException {

        PreparedStatement stmt = con.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }

        ResultSet rs = stmt.executeQuery();
        List<Map<String, Object>> lista = new ArrayList<>();

        while (rs.next()) {
            Map<String, Object> registro = new HashMap<>();
            registro.put(primaryKey, rs.getObject(primaryKey));

            for (String column : columns) {
                registro.put(column, rs.getObject(column));
            }
            lista.add(registro);
        }

        return lista;
    }
}
