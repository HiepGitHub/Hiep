package com.sss.linkboard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseFragment;
import com.sss.linkboard.local.model.LoginAccount;
import com.sss.linkboard.service.client.TrendingItem;
import com.sss.linkboard.ui.adapter.TrendingAdapter;
import com.sss.linkboard.ui.component.HomeFooterView;
import com.sss.linkboard.util.Utils;


public class HomeFragment extends BaseFragment {

    public static HomeFragment createInstance(Bundle bundle) {
        HomeFragment fragment = new HomeFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    public interface HomeFragmentDelegate {
        public void HomeFragment_TouchSignUp();

        public void HomeFragment_TouchLogin();

        public void HomeFragment_SearchAction(String textSearch);
    }

    private EditText edSearch;
    private TrendingAdapter adapter;
    private HomeFragmentDelegate delegate;
    private ListView lvTrend;
    private ViewGroup vgSignUpLogin;
    private HomeFooterView homeFooterView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        delegate = (HomeFragmentDelegate) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        delegate = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        edSearch = (EditText) view.findViewById(R.id.editSearchTrend);

        edSearch.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if (delegate != null) {
                        Utils.hideKeyboard(getActivity(), edSearch);
                        delegate.HomeFragment_SearchAction(v.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });

        homeFooterView = (HomeFooterView) view.findViewById(R.id.vg_bottom_footer);
        vgSignUpLogin = (ViewGroup) view.findViewById(R.id.vg_bottom_sign_login);

        view.findViewById(R.id.re_main_container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.hideKeyboard(getActivity(), edSearch);
            }
        });

        view.findViewById(R.id.btnSignUpHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (delegate != null) {
                    delegate.HomeFragment_TouchSignUp();
                }
            }
        });

        view.findViewById(R.id.btnLoginHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delegate.HomeFragment_TouchLogin();
            }
        });

        lvTrend = (ListView) view.findViewById(R.id.lvTrendNews);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new TrendingAdapter(getActivity());
        lvTrend.setAdapter(adapter);
        lvTrend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (delegate != null) {
                    TrendingItem trendingItem = adapter.getItemAtIndex(position);
                    delegate.HomeFragment_SearchAction(trendingItem.getTitle());
                }
            }
        });
    }

    public void setTrendingItemListData(TrendingItem[] items) {
        if (adapter != null) {
            adapter.setList(items);
        }
    }

    public void checkAndLayoutBottomMenu() {
        boolean isLogged = LoginAccount.getInstance(getActivity()).isLogged();
        vgSignUpLogin.setVisibility(isLogged ? View.GONE : View.VISIBLE);
        homeFooterView.setVisibility(isLogged ? View.VISIBLE : View.GONE);
    }

}
