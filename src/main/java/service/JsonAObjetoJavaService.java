package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import clases.Alumno;
import clases.Persona;
import clases.Profesor;

import java.lang.reflect.Type;
import java.util.List;

public class JsonAObjetoJavaService {

    public static Persona[] parsePersonasFromJson(String json) {
        try {
            Gson gson = new Gson();
            Type personaListType = new TypeToken<List<Persona>>() {}.getType();
            List<Persona> personaList = gson.fromJson(json, personaListType);
            return personaList.toArray(new Persona[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return new Persona[0];
        }
    }
    public static Alumno[] parseAlumnosFromJson(String json) {
        try {
            Gson gson = new Gson();
            Type alumnoListType = new TypeToken<List<Alumno>>() {}.getType();
            List<Alumno> alumnoList = gson.fromJson(json, alumnoListType);
            return alumnoList.toArray(new Alumno[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return new Alumno[0];
        }
    }
    public static Profesor[] parseProfesoresFromJson(String json) {
        try {
            Gson gson = new Gson();
            Type profesorListType = new TypeToken<List<Profesor>>() {}.getType();
            List<Profesor> profesorList = gson.fromJson(json, profesorListType);
            return profesorList.toArray(new Profesor[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return new Profesor[0];
        }
    }
}