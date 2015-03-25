package com.sss.linkboard.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseActivity;
import com.sss.linkboard.service.client.BingRequest;
import com.sss.linkboard.service.client.TweetRequest;
import com.sss.linkboard.service.client.bing.Bing;
import com.sss.linkboard.service.client.tweet.Tweet;
import com.sss.linkboard.service.network.VolleySingleton;
import com.sss.linkboard.ui.component.HeaderSearchView;


public class SearchResultActivity extends BaseActivity implements HeaderSearchView.HeaderSearchViewDelegate, RightMenuFragment.RightMenuFragmentDelegate{
    public static final String BUNDLE_EXTRA_SEARCH = "extra_search";
    public static final String BUNDLE_EXTRA_PAGE_INDEX = "extra_page_index";

    private static final String FRAGMENT_LEFT_MENU_TAG = "fragment_left_menu_tag";
    private static final String FRAGMENT_RIGHT_MENU_TAG = "fragment_right_menu_tag";

    private static final String FRAGMENT_WEB_SEARCH_TAG = "fragment_web_search_tag";
    private static final String FRAGMENT_SOCIAL_SEARCH_TAG = "fragment_social_search_tag";
    private WebSearchFragment webFragment;
    private SocialSearchFragment socialSearchFragment;

    private HeaderSearchView headerSearchView;

    private String searchText;

    private int pageIndex;


    private LeftMenuFragment leftMenuFragment;
    private RightMenuFragment rightMenuFragment;

    private DrawerLayout mDrawerLayout;
    private FrameLayout menuLeftLayout;
    private FrameLayout menuRightLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customActionBar();
        setContentView(R.layout.activity_search_result);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuLeftLayout = (FrameLayout) findViewById(R.id.frame_leftMenu);
        menuRightLayout = (FrameLayout) findViewById(R.id.frame_rightMenu);


        headerSearchView = (HeaderSearchView) findViewById(R.id.header_search_view);
        headerSearchView.setDelegate(this);

        if (savedInstanceState == null) {
            pageIndex = 0;
            searchText = getIntent().getStringExtra(BUNDLE_EXTRA_SEARCH);
            webFragment = WebSearchFragment.createInstance(null);
            socialSearchFragment = SocialSearchFragment.createInstance(null);
            leftMenuFragment = LeftMenuFragment.createInstance(null);
            rightMenuFragment = RightMenuFragment.createInstance(null);
            getSupportFragmentManager().beginTransaction().add(R.id.frame_web_search_result, webFragment, FRAGMENT_WEB_SEARCH_TAG)
                    .add(R.id.frame_social_search_result, socialSearchFragment, FRAGMENT_SOCIAL_SEARCH_TAG)
                    .add(R.id.frame_leftMenu, leftMenuFragment, FRAGMENT_LEFT_MENU_TAG)
                    .add(R.id.frame_rightMenu, rightMenuFragment, FRAGMENT_RIGHT_MENU_TAG).commit();
        } else {
            leftMenuFragment = (LeftMenuFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_LEFT_MENU_TAG);
            rightMenuFragment = (RightMenuFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_RIGHT_MENU_TAG);
            webFragment = (WebSearchFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_WEB_SEARCH_TAG);
            socialSearchFragment = (SocialSearchFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_SOCIAL_SEARCH_TAG);
            searchText = savedInstanceState.getString(BUNDLE_EXTRA_SEARCH);
            pageIndex = savedInstanceState.getInt(BUNDLE_EXTRA_PAGE_INDEX);
        }

        headerSearchView.setEditorText(searchText);
        headerSearchView.setSelectIndex(pageIndex);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        searchText = intent.getStringExtra(BUNDLE_EXTRA_SEARCH);
        headerSearchView.setEditorText(searchText);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BUNDLE_EXTRA_SEARCH, searchText);
        outState.putInt(BUNDLE_EXTRA_PAGE_INDEX, pageIndex);
    }

    @Override
    protected void onResume() {
        super.onResume();
        searchBing();
    }

    @Override
    public void HeaderSearchView_TouchMoreButton() {
        Bundle bundle = new Bundle();
        bundle.putString(SettingActivity.BUNDLE_EXTRA_SEARCH,searchText);
        SettingActivity.startSettingActivity(this, bundle);
    }

    @Override
    public void HeaderSearchView_TouchSearch(String searchText) {
        this.searchText = searchText;
        searchBing();
    }

    @Override
    public void HeaderSearchView_TouchWebTab() {
        getSupportFragmentManager().beginTransaction().show(webFragment).hide(socialSearchFragment).commit();
    }

    @Override
    public void HeaderSearchView_TouchSocialTab() {
        getSupportFragmentManager().beginTransaction().show(socialSearchFragment).hide(webFragment).commit();
    }

    @Override
    protected void stopServiceAndResource() {
        super.stopServiceAndResource();
        VolleySingleton.getInstance(this).getRequestQueue().cancelAll(BingRequest.TAG_REQUEST);
        VolleySingleton.getInstance(this).getRequestQueue().cancelAll(TweetRequest.TAG_REQUEST);
    }

    private void searchBing(){
        startProgress();
        VolleySingleton.getInstance(this).addToRequestQueue(new BingRequest(BingRequest.buildParam(this,searchText), new Response.Listener<Bing>() {
            @Override
            public void onResponse(Bing bing) {
                if (webFragment != null) {
                    webFragment.setBingItemListData(bing);
                }

                searchTweet();
                headerSearchView.setLabelText(searchText);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (webFragment != null) {
                    webFragment.setBingItemListData(null);
                }
                searchTweet();
                Toast.makeText(SearchResultActivity.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private void searchTweet(){
        VolleySingleton.getInstance(this).addToRequestQueue(new TweetRequest(TweetRequest.buildParam(this,searchText), new Response.Listener<Tweet[]>() {
            @Override
            public void onResponse(Tweet[] tweets) {
                abort(false);
                if (socialSearchFragment != null) {
                    socialSearchFragment.setTweetItemListData(tweets);
                }
                headerSearchView.setLabelText(searchText);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (socialSearchFragment != null) {
                    socialSearchFragment.setTweetItemListData(null);
                }
                abort(false);
                Toast.makeText(SearchResultActivity.this, volleyError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public void onDidTouchMenu() {
        mDrawerLayout.closeDrawer(menuRightLayout);
    }

    private void customActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        LayoutInflater inflate = LayoutInflater.from(this);
        View customView = inflate.inflate(R.layout.actionbar_home, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        customView.setLayoutParams(layoutParams);
        Button btnMenu = (Button) customView.findViewById(R.id.btnMenu);
        LinearLayout logoLayout = (LinearLayout) customView.findViewById(R.id.title_text);

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
        logoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.startHomeActivity(SearchResultActivity.this,Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);
    }

    public static void startSearchActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context, SearchResultActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    public static void startSearchActivity(Context context, Bundle bundle, int flags) {
        Intent intent = new Intent(context, SearchResultActivity.class);
        intent.setFlags(flags);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }


}
