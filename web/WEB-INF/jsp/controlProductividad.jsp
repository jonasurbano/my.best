<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de la productividad</title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js" type="text/javascript"></script>
        <script src="resources/js/highcharts.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Control de la productividad</h1>
        <table align="center" style="border:solid 1px #009" >
            <c:forEach items="${controlProductividad}" var="cp">
            <tr>
                <td style="width:400px; background-color:#FFC"><c:out value="${cp.nombreTarea}" /></td>
                <td style="width:200px; background-color:#FF9"><c:out value="${cp.horas}" /></td>
                <td style="width:200px; background-color:#FF9"><c:out value="${cp.horasProductivas}" /></td>
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
                text: 'Tareas en la última semana'
            },
            xAxis: {
                categories: [
                    <c:forEach items="${controlProductividad}" var="cp">
                        '<c:out value="${cp.nombreTarea}" />',
                    </c:forEach>
               ]
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'Horas productivas >> Horas en los últimos 7 días'
                },
                stackLabels: {
                    enabled: true,
                    style: {
                        fontWeight: 'bold',
                        color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                    }
                }
            },
            legend: {
                align: 'right',
                x: -100,
                verticalAlign: 'top',
                y: 20,
                floating: true,
                backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColorSolid) || 'white',
                borderColor: '#CCC',
                borderWidth: 1,
                shadow: false
            },
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.x +'</b><br/>'+
                        this.series.name +': '+ this.y +'<br/>'+
                        'Total: '+ this.point.stackTotal;
                }
            },
            plotOptions: {
                column: {
                    stacking: 'normal',
                    dataLabels: {
                        enabled: true,
                        color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
                    }
                }
            },
            series: [{
                name: 'Horas',
                data: [
                    <c:forEach items="${controlProductividad}" var="cp">
                        <c:out value="${cp.horas}" />-<c:out value="${cp.horasProductivas}" />,
                    </c:forEach>
                ]
            }, {
                name: 'Horas productivas',
                data: [
                    <c:forEach items="${controlProductividad}" var="cp">
                        <c:out value="${cp.horasProductivas}" />,
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
