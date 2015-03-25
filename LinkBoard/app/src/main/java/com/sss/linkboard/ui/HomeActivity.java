package com.sss.linkboard.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseActivity;
import com.sss.linkboard.service.client.TrendingItem;
import com.sss.linkboard.service.client.TrendingRequest;
import com.sss.linkboard.service.network.VolleySingleton;


public class HomeActivity extends BaseActivity implements HomeFragment.HomeFragmentDelegate, RightMenuFragment.RightMenuFragmentDelegate{

    private static final String FRAGMENT_HOME_TAG = "fragment_home_tag";
    private static final String FRAGMENT_LEFT_MENU_TAG = "fragment_left_menu_tag";
    private static final String FRAGMENT_RIGHT_MENU_TAG = "fragment_right_menu_tag";

    private HomeFragment homeFragment;
    private LeftMenuFragment leftMenuFragment;
    private RightMenuFragment rightMenuFragment;

    private DrawerLayout mDrawerLayout;
    private FrameLayout menuLeftLayout;
    private FrameLayout menuRightLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        customActionBar();

        setContentView(R.layout.activity_home);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuLeftLayout = (FrameLayout) findViewById(R.id.frame_leftMenu);
        menuRightLayout = (FrameLayout) findViewById(R.id.frame_rightMenu);


        if (savedInstanceState == null) {
            homeFragment = HomeFragment.createInstance(null);
            leftMenuFragment = LeftMenuFragment.createInstance(null);
            rightMenuFragment = RightMenuFragment.createInstance(null);
            getSupportFragmentManager().beginTransaction().add(R.id.frame_home, homeFragment, FRAGMENT_HOME_TAG)
                    .add(R.id.frame_leftMenu, leftMenuFragment, FRAGMENT_LEFT_MENU_TAG)
                    .add(R.id.frame_rightMenu, rightMenuFragment, FRAGMENT_RIGHT_MENU_TAG).commit();
        } else {
            homeFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_HOME_TAG);
            leftMenuFragment = (LeftMenuFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_LEFT_MENU_TAG);
            rightMenuFragment = (RightMenuFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_RIGHT_MENU_TAG);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (homeFragment != null){
            homeFragment.checkAndLayoutBottomMenu();
        }

        VolleySingleton.getInstance(this).addToRequestQueue(new TrendingRequest(new Response.Listener<TrendingItem[]>() {
            @Override
            public void onResponse(TrendingItem[] trendingItems) {
                if (homeFragment != null){
                    homeFragment.setTrendingItemListData(trendingItems);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(HomeActivity.this,volleyError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    protected void onPause() {
        super.onPause();
        VolleySingleton.getInstance(this).getRequestQueue().cancelAll(TrendingRequest.TAG_REQUEST);
    }


    @Override
    public void HomeFragment_TouchSignUp() {
        SignUpActivity.startSignUpActivity(this);
    }

    @Override
    public void HomeFragment_TouchLogin() {
        LoginActivity.startLoginActivity(this);
    }

    @Override
    public void HomeFragment_SearchAction(String textSearch) {
        Bundle bundle = new Bundle();
        bundle.putString(SearchResultActivity.BUNDLE_EXTRA_SEARCH,textSearch);
        SearchResultActivity.startSearchActivity(this,bundle);
    }

    @Override
    public void onDidTouchMenu() {
        mDrawerLayout.closeDrawer(menuRightLayout);
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
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(menuLeftLayout)) {
                    mDrawerLayout.closeDrawer(menuLeftLayout);
                } else {
                    mDrawerLayout.openDrawer(menuLeftLayout);
                }
            }
        });

        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);
    }


    public static void startHomeActivity(Context context, int flags) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.setFlags(flags);
        context.startActivity(intent);
    }


}
