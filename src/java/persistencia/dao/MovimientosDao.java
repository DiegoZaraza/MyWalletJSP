package persistencia.dao;

import interfaces.CRUDMovimientos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.Conexion;
import logica.vo.MovimientosVo;

public class MovimientosDao implements CRUDMovimientos {

    Conexion conex = new Conexion();
    Connection conn;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    MovimientosVo mov = new MovimientosVo();

    @Override
    public List listar() {
        ArrayList<MovimientosVo> list = new ArrayList<>();
        String sql = "SELECT * FROM MOVIMIENTOS ORDER BY IdMov";

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                MovimientosVo m = new MovimientosVo();
                m.setIdMov(rs.getInt("IdMov"));
                Date s = rs.getDate("FechaMov");
                m.setFechaMov(rs.getDate("FechaMov"));
                m.setValorMovimiento(rs.getInt("ValorMov"));
                m.setIdCategoria(rs.getInt("IdCategoria"));
                m.setIdCuenta(rs.getInt("IdCuenta"));
                list.add(m);
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MovimientosVo list(int id) {
        String sql = "SELECT * FROM MOVIMIENTOS WHERE IdMov = " + id;

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                mov.setIdMov(rs.getInt("IdMov"));
                mov.setFechaMov(rs.getDate("FechaMov"));
                mov.setValorMovimiento(rs.getInt("ValorMov"));
                mov.setIdCategoria(rs.getInt("IdCategoria"));
                mov.setIdCuenta(rs.getInt("IdCuenta"));
            }
        } catch (SQLException e) { }
        return mov;
    }

    @Override
    public boolean add(MovimientosVo mov) {
        String sql = ("INSERT INTO MOVIMIENTOS VALUES('" + mov.getIdMov() + "', '"
                + mov.getFechaMov() + "', '" + mov.getValorMovimiento() + "', '"
                + mov.getIdCuenta() + "','" + mov.getIdCategoria() + "')");
        try {
            conn = conex.getConnection();
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) { }

        return false;
    }

    @Override
    public boolean edit(MovimientosVo mov) {
        String sql = "UPDATE MOVIMIENTOS SET FechaMov = '" + mov.getFechaMov()
                + "', ValorMov = " + mov.getValorMovimiento() + ", IdCuenta = "
                + mov.getIdCuenta() + ", IdCategoria = " + mov.getIdCategoria()
                + " WHERE IdMov = " + mov.getIdMov();

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) { }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM MOVIMIENTOS WHERE IdMov = " + id;

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) { }
        return false;
    }
}