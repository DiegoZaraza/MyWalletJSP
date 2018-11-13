<%-- 
    Document   : movEdit
    Created on : 30/10/2018, 04:52:37 PM
    Author     : e10417a
--%>

<%@page import="logica.vo.MovimientosVo"%>
<%@page import="persistencia.dao.MovimientosDao"%>
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
            MovimientosDao dao = new MovimientosDao();
            int id = Integer.parseInt((String) request.getAttribute("idper"));
            MovimientosVo m = (MovimientosVo) dao.list(id);
        %>
        <div class="contenedor">
            <form class="form"name="formMovimiento" method="POST" action="ControladorMovimientos">
                <div class="form-header">
                    <h1 class="form-title">E<span>ditar</span> M<span>ovimientos</span></h1>
                </div>
                <label for="IdMovimiento" class="form-label">Id Movimiento:</label>
                <input type ="text" class="form-input" placeholder="Escriba ID" name="txtID" value="<%= m.getIdMov()%>"/>

                <label for="Fecha" class="form-label">Fecha:</label>
                <input type ="text" class="form-input" placeholder="Escriba Fecha" name="txtFecha" value="<%= m.getFechaMov()%>" required/>

                <label for="Categoria" class="form-label">Categoria:</label>
                <input type ="text" class="form-input" placeholder="Escriba Categoria" name="txtCategoria" value="<%= m.getIdCategoria()%>"/>

                <label for="Cuenta" class="form-label">Cuenta:</label>
                <input type ="text" class="form-input" placeholder="Escriba Cuenta" name="txtCuenta" value="<%= m.getIdCuenta()%>"/>

                <label for="Valor" class="form-label">Valor:</label>
                <input type ="text" class="form-input" placeholder="Escriba Valor" name="txtValor" value="<%= m.getValorMovimiento()%>"/>

                <input type="submit" class="btn-submit" name="action" value="UPDATE">
            </form>
        </div>
    </body>
</html>
