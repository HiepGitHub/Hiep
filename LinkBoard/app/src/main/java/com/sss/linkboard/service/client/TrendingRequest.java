package com.sss.linkboard.service.client;

import com.android.volley.Response;
import com.sss.linkboard.service.network.GsonRequest;

import java.util.Map;


public class TrendingRequest extends GsonRequest<TrendingItem[]> {

    public static String TAG_REQUEST = TrendingRequest.class.getSimpleName();


    public TrendingRequest(Response.Listener<TrendingItem[]> listener, Response.ErrorListener errorListener) {
        this(Method.GET, LinkBoardAPI.TRENDING_API, TrendingItem[].class, null, null, listener, errorListener);
        setTag(TAG_REQUEST);
    }

    /**
     * Make a GET request and return a parsed object from JSON.
     *
     * @param url           URL of the request to make
     * @param clazz         Relevant class object, for Gson's reflection
     * @param headers       Map of request headers
     * @param listener
     * @param errorListener
     */
    public TrendingRequest(int method, String url, Class<TrendingItem[]> clazz, Map<String, String> headers, Map<String, String> params, Response.Listener<TrendingItem[]> listener, Response.ErrorListener errorListener) {
        super(method, url, clazz, headers, params, listener, errorListener);
    }
}
