package com.unidad4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EjemploConexiones {
    public static void main(String[] args) {
        Connection connection = null; //REVISAR PQ FALLA LA CONEXION
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jbdc:mysql://localhost:3306/peliculas_marcadiz", "root", "toor");
            
                //Crear Consulta
            String query = "Select * from pelicula";
                //Crear la Sentencia
            Statement stmt = connection.createStatement();
                //Ejecutarla y guardarla
            ResultSet rs = stmt.executeQuery(query);

            connection.close();
        }catch(ClassNotFoundException ce){
            System.out.println("Error bd");
            ce.printStackTrace();
        }
         catch (Exception e) {
            // TODO: handle exception
            System.out.println("No tenemos el driver");
            e.printStackTrace();
        }
    }
}
