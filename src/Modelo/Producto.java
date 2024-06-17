package Modelo;

// Clase Producto que representa un producto en el sistema
public class Producto {
    // Declaración de variables de instancia
    private int id; // Identificador único del producto
    private String codigo, nombre; // Código y nombre del producto
    private int precio; // Precio del producto

    // Método para obtener el ID del producto
    public int getId() {
        return id;
    }

    // Método para establecer el ID del producto
    public void setId(int id) {
        this.id = id;
    }

    // Método para obtener el código del producto
    public String getCodigo() {
        return codigo;
    }

    // Método para establecer el código del producto
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Método para obtener el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Método para establecer el nombre del producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el precio del producto
    public int getPrecio() {
        return precio;
    }

    // Método para establecer el precio del producto
    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
