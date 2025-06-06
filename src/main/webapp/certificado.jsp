<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="clases.AsignaturaNotaAlumno" %>
<%@ page import="servlets.CertificadoServlet" %>
<%@ include file="/includes/header.jsp" %>

<%
    String dni = (String) request.getAttribute("dni");
    String nombre = (String) request.getAttribute("nombre");
    String apellidos = (String) request.getAttribute("apellidos");
    AsignaturaNotaAlumno[] asignaturas = (AsignaturaNotaAlumno[]) request.getAttribute("asignaturas");
%>

<title>Certificado de Notas</title>
<style>
@media print {
    .no-print {
        display: none !important;
    }
}
</style>
</head>
<body>

<div class="container mt-5">
    <div class="bienvenida-caja sombra-verde">
        <div class="row">
            <%
                String dniFoto = (dni != null && !dni.isEmpty()) ? dni : "default_chico";
            %>
            <div class="col-md-3 mb-3">
                <img src="imgs/fotos/<%= dniFoto %>.jpeg" alt="Foto del alumno" class="img-fluid rounded sombra-retro">
            </div>
            <div class="col-md-9">
                <h4 class="mb-3"><%= apellidos %>, <%= nombre %> (<%= dni %>)</h4>
                <p class="mb-2">
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
                <p class="mt-3 text-muted">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                    Integer quis interdum tellus. Etiam eget diam lacus.
                    Sed at sem rutrum, pretium metus non, tristique enim.
                    Praesent nec placerat elit, vitae euismod ante.
                </p>
            </div>
        </div>
    </div>

    <hr class="linea-verde" />

    <p class="text-center">El alumno ha estado matriculado en las siguientes asignaturas y ha obtenido las calificaciones que se indican:</p>

    <ul class="list-group shadow mb-4">
        <%
            if (asignaturas != null && asignaturas.length > 0) {
                for (int i = 0; i < asignaturas.length; i++) {
        %>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <%= asignaturas[i].getAsignatura() %>
                <span class="badge bg-primary rounded-pill"><%= asignaturas[i].getNota() %></span>
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
	<div class="text-center m-3 no-print">
		<button onclick="window.print()" class="btn btn-success"> Imprimir esta página</button>
	</div>
    <div class="text-center no-print">
        <a href="/Trabajo" class="btn btn-secondary ">Volver al inicio</a>
    </div>
</div>

<%@ include file="/includes/footer.jsp" %>
