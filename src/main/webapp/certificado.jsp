<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="clases.AsignaturaNotaAlumno" %>
<%@ include file="/includes/header.jsp" %>

<%
    String dni = (String) session.getAttribute("dni");
    String nombre = (String) session.getAttribute("nombre");
    String apellidos = (String) session.getAttribute("apellidos");
    AsignaturaNotaAlumno[] asignaturas = (AsignaturaNotaAlumno[]) request.getAttribute("asignaturas");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Certificado de Notas</title>
<link href="b5css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
	<div class="card mb-4 p-4">
        <div class="row">
            <div class="col-md-3">
                <img src="" alt="Foto del alumno">
            </div>
            <div class="col-md-9">
                <h4><%= apellidos %>, <%= nombre %> (<%= dni %>)</h4>
                <p>
                [Matriculad@ en:
                <%
                    if (asignaturas != null && asignaturas.length > 0) {
                        for (int i = 0; i < asignaturas.length; i++) {
                            out.print(asignaturas[i].getAsignatura());
                            if (i < asignaturas.length - 1) out.print(", ");
                        }
                    } else {
                        out.print("Ninguna asignatura");
                    }
                %>]
                </p>
            </div>
        </div>
    </div>
</div>  
<div>
        <p> El alumno/a ha estado matriculado/a en las siguientes asignaturas y ha obtenido las calificaciones que se indican:</p>
        <ul class="list-group mb-4">
        <%
            if (asignaturas != null && asignaturas.length > 0) {
                for (int i = 0; i < asignaturas.length; i++) {
        %>
            <li class="list-group-item d-flex justify-content-between">
                <span><%= asignaturas[i].getAsignatura() %></span>
                <strong><%= asignaturas[i].getNota() %></strong>
            </li>
        <%
                }
            } else {
        %>
            <li class="list-group-item">No hay asignaturas disponibles</li>
        <%
            }
        %>
        </ul>
</div>
</body>
</html>

<%@ include file="/includes/footer.jsp" %>