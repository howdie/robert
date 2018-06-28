package com.example.haowei.twitter.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Tweet {
    private String id_str,tweet, date;
    private User user;

    public Tweet(String tweet) {
        this.tweet = tweet;
    }

    public Tweet(JSONObject jsonObject){
        try {
            this.tweet = jsonObject.getString("text");
            this.date = jsonObject.getString("created_at");
            this.id_str = jsonObject.getString("id_str");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getTweet() {
        return tweet;
    }

    public String getDate() {
        return date;
    }

}

