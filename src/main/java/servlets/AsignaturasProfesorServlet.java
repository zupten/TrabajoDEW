package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CentroEducativoService;

import java.io.IOException;

import clases.Asignatura;
import clases.AsignaturaNotaAlumno;

/**
 * Servlet implementation class AsignaturasProfesorServlet
 */
public class AsignaturasProfesorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String dni = request.getRemoteUser();
        CentroEducativoService service = (CentroEducativoService) session.getAttribute("service");

        String pass = (String) session.getAttribute("pass");
        if (!request.isUserInRole("profesor")) {
			request.setAttribute("mensaje", "no tienes permiso de acceso");
			this.getServletContext().getRequestDispatcher("/errorLogin.jsp").forward(request, response);
		}
        try {
            if (service == null) {
            	service = new CentroEducativoService();
            	if (pass == null)
            		pass = "123456";
    			service.init(dni, pass);
            }
			Asignatura[] asignaturas = service.getAsignaturasDeProfesor(dni);
			request.setAttribute("asignaturas", asignaturas);
			
	        // Redirigir a la vista JSP
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/asignaturasProfesor.jsp");
	        
	        dispatcher.forward(request, response);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
     
        
    }
}
