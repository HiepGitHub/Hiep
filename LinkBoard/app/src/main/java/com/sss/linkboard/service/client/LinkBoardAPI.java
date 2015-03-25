package com.sss.linkboard.service.client;


public final class LinkBoardAPI {
    public static final String BASE_URL = "http://api.linkboard.com";
    public static final String TRENDING_API = BASE_URL + "/search/getTrending";
    public static final String GET_TWEETS_API = BASE_URL + "/search/getTweets";
    public static final String GET_BING_API = BASE_URL + "/search/getBingResults";

    public static final String SIGN_UP_API = BASE_URL + "/users/register";
    public static final String LOGIN_API = BASE_URL + "/users/login";
}
