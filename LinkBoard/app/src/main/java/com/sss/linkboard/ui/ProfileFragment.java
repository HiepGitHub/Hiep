package com.sss.linkboard.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseFragment;
import com.sss.linkboard.local.model.LoginAccount;


public class ProfileFragment extends BaseFragment {

    public static ProfileFragment createInstance(Bundle bundle) {
        ProfileFragment fragment = new ProfileFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    private NetworkImageView networkImageView;
    private TextView tvFullName, tvUserName;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
        tvFullName = (TextView) view.findViewById(R.id.tv_full_name);
        networkImageView = (NetworkImageView) view.findViewById(R.id.ivPhoto);

        tvUserName.setText(LoginAccount.getInstance(getActivity()).getUsername());
        tvFullName.setText(LoginAccount.getInstance(getActivity()).getEmail());
        networkImageView.setDefaultImageResId(R.drawable.chipu_converted);

        return view;
    }
}
