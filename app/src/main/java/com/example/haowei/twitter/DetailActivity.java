package com.example.haowei.twitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.haowei.twitter.model.Tweet;
import com.example.haowei.twitter.model.TweetProvider;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private List<Tweet> tweets = TweetProvider.Tweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_main);

        Intent launch = getIntent();

        if(launch != null){
            int position = launch.getIntExtra(MainActivity.TWEET,-1);

            if(position > 0 && position < tweets.size()) {
                Tweet tweet = tweets.get(position);

                TextView name = findViewById(R.id.name_d);
                name.setText(tweet.getUsername());

                TextView text = findViewById(R.id.tweet_d);
                text.setText(tweet.getTweet());
            }

        }
    }
}
