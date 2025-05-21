package paginas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CentroEducativoService;

import java.io.IOException;

import clases.Alumno;
import clases.Profesor;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
		    String usuario = request.getParameter("usuario");
		    String contrasena = request.getParameter("contra");
		    CentroEducativoService service = new CentroEducativoService();
				service.init();
        	Alumno[] alumnos = service.getAlumnos();

        	for (Alumno p : alumnos) {
        		if(p.getDni().equals(usuario)) { //&& p.getPassword().equals(contrasena)) { //password es null en todos
        			request.setAttribute("rol", "alumno");
        			request.setAttribute("nombre", p.getNombre());
        	        request.setAttribute("apellidos", p.getApellidos());
        			response.sendRedirect("/Trabajo/auth/identificacion");
        			//getServletContext().getRequestDispatcher("/identificacion.jsp").forward(request, response);
        		}
        	}
        	Profesor[] profesores = service.getProfesores();
        	for (Profesor p : profesores) {
        		if(p.getDni().equals(usuario))  { //&& p.getPassword().equals(contrasena)) {
        			request.setAttribute("rol", "profesor");
        			request.setAttribute("nombre", p.getNombre());
        	        request.setAttribute("apellidos", p.getApellidos());
        			response.sendRedirect("/Trabajo/auth/identificacion");
        			//getServletContext().getRequestDispatcher("/identificacion.jsp").forward(request, response);
        		}
        	}
	        response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().println("<html><body><h2>Login incorrecto</h2><a href='login.html'>Volver</a></body></html>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
