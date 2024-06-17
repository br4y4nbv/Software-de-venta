package Controlador;

import Vista.VPrincipal;
import Vista.VProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase ControladorPrincipal que implementa la interfaz ActionListener
public class ControladorPrincipal implements ActionListener {
    // Declaración de variables de instancia
    private VPrincipal frmPri; // Objeto de la clase VPrincipal (Vista)
    private VProducto frmPro; // Objeto de la clase VProducto (Vista)

    // Constructor de la clase ControladorPrincipal
    public ControladorPrincipal(VPrincipal frmPri, VProducto frmPro) {
        this.frmPri = frmPri;
        this.frmPro = frmPro;
        // Asignación de los listeners a los items del menú
        this.frmPri.menu_producto.addActionListener(this);
        this.frmPri.menu_salir.addActionListener(this);
    }

    // Método para iniciar la vista principal
    public void iniciar(){
        frmPro.setTitle("Producto"); // Se establece el título de la ventana del producto
        frmPri.setTitle("Principal"); // Se establece el título de la ventana principal
        frmPri.setLocationRelativeTo(null); // Se centra la ventana principal
        frmPro.setLocationRelativeTo(null); // Se centra la ventana del producto
    }
    
    // Método que se ejecuta al realizar una acción (click en un item del menú)
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acciones a realizar cuando se selecciona el item Producto del menú
        if (e.getSource()==frmPri.menu_producto){
            frmPro.setVisible(true); // Se hace visible la ventana del producto
            frmPri.dispose(); // Se cierra la ventana principal
        }
        
        // Acciones a realizar cuando se selecciona el item Salir del menú
        if(e.getSource()==frmPri.menu_salir){
            System.exit(0); // Se cierra la aplicación
        }
    }
}
