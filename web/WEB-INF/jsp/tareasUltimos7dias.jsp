<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tareas en los últimos 7 días</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js" type="text/javascript"></script>
        <script src="resources/js/highcharts.js" type="text/javascript"></script>
        <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet" />
    </head>
    <body>
        <h1>Tareas en los últimos 7 días</h1>
        <table style="max-width: 600px" class="table table-bordered table-striped" >
            <c:forEach items="${tareas}" var="tarea">
            <tr>
                <td><c:out value="${tarea.tarea}" /></td>
                <td><c:out value="${tarea.horasUltimosSieteDias()}" /></td>
            </tr>
            </c:forEach>
        </table><br />
        <script type="text/javascript">      
            var chart;
            $(document).ready(function() {
                chart = new Highcharts.Chart({
                    chart: {
                        renderTo: 'container',
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false
                    },
                    title: {
                        text: 'Horas por tarea en los últimos 7 días'
                    },
                    tooltip: {
                            pointFormat: '{series.name}: <b>{point.percentage}%</b>',
                        percentageDecimals: 1
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true,
                                color: '#000000',
                                connectorColor: '#000000',
                                formatter: function() {
                                    return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
                                }
                            }
                        }
                    },
                    series: [{
                        type: 'pie',
                        name: 'Horas por tarea en los últimos 7 días',
                        data: [
                            <c:forEach items="${tareas}" var="tarea">
                            ['<c:out value="${tarea.tarea}" />', <c:out value="${tarea.horasUltimosSieteDias()}" />],
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
