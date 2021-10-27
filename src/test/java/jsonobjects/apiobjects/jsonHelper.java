package jsonobjects.apiobjects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class jsonHelper {

    private static String json;
    private Object T;
    private static String jsonPath = "src/test/resources/%s.json";
    private ObjectMapper mapper = new ObjectMapper();

    public static String readJson(String path) {
        try {
            json = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static <T> T getObjectFromJson(String value) throws JsonProcessingException {
        json = String.format(jsonPath, value);
        ObjectMapper mapper = new ObjectMapper();
        switch (value) {
            case "addPlace":
                return (T) mapper.readValue(readJson(json), AddPlace.class);
            case "cat":
                return (T) mapper.readValue(readJson(json), Cat.class);
            default:
                return null;
        }
    }


    public AddPlace getAddPlace(String value){
        json = String.format(jsonPath, value);
        AddPlace addPlace = null;
        try {
            addPlace = mapper.readValue(readJson(json), AddPlace.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return addPlace;
    }
}



