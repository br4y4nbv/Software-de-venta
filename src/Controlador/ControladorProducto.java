package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.VProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// Clase ControladorProducto que implementa la interfaz ActionListener
public class ControladorProducto implements ActionListener {
    // Declaración de variables de instancia
    private Producto pro; // Objeto de la clase Producto
    private VProducto frmPro; // Objeto de la clase VProducto (Vista)
    private ConsultasProducto proC; // Objeto de la clase ConsultasProducto (Modelo)

    // Constructor de la clase ControladorProducto
    public ControladorProducto(Producto pro, VProducto frmPro, ConsultasProducto proC) {
        this.pro = pro;
        this.frmPro = frmPro;
        this.proC = proC;
        // Asignación de los listeners a los botones
        this.frmPro.btn_agregar.addActionListener(this);
        this.frmPro.btn_buscar.addActionListener(this);
        this.frmPro.btn_eliminar.addActionListener(this);
        this.frmPro.btn_limpiar.addActionListener(this);
        this.frmPro.btn_modificar.addActionListener(this);
    }

    // Método que se ejecuta al realizar una acción (click en un botón)
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acciones a realizar cuando se presiona el botón Agregar
        if(e.getSource()==frmPro.btn_agregar){
            // Se obtienen los datos ingresados por el usuario y se asignan al objeto pro
            pro.setCodigo(frmPro.txt_codigo.getText());
            pro.setNombre(frmPro.txt_nombre.getText());
            pro.setPrecio(Integer.parseInt(frmPro.txt_precio.getText()));
            // Si el registro es exitoso, se muestra un mensaje y se limpian los campos
            if(proC.registar(pro)){
                JOptionPane.showMessageDialog(null, "Producto agregado");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al agregar");
                Limpiar();
            }
        }
        
        // Acciones a realizar cuando se presiona el botón Modificar
        if(e.getSource()==frmPro.btn_modificar){
            // Se obtienen los datos ingresados por el usuario y se asignan al objeto pro
            pro.setId(Integer.parseInt(frmPro.txt_id.getText()));
            pro.setCodigo(frmPro.txt_codigo.getText());
            pro.setNombre(frmPro.txt_nombre.getText());
            pro.setPrecio(Integer.parseInt(frmPro.txt_precio.getText()));
            // Si la modificación es exitosa, se muestra un mensaje y se limpian los campos
            if(proC.modificar(pro)){
                JOptionPane.showMessageDialog(null, "Producto modificado");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                Limpiar();
            }
        }
        
        // Acciones a realizar cuando se presiona el botón Eliminar
        if(e.getSource()==frmPro.btn_eliminar){
            // Se obtiene el ID ingresado por el usuario y se asigna al objeto pro
            pro.setId(Integer.parseInt(frmPro.txt_id.getText()));
            // Si la eliminación es exitosa, se muestra un mensaje y se limpian los campos
            if(proC.eliminar(pro)){
                JOptionPane.showMessageDialog(null, "Producto eliminado");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                Limpiar();
            }
        }
        
        // Acciones a realizar cuando se presiona el botón Buscar
        if(e.getSource()==frmPro.btn_buscar){
            // Se obtiene el ID ingresado por el usuario y se asigna al objeto pro
            pro.setId(Integer.parseInt(frmPro.txt_id.getText()));
            // Si la búsqueda es exitosa, se muestran los datos del producto en los campos correspondientes
            if(proC.buscar(pro)){
                frmPro.txt_id.setText(String.valueOf(pro.getId()));
                frmPro.txt_codigo.setText(pro.getCodigo());
                frmPro.txt_nombre.setText(pro.getNombre());
                frmPro.txt_precio.setText(String.valueOf(pro.getPrecio()));
            }else{
                JOptionPane.showMessageDialog(null, "Error al buscar");
                Limpiar();
            }
        }
        
        // Acciones a realizar cuando se presiona el botón Limpiar
        if(e.getSource()==frmPro.btn_limpiar){
            Limpiar();
        }
        
    }//FIN ACTION
    
    // Método para limpiar los campos de texto
    public void Limpiar (){
        frmPro.txt_codigo.setText(null);
        frmPro.txt_id.setText(null);
        frmPro.txt_nombre.setText(null);
        frmPro.txt_precio.setText(null);
    }
}
