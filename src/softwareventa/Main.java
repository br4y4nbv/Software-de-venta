package softwareventa;

import Controlador.ControladorPrincipal;
import Controlador.ControladorProducto;
import Modelo.Conexion;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.VPrincipal;
import Vista.VProducto;

// Clase Main que contiene el método principal del programa
public class Main {
    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) { 
        // Se crean los objetos necesarios para el funcionamiento del programa
        Producto pro = new Producto(); // Objeto de la clase Producto
        ConsultasProducto proC = new ConsultasProducto(); // Objeto de la clase ConsultasProducto
        VProducto frmPro = new VProducto(); // Objeto de la clase VProducto (Vista)
        // Se crea el controlador del producto y se le pasan los objetos necesarios
        ControladorProducto ctrlPro = new ControladorProducto(pro, frmPro, proC);
        VPrincipal frmPri = new VPrincipal(); // Objeto de la clase VPrincipal (Vista)
        // Se crea el controlador principal y se le pasan los objetos necesarios
        ControladorPrincipal ctrlPri = new ControladorPrincipal(frmPri, frmPro);
        ctrlPri.iniciar(); // Se inicia el controlador principal
        frmPri.setVisible(true); // Se hace visible la vista principal
        
        // Se crea el objeto de la clase Conexion para establecer la conexión con la base de datos
        Conexion con = new Conexion();
        con.getConexion(); // Se obtiene la conexión
    }
}
