package com.sss.linkboard.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseFragment;
import com.sss.linkboard.util.Validator;


public class LoginFragment extends BaseFragment {
    public static LoginFragment createInstance(Bundle bundle) {
        LoginFragment fragment = new LoginFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    public interface LoginFragmentDelegate {
        public void LoginFragment_TouchLoginButton(String userName, String password, boolean isEmail);
    }

    private LoginFragmentDelegate delegate;


    private EditText edUserName;
    private EditText edPassword;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        delegate = (LoginFragmentDelegate) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        delegate = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        edUserName = (EditText) view.findViewById(R.id.edtUsername);
        edPassword = (EditText) view.findViewById(R.id.edtPassword);

        view.findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (delegate == null) {
                    return;
                }

                String userName = edUserName.getText().toString();
                String password = edPassword.getText().toString();
                boolean isEmail = Validator.validateEmail(userName);
                int status = validateFormData(userName, password);
                if (status <= 0) {
                    delegate.LoginFragment_TouchLoginButton(userName, password, isEmail);
                } else {
                    String msg = getString(status);
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private int validateFormData(String userName, String password) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            return R.string.alert_validate_empty;
        }
        return 0;
    }
}
