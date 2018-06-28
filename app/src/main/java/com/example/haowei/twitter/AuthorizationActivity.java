package com.example.haowei.twitter;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.haowei.twitter.model.AuthenticationManager;
import com.example.haowei.twitter.model.Tweet;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class AuthorizationActivity extends AppCompatActivity {
    private static OAuth10aService service;
    private OAuth1RequestToken requestToken;
    private String authUrl;
    private WebView webView;
    private String verifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        webView = findViewById(R.id.Webview);

        AuthenticationManager.getInstance();
        service = AuthenticationManager.getService();

        new getRequestToken().execute();

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("https://www.saxion.nl")) {
                    // Get parameter from the url
                    Uri uri = Uri.parse(url);
                    verifier = uri.getQueryParameter("https://www.saxion.nl");
                    new verifyAccessToken().execute(verifier);
                    Intent intent = new Intent(AuthorizationActivity.this, TweetActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });

    }

    private class getRequestToken extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {

            try {
                requestToken = service.getRequestToken();
                authUrl = service.getAuthorizationUrl(requestToken);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            webView.loadUrl(authUrl);
        }
    }

    private class verifyAccessToken extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... voids) {
            try {
                OAuth1AccessToken accessToken = service.getAccessToken(requestToken,verifier);
                OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.twitter.com/1.1/account/verify_credentials.json");
                service.signRequest(accessToken, request);
                Response response = service.execute(request);
                if (response.isSuccessful()) {
                    System.out.println(response.getBody());
                    Button button = findViewById(R.id.login);
                    button.setVisibility(View.INVISIBLE);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}
