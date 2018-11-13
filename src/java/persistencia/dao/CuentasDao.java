package persistencia.dao;

import interfaces.CRUDCuentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import persistencia.Conexion;
import logica.vo.CuentasVo;

public class CuentasDao implements CRUDCuentas {

    Conexion conex = new Conexion();
    Connection conn;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    CuentasVo cta = new CuentasVo();

    @Override
    public List listar() {
        ArrayList<CuentasVo> list = new ArrayList<>();
        String sql = "SELECT * FROM CUENTAS ORDER BY IdCuenta";

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                CuentasVo c = new CuentasVo();
                c.setIdCuenta(rs.getInt("IdCuentas"));
                c.setNomCuenta(rs.getString("NamCuenta"));
                list.add(c);
            }
        } catch (SQLException e) { }
        return list;
    }

    @Override
    public CuentasVo list(int id) {
        String sql = "SELECT * FROM CUENTAS WHERE IdCuentas = " + id;

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cta.setIdCuenta(rs.getInt("IdCuenta"));
                cta.setNomCuenta(rs.getString("NamCuenta"));
            }

        } catch (SQLException e) { }
        return cta;
    }

    @Override
    public boolean add(CuentasVo cta) {
        String sql = ("INSERT INTO CUENTAS VALUES(" + cta.getIdCuenta() + ", '"
                + cta.getNomCuenta() + "')");
        try {
            conn = conex.getConnection();
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) { }

        return false;
    }

    @Override
    public boolean edit(CuentasVo cta) {
        String sql = "UPDATE CUENTAS SET NamCuenta = '" + cta.getNomCuenta()
                + "' WHERE IdCuenta = " + cta.getIdCuenta();

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) { }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM CUENTAS WHERE IdCuenta = " + id;

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) { }
        return false;
    }
}