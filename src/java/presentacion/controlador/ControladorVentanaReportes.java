/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import presentacion.VentanaReportes;

/**
 *
 * @author e10417a
 */
public class ControladorVentanaReportes  implements ActionListener{

    private final VentanaReportes vRep;

    public ControladorVentanaReportes(VentanaReportes aThis) {
        vRep = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton radio = (JRadioButton) e.getSource();
        if (radio == vRep.getjRadioCuenta()) {
            vRep.getModelo().graficaCuenta();
        } else if (radio == vRep.getjRadioCategoria()) {
            vRep.getModelo().graficaCategoria();
        } else if (radio == vRep.getjRadioIngresos()) {
            vRep.getModelo().graficaIngresoGastos();
        }
    }
}