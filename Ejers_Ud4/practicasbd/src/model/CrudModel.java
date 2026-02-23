package com.practicasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class CrudModel {

    private Connection con;
    private String table;
    private List<String> columns;

    public CrudModel() {
        conectar();
    }

    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/tu_base";
            String user = "root";
            String password = "1234";

            con = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM proyecto";

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


        } catch (ClassNotFoundException e) {
            System.out.println("No tenemos el driver instalado");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }
        return rs;
    }

    // FIND BY ID
    public Map<String, Object> FindById(Object id) {
        ResultSet rs = null;
        Map registro = null;

        try {
            // Creamos la consulta sql
            String query = "select * from " + table + " where id = ?";

            // Creamos la sentencia
            PreparedStatement stmt = this.con.prepareStatement(query);

            stmt.setObject(1, id);

            // Ejecutamos y guardamos los datos en un resultset
            rs = stmt.executeQuery();

            registro = new HashMap<String, Object>();
            for (String column : columns) {
                registro.put(column, rs.getObject(column));
            }

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return registro;
    }

    // FIND ALL
    public List<Map<String, object>> FindAll() {
        ResultSet rs = null;
        Map listado = null;
        try {
            // Creamos la consulta sql
            String query = "select * from " + table;

            // Creamos la sentencia
            PreparedStatement stmt = this.con.prepareStatement(query);

            // Ejecutamos y guardamos los datos en un resultset
            rs = stmt.executeQuery();

            listado = new HashMap<String, Object>();
            for (String column : columns) {
                registro.put(column, rs.getObject(column));
            }

        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }

        return rs;
    }

    // Actualizar Registros
    public boolean update(Object id, Map<String, Object> data) {
        ResultSet rs = null;
        try {

            String query = "update proyecto set ";
            boolean primero = true;
            for (Map.Entry<String, String> column : columns.entrySet()){
                if (primero){
                    primero = false;
                }else {
                    query += ",";
                }
                query += column.getKey() + "=?";

                PreparedStatement stmt = con.prepareStatement(query);
                //Rellenamos los huecos
                int posicion  = 1;
            for (Map.Entry<String, String> columEntry : columns.entrySet()) {
            // Según el campo, seteamos como String o como Int
            if (column.getKey().equals("") || campo.getKey().equals("")) {
                stmt.setString(posicion, column.getValue());
            } else {
                stmt.setInt(posicion, Integer.valueOf(colun.getValue()));
            }
            posicion++;
        }
        
            stmt.setInt(posicion, posicion);

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

            String query = "delete from proyecto  where id = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);

            rs = stmt.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("No tenemos el driver instalado");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }
        return rs;
    }

    // Paginación
    public List<Map<String, Object>> findAll(int page, int size) {
        ResultSet rs = null;
        try {
            //Formula del offset
            int offset = (page - 1) * size;
            String query = "select * from proyecto";
            //Limit = cuantos mostramos ||  desde cual empezamos 
            query += " LIMIT " + size + " OFFSET " + offset;

            Statement stmt = this.con.createStatement();
            rs = stmt.executeQuery(query);



        } catch (ClassNotFoundException e) {
            System.out.println("No tenemos el driver instalado");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }
        return rs;
    }

    

    // Contar Registros
    public int count() {

    }

    // METODOS ABSTRACTOS
    // Filtrado simple

    // Buscar

    // METODO AUXILIAR protegido
    private List<Map<String, Object>> buscar(String campo, String comparador, String texto) {

    }
}
