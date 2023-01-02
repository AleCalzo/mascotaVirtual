package persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLConnection {

    final String URL = "jdbc:mysql://localhost:3306/";
    final String BD = "mascotas";
    final String USERNAME = "root";
    final String PASSWORD = "root";

    Connection connection;

    public Connection establecerConeccion (){
        // establece la coneccion con la base de datos
        try {
            connection = DriverManager.getConnection(URL + BD, USERNAME, PASSWORD);
            System.out.println("Conexion con base de datos " + BD + " ha sido abierta");

            String sql = "CREATE TABLE mascotas (id INTEGER PRIMARY KEY AUTO_INCREMENT," +
            "nombre VARCHAR(255)," + "apellido VARCHAR(255)," + "fecha_nacimiento DATE)";


            connection.close();

        }catch (SQLException e){
            System.out.println("No se ha podido establecer conexion con la base de datos");
            e.printStackTrace();
        }
        return  connection;
    }

    public void cerrarConnection (){
        try {
            connection.close();
            System.out.println("Conexion con base de datos " + BD + " ha sido cerrada");
        }catch (SQLException e){
            System.out.println("No se ha podido cerrar la conexion con la base de datos");
            e.printStackTrace();
        }
    }

    public PreparedStatement enviarConsulta (Connection connection, String sql){

        try {
            return connection.prepareStatement(sql);
        }catch (SQLException e){
            System.out.println("No se ha podido generar el objeto PrepareStatement");
            e.printStackTrace();
        }
        return null;
    }



}
