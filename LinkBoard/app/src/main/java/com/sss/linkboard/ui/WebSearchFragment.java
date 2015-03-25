package com.sss.linkboard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseFragment;
import com.sss.linkboard.service.client.bing.Bing;
import com.sss.linkboard.ui.adapter.BingAdapter;


public class WebSearchFragment extends BaseFragment {

    public static WebSearchFragment createInstance(Bundle bundle) {
        WebSearchFragment fragment = new WebSearchFragment();
        if (bundle != null)
            fragment.setArguments(bundle);
        return fragment;
    }

    public interface WebSearchFragmentDelegate{}

    private WebSearchFragmentDelegate delegate;
    private BingAdapter bingAdapter;
    private ListView lvResult;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        delegate = (WebSearchFragmentDelegate) activity;
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
        bingAdapter = new BingAdapter(getActivity());
        bingAdapter.setListView(lvResult);
        lvResult.setAdapter(bingAdapter);
    }

    public void setBingItemListData(Bing items) {
        if (bingAdapter != null) {
            bingAdapter.setList(items);
        }
    }
}
