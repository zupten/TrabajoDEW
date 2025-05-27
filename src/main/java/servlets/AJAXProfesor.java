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

/**
 * Servlet implementation class AJAXProfesor
 */
public class AJAXProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String dni = request.getRemoteUser();
        CentroEducativoService service = (CentroEducativoService) session.getAttribute("service");

        String pass = (String) session.getAttribute("pass");

        try {
            if (service == null) {
            	service = new CentroEducativoService();
            	if (pass == null)
            		pass = "123456";
    			service.init(dni, pass);
            }
            
            String action = request.getParameter("action");
            if (action != null && action.equals("AlumnosDeAsignatura")) {
                String acronimo = request.getParameter("acronimo");
            	response.setContentType("application/json");
            	response.setCharacterEncoding("UTF-8");
            	String json = service.getAlumnosDeAsignatura(acronimo);
            	response.getWriter().print(json);
            }
            
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
     
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
