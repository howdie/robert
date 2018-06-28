package com.example.haowei.twitter.model;

import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.oauth.OAuth10aService;

public class AuthenticationManager {
    private static AuthenticationManager manager;
    private static final OAuth10aService service = new
                     ServiceBuilder("SYluCqR9DPlFBNIB6aMS2ZDHu")
                    .apiSecret("5SiGRqRmK91cm0TMjetvJlkA1b80Ufvt4oUW8rCE4IYwtOMoLT")
                    .callback("https://www.saxion.nl")
                    .build(TwitterApi.instance());;
    private static OAuth1AccessToken auth1AccessToken;

    public static AuthenticationManager getInstance() {
        if(manager == null){
            manager = new AuthenticationManager();
        }

        return manager;
    }

    public static OAuth10aService getService() {
        return service;
    }

    public static void setManager(AuthenticationManager manager) {
        AuthenticationManager.manager = manager;
    }
}
