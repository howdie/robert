package com.example.haowei.twitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.haowei.twitter.model.Tweet;
import com.example.haowei.twitter.model.TweetProvider;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Tweet> tweets = TweetProvider.Tweets;
    public static final String TWEET = "tweet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            readJson();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListView listView = findViewById(R.id.lv_tweets);
        Tweetadapter tweetAdapter = new Tweetadapter(this, tweets);
        listView.setAdapter(tweetAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detial = new Intent(MainActivity.this, DetailActivity.class);
                detial.putExtra(TWEET, position);
                startActivity(detial);
            }
        });
    }


    public void readJson() throws JSONException {

//        JSONObject jsonObject = new JSONObject(filecontent);
//        JSONArray jsonArray = jsonObject.getJSONArray("statuses");
//        for (int i = 0; i < jsonArray.length(); i++) {
//            try {
//                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                Tweet tweet = new Tweet();
//                String username = jsonObject1.getString("screen_name");
//                tweet.setUsername(username);
//                String text = jsonObject1.getString("text");
//                tweet.setTweet(text);
//                tweets.add(tweet);
//            } catch (JSONException e) {
//
//            }
//        }
    }
}
