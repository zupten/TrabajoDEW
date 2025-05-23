<%@page import="clases.AsignaturaNotaAlumno"%>
<%@page import="paginas.AsignaturasAlumnoServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jsp" %>
<body>
<div class="container mt-5">
    <h2>Asignaturas en las que estás matriculado</h2>
    <ul class="list-group mt-4">
        <%
        	AsignaturaNotaAlumno[] asignaturas = (AsignaturaNotaAlumno[]) request.getAttribute("asignaturas");
        	for (int i = 0; i<asignaturas.length; i++) {
        %>
        	<p>Asignatura: <%= asignaturas[i].getAsignatura()%>; Nota:  <%= asignaturas[i].getNota()%></p>
        <%
        	}
        %>
    </ul>
    
    <a href="/Trabajo/certificado" class="btn btn-primary mt-3">Ver certificado de notas</a>
    
</div>
<%@ include file="/includes/footer.jsp" %>

