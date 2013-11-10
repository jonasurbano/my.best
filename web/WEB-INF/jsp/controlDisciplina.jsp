<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de la disciplina</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js" type="text/javascript"></script>
        <script src="resources/js/highcharts.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Control de la disciplina</h1>
        <table align="center" style="border:solid 1px #009" >
            <c:forEach items="${fechas}" var="fecha">
            <tr>
                <td style="width:400px; background-color:#FFC"><c:out value="${fecha}" /></td>
            </tr>
            </c:forEach>
        </table><br />
        <script type="text/javascript">
            var chart;
            $(document).ready(function() {
                chart = new Highcharts.Chart({
                    chart: {
                        renderTo: 'container',
                        type: 'line',
                        marginRight: 130,
                        marginBottom: 25
                    },
                    title: {
                        text: 'Control de la disciplina',
                        x: -20 //center
                    },
                    subtitle: {
                        text: 'Comparación del momento de inicio diario de la tarea',
                        x: -20
                    },
                    xAxis: {
                        categories: [
                            <c:forEach items="${fechas}" var="fecha">
                                '<c:out value="${fecha}" />',
                            </c:forEach>
                        ]
                    },
                    yAxis: {
                        title: {
                            text: 'Minutos'
                        },
                        plotLines: [{
                            value: 0,
                            width: 1,
                            color: '#808080'
                        }]
                    },
                    tooltip: {
                        formatter: function() {
                                return '<b>'+ this.series.name +'</b><br/>'+
                                this.x +': '+ this.y +'minutos';
                        }
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'top',
                        x: -10,
                        y: 100,
                        borderWidth: 0
                    },
                    series: [{
                        name: 'Minutos',
                        data: [
                            <c:forEach items="${fechas}" var="fecha">
                                <c:out value="${fecha.hours}" /> * 60 + <c:out value="${fecha.minutes}" />,
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