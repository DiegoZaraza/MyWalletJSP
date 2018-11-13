<%-- 
    Document   : error
    Created on : 30/10/2018, 01:13:53 PM
    Author     : e10417a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ERROR</h1>
        <%String mensaje = (String)request.getAttribute("error"); %>
        <%=mensaje%>
    </body>
</html>
