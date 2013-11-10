<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva tarea</title>
        <link rel="stylesheet" type="text/css" href="resources/css/style.css" media="screen" />
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet" />
    </head>
    <body>
        <h1>Nueva tarea</h1>       
        <form:form class="form-horizontal" action="nuevatarea.htm" method="POST" commandName="tareaForm"> 
            
            <div class="control-group">
                <label class="control-label">Nombre</label>
                <div class="controls">
                    <form:input path="tarea" />
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">Fecha de inicio:</label>
                <div class="controls">
                    <form:input type="datetime-local" path="fechaInicio" />
                </div>
            </div>
            
            <div class="control-group">
                <label class="control-label">Fecha de fin:</label>
                <div class="controls">
                    <form:input type="datetime-local" path="fechaFin" />
                </div>
            </div>
            
            <div class="control-group">
                <label class="control-label">Descripción:</label>
                <div class="controls">
                    <form:textarea path="descripcion" />
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">Duración estimada:</label>
                <div class="controls">
                    <form:input path="duracionEstimada" />
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">Horas por sesión:</label>
                <div class="controls">
                    <form:input path="horasPorSesion" />
                </div>
            </div>

            <div class="control-group">
                <label class="control-label">Prioridad:</label>
                <div class="controls">
                
                <form:select path="prioridad">
                    <form:option label="Seleccione prioridad" value="" />
                    <form:option label="Ninguna" value="Ninguna" />
                    <form:option label="Baja" value="Baja" />
                    <form:option label="Media" value="Media" />
                    <form:option label="Alta" value="Alta"/>
                    <form:option label="Muy alta" value="Muy alta" />
                </form:select><br>

                </div>
            </div>
                
            <label class="checkbox inline">L:<form:checkbox path="lunes" /></label>
            <label class="checkbox inline">M:<form:checkbox path="martes" /></label>
            <label class="checkbox inline">MX:<form:checkbox path="miercoles" /></label>
            <label class="checkbox inline">J:<form:checkbox path="jueves" /></label>
            <label class="checkbox inline">V:<form:checkbox path="viernes" /></label>
            <label class="checkbox inline">S:<form:checkbox path="sabado" /></label>
            <label class="checkbox inline">D:<form:checkbox path="domingo" /></label>
            <br><br>
            
            <div class="control-group">
                <div class="controls">
                <input class="btn btn-success" type="submit" value="Crear tarea" />
                </div>
            </div>
        </form:form>
   </body>
</html>
