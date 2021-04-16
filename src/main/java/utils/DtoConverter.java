package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.Map;

public class DtoConverter {
    static ObjectMapper mapper = new ObjectMapper();

    public static JsonObject stringToJsonObject(String json) {
        return new JsonParser().parse(json).getAsJsonObject();
    }

    public static String objectToJsonString(Object object) {
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public static Map stringToMap(String json) {
        Map map = null;
        try {
            map = mapper.readValue(json, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
