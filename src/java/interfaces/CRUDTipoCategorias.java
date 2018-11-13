/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import logica.vo.TipoCategoriaVo;

/**
 *
 * @author e10417a
 */
public interface CRUDTipoCategorias {
    public List listar();
    public TipoCategoriaVo list(int id);
    public boolean add(TipoCategoriaVo mov);
    public boolean edit(TipoCategoriaVo mov);
    public boolean delete(int id);
}
