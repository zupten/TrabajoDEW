<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>

<title>Página identificación</title>
</head>
<body style="background-color: var(--color-fondo); font-family: 'Lexend', sans-serif;">

<div class="container mt-5 text-center">
    <div class="bienvenida-caja sombra-retro p-4">
        <h2 style="color: var(--color-borde);">Bienvenido/a, ${rol} ${nombre} ${apellidos}</h2>
        <hr class="linea-verde mb-4">

        <div class="d-grid gap-3">
            <%
                if (request.isUserInRole("alumno")) {
            %>
                <a href="/Trabajo/alumno/asignaturas" class="boton-retro">Ver asignaturas</a>
            <%
                } else if (request.isUserInRole("profesor")) {
            %>
                <a href="/Trabajo/profesor/asignaturas" class="boton-retro">Ver asignaturas impartidas</a>
            <%
                }
            %>
            <a href="/Trabajo/identificacion?action=cierra" class="boton-retro mt-3">Cerrar sesión</a>
        </div>
    </div>
</div>

<%@ include file="/includes/footer.jsp" %>
