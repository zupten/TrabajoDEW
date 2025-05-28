<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String rol;
	if(request.isUserInRole("alumno")) {
		rol = "alumno";
	} else if (request.isUserInRole("profsor")) {
		rol = "profesor";
	} else {
		rol = null;
	}

%>
<nav class="barra-superior">
        <ul>
            <li><a href="/Trabajo">Bienvenida</a></li>
            <%
            	if (rol != null) {
            %>
            	<li><a href="/Trabajo/identificacion?action=cierra">Logout</a></li>
            <%
            	}
            %>
        </ul>
 </nav>