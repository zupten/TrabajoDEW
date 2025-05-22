 package paginas;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CentroEducativoService;

import java.io.IOException;

import clases.AsignaturaNotaAlumno;
import clases.Alumno;

/**
 * Servlet implementation class CertificadoServlet
 */
@WebServlet("/certificado")
public class CertificadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CertificadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
        String dni = request.getRemoteUser();
        String pass = (String) session.getAttribute("pass");
        CentroEducativoService service = (CentroEducativoService) session.getAttribute("service");
     
             
        try {
        	if (service == null) {
    			service = new CentroEducativoService();
    			if (pass == null) pass = "123456";    			
    			service.init(dni, pass);
    			session.setAttribute("service", service);
    		}
        		
			
			AsignaturaNotaAlumno[] asignaturas = service.getAsginaturasPorAlumno(dni);
			request.setAttribute("asignaturas", asignaturas);

			Alumno[] alumnos = service.getAlumnos();
			String nombre = "Desconocido";
			String apellidos = "Desconocido";

			for (Alumno a : alumnos) {
			    if (a.getDni().equals(dni)) {
			        nombre = a.getNombre();
			        apellidos = a.getApellidos();
			        break;
			    }
			}
			request.setAttribute("nombre", nombre);
			request.setAttribute("apellidos", apellidos);
			request.setAttribute("dni", dni);

						
			RequestDispatcher dispatcher = request.getRequestDispatcher("/certificado.jsp");
			dispatcher.forward(request, response);
			
		} catch (IOException | InterruptedException e) {
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
