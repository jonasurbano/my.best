<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet" />
        <title>&iquest;Qu&eacute; tarea hago primero?</title>
    </head>
    <body>
        <h1>&iquest;Qu&eacute; tarea hago primero?</h1>
        <table style="max-width: 600px" class="table table-bordered table-striped">
            <c:forEach items="${tareas}" var="tarea">
            <tr>
                <td><a href="realizartarea.htm?id=${tarea.id}"><i class="icon-ok icon-green"></i></a></td>
                <td><c:out value="${tarea.tarea}" /></td>
                <td><c:out value="${tarea.fechaFin}" /></td>
            </tr>
            </c:forEach>
        </table>
        <a href="index.htm">Inicio</a> -
        <a href="tareasordenadas.htm">Tareas ordenadas</a> - 
        <a href="nuevatarea.htm">Nueva tarea</a> -
        <a href="nuevasesion.htm">Nueva sesión</a>

    </body>
</html>
