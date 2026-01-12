package com.unidad4;

public class EjemploConexiones {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("No tenemos el driver");
        }
    }
}
