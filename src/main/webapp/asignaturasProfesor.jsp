<%@page import="clases.Asignatura"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>
<title>Asignaturas Alumno</title>
</head>
<body>
<div class="container mt-5">
    <h2>Asignaturas en las que estás impartiendo</h2>
    <p>haz click en una asignatura para listar alumnos y notas</p>
    //Mensaje que sale si se ha modificado
    <%
    	String mensaje = (String) session.getAttribute("mensajeError");
    	if (mensaje != null) {
	%>
    	<div class="alert alert-danger" role="alert">
        	<%= mensaje %>
    	</div>
	<%
        	session.removeAttribute("mensajeError");
    	}

    	String mensajeOk = (String) session.getAttribute("mensajeOK");
    	if (mensajeOk != null) {
	%>
    	<div class="alert alert-success" role="alert">
        	<%= mensajeOk %>
    	</div>
	<%
        session.removeAttribute("mensajeOK");
    	}
	%>
    <table>
    	<tr>
    		<th>Nº</th>
    		<th>acronimo</th>
    		<th>nombre completo</th>
    	</tr>
        <%
        	Asignatura[] asignaturas = (Asignatura[]) request.getAttribute("asignaturas");
        	for (int i = 0; i<asignaturas.length; i++) {
        %>
        	<tr><td><%=i+1%>/<%=asignaturas.length%> </td><td><button type="button" class="boton-async"><%= asignaturas[i].getAcronimo() %></button></td><td><%= asignaturas[i].getNombre()%></td></tr>
        <%
        	}
        %>
    </table>
    <div id="salida">
    </div>
    
    <div class="mt-4 text-center">
    <a href="/Trabajo" class="btn btn-secondary">Volver al inicio</a>
</div>
    
</div>

<%@ include file="/includes/footer.jsp" %>
<script src="/Trabajo/js/ajax.js"></script>
</body>
</html>