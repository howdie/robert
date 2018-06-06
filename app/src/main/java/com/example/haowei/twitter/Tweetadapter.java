package com.example.haowei.twitter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.haowei.twitter.model.Tweet;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Tweetadapter extends ArrayAdapter {

    private List<Tweet> tweets;
    private LayoutInflater inflater;


    public Tweetadapter(@NonNull Context context, @NonNull List objects) {
        super(context, R.layout.tweet, objects);

        tweets = objects;
        inflater = LayoutInflater.from(context);
    }


        @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = inflater.inflate(R.layout.tweet, parent, false);
        }

        TextView tweet = convertView.findViewById(R.id.tweet);

        Tweet tweet1 = tweets.get(position);

        tweet.setText(tweet1.getTweet());

        String imageUri = "https://i.imgur.com/tGbaZCY.jpg";
        ImageView profile = convertView.findViewById(R.id.profilepic);
        Picasso.with(convertView.getContext()).load(imageUri).into(profile);

        return convertView;
    }
}
