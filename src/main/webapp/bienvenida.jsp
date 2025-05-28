<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jsp" %>

<title>Página bienvenida</title>
</head>
<body style="background-color: var(--color-fondo); font-family: 'Lexend', sans-serif;">

<%@ include file="/includes/barraSuperior.jsp" %>
    <div class="container mt-5 text-center">
        <div class="bienvenida-caja sombra-retro">
            <h1 style="color: var(--color-borde);">Bienvenid@ a <em>Notas OnLine</em></h1>
            <h4 class="mt-3">
                Una aplicación que cuesta más de lo que parece para conseguir menos de lo que creías... 
                <strong>¿¡Qué más se puede pedir!? </strong>
            </h4>
        </div>
    </div>

    <div class="container">
        <hr class="linea-verde">
    </div>
    
    <div class="row m-5">
        <div class="col-md-8">
            <h2 style="color: var(--color-borde);">Si eres alumn@...</h2>
            <p>
                Podrás <a href="/Trabajo/identificacion?login=alumno">consultar</a> tus calificaciones.<br>
                Debes contar con tus datos identificativos para acceder.
            </p>

            <h2 class="mt-4" style="color: var(--color-borde);">Si eres profesor@...</h2>
            <p>
                Podrás <a href="/Trabajo/identificacion?login=profesor">consultar</a> o <a href="">modificar</a> las calificaciones.<br>
                También necesitarás tus credenciales.
            </p>

            <div class="d-flex justify-content-start gap-3 mt-4">
                <a href="/Trabajo/alumno/asignaturas" class="boton-retro">Ver asignaturas</a>
                <%
                	if(request.getRemoteUser() != null) {
                %>
                		<a href="/Trabajo/identificacion?action=cierra" class="boton-retro">Cerrar sesión</a>
                <% } %>
            </div>
        </div>

        <div class="col-md-4">
            <div class="p-4 bg-white border rounded sombra-verde">
                <h5 style="color: var(--color-borde);"><strong>Grupo G14_labo_Miércoles_3TI12</strong></h5>
                <ol class="mt-3 mb-0" style="padding-left: 1.2rem;">
                    <li>López Izquierdo, Marcos</li>
                    <li>Monzó Sanchis, Toni</li>
                    <li>Navarro Chiner, Hugo</li>
                    <li>Notario Soto, Alejandro</li>
                    <li>Teng, Zupan</li>
                </ol>
            </div>
        </div>
    </div>

<%@ include file="/includes/footer.jsp" %>
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script> -->

