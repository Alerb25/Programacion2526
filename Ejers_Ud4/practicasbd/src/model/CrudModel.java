package com.practicasbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.github.cdimascio.dotenv.Dotenv;

public class CrudModel {
    public static void main(String[] args) throws SQLException {

        try {
            Connection con = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            // Creamos la consulta sql
            //REVISAR COMO PROTEGER LOS DATOS 
            String query = "select * from proyecto";

            // Creamos la sentencia
            Statement stmt = con.createStatement();

            // Ejecutamos y guardamos los datos en un resultset
            ResultSet rs = stmt.executeQuery(query);

            con.close();
        } catch (ClassNotFoundException ce) {
            System.out.println("No tenemos el driver de conexion a bd instalado");
            ce.printStackTrace();
        } catch (Exception e) {
            System.out.println("Hubo un problema con la BD");
            e.printStackTrace();
        }
    }

}
