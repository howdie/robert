package com.example.haowei.twitter;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.haowei.twitter.model.Tweet;
import com.example.haowei.twitter.model.DataProvider;
import com.example.haowei.twitter.model.User;
import com.github.scribejava.apis.LinkedInApi20;
import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.github.scribejava.core.oauth.OAuthService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    public static List<Tweet> tweetList = DataProvider.tweets;
    public static final String TWEET = "tweet";
    public ListView listView;
    public Tweetadapter tweetadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listView = findViewById(R.id.lv_tweets);
//
//        tweetadapter = new Tweetadapter(this, tweetList);
//
//        new getTwitter().execute();
//
//        listView.setAdapter(tweetadapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent detial = new Intent(MainActivity.this, DetialActivity.class);
//                detial.putExtra(TWEET, position);
//                startActivity(detial);
//            }
//        });

    }

    public void onclick(View view){
        Intent intent = new Intent(this, AuthorizationActivity.class);
        startActivity(intent);
    }


//    private class getTwitter extends AsyncTask<Void, Void, Tweet[]> {
//        @Override
//        protected Tweet[] doInBackground(Void... voids) {
//            String data = null;
//
////            InputStream is = getBaseContext().getResources().openRawResource(R.raw.tweets);
////            try {
////                byte[] b = new byte[is.available()];
////                is.read(b);
////                is.close();
////                data = new String(b);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//
//
//            try {
//                JSONObject jsonObject = new JSONObject(data);
//
//                JSONArray jsonArrayTweet = jsonObject.getJSONArray("statuses");
//
//                //make a new tweet
//                for (int i = 0; i < jsonArrayTweet.length(); i++) {
//                    JSONObject jsonObjectTweet = jsonArrayTweet.getJSONObject(i);
//                    Tweet tweet = new Tweet(jsonObjectTweet);
//
//                    JSONObject jsonObjectUser = jsonObjectTweet.getJSONObject("user");
//                    User user = new User(jsonObjectUser);
//                    tweet.setUser(user);
//
//                    tweetList.add(tweet);
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Tweet[] tweets) {
//            super.onPostExecute(tweets);
//            tweetadapter.notifyDataSetChanged();
//        }
//    }
}
