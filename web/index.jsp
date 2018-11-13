<%-- 
    Document   : index.jsp
    Created on : 30/10/2018, 01:29:56 PM
    Author     : e10417a
--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="persistencia.dao.ProcesoDao"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventana Principal</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="main.css">
    </head>
    <body>
        <div class="contenedor">
            <table class="table">
                <thead class="headertable">
                    <tr>
                        <td class="encabezado" colspan="4">Saldos</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%
                ProcesoDao DAO = new ProcesoDao();
                                DecimalFormat formatea = new DecimalFormat("###,###.##");
                            %>
                        <td class="encabezado">Billetera</td>
                        <td class="celdas"><%= formatea.format(DAO.consultarSaldoBilletera())%></td>
                        <td class="encabezado">Gastos</td>
                        <td class="celdas"><%= formatea.format(DAO.consultarSaldoEgresos())%></td>
                    </tr>
                    <tr>
                        <td class="encabezado">Cuenta</td>
                        <td class="celdas"><%= formatea.format(DAO.consultarSaldoCuenta())%></td>
                        <td class="encabezado">Ingresos</td>
                        <td class="celdas"><%= formatea.format(DAO.consultarSaldoIngreso())%></td>
                    </tr>            
                </tbody>
                <tfoot>
                    <tr>
                        <td class="celdas" colspan="2"><a class="link" href="movimientos.jsp">Movimientos</a></td>
                        <td class="celdas"><a class="link" href="categorias.jsp">Categorias</a></td>
                        <td class="celdas"><a class="link" href="tipocategorias.jsp">Tipo Categorias</a></td>
                    </tr>
                </tfoot>
            </table>
        </div>

    </body>
</html>
