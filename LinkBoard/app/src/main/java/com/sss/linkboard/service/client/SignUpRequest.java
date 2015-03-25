package com.sss.linkboard.service.client;

import android.net.Uri;

import com.android.volley.Response;
import com.sss.linkboard.service.network.GsonRequest;

import java.util.HashMap;
import java.util.Map;

public class SignUpRequest extends GsonRequest<SignUpItem[]>{

    public static String TAG_REQUEST = SignUpRequest.class.getSimpleName();

    public SignUpRequest(Map<String, String> params, Response.Listener<SignUpItem[]> listener, Response.ErrorListener errorListener) {
        this(Method.POST, LinkBoardAPI.SIGN_UP_API, SignUpItem[].class, headerUrlEncode(), params, listener, errorListener);
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
    public SignUpRequest(int method, String url, Class<SignUpItem[]> clazz, Map<String, String> headers, Map<String, String> params, Response.Listener<SignUpItem[]> listener, Response.ErrorListener errorListener) {
        super(method, url, clazz, headers, params, listener, errorListener);
    }

    public static Map<String, String> buildParam(String email, String userName, String password){
        Map<String,String> params = new HashMap<String, String>();
        params.put("username", userName);
        params.put("password", password);
        params.put("email", email);
        return params;
    }
}
