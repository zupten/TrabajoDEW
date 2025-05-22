<%@page import="clases.AsignaturaNotaAlumno"%>
<%@page import="paginas.AsignaturasAlumnoServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jsp" %>

<div class="container mt-5">
    <div class="bienvenida-caja sombra-verde">
        <h2 class="mb-4">Asignaturas en las que estás matriculado</h2>

        <%
        	AsignaturaNotaAlumno[] asignaturas = (AsignaturaNotaAlumno[]) request.getAttribute("asignaturas");

        	if (asignaturas != null && asignaturas.length > 0) {
        %>
        <ul class="list-group">
            <%
                for (int i = 0; i < asignaturas.length; i++) {
            %>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <span><strong><%= asignaturas[i].getAsignatura() %></strong></span>
                <span class="badge rounded-pill"
                      style="background-color: var(--color-boton); color: white;">
                    <%= asignaturas[i].getNota() %>
                </span>
            </li>
            <%
                }
            %>
        </ul>
        <%
        	} else {
        %>
        <p class="text-muted">No se han encontrado asignaturas.</p>
        <%
        	}
        %>

        <div class="mt-4 text-center">
            <a href="/Trabajo/certificado" class="boton-retro">Ver certificado de notas</a>
        </div>
    </div>
</div>

<%@ include file="/includes/footer.jsp" %>
