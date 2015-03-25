package com.sss.linkboard.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseActivity;
import com.sss.linkboard.local.model.LoginAccount;
import com.sss.linkboard.service.client.LoginItem;
import com.sss.linkboard.service.client.LoginRequest;
import com.sss.linkboard.service.network.PlainTextParserError;
import com.sss.linkboard.service.network.VolleySingleton;

import java.util.Map;


public class LoginActivity extends BaseActivity implements LoginFragment.LoginFragmentDelegate {

    private static final String FRAGMENT_LOGIN_TAG = "fragment_login_tag";

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        if (savedInstanceState == null) {
            loginFragment = LoginFragment.createInstance(null);
            getSupportFragmentManager().beginTransaction().add(R.id.frame_login, loginFragment, FRAGMENT_LOGIN_TAG).commit();
        } else {
            loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_LOGIN_TAG);
        }
    }

    @Override
    protected void stopServiceAndResource() {
        super.stopServiceAndResource();
        VolleySingleton.getInstance(this).getRequestQueue().cancelAll(LoginRequest.TAG_REQUEST);
    }

    @Override
    public void LoginFragment_TouchLoginButton(String userName, String password, boolean isEmail) {
        startProgress();
        Map<String, String> params = null;
        if (isEmail) {
            params = LoginRequest.buildParamEmail(userName, password);
        } else {
            params = LoginRequest.buildParamUserName(userName, password);
        }
        VolleySingleton.getInstance(this).addToRequestQueue(new LoginRequest(params, new Response.Listener<LoginItem>() {
            @Override
            public void onResponse(LoginItem loginItem) {
                LoginAccount.getInstance(LoginActivity.this).saveToLocal(loginItem.getUserID(),loginItem.getEmail(),loginItem.getUsername());
                abort(false);
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                String msg = volleyError.getMessage();
                if (volleyError instanceof PlainTextParserError) {
                    PlainTextParserError err = (PlainTextParserError) volleyError;
                    msg = err.getJsonResponse();
                }
                if (msg == null){
                    msg = getString(R.string.alert_server_error);
                }
                abort(false);
                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    public static void startLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

}
