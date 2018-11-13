/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import logica.vo.CuentasVo;

/**
 *
 * @author e10417a
 */
public interface CRUDCuentas {
    public List listar();
    public CuentasVo list(int id);
    public boolean add(CuentasVo mov);
    public boolean edit(CuentasVo mov);
    public boolean delete(int id);

}
