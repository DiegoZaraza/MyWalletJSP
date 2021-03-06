<%-- 
    Document   : movListar
    Created on : 30/10/2018, 03:19:25 PM
    Author     : e10417a
--%>

<%@page import="java.util.Iterator"%>
<%@page import="logica.vo.TipoCategoriaVo"%>
<%@page import="java.util.List"%>
<%@page import="persistencia.dao.TipoCategoriasDao"%>
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
                        <th class="encabezado">ID TIPO CATEGORIA</th>
                        <th class="encabezado">NOMBRE TIPO CATEGORIA</th>
                        <th class="encabezado">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    TipoCategoriasDao DAO = new TipoCategoriasDao();
                    List<TipoCategoriaVo> list = DAO.listar();
                    Iterator<TipoCategoriaVo> iter = list.iterator();
                    TipoCategoriaVo mov = null;
                    while (iter.hasNext()) {
                        mov = iter.next();
                %>
                <tbody class="bodytable">
                    <tr>
                        <td class="celdas"><%= mov.getIdTipoCategoria()%></td>
                        <td class="celdas"><%= mov.getNombreTipoCat()%></td>
                        
                        <td class="celdas"><a class="link" href="ControladorCategorias?action=editar&id=<%= mov.getIdTipoCategoria()%>">Editar</a> | 
                            <a class="link" href="ControladorCategorias?action=delete&id=<%= mov.getIdTipoCategoria()%>">Eliminar</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table> 
        </div>
    </body>
</html>