package com.sss.linkboard.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseActivity;

public class WebViewActivity extends BaseActivity{

    public static final String BUNDLE_EXTRA_SOURCE = "BUNDLE_EXTRA_SOURCE";

    private WebView webView;
    private String urlSource;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        customActionBar();

        if (savedInstanceState == null){
            urlSource = getIntent().getStringExtra(BUNDLE_EXTRA_SOURCE);
        }else{
            urlSource = savedInstanceState.getString(BUNDLE_EXTRA_SOURCE);
        }

        setContentView(R.layout.activity_webview);
        webView = (WebView) findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(urlSource);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BUNDLE_EXTRA_SOURCE,urlSource);
    }

    public static void startWebViewActivity(Context context, Bundle bundle){
        Intent intent = new Intent(context, WebViewActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    private void customActionBar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        LayoutInflater inflate = LayoutInflater.from(this);
        View customView = inflate.inflate(R.layout.actionbar_webview,null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        customView.setLayoutParams(layoutParams);
        Button btnBack = (Button) customView.findViewById(R.id.btnBack);
        LinearLayout logoLayout = (LinearLayout) customView.findViewById(R.id.title_text);
        logoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.startHomeActivity(WebViewActivity.this,Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()){
                    webView.goBack();
                }else{
                    onBackPressed();
                }
            }
        });

        Button btnExit = (Button) customView.findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);
    }
}
