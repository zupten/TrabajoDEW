package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import clases.Alumno;
import clases.Asignatura;
import clases.AsignaturaNotaAlumno;
import clases.Persona;
import clases.Profesor;

import java.lang.reflect.Type;
import java.util.List;

public class JsonAObjetoJavaService {

	public static <T> T[] parseArrayFromJson(String json, Class<T> clazz) {
        try {
            Gson gson = new Gson();
            Type listType = TypeToken.getParameterized(List.class, clazz).getType();
            List<T> list = gson.fromJson(json, listType);
            @SuppressWarnings("unchecked")
            T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, list.size());
            return list.toArray(array);
        } catch (Exception e) {
            e.printStackTrace();
            @SuppressWarnings("unchecked")
            T[] emptyArray = (T[]) java.lang.reflect.Array.newInstance(clazz, 0);
            return emptyArray;
        }
    }

    public static Persona[] parsePersonasFromJson(String json) {
        return parseArrayFromJson(json, Persona.class);
    }

    public static Alumno[] parseAlumnosFromJson(String json) {
        return parseArrayFromJson(json, Alumno.class);
    }

    public static Profesor[] parseProfesoresFromJson(String json) {
        return parseArrayFromJson(json, Profesor.class);
    }

    public static AsignaturaNotaAlumno[] parseAsignaturaNotaAlumnoFromJson(String json) {
        return parseArrayFromJson(json, AsignaturaNotaAlumno.class);
    }

    public static Asignatura[] parseAsignaturaFromJson(String json) {
        return parseArrayFromJson(json, Asignatura.class);
    }
    
}