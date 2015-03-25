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
import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseActivity;
import com.sss.linkboard.ui.component.HeaderSearchView;


public class SettingActivity extends BaseActivity implements SettingWebFragment.SettingWebFragmentDelegate, SettingSocialFragment.SettingSocialFragmentDelegate, HeaderSearchView.HeaderSearchViewDelegate,
        RightMenuFragment.RightMenuFragmentDelegate{
    private static final String FRAGMENT_WEB_SETTING_TAG = "fragment_web_setting_tag";
    private static final String FRAGMENT_SOCIAL_SETTING_TAG = "fragment_social_setting_tag";

    private static final String FRAGMENT_LEFT_MENU_TAG = "fragment_left_menu_tag";
    private static final String FRAGMENT_RIGHT_MENU_TAG = "fragment_right_menu_tag";


    public static final String BUNDLE_EXTRA_SEARCH = "extra_search";
    public static final String BUNDLE_EXTRA_PAGE_INDEX = "extra_page_index";

    private SettingWebFragment settingWebFragment;
    private SettingSocialFragment settingSocialFragment;

    private String searchText;
    private HeaderSearchView headerSearchView;
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

        setContentView(R.layout.activity_setting);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        menuLeftLayout = (FrameLayout) findViewById(R.id.frame_leftMenu);
        menuRightLayout = (FrameLayout) findViewById(R.id.frame_rightMenu);


        headerSearchView = (HeaderSearchView) findViewById(R.id.header_search_view);
        headerSearchView.setDelegate(this);

        if (savedInstanceState == null) {
            pageIndex = 0;
            searchText = getIntent().getStringExtra(BUNDLE_EXTRA_SEARCH);
            settingWebFragment = SettingWebFragment.createInstance(null);
            settingSocialFragment = SettingSocialFragment.createInstance(null);

            leftMenuFragment = LeftMenuFragment.createInstance(null);
            rightMenuFragment = RightMenuFragment.createInstance(null);

            getSupportFragmentManager().beginTransaction().add(R.id.frame_web_setting, settingWebFragment, FRAGMENT_WEB_SETTING_TAG)
                    .add(R.id.frame_social_setting, settingSocialFragment, FRAGMENT_SOCIAL_SETTING_TAG)
                    .add(R.id.frame_leftMenu, leftMenuFragment, FRAGMENT_LEFT_MENU_TAG)
                    .add(R.id.frame_rightMenu, rightMenuFragment, FRAGMENT_RIGHT_MENU_TAG).commit();
        } else {
            leftMenuFragment = (LeftMenuFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_LEFT_MENU_TAG);
            rightMenuFragment = (RightMenuFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_RIGHT_MENU_TAG);
            settingWebFragment = (SettingWebFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_WEB_SETTING_TAG);
            settingSocialFragment = (SettingSocialFragment) getSupportFragmentManager().findFragmentByTag(FRAGMENT_SOCIAL_SETTING_TAG);
            searchText = savedInstanceState.getString(BUNDLE_EXTRA_SEARCH);
            pageIndex = savedInstanceState.getInt(BUNDLE_EXTRA_PAGE_INDEX);
        }

        headerSearchView.setEditorText(searchText);
        headerSearchView.setSelectIndex(pageIndex);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BUNDLE_EXTRA_SEARCH, searchText);
        outState.putInt(BUNDLE_EXTRA_PAGE_INDEX, pageIndex);
    }

    @Override
    public void HeaderSearchView_TouchMoreButton() {

    }

    @Override
    public void HeaderSearchView_TouchSearch(String searchText) {
        Bundle bundle = new Bundle();
        bundle.putString(SearchResultActivity.BUNDLE_EXTRA_SEARCH,searchText);
        SearchResultActivity.startSearchActivity(this,bundle, Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    public void HeaderSearchView_TouchWebTab() {
        switchFragment(true);
    }

    @Override
    public void HeaderSearchView_TouchSocialTab() {
        switchFragment(false);
    }

    private void switchFragment(boolean isWebShow){
        if (isWebShow) {
            getSupportFragmentManager().beginTransaction().hide(settingSocialFragment).show(settingWebFragment).commit();
        }else{
            getSupportFragmentManager().beginTransaction().hide(settingWebFragment).show(settingSocialFragment).commit();
        }
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
                HomeActivity.startHomeActivity(SettingActivity.this,Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });
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


    public static void startSettingActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context, SettingActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    @Override
    public void onDidTouchMenu() {
        mDrawerLayout.closeDrawer(menuRightLayout);
    }
}
