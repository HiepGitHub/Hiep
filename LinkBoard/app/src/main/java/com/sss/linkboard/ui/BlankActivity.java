package com.sss.linkboard.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.actionbarsherlock.app.ActionBar;
import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseActivity;


public class BlankActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customActionBar();
        setContentView(R.layout.activity_blank);
    }

    private void customActionBar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        LayoutInflater inflate = LayoutInflater.from(this);
        View customView = inflate.inflate(R.layout.actionbar_normal,null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        customView.setLayoutParams(layoutParams);
        LinearLayout logoLayout = (LinearLayout) customView.findViewById(R.id.title_text);
        logoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.startHomeActivity(BlankActivity.this, Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        Button btnBack = (Button) customView.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);
    }

    public static void startBlankActivity(Context context) {
        Intent intent = new Intent(context, BlankActivity.class);
        context.startActivity(intent);
    }
}
