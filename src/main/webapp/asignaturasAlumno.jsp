<%@page import="clases.AsignaturaNotaAlumno"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>
<title>Asignaturas Alumno</title>
</head>
<body>
<div class="container mt-5">
    <div class="bienvenida-caja sombra-verde">
        <h2 class="mb-4">Asignaturas en las que estás matriculado</h2>

        <ul class="list-group shadow-sm">
            <%
                AsignaturaNotaAlumno[] asignaturas = (AsignaturaNotaAlumno[]) request.getAttribute("asignaturas");
                if (asignaturas != null) {
                    for (int i = 0; i < asignaturas.length; i++) {
            %>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    <span><strong><%= asignaturas[i].getAsignatura() %></strong></span>
                    <span class="badge bg-success rounded-pill"><%= asignaturas[i].getNota() %></span>
                </li>
            <%
                    }
                } else {
            %>
                <li class="list-group-item">No se encontraron asignaturas.</li>
            <%
                }
            %>
        </ul>

        <div class="mt-4 text-center">
            <a href="/Trabajo/certificado" class="btn boton-retro">Ver certificado de notas</a>
        </div>
    </div>
</div>

<%@ include file="/includes/footer.jsp" %>
