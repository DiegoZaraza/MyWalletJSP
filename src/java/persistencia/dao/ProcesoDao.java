package persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import persistencia.Conexion;

public class ProcesoDao {

    Conexion conex = new Conexion();
    Connection conn;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    MovimientosDao mov = new MovimientosDao();
    CategoriasDao cat = new CategoriasDao();
    CuentasDao cta = new CuentasDao();
    TipoCategoriasDao tc = new TipoCategoriasDao();

    public int consultarSaldoIngreso() {
        String sql = "SELECT SUM(ValorMov) AS Saldo FROM MOVIMIENTOS WHERE IdCategoria IN (SELECT IdCategoria FROM CATEGORIAS WHERE IdTipoCategoria = 11)";
        int valor = 0;
        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                valor = rs.getInt("Saldo");
            }
        } catch (SQLException e) { }
        return valor;
    }

    public int consultarSaldoEgresos() {
        String sql = "SELECT SUM(ValorMov) AS Saldo FROM MOVIMIENTOS WHERE IdCategoria IN (SELECT IdCategoria FROM CATEGORIAS WHERE IdTipoCategoria = 12)";
        int valor = 0;
        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                valor = rs.getInt("Saldo");
            }
        } catch (SQLException e) { }
        return valor;
    }

    public int consultarSaldoBilletera() {
        String sql1 = "SELECT SUM(ValorMov) AS Saldo FROM MOVIMIENTOS WHERE IdCuenta = '1000' AND IdCategoria IN (SELECT IdCategoria FROM CATEGORIAS WHERE IdTipoCategoria = 11)";
        String sql2 = "SELECT SUM(ValorMov) AS Saldo FROM MOVIMIENTOS WHERE IdCuenta = '1000' AND IdCategoria IN (SELECT IdCategoria FROM CATEGORIAS WHERE IdTipoCategoria = 12)";

        int valor1 = 0;
        int valor2 = 0;

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql1);
            rs = ps.executeQuery();

            while (rs.next()) {
                valor1 = rs.getInt("Saldo");
            }

            ps = conn.prepareStatement(sql2);
            rs = ps.executeQuery();

            while (rs.next()) {
                valor2 = rs.getInt("Saldo");
            }
        } catch (SQLException e) { }
        return valor1 - valor2;
    }

    public int consultarSaldoCuenta() {
        String sql1 = "SELECT SUM(ValorMov) AS Saldo FROM MOVIMIENTOS WHERE IdCuenta = '1001' AND IdCategoria IN (SELECT IdCategoria FROM CATEGORIAS WHERE IdTipoCategoria = 11)";
        String sql2 = "SELECT SUM(ValorMov) AS Saldo FROM MOVIMIENTOS WHERE IdCuenta = '1001' AND IdCategoria IN (SELECT IdCategoria FROM CATEGORIAS WHERE IdTipoCategoria = 12)";

        int valor1 = 0;
        int valor2 = 0;

        try {
            conn = conex.getConnection();
            ps = conn.prepareStatement(sql1);
            rs = ps.executeQuery();

            while (rs.next()) {
                valor1 = rs.getInt("Saldo");
            }

            ps = conn.prepareStatement(sql2);
            rs = ps.executeQuery();

            while (rs.next()) {
                valor2 = rs.getInt("Saldo");
            }
        } catch (SQLException e) { }
        return valor1 - valor2;
    }
}