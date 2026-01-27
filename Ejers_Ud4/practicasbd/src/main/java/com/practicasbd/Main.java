package com.practicasbd;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection con = null;
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                //TODO cambiar el modo de conectar por proteger los datos
                "jdbc:mysql://localhost:3306/proyecto", "proyecto", "proyecto");
            

            connection.close();
        }catch(ClassNotFoundException ce){
            System.out.println("Error bd");
            ce.printStackTrace();
        }

    }
}