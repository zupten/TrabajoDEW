<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>

<title>Página identificación</title>
</head>
<body>
<%@ include file="/includes/barraSuperior.jsp" %>
<div class="container mt-5 shadow m-5 p-5">
	<h2 class="">Bienvenido, ${rol} ${nombre} ${apellidos}</h2><br>
	<%
		if (request.isUserInRole("alumno")) {
	%>
			<p> <a href="/Trabajo/alumno/asignaturas">Lista Asignaturas</a></p>
	<%
		} else if (request.isUserInRole("profesor")) {
	%>
			<p>Eres profesor</p>
			<p>Prueba acceder <a href="/Trabajo/alumno/asignaturas">Lista Asignaturas de alumno</a> (lanzará acceso denegado)</p>
			<p> <a href="/Trabajo/profesor/asignaturas">Lista Asignaturas impartiendo</a></p>
	<%
		}
	%>
	<p> <a href="/Trabajo/identificacion?action=cierra" target="_self">cerrar sesión</a> </p>
</div>
<%@ include file="/includes/footer.jsp" %>