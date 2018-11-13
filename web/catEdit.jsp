<%-- 
    Document   : movEdit
    Created on : 30/10/2018, 04:52:37 PM
    Author     : e10417a
--%>

<%@page import="logica.vo.TipoCategoriaVo"%>
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
        <%
            TipoCategoriasDao dao = new TipoCategoriasDao();
            int id = Integer.parseInt((String) request.getAttribute("idcat"));
            TipoCategoriaVo c = (TipoCategoriaVo) dao.list(id);
        %>
        <div class="contenedor">
            <form class="form" name="formCategoria" method="POST" action="ControladorCategorias">
                <div class="form-header">
                    <h1 class="form-title">E<span>ditar</span> T<span>ipo</span> C<span>ategoria</span></h1>
                </div>
                <label for="IdMovimiento" class="form-label">Id Categorias:</label>
                <input type ="text" class="form-input" name="txtID" value="<%= c.getIdTipoCategoria()%>"/>

                <label for="Categoria" class="form-label">Nombre Categoria:</label>
                <input type ="text" class="form-input"  name="IdTipoCategoria" value="<%= c.getNombreTipoCat()%>"/>

                <input type="submit" class="btn-submit" name="action" value="UPDATE">
            </form>
        </div>
    </body>
</html>
