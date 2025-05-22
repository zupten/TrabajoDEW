<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/includes/header.jsp" %>

 <title>Login Alumno</title>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
  <div class="container mt-5">
    <div class="row justify-content-center">
      <div class="col-md-5">
        <div class="card shadow-sm">
          <div class="card-body">
            <h3 class="card-title text-center mb-4">Iniciar sesión</h3>
            <form action="j_security_check" method="post">
              <div class="mb-3">
                <label for="j_username" class="form-label">DNI</label>
                <input type="text" class="form-control" id="j_username" name="j_username" required>
              </div>
              <div class="mb-3">
                <label for="j_password" class="form-label">Contraseña</label>
                <input type="password" class="form-control" id="j_password" name="j_password" required>
              </div>
              <div class="d-grid">
                <button type="submit" class="btn btn-primary">Entrar</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

<%@ include file="/includes/footer.jsp" %>

	
	
	