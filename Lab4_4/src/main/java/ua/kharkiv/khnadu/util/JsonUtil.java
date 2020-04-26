package ua.kharkiv.khnadu.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtil {
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public String toJson(Object src) {
        return gson.toJson(src);
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
