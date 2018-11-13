<%-- 
    Document   : movListar
    Created on : 30/10/2018, 03:19:25 PM
    Author     : e10417a
--%>

<%@page import="java.util.Iterator"%>
<%@page import="logica.vo.MovimientosVo"%>
<%@page import="java.util.List"%>
<%@page import="persistencia.dao.MovimientosDao"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Movimientos</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="main.css">
    </head>
    <body>
        <div class="contenedor">
        <table class="table">
            <thead class="headertable">
                <tr>
                    <th class="encabezado">ID MOVIMIENTO</th>
                    <th class="encabezado">FECHA</th>
                    <th class="encabezado">VALOR</th>
                    <th class="encabezado">ID CUENTA</th>
                    <th class="encabezado">ID CATEGORIA</th>
                    <th class="encabezado">ACCIONES</th>
                </tr>
            </thead>
            <%
                MovimientosDao DAO = new MovimientosDao();
                DecimalFormat formatea = new DecimalFormat("###,###.##");
                List<MovimientosVo> list = DAO.listar();
                Iterator<MovimientosVo> iter = list.iterator();
                MovimientosVo mov = null;
                while (iter.hasNext()) {
                    mov = iter.next();
            %>
            <tbody class="bodytable">
                <tr>
                    <td class="celdas"><%= mov.getIdMov()%></td>
                    <td class="celdas"><%= mov.getFechaMov()%></td>
                    <td class="celdas"><%= formatea.format(mov.getValorMovimiento())%></td>
                    <td class="celdas"><%= mov.getIdCuenta()%></td>
                    <td class="celdas"><%= mov.getIdCategoria()%></td>
                    <td class="celdas"><a class="link" href="ControladorMovimientos?action=editar&id=<%= mov.getIdMov()%>">Editar</a> | 
                        <a class="link" href="ControladorMovimientos?action=delete&id=<%= mov.getIdMov()%>">Eliminar</a></td>
                </tr>
                <%}%>
            </tbody>
        </table> 

        </div>
    </body>
</html>
