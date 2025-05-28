<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    String mensaje = (String) request.getAttribute("mensaje");
%>
<%@ include file="/includes/header.jsp" %>
<title>Página error</title>
</head>
<div class="container mt-5">
  <div class="bienvenida-caja sombra-verde text-center">
    <h2 class="mb-4">Error de autenticación</h2>
	<% if (mensaje != null) { %>
		<p> <%=  mensaje%>
	<% } else { %>
    <p>El nombre de usuario o la contraseña introducidos no son correctos.</p>
    <p>Por favor, vuelve a intentarlo.</p>
    <% } %>

    <div class="mt-4">
      <a href="/Trabajo" class="boton-retro">Volver a la página principal</a>
    </div>
  </div>
</div>

<%@ include file="/includes/footer.jsp" %>
