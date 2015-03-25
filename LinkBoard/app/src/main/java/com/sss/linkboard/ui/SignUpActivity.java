package com.sss.linkboard.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseActivity;
import com.sss.linkboard.service.client.SignUpItem;
import com.sss.linkboard.service.client.SignUpRequest;
import com.sss.linkboard.service.network.PlainTextParserError;
import com.sss.linkboard.service.network.VolleySingleton;

import java.util.Map;


public class SignUpActivity extends BaseActivity implements SignUpFragment.SignUpFragmentDelegate {
    private static final String FRAGMENT_SIGN_UP_TAG = "fragment_sign_up_tag";

    private SignUpFragment signUpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        if (savedInstanceState == null) {
            signUpFragment = SignUpFragment.createInstance(null);
            getSupportFragmentManager().beginTransaction().add(R.id.frame_sign_up, signUpFragment, FRAGMENT_SIGN_UP_TAG).commit();
        } else {
            signUpFragment = (SignUpFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_SIGN_UP_TAG);
        }
    }

    @Override
    protected void stopServiceAndResource() {
        super.stopServiceAndResource();
        VolleySingleton.getInstance(this).getRequestQueue().cancelAll(SignUpRequest.TAG_REQUEST);
    }

    @Override
    public void SignUpFragment_TouchSignUpButton(String email, String userName, String password) {
        startProgress();
        Map<String, String> params = SignUpRequest.buildParam(email,userName,password);
        VolleySingleton.getInstance(this).addToRequestQueue(new SignUpRequest(params, new Response.Listener<SignUpItem[]>() {
            @Override
            public void onResponse(SignUpItem[] signUpItem) {
                abort(false);
                LoginActivity.startLoginActivity(SignUpActivity.this);
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
                Toast.makeText(SignUpActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    public static void startSignUpActivity(Context context){
        Intent intent = new Intent(context,SignUpActivity.class);
        context.startActivity(intent);
    }

}
