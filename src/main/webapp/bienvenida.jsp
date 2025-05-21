<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/includes/header.jsp" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<title>Página bienvenida</title>
</head>
<body>
	<div class="container mt-5 shadow text-white m-5 p-5" style="background: url('imgs/kato.jpeg') center; background-size: cover;">
	        <h1>Bienvenid@ a <em>Notas OnLine</em></h1>
	        <h4 class="mt-3">
	            Una aplicación que cuesta más de lo que parece para conseguir menos de lo que creías... 
	            <strong>¿¡Qué más se puede pedir!?</strong>
	        </h4>
	        <br>
	        <br>
	        <br>
	</div>

    <div class="row m-5">
        <div class="col-md-8">
        	<h2>Si eres alumn@...</h2>
            <p>Podrás <a href="http://localhost:8080/Trabajo/identificacion">consultar</a> tus calificaciones... Debes contar con tus datos identificativos para acceder.</p>

            <h2 class="mt-4">Si eres profesor@...</h2>
            <p>Podrás <a href="http://localhost:8080/Trabajo/identificacion">consultar</a> o <a href="#">modificar</a> las calificaciones en tus asignaturas... Debes contar con tus datos identificativos para acceder.</p>
       
        </div>
        <div class="col-md-4">
        	 <div class="p-3 bg-white border rounded shadow-sm">
                <h5><strong>Grupo G14_labo_Miercoles_3TI12</strong></h5>
                <ol class="mt-2">
                    <li>López Izquierdo, Marcos</li>
                    <li>Monzó Sanchis, Toni</li>
                    <li>Navarro Chiner, Hugo</li>
                    <li>Notario Soto, Alejandro</li>
                    <li>Teng, Zupan</li>
                </ol>
            </div>
        </div>
    </div>
</div>

<%@ include file="/includes/footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>