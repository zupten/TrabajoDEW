<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/includes/header.jsp" %>
<%
    String dni = request.getParameter("dni");
    String acronimo = request.getParameter("acronimo");
%>
<title>Modificar Nota</title>
</head>
<body>
<div class="container mt-5">
    <div class="bienvenida-caja sombra-verde">
        <h2 class="mb-4">Modificar nota del alumno</h2>

        <form method="post" action="/Trabajo/profesor/modificarNota">
            <div class="mb-3 text-start">
                <label class="form-label">DNI del alumno</label>
                <input type="text" class="form-control" name="dni" value="<%= dni != null ? dni : "" %>" readonly />
            </div>
            <div class="mb-3 text-start">
                <label class="form-label">Acrónimo de la asignatura</label>
                <input type="text" class="form-control" name="acronimo" value="<%= acronimo != null ? acronimo : "" %>" readonly />
            </div>
            <div class="mb-3 text-start">
                <label class="form-label">Nueva nota</label>
                <input type="number" class="form-control" name="nota" min="0" max="10" step="0.1" required />
            </div>

            <div class="text-center">
                <button type="submit" class="boton-retro">Modificar nota</button>
            </div>
        </form>
    </div>
</div>

<%@ include file="/includes/footer.jsp" %>
</body>
</html>
