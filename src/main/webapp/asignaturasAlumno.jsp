<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jsp" %>
<head>
    <title>Asignaturas del Alumno</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Asignaturas en las que estás matriculado</h2>
    <ul class="list-group mt-4">
        <c:forEach var="asignatura" items="${asignaturas}">
            <li class="list-group-item">
                <a href="detalleAsignatura?acronimo=${asignatura.acronimo}">
                    ${asignatura.nombre} (${asignatura.acronimo})
                </a>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
<%@ include file="/includes/footer.jsp" %>