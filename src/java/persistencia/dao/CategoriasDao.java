package persistencia.dao;

import interfaces.CRUDCategorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logica.vo.CategoriasVo;
import persistencia.Conexion;

public class CategoriasDao implements CRUDCategorias {

    Conexion conex = new Conexion();
    Connection conn;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    CategoriasVo cat = new CategoriasVo();

    @Override
    public List listar() {
        ArrayList<CategoriasVo> list = new ArrayList<>();
        String sql = "SELECT * FROM CATEGORIAS";

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                CategoriasVo c = new CategoriasVo();
                c.setIdCategoria(rs.getInt("IdCategoria"));
                c.setNombreCategoria(rs.getString("NamCategoria"));
                c.setTipoCategoria(rs.getInt("IdTipoCategoria"));
                list.add(c);
            }
        } catch (Exception e) { }
        return list;
    }

    @Override
    public CategoriasVo list(int id) {
        String sql = "SELECT * FROM CATEGORIAS WHERE IdCategoria = " + id;

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cat.setIdCategoria(rs.getInt("IdCategoria"));
                cat.setTipoCategoria(rs.getInt("IdTipoCategoria"));
                cat.setNombreCategoria(rs.getString("NamCategoria"));
            }
        } catch (SQLException e) { }
        return cat;
    }

    @Override
    public boolean add(CategoriasVo cat) {
        String sql = ("INSERT INTO CATEGORIAS VALUES('" + cat.getIdCategoria() + "', '"
                + cat.getTipoCategoria() + "', '" + cat.getNombreCategoria() + "')");
        
        try {
            conn = conex.getConnection();
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) { }

        return false;
    }

    @Override
    public boolean edit(CategoriasVo cat) {
        String sql = "UPDATE CATEGORIAS SET IdTipoCategoria = '" + cat.getTipoCategoria()
                + "', NamCategoria = " + cat.getNombreCategoria() + " WHERE IdCategoria = " + cat.getIdCategoria();

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) { }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM CATEGORIAS WHERE IdCategoria = " + id;

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) { }
        return false;
    }
}