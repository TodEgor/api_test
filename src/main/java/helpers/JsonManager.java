package helpers;

import kong.unirest.json.JSONObject;

public class JsonManager {

    public static JSONObject getCategoryJson(String id, String name) {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("id", id);
        return json;
    }
}
