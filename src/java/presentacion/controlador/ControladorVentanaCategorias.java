/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import presentacion.VentanaCategorias;

/**
 *
 * @author e10417a
 */
public class ControladorVentanaCategorias implements ActionListener{
    private final VentanaCategorias vCat;

    public ControladorVentanaCategorias(VentanaCategorias aThis) {
        vCat = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        if (boton == vCat.getjButtonRegistrar()) {
            vCat.getModelo().insertarCategoria();
        } else if (boton == vCat.getjButtonEditar()) {
          //  vMov.getModelo().paginaParametrizar();
        } else if (boton == vCat.getjButtonEliminar()) {
            //vMov.getModelo().paginaReportes();
        } else if (boton == vCat.getjButtonBuscar()) {
            
        }
    }
}
