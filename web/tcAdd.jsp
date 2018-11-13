<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Tipo Categorias</title>
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="main.css">
    </head>
    <body>
        <div class="contenedor">
            <form class="form" name="formTipoCategorias" method="POST" action="ControladorMovimientos">
                <div class="form-header">
                    <h1 class="form-title">I<span>nsertar</span> T<span>ipo</span> C<span>ategorias</span></h1>
                </div>
                <label for="IdMovimiento" class="form-label">Id Tipo Categoria:</label>
                <input type ="text" class="form-input" placeholder="Escriba ID Tipo Categoria" name="txtID"/>

                <label for="Fecha" class="form-label">Nombre Tipo Categoria:</label>
                <input type ="text" class="form-input" placeholder="Escriba Nombre Tipo Categoria" name="txtNombreTipo"/>

                <input type="submit" class="btn-submit" name="action" value="INSERTAR">
            </form>
        </div>
    </body>
</html>
