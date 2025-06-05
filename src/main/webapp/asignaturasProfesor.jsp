<%@page import="clases.Asignatura"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>
<title>Asignaturas Profesor</title>
</head>
<body>
<div class="container mt-5">
    <div class="bienvenida-caja sombra-verde">
        <h2 class="mb-3">Asignaturas que impartes</h2>
        <p>Haz clic en una asignatura para listar alumnos y modificar sus notas.</p>

        <%-- Mensaje de error --%>
        <%
            String mensaje = (String) session.getAttribute("mensajeError");
            if (mensaje != null) {
        %>
            <div class="alert alert-danger mt-3" role="alert">
                <%= mensaje %>
            </div>
        <%
                session.removeAttribute("mensajeError");
            }

            String mensajeOk = (String) session.getAttribute("mensajeOK");
            if (mensajeOk != null) {
        %>
            <div class="alert alert-success mt-3" role="alert">
                <%= mensajeOk %>
            </div>
        <%
                session.removeAttribute("mensajeOK");
            }
        %>

        <div class="table-responsive mt-4">
            <table class="table table-bordered align-middle text-center">
                <thead class="table-light">
                    <tr>
                        <th>#</th>
                        <th>Acrónimo</th>
                        <th>Nombre completo</th>
                    </tr>
                </thead>
                <tbody>
                <%
                    Asignatura[] asignaturas = (Asignatura[]) request.getAttribute("asignaturas");
                    for (int i = 0; i < asignaturas.length; i++) {
                %>
                    <tr>
                        <td><%= i + 1 %> / <%= asignaturas.length %></td>
                        <td>
                            <button type="button" class="boton-retro boton-async">
                                <%= asignaturas[i].getAcronimo() %>
                            </button>
                        </td>
                        <td><%= asignaturas[i].getNombre() %></td>
                    </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>

        <div id="salida" class="mt-4"></div>

        <div class="text-center mt-4">
            <a href="/Trabajo" class="btn btn-secondary">Volver al inicio</a>
        </div>
    </div>
</div>

<%@ include file="/includes/footer.jsp" %>
<script src="/Trabajo/js/ajax.js"></script>
</body>
</html>
