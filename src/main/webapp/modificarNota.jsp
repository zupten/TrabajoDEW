<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String dni = request.getParameter("dni");
    String acronimo = request.getParameter("acronimo");
%>

<html>
<head>
    <title>Modificar Nota</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" />
</head>
<body>
<div class="container mt-5">
    <h3>Modificar nota del alumno</h3>
    <form method="post" action="/Trabajo/profesor/modificarNota">
   		<div class="mb-3">
        	<label>DNI del alumno</label>
        	<input type="text" class="form-control" name="dni" value="<%= dni != null ? dni : "" %>" readonly />
    	</div>
    	<div class="mb-3">
        	<label>Acrónimo de la asignatura</label>
        	<input type="text" class="form-control" name="acronimo" value="<%= acronimo != null ? acronimo : "" %>" readonly />
    	</div>
    	<div class="mb-3">
        	<label>Nueva nota</label>
        	<input type="number" class="form-control" name="nota" min="0" max="10" step="0.1" required />
    	</div>
    	<button type="submit" class="btn btn-primary">Modificar nota</button>
	</form>



</div>
</body>
</html>