package com.example.haowei.twitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.haowei.twitter.model.Tweet;
import com.example.haowei.twitter.model.User;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetialActivity extends AppCompatActivity {
    private List<Tweet> tweets = MainActivity.tweetList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_main);

        Intent launch = getIntent();

        if(launch != null){
            int position = launch.getIntExtra(MainActivity.TWEET,-1);

            if(position >= 0 && position < tweets.size()) {
                Tweet tweet = tweets.get(position);


                ImageView profilepic = findViewById(R.id.profileImg);
                String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
                Picasso.with(getBaseContext()).load(imageUri).into(profilepic);

                TextView name = findViewById(R.id.name_d);
                String full_name = tweet.getUser().getScreen_name() + " @" + tweet.getUser().getName();
                name.setText(full_name);

                TextView date = findViewById(R.id.date_d);
                date.setText(tweet.getDate());

                TextView text = findViewById(R.id.tweet_d);
                text.setText(tweet.getTweet());
            }

        }

    }
}
