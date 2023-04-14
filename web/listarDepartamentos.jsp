<%@page import="java.util.List"%>
<%@page import="model.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            List<Departamento> listaDepartamentos = (List<Departamento>) request.getAttribute("listaDepartamentos");
        %>
        <table>
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>Telefone</th>    
                <th>Exclusão</th>
                <th>Alterar</th>
            </tr>
            <%
                for (Departamento departamento : listaDepartamentos) {
            %>
            <tr>
                <td> <%= departamento.getIdDepartamento()%> </td> 
                <td> <%= departamento.getNomeDepartamento()%> </td>  
                <td> <%= departamento.getFoneDepartamento()%> </td>  
                <td> <a href="Controle?flag=excluirDepartamento&idDep= <%= departamento.getIdDepartamento()%>"> Excluir </a>  </td>
                <td> <a href="Controle?flag=alterarDepartamento&idDep= <%= departamento.getIdDepartamento()%>"> Alterar </a>  </td>
            </tr>
            <%
                }
            %>

        </table>
    </body>
</html>
