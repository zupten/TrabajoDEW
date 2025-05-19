package paginas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
	    String usuario = request.getParameter("usuario");
	    String contrasena = request.getParameter("contra");
	    if (("alumno".equals(usuario) && "1234".equals(contrasena)) ||
	        ("profe".equals(usuario) && "abcd".equals(contrasena))) {
	        response.sendRedirect("bienvenida.jsp");
	    } else {
	        response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().println("<html><body><h2>Login incorrecto</h2><a href='login.html'>Volver</a></body></html>");
	    }
	}

}
