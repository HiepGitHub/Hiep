package com.sss.linkboard.ui.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.sss.linkboard.R;
import com.sss.linkboard.ui.BlankActivity;


public class HomeFooterView extends LinearLayout{
    public HomeFooterView(Context context) {
        this(context, null, 0);
    }

    public HomeFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomeFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) super.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.widget_footer_home_menu, this, true);

        findViewById(R.id.btAbout).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankActivity.startBlankActivity(getContext());
            }
        });

        findViewById(R.id.btContact).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankActivity.startBlankActivity(getContext());
            }
        });

        findViewById(R.id.btBusiness).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankActivity.startBlankActivity(getContext());
            }
        });

        findViewById(R.id.btPrivacy).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankActivity.startBlankActivity(getContext());
            }
        });

        findViewById(R.id.btTerms).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankActivity.startBlankActivity(getContext());
            }
        });
    }

}
