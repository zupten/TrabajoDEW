package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import clases.Alumno;
import clases.Asignatura;
import clases.AsignaturaNotaAlumno;
import clases.Profesor;

public class CentroEducativoService {

    private static final String URL = "http://localhost:9090/CentroEducativo";
    private String dni = "111111111";
    private String password = "654321";
    private String key;
    private String sessionCookie;
    public void init() throws IOException, InterruptedException {
        String loginUrl = URL + "/login";
        String loginJSON = "{\"dni\": \"" + dni + "\", \"password\": \"" + password + "\"}";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(loginUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(loginJSON))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        key = response.body();
        sessionCookie = response.headers().firstValue("Set-Cookie").orElse("");
    }

    public void init(String dni, String password) throws IOException, InterruptedException {
        String loginUrl = URL + "/login";
        String loginJSON = "{\"dni\": \"" + dni + "\", \"password\": \"" + password + "\"}";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(loginUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(loginJSON))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        key = response.body();
        sessionCookie = response.headers().firstValue("Set-Cookie").orElse("");
    }
    public Alumno[] getAlumnos() throws IOException, InterruptedException {
        String url = URL + "/alumnos?key=" + key;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Cookie", sessionCookie)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        Alumno[] alumnos = JsonAObjetoJavaService.parseAlumnosFromJson(responseBody);
        return alumnos;
    }

    public Profesor[] getProfesores() throws IOException, InterruptedException {
        String url = URL + "/profesores?key=" + key;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Cookie", sessionCookie)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        Profesor[] profesores = JsonAObjetoJavaService.parseProfesoresFromJson(responseBody);
        return profesores;
    }
    
    public AsignaturaNotaAlumno[] getAsginaturasPorAlumno(String DNI) throws IOException, InterruptedException{
    	
    	String url = URL + "/alumnos/"+ DNI + "/asignaturas?key=" + key;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Cookie", sessionCookie)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        
        AsignaturaNotaAlumno[] asignaturas = JsonAObjetoJavaService.parseAsignaturaNotaAlumnoFromJson(responseBody);
		return asignaturas;
    	
    }
    
    //getAsignaturasDeProfesor
    public Asignatura[] getAsignaturasDeProfesor(String DNI) throws IOException, InterruptedException{
    	
    	String url = URL + "/profesores/"+ DNI + "/asignaturas?key=" + key;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Cookie", sessionCookie)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        
        Asignatura[] asignaturas = JsonAObjetoJavaService.parseAsignaturaFromJson(responseBody);
		return asignaturas;
    	
    }

    
    //getAlumnosDeAsignatura
    public String getAlumnosDeAsignatura(String acronimo) throws IOException, InterruptedException{
    	
    	String url = URL + "/asignaturas/"+ acronimo + "/alumnos?key=" + key;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Cookie", sessionCookie)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        
        return responseBody;
    }
    
    //setNotaToAsignaturaAlumno
    public void modificarNota(String dni, String acronimo, double nota) throws IOException, InterruptedException {
        String url = URL + "/alumnos/" + dni + "/asignaturas/" + acronimo + "?key=" + key;

        HttpClient client = HttpClient.newHttpClient();
        
        
        String notaF = String.format(java.util.Locale.US, "%.2f", nota);//Asegura que el número decimal tenga punto como separador
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Cookie", sessionCookie)
                .PUT(HttpRequest.BodyPublishers.ofString(notaF))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Error al modificar la nota. Código: " + response.body());
        }
    }
    
    //GetNotas
    public AsignaturaNotaAlumno[] getNotasDeAsignatura(String acronimo) throws IOException, InterruptedException {
        String url = URL + "/asignaturas/" + acronimo + "/alumnos?key=" + key;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Cookie", sessionCookie)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        return JsonAObjetoJavaService.parseAsignaturaNotaAlumnoFromJson(responseBody);
    }

    

}
