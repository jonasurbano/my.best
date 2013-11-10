<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de la disciplina</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
        type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"
        type="text/javascript"></script>
        <script src="resources/js/datepicker.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/style.css" media="screen" />
    </head>
    <body>
        <h1>Control de la disciplina</h1>
        <h2>Elija la tarea</h2>
        <form:form action="controldisciplina.htm" method="POST" commandName="controlDisciplina"> 
            
            <form:select path="tarea">
                <form:option label="Seleccione una tarea" value="" />
                <form:options items="${controlDisciplina.tareas}" />
            </form:select><br>
            
            <input type="submit" value="Crear sesión" />
        </form:form>
   </body>
</html>