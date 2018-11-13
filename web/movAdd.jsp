<%-- 
    Document   : movADd
    Created on : 30/10/2018, 03:47:16 PM
    Author     : e10417a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Movimientos</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="main.css">
    </head>
    <body>
        <div class="contenedor">
            <form class="form" name="formMovimiento" method="POST" action="ControladorMovimientos">
                <div class="form-header">
                    <h1 class="form-title">I<span>nsertar</span> M<span>ovimientos</span></h1>
                </div>
                <label for="IdMovimiento" class="form-label">Id Movimiento:</label>
                <input type ="text" class="form-input" placeholder="Escriba ID" name="txtID"/>

                <label for="Fecha" class="form-label">Fecha:</label>
                <input type ="text" class="form-input" placeholder="Escriba Fecha" name="txtFecha"/>

                <label for="Categoria" class="form-label">Categoria:</label>
                <input type ="text" class="form-input" placeholder="Escriba Categoria" name="txtCategoria"/>

                <label for="Cuenta" class="form-label">Cuenta:</label>
                <input type ="text" class="form-input" placeholder="Escriba Cuenta" name="txtCuenta"/>

                <label for="Valor" class="form-label">Valor:</label>
                <input type ="text" class="form-input" placeholder="Escriba Valor" name="txtValor"/>

                <input type="submit" class="btn-submit" name="action" value="INSERTAR">
            </form>
        </div>
    </body>
</html>
