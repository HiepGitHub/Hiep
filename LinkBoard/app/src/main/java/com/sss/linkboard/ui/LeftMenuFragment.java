package com.sss.linkboard.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseFragment;


public class LeftMenuFragment extends BaseFragment{

    public static LeftMenuFragment createInstance(Bundle bundle){
        LeftMenuFragment fragment = new LeftMenuFragment();
        if (bundle!=null){
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left_menu,container,false);
        return view;
    }

}
