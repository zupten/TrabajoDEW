package test;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        	out.println("<h1>Test acceso de datos by LMT</h1><br>");
        	// login, obtener KEY
        	String loginRL = "http://localhost:9090/CentroEducativo/login";
        	String loginJSON = "{\"dni\": \"111111111\", \"password\": \"654321\"}";
        	HttpClient clientLogin = HttpClient.newHttpClient();
        	
        	HttpRequest loginRequest = HttpRequest.newBuilder()
        			.uri(URI.create(loginRL))
        			.header("Content-Type", "application/json")
        			.POST(HttpRequest.BodyPublishers.ofString(loginJSON))
        			.build();
        	HttpResponse<String> loginResponse = clientLogin.send(loginRequest, HttpResponse.BodyHandlers.ofString());
        	String key = loginResponse.body();
        	
        	out.println("login KEY:" + key + "<br>");
        	
        	String sessionCookie = loginResponse.headers().firstValue("Set-Cookie").orElse("");

        	String url_GetAlumnos = "http://localhost:9090/CentroEducativo/alumnos?key=" + key;
        	out.println("URL enviado: " + url_GetAlumnos + "<br>");
        	HttpClient client = HttpClient.newHttpClient();
        	HttpRequest request_GetAlumnos = HttpRequest.newBuilder()
        			.uri(URI.create(url_GetAlumnos))
        			.header("Cookie", sessionCookie)
        			.build();
        	HttpResponse<String> responseGetAlumnos = client.send(request_GetAlumnos, HttpResponse.BodyHandlers.ofString());
        	String responseBodyAlumnos = responseGetAlumnos.body();
        	out.println(responseBodyAlumnos + "<br>");
        	String url_GetProfesores = "http://localhost:9090/CentroEducativo/profesores?key=" + key;
        	out.println("URL enviado: " + url_GetProfesores + "<br>");
        	HttpClient clientGetProfesores = HttpClient.newHttpClient();
        	HttpRequest request_GetProfesores = HttpRequest.newBuilder()
        			.uri(URI.create(url_GetAlumnos))
        			.header("Cookie", sessionCookie)
        			.build();
        	HttpResponse<String> responseGetProfesores = client.send(request_GetProfesores, HttpResponse.BodyHandlers.ofString());
        	String responseBodyProfesores = responseGetAlumnos.body();
        	out.println(responseBodyProfesores);
        	
        } catch (InterruptedException e) {
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
