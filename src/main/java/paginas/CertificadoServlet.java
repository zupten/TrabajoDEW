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
        String dni = (String) session.getAttribute("dni");
        String nombre = (String) session.getAttribute("nombre");
        String apellidos = (String) session.getAttribute("apellidos");
        String pass = (String) session.getAttribute("pass");
        CentroEducativoService service = (CentroEducativoService) session.getAttribute("service");
        
        try {
        	if (service == null) {
    			service = new CentroEducativoService();
    			session.setAttribute("service", service);
    			if (pass == null) pass = "123456";
    			service.init(dni, pass);
    		}
        	
			AsignaturaNotaAlumno[] asignaturas = service.getAsginaturasPorAlumno(dni);
			
			request.setAttribute("asignaturas", asignaturas);
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
