package com.practicasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

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
}
