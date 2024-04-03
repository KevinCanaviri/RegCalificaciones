<%@page import="com.emergentes.modelo.Estudiante"%>
<%
    Estudiante reg=(Estudiante) request.getAttribute("miobjest");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .contenedor {
                width: 300px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                text-align: center;
            }
            h1 {
                text-align: center;
            }
            .centrado {
                display: flex;
                justify-content: center;
                align-items: center;
            }
        </style>
    </head>
    <body>
        <div class="contenedor">
            <p>PRIMER PARCIAL TEM-742<br>
                Nombre: Kevin Efrain Canaviri Callisaya<br>
                Carnet: 10095136</p>
        </div>
        <h1>Registro de Estudiante</h1>
        
        <form action="MainServlet" method="post">
            <div class="centrado">
            <table>
                <tr>
                    <td>ID:</td>
                    <td><input type="text" name="id" value="<%= reg.getId()%>" size="2" readonly></td>
                </tr>
                <tr>
                    <td>Nombre_del_estudiante:</td>
                    <td><input type="text" name="nombre" value="<%= reg.getNombre_del_estudiante()%>"></td>
                </tr>
                <tr>
                    <td>Primer_Parcial(sobre 30 puntos)</td>
                    <td><input type="text" name="P1" value="<%= reg.getPrimer_Parcial()%>"></td>
                </tr>
                <tr>
                    <td>Segundo_Parcial(sobre 30 puntos)</td>
                    <td><input type="text" name="P2" value="<%= reg.getSegundo_Parcial()%>"></td>
                </tr>
                <tr>
                    <td>Examen_Final(sobre 40 puntos)</td>
                    <td><input type="text" name="EF" value="<%= reg.getExamen_Final()%>"></td>
                </tr>
                <tr>
               
                    <td>Nota</td>
                    <td><input type="text" name="nota" value="<%= reg.getNota()%>"></td>
                
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
            </div>
        </form>
    </body>
</html>
