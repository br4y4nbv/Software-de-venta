package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

// Clase Conexion que se encarga de establecer la conexión con la base de datos
public class Conexion {
    // Declaración de variables de instancia
    private String base ="tienda"; // Nombre de la base de datos
    private String user ="root"; // Usuario de la base de datos
    private String password =""; // Contraseña de la base de datos
    // URL de la base de datos
    String url = "jdbc:mysql://localhost:3306/" + base + "?allowPublicKeyRetrieval=true&useSSL=false";
    private Connection con = null; // Objeto Connection para manejar la conexión
    
    // Método para obtener la conexión a la base de datos
    public Connection getConexion(){
        try{
            // Se carga el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Se establece la conexión con la base de datos
            con = (Connection) DriverManager .getConnection(this.url, this.user, this.password);
            // Se muestra un mensaje de éxito al establecer la conexión
            JOptionPane.showMessageDialog(null, "conectado");
        }catch (SQLException e){
            // En caso de error, se imprime la traza del error
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            // En caso de no encontrar el driver, se registra el error en el log
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }      
        // Se retorna el objeto Connection
        return con;
    }
    
}
