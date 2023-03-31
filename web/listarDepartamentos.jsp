<%@page import="java.util.List"%>
<%@page import="model.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Departamentos</title>
    </head>
    <body>
        <%
            List<Departamento> listaDepartamentos = (List<Departamento>) request.getAttribute("listaDepartamentos");
        %>
    </body>
</html>
