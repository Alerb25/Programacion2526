public class conexion {
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
        
}
