package paginas;

import java.io.IOException;
import java.util.List;

import clases.Asignatura;
import clases.AsignaturaNotaAlumno;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import service.CentroEducativoAPI;
import service.CentroEducativoService;

public class AsignaturasAlumnoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String dni = request.getRemoteUser(); // Tomcat ya autenticó
        CentroEducativoService service = (CentroEducativoService) session.getAttribute("service");
        //String key = (String) session.getAttribute("key");
        String pass = (String) session.getAttribute("pass");

        // Si no hay key, autenticarse en CentroEducativo
        //if (key == null) {
            //if (pass == null) {
                // Aquí deberías tener una forma de recuperar la contraseña del usuario.
                // Para pruebas, por ejemplo:
                //pass = "123456"; 
                //session.setAttribute("pass", pass);
            //}
            //key = CentroEducativoAPI.login(dni, pass);
            //session.setAttribute("key", key);
        //}

        // Llamar a la API REST para obtener asignaturas del alumno
        //List<Asignatura> asignaturas = CentroEducativoAPI.obtenerAsignaturasDeAlumno(dni, key);
        //request.setAttribute("asignaturas", asignaturas);

        try {
            if (service == null) {
            	service = new CentroEducativoService();
            	if (pass == null)
            		pass = "123456";
    			service.init(dni, pass);
            }
			AsignaturaNotaAlumno[] asignaturas = service.getAsginaturasPorAlumno(dni);
			request.setAttribute("asignaturas", asignaturas);
			
	        // Redirigir a la vista JSP
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/asignaturasAlumno.jsp");
	        
	        dispatcher.forward(request, response);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
     
        
    }
}

