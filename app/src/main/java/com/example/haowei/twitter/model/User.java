package com.example.haowei.twitter.model;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private String id_str, name, screen_name;

    public User(int id, String id_str, String name, String screen_name) {
        this.id_str = id_str;
        this.name = name;
        this.screen_name = screen_name;
    }

    public User(JSONObject jsonObject) {
        try {
            this.id_str = jsonObject.getString("id_str");
            this.name = jsonObject.getString("name");
            this.screen_name = jsonObject.getString("screen_name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getId_str() {
        return id_str;
    }

    public String getName() {
        return name;
    }

    public String getScreen_name() {
        return screen_name;
    }
}
