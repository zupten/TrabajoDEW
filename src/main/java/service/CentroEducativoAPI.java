package service;
import java.io.*;
import java.net.*;
import java.util.*;

public class CentroEducativoAPI {

    private static final String API_URL = "http://localhost:9090/CentroEducativo";

    public static String login(String dni, String password) {
        try {
            URL url = new URL(API_URL + "/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInput = "{\"dni\":\"" + dni + "\",\"password\":\"" + password + "\"}";

            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonInput.getBytes());
                os.flush();
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String key = in.readLine().replace("\"", ""); // eliminar comillas del string JSON simple
            in.close();
            return key;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Asignatura> obtenerAsignaturasDeAlumno(String dni, String key) {
        List<Asignatura> lista = new ArrayList<>();

        try {
            URL url = new URL(API_URL + "/alumnosyasignaturas?key=" + key);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                responseBuilder.append(line);
            }
            in.close();

            String response = responseBuilder.toString();

            // Buscar alumno por dni
            String dniTag = "\"dni\":\"" + dni + "\"";
            int dniIndex = response.indexOf(dniTag);

            if (dniIndex != -1) {
                int asigIndex = response.indexOf("\"asignaturas\":[", dniIndex);
                if (asigIndex != -1) {
                    int start = asigIndex + "\"asignaturas\":[".length();
                    int end = response.indexOf("]", start);
                    String asignaturasStr = response.substring(start, end);

                    String[] asignaturasArray = asignaturasStr.replace("\"", "").split(",");
                    for (String acronimo : asignaturasArray) {
                        if (!acronimo.trim().isEmpty()) {
                            lista.add(new Asignatura(acronimo.trim(), acronimo, acronimo, end, end));
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
