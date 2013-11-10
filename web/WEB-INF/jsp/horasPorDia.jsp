<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Horas por día</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js" type="text/javascript"></script>
        <script src="resources/js/highcharts.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Horas por día</h1>
        <table align="center" style="border:solid 1px #009" >
            <c:forEach items="${dias}" var="horas">
            <tr>
                <td style="width:400px; background-color:#FFC"><c:out value="${horas.dia}" /></td>
                <td style="width:200px; background-color:#FF9"><c:out value="${horas.horas}" /></td>
            </tr>
            </c:forEach>
        </table><br />
        <script type="text/javascript">
            var chart;
            $(document).ready(function() {
                chart = new Highcharts.Chart({
                    chart: {
                        renderTo: 'container',
                        type: 'column'
                    },
                    title: {
                        text: 'Control de la eficacia'
                    },
                    subtitle: {
                        text: 'Número de horas empleadas en tareas por día'
                    },
                    xAxis: {
                        categories: [
                            <c:forEach items="${dias}" var="horas">
                                '<c:out value="${horas.dia}" />',
                            </c:forEach>
                        ]
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Horas'
                        }
                    },
                    legend: {
                        layout: 'vertical',
                        backgroundColor: '#FFFFFF',
                        align: 'left',
                        verticalAlign: 'top',
                        x: 100,
                        y: 70,
                        floating: true,
                        shadow: true
                    },
                    tooltip: {
                        formatter: function() {
                            return ''+
                                this.x +': '+ this.y +' mm';
                        }
                    },
                    plotOptions: {
                        column: {
                            pointPadding: 0.2,
                            borderWidth: 0
                        }
                    },
                        series: [{
                        name: 'Horas',
                        data: [
                            <c:forEach items="${dias}" var="horas">
                                <c:out value="${horas.horas}" />,
                            </c:forEach>
                        ]
                    }]
                });
            });
        </script>
        <div id="container" style="width: 100%; height: 400px"></div>
        <a href="index.htm">Inicio</a> -
        <a href="tareasordenadas.htm">Tareas ordenadas</a> - 
        <a href="nuevatarea.htm">Nueva tarea</a> -
        <a href="nuevasesion.htm">Nueva sesión</a>
    </body>
</html>
