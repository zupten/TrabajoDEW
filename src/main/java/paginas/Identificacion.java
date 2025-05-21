package paginas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Identificacion
 */
public class Identificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Identificacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion = request.getSession();
		
		String action = request.getParameter("action");
		String usuario = request.getRemoteUser();
		
		if(action != null && action.equals("cierra")) { //si se da la orden de cerrar sesión...
			sesion.invalidate();
			response.sendRedirect("/Trabajo");
			return;
		}
		
		else {
			request.setAttribute("idSesion", sesion.getId());
			request.setAttribute("usuario", usuario);
			
			String username = request.getRemoteUser();
			
			request.setAttribute("nombre", username);
			this.getServletContext().getRequestDispatcher("/identificacion.jsp").forward(request, response);
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
