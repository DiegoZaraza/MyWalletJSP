package persistencia.dao;

import interfaces.CRUDTipoCategorias;
import java.util.List;
import logica.vo.TipoCategoriaVo;
import persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TipoCategoriasDao implements CRUDTipoCategorias {

    Conexion conex = new Conexion();
    Connection conn;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    TipoCategoriaVo tc = new TipoCategoriaVo();

    @Override
    public List listar() {
        ArrayList<TipoCategoriaVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TIPOCAT ORDER BY IdTipoCat";

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                TipoCategoriaVo t = new TipoCategoriaVo();
                t.setIdTipoCategoria(rs.getInt("IdTipoCat"));
                t.setNombreTipoCat(rs.getString("NamTipoCat"));
                list.add(t);
            }
        } catch (SQLException e) { }
        return list;
    }

    @Override
    public TipoCategoriaVo list(int id) {
        String sql = "SELECT * FROM TIPOCAT WHERE IdTipoCat = " + id;

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                tc.setIdTipoCategoria(rs.getInt("IdTipoCat"));
                tc.setNombreTipoCat(rs.getString("NamTipoCat"));

            }
        } catch (SQLException e) { }
        return tc;
    }

    @Override
    public boolean add(TipoCategoriaVo tc) {
        String sql = ("INSERT INTO TIPOCAT VALUES(" + tc.getIdTipoCategoria() + ", '"
                + tc.getNombreTipoCat() + "')");
        try {
            conn = conex.getConnection();
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) { }
        return false;
    }

    @Override
    public boolean edit(TipoCategoriaVo tc) {
        String sql = "UPDATE TIPOCAT SET FechaMov = '" + tc.getNombreTipoCat()
                + "WHERE IdTipoCat = " + tc.getIdTipoCategoria();

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) { }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM TIPOCAT WHERE IdTipoCat = " + id;

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) { }
        return false;
    }
}