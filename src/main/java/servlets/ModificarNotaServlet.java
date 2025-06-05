package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.CentroEducativoService;

import java.io.IOException;


public class ModificarNotaServlet extends HttpServlet {
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String acronimo = request.getParameter("acronimo");
        double nota = Double.parseDouble(request.getParameter("nota"));

        HttpSession session = request.getSession();
        String pass = (String) session.getAttribute("pass");
        String usuario = request.getRemoteUser(); // el profesor autenticado

        try {
        	CentroEducativoService service = (CentroEducativoService) session.getAttribute("service");
        	if (service == null) {
        		service = new CentroEducativoService();
        		if (pass == null) pass = "123456";
        		service.init(usuario, pass);
        		session.setAttribute("service", service);
        	}
            service.modificarNota(dni, acronimo, nota);

            response.sendRedirect("/Trabajo/profesor/asignaturas");

        } catch (Exception e) {
            //error
            session.setAttribute("mensajeError", "Error al modificar la nota: " + e.getMessage());
            response.sendRedirect("/Trabajo/profesor/asignaturas");
        }

        
    }
}
