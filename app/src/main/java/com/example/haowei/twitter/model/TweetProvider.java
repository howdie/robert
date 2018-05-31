package com.example.haowei.twitter.model;

import java.util.ArrayList;
import java.util.List;

public class TweetProvider {
    public static List<Tweet> Tweets = new ArrayList<>();

    static {

    }

    public static void addtweet(Tweet tweet){
        Tweets.add(tweet);
    }
}
