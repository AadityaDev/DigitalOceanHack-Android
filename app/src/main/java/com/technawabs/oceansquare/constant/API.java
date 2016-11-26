package com.technawabs.oceansquare.constant;

public class API {

    public static final String BASE_URL = "http://104.131.39.100:8083/";
    public static final String loginUrl = "https://cloud.digitalocean.com/v1/oauth/authorize?client_id=bc9ddc5faa820489de13ac23f998fe79d55a9e880b5faaa0353321630539822d&redirect_uri=http://104.131.39.100:8083/callback&response_type=code";
    public static final String HOME = BASE_URL + "home";
    public static final String CALLBACK = BASE_URL + "callback";
}
