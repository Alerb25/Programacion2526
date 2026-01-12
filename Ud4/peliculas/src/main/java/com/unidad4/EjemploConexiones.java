package com.unidad4;

import java.sql.Connection;
import java.sql.DriverManager;

public class EjemploConexiones {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jbdc:mysql://localhost:3306/mydb", "mydbuser", "mydbuser");
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
