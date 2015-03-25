package com.sss.linkboard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseFragment;
import com.sss.linkboard.service.client.bing.Bing;
import com.sss.linkboard.service.client.tweet.Tweet;
import com.sss.linkboard.ui.adapter.BingAdapter;
import com.sss.linkboard.ui.adapter.SocialAdapter;


public class SocialSearchFragment extends BaseFragment {

    public static SocialSearchFragment createInstance(Bundle bundle) {
        SocialSearchFragment fragment = new SocialSearchFragment();
        if (bundle != null)
            fragment.setArguments(bundle);
        return fragment;
    }

    public interface SocialSearchFragmentDelegate{}

    private SocialSearchFragmentDelegate delegate;
    private SocialAdapter socialAdapter;
    private ListView lvResult;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        delegate = null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_search, container, false);
        lvResult = (ListView) view.findViewById(R.id.lvWebSearch);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        socialAdapter = new SocialAdapter(getActivity());
        socialAdapter.setListView(lvResult);
        lvResult.setAdapter(socialAdapter);
    }

    public void setTweetItemListData(Tweet[] items) {
        if (socialAdapter != null) {
            socialAdapter.setList(items);
        }
    }
}
