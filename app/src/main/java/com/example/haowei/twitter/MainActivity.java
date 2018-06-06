package com.example.haowei.twitter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.haowei.twitter.model.Tweet;
import com.example.haowei.twitter.model.TweetProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarException;

public class MainActivity extends AppCompatActivity {
    public List<Tweet> tweets = new ArrayList<>();
    public static final String TWEET = "tweet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            tweets = jsontolist();
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


    public String readJson(){
        String data = null;

        InputStream is = getBaseContext().getResources().openRawResource(R.raw.tweets);;
        try{
            byte[] b = new byte[is.available()];
            is.read(b);
            is.close();
            data = new String(b);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }

        return data;

    }

    public ArrayList<Tweet> jsontolist() throws JSONException {
        ArrayList<Tweet> list = new ArrayList<>();

        String json = readJson();

        JSONObject jsOb = new JSONObject(json);

        JSONArray jsonArray = jsOb.getJSONArray("statuses");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Tweet tweet = new Tweet(jsonObject);
            list.add(tweet);
        }

        return list;
    }
}
