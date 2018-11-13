/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import logica.vo.MovimientosVo;

/**
 *
 * @author e10417a
 */
public interface CRUDMovimientos {
    public List listar();
    public MovimientosVo list(int id);
    public boolean add(MovimientosVo mov);
    public boolean edit(MovimientosVo mov);
    public boolean delete(int id);
    
}
