package com.sss.linkboard.service.client;

import com.android.volley.Response;
import com.sss.linkboard.service.network.GsonRequest;

import java.util.HashMap;
import java.util.Map;


public class LoginRequest extends GsonRequest<LoginItem>{

    public static String TAG_REQUEST = LoginRequest.class.getSimpleName();

    public LoginRequest(Map<String, String> params, Response.Listener<LoginItem> listener, Response.ErrorListener errorListener) {
        this(Method.POST, LinkBoardAPI.LOGIN_API, LoginItem.class, headerUrlEncode(), params, listener, errorListener);
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
    public LoginRequest(int method, String url, Class<LoginItem> clazz, Map<String, String> headers, Map<String, String> params, Response.Listener<LoginItem> listener, Response.ErrorListener errorListener) {
        super(method, url, clazz, headers, params, listener, errorListener);
    }

    public static Map<String, String> buildParamUserName(String userName, String password){
        Map<String,String> params = new HashMap<String, String>();
        params.put("username", userName);
        params.put("password", password);
        return params;
    }

    public static Map<String, String> buildParamEmail(String email, String password){
        Map<String,String> params = new HashMap<String, String>();
        params.put("email", email);
        params.put("password", password);
        return params;
    }
}
