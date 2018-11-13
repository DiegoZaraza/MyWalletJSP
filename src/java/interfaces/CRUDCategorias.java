/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import logica.vo.CategoriasVo;

/**
 *
 * @author e10417a
 */
public interface CRUDCategorias {
    public List listar();
    public CategoriasVo list(int id);
    public boolean add(CategoriasVo cat);
    public boolean edit(CategoriasVo cat);
    public boolean delete(int id);
}
