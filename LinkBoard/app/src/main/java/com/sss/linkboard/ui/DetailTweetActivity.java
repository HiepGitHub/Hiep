package com.sss.linkboard.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.android.volley.toolbox.NetworkImageView;
import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseActivity;
import com.sss.linkboard.service.client.tweet.Tweet;
import com.sss.linkboard.service.client.tweet.TweetTemp;
import com.sss.linkboard.service.network.VolleySingleton;


public class DetailTweetActivity extends BaseActivity {

    public static final String BUNDLE_EXTRA_TWEET = "BUNDLE_EXTRA_TWEET";
    private TweetTemp tweet;

    private TextView tvTitleDetail,tvAuthor,tvTimetampDetail,tvContentDetail;
    private NetworkImageView ivIconDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customActionBar();
        setContentView(R.layout.activity_detail_twitter);
        findById();

        if (savedInstanceState == null){
            tweet = (TweetTemp) getIntent().getParcelableExtra(BUNDLE_EXTRA_TWEET);
        }else{
            tweet = (TweetTemp) savedInstanceState.getParcelable(BUNDLE_EXTRA_TWEET);
        }


       /* tvTitleDetail.setText(tweet.getText());
        tvAuthor.setText(tweet.getUser().getName());
        tvTimetampDetail.setText(tweet.getCreated_at());
        tvContentDetail.setText(tweet.getUser().getDescription());
        ivIconDetail.setImageUrl(tweet.getUser().getProfile_image_url(), VolleySingleton.getInstance(this).getImageLoader());*/

        tvTitleDetail.setText(tweet.getText());
        tvAuthor.setText(tweet.getName());
        tvTimetampDetail.setText(tweet.getCreated_at());
        tvContentDetail.setText(tweet.getDescription());
        ivIconDetail.setImageUrl(tweet.getUrl(), VolleySingleton.getInstance(this).getImageLoader());
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putParcelable(BUNDLE_EXTRA_TWEET, tweet);
    }

    public static void startDetailActivity(Context context, Bundle bundle){
        Intent intent = new Intent(context, DetailTweetActivity.class);
        if (bundle != null){
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    private void findById(){
        tvTitleDetail = (TextView) this.findViewById(R.id.tvTitleDetail);
        tvAuthor = (TextView) this.findViewById(R.id.tvAuthor);
        tvTimetampDetail = (TextView) this.findViewById(R.id.tvTimetampDetail);
        tvContentDetail = (TextView) this.findViewById(R.id.tvContentDetail);
        ivIconDetail = (NetworkImageView) this.findViewById(R.id.ivIconDetail);
    }

    private void customActionBar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        LayoutInflater inflate = LayoutInflater.from(this);
        View customView = inflate.inflate(R.layout.actionbar_home,null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        customView.setLayoutParams(layoutParams);
        Button btnMenu = (Button) customView.findViewById(R.id.btnMenu);
        LinearLayout logoLayout = (LinearLayout) customView.findViewById(R.id.title_text);
        logoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.startHomeActivity(DetailTweetActivity.this,Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailTweetActivity.this, "Menu Action", Toast.LENGTH_SHORT).show();
            }
        });

        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);
    }
}
