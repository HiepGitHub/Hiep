package com.sss.linkboard.service.client;

import android.content.Context;

import com.android.volley.Response;
import com.sss.linkboard.local.model.SettingSocialSearchModel;
import com.sss.linkboard.service.client.tweet.Tweet;
import com.sss.linkboard.service.network.GsonRequest;

import java.util.HashMap;
import java.util.Map;

public class TweetRequest extends GsonRequest<Tweet[]> {

    public static String TAG_REQUEST = TweetRequest.class.getSimpleName();

    public TweetRequest(Map<String, String> params, Response.Listener<Tweet[]> listener, Response.ErrorListener errorListener) {
        this(Method.POST, LinkBoardAPI.GET_TWEETS_API, Tweet[].class, headerUrlEncode(), params, listener, errorListener);
        setTag(TAG_REQUEST);
    }

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param method
     * @param url           URL of the request to make
     * @param clazz         Relevant class object, for Gson's reflection
     * @param headers       Map of request headers
     * @param params
     * @param listener
     * @param errorListener
     */
    public TweetRequest(int method, String url, Class<Tweet[]> clazz, Map<String, String> headers, Map<String, String> params, Response.Listener<Tweet[]> listener, Response.ErrorListener errorListener) {
        super(method, url, clazz, headers, params, listener, errorListener);
    }

    public static Map<String, String> buildParam(Context context, String twitter_all){
        SettingSocialSearchModel model = SettingSocialSearchModel.getInstance(context);
        if (twitter_all.equals("")){
            twitter_all = model.getTwitterAll();
        }

        Map<String,String> params = new HashMap<String, String>();
        params.put("twitter_all", twitter_all);
        params.put("twitter_any", model.getTwitterAny());
        params.put("twitter_none", model.getTwitterNone());
        params.put("twitter_exact", model.getTwitterExact());
        params.put("twitter_hashtags", model.getTwitterHashtags());
        params.put("twitter_to", model.getTwitterTo());
        params.put("twitter_from", model.getTwitterFrom());
        params.put("twitter_mention", model.getTwitterMention());
        params.put("twitter_type", model.getTwitterType());
        return params;
    }

    public static Map<String, String> buildParam(String twitter_all, String twitter_any, String twitter_none,String twitter_exact, String twitter_hashtags, String twitter_to,String twitter_from, String twitter_mention,String twitter_type){
        Map<String,String> params = new HashMap<String, String>();
        params.put("twitter_all", twitter_all);
        params.put("twitter_any", twitter_any);
        params.put("twitter_none", twitter_none);
        params.put("twitter_exact", twitter_exact);
        params.put("twitter_hashtags", twitter_hashtags);
        params.put("twitter_to", twitter_to);
        params.put("twitter_from", twitter_from);
        params.put("twitter_mention", twitter_mention);
        params.put("twitter_type", twitter_type);
        return params;
    }
}
