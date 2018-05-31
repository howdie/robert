package com.example.haowei.twitter.model;

public class Tweet {
    String Username, Tweet;

    public Tweet(String username, String tweet) {
        Username = username;
        Tweet = tweet;
    }

    public Tweet() {
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

