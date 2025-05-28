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
</div>
<script src="/Trabajo/js/ajax.js"></script>
<%@ include file="/includes/footer.jsp" %>