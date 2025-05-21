<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>

<title>Página identificación</title>
</head>
<body>
<div class="container mt-5 shadow m-5 p-5">
	<h2 class="">Bienvenido, ${rol} ${nombre} ${apellidos}</h2>
	<p> <a href="http://localhost:8080/Trabajo/alumno/asignaturas">Lista Asignaturas</a> .</p>
	<p> <a href="/Trabajo/identificacion?action=cierra" target="_self">cerrar sesión</a> </p>
</div>
<%@ include file="/includes/footer.jsp" %>