<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>

<div class="container mt-5">
  <div class="bienvenida-caja sombra-verde" style="max-width: 500px;">
    <h2 class="mb-4">Iniciar sesión</h2>
    
    <form action="j_security_check" method="post">
      <div class="mb-3 text-start">
        <label for="j_username" class="form-label">DNI</label>
        <input type="text" id="j_username" name="j_username" class="form-control" required>
      </div>

      <div class="mb-3 text-start">
        <label for="j_password" class="form-label">Contraseña</label>
        <input type="password" id="j_password" name="j_password" class="form-control" required>
      </div>

      <div class="d-grid mt-4">
        <button type="submit" class="boton-retro">Entrar</button>
      </div>
    </form>

    <p class="text-muted mt-4" style="font-size: 0.9rem;">
      Si tienes problemas para acceder, consulta con el profesor o revisa tu DNI.
    </p>
  </div>
</div>

<%@ include file="/includes/footer.jsp" %>


