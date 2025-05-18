package utilidades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import clases.Persona;

import java.lang.reflect.Type;
import java.util.List;

public class JsonAObjetoJava {

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

}