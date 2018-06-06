package com.example.haowei.twitter.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Tweet {
    private String Username, Tweet;

    public Tweet(String username, String tweet) {
        Username = username;
        Tweet = tweet;
    }

    public Tweet(JSONObject jsonObject){
        try {
            this.Tweet = jsonObject.getString("text");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getTweet() {
        return Tweet;
    }

    public void setTweet(String tweet) {
        Tweet = tweet;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "Username='" + Username + '\'' +
                ", Tweet='" + Tweet + '\'' +
                '}';
    }
}

