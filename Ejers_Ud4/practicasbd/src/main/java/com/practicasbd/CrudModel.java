package com.practicasbd;

import java.sql.*;

import io.github.cdimascio.dotenv.Dotenv;

public class CrudModel {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
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

            

        } catch (ClassNotFoundException ce) {
            System.out.println("Error bd");
            ce.printStackTrace();
        }

    }
}