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

import clases.Alumno;
import clases.Asignatura;
import clases.AsignaturaNotaAlumno;

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
            	//html tabla
                AsignaturaNotaAlumno[] alumnosNotas = service.getNotasDeAsignatura(acronimo);
            	Alumno[] todosAlumnos = service.getAlumnos();

            	response.setContentType("text/html;charset=UTF-8");
            	StringBuilder html = new StringBuilder();

            	html.append("<table class='table table-striped'>");
            	html.append("<thead><tr><th>DNI</th><th>Nombre completo</th><th>Nota</th><th>Acción</th></tr></thead>");
            	html.append("<tbody>");

            	for (AsignaturaNotaAlumno reg : alumnosNotas) {
            	    String dniAlumno = reg.getAlumno();
            	    String nota = String.valueOf(reg.getNota());

            	    // Buscar nombre y apellidos
            	    String nombreCompleto = dniAlumno;
            	    for (Alumno a : todosAlumnos) {
            	        if (a.getDni().equals(dniAlumno)) {
            	            nombreCompleto = a.getNombre() + " " + a.getApellidos();
            	            break;
            	        }
            	    }

            	    html.append("<tr>");
            	    html.append("<td>").append(dniAlumno).append("</td>");
            	    html.append("<td>").append(nombreCompleto).append("</td>");
            	    html.append("<td class=\"nota\">").append(nota).append("</td>");
            	    html.append("<td>");
            	    html.append("<a class='btn btn-sm btn-warning' href='/Trabajo/modificarNota.jsp?dni=")
            	        .append(dniAlumno)
            	        .append("&acronimo=")
            	        .append(acronimo)
            	        .append("'>Modificar nota</a>");
            	    html.append("</td>");
            	    html.append("</tr>");
            	}
            	html.append("</tbody></table>");
                html.append("<button type='button' class='boton-retro' id='boton-media'>Calcular media</button>");

            	response.getWriter().print(html.toString());

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
