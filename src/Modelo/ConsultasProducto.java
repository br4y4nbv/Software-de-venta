package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

// Clase ConsultasProducto que hereda de la clase Conexion
public class ConsultasProducto extends Conexion {
    
// Método para registrar un producto en la base de datos
public boolean registar (Producto p){
    PreparedStatement ps = null; // Objeto PreparedStatement para ejecutar la consulta SQL
    Connection con = getConexion(); // Se obtiene la conexión a la base de datos
    String sql ="INSERT INTO producto (codigo, nombre, precio, stock, descripcion) VALUES (?, ?, ?, ?, ?)"; // Consulta SQL para insertar un producto
    try{
        ps = con.prepareStatement(sql); // Se prepara la consulta SQL
        // Se asignan los valores a los parámetros de la consulta
        ps.setString(1, p.getCodigo());
        ps.setString(2, p.getNombre());
        ps.setInt(3, p.getPrecio()); 
        ps.setInt(4, p.getStock()); 
        ps.setString(5, p.getDescripcion()); 
        ps.execute(); // Se ejecuta la consulta
        return true; // Si la consulta se ejecutó correctamente, se retorna true
    }catch(SQLException e){
        System.err.println(e); // En caso de error, se imprime la traza del error
        return false; // Se retorna false indicando que hubo un error
    }
}

    
// Método para modificar un producto en la base de datos
public boolean modificar (Producto p){
    PreparedStatement ps = null;
    Connection con = getConexion();
    // Se actualiza la consulta SQL para incluir los campos stock y descripcion
    String sql ="UPDATE producto SET codigo=?, nombre=?, precio=?, stock=?, descripcion=? WHERE id=?";
    try{
        ps = con.prepareStatement(sql);
        // Se asignan los valores a los parámetros de la consulta
        ps.setString(1, p.getCodigo());
        ps.setString(2, p.getNombre());
        ps.setInt(3, p.getPrecio()); 
        ps.setInt(4, p.getStock()); 
        ps.setString(5, p.getDescripcion()); 
        ps.setInt(6, p.getId());
        ps.execute();
        return true;
    }catch(SQLException e){
        System.err.println(e);
        return false;
    }
}

    
    // Método para eliminar un producto de la base de datos
    public boolean eliminar (Producto p){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql ="delete from producto where id=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }
    }
    
   // Método para buscar un producto en la base de datos
public boolean buscar (Producto p){
    PreparedStatement ps = null;
    Connection con = getConexion();
    ResultSet rs = null; // Objeto ResultSet para almacenar el resultado de la consulta
    String sql ="SELECT * FROM producto WHERE id=?";
    try{
        ps = con.prepareStatement(sql);
        ps.setInt(1, p.getId());
        rs = ps.executeQuery(); // Se ejecuta la consulta y se almacena el resultado en rs
        // Si se encontró un producto con el id especificado, se asignan los valores a los atributos del objeto p
        if(rs.next()){
            p.setId(rs.getInt("id"));
            p.setCodigo(rs.getString("codigo"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(rs.getInt("precio")); 
            p.setStock(rs.getInt("stock")); 
            p.setDescripcion(rs.getString("descripcion")); 
            return true; // Se retorna true indicando que se encontró el producto
        }
        return false; // Si no se encontró el producto, se retorna false
    }catch(SQLException e){
        System.err.println(e);
        return false;
    }
  }
}
