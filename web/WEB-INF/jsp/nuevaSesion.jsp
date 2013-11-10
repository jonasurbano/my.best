<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva sesión</title>
        <link rel="stylesheet" type="text/css" href="resources/css/style.css" />
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet" />
    </head>
    <body>
        <h1>Nueva sesión</h1>       
        <form:form class="form-horizontal" action="nuevasesion.htm" method="POST" commandName="sesionForm"> 
                     
            <div class="control-group">
                <div class="controls">
                    <form:select path="tarea">
                        <form:option label="Seleccione una tarea" value="" />
                        <form:options items="${sesionForm.tareas}" />
                    </form:select><br>

                </div>
            </div>            
            
            <div class="control-group">
                <label class="control-label">Fecha:</label>
                <div class="controls">
                    <form:input type="datetime-local" path="fecha" /><br />                
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">Duración:</label>
                <div class="controls">
                    <form:input path="duracion" /><br />
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                
                    <form:select path="productividad">
                        <form:option label="Seleccione productividad" value="" />
                        <form:option label="Baja" value="Baja" />
                        <form:option label="Media" value="Media" />
                        <form:option label="Alta" value="Alta"/>
                    </form:select><br>
            
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <input class="btn btn-success" type="submit" value="Crear sesión" />                
                </div>
            </div>
                
        </form:form>
   </body>
</html>
