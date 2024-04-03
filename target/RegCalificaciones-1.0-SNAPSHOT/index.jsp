<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Estudiante "%>
<%
    if (session.getAttribute("listaest") == null){
        ArrayList<Estudiante> lisaux = new ArrayList<Estudiante>();
        session.setAttribute("listaest", lisaux);
    }
    ArrayList<Estudiante> lista=(ArrayList<Estudiante>) session.getAttribute("listaest");
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
            h1{
                text-align: center;
            }
            
        </style>
    </head>
    <body>
        <div class="contenedor">
            <p>PRIMER PARCIAL TEM-742<br>
            Nombre: Kevin Efrain Canaviri Callisaya<br>
            Carnet: 10095136</p>
        </div>
        <h1>  Registro de Calificaciones</h1>
        <div style="text-align: center;">
        <a href="MainServlet?op=nuevo">Nuevo</a>
        </div>
        <table border = "1" align= "center">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>P1(30)</th>
                <th>P2(30)</th>
                <th>EF(40)</th>
                <th>Nota</th>
                <th></th>
                <th></th>
            </tr>
            <%
              if (lista != null){
                  for(Estudiante item:lista){
                %>
                <tr>
                    <td><%=item.getId()%></td> 
                    <td><%=item.getNombre_del_estudiante()%></td> 
                    <td><%=item.getPrimer_Parcial()%></td> 
                    <td><%=item.getSegundo_Parcial()%></td> 
                    <td><%=item.getExamen_Final()%></td>
                    <td><%=item.getNota()%></td> 
                    <td>
                        <a href="MainServlet?op=editar&id=<%=item.getId()%>">Editar</a>
                    </td>
                    <td>
                        <a href="MainServlet?op=eliminar&id=<%=item.getId()%>" 
                            onclick="return(confirm('Esta seguro de eliminar ?'))"
                            >Eliminar</a>
                    </td>
                    
                </tr>
                <%
                    }
}
                    %>
        </table>
    </body>
</html>
