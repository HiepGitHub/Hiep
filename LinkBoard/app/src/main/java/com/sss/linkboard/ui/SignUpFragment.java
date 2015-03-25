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

public class SignUpFragment extends BaseFragment {
    public static SignUpFragment createInstance(Bundle bundle) {
        SignUpFragment fragment = new SignUpFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    public interface SignUpFragmentDelegate {
        public void SignUpFragment_TouchSignUpButton(String email, String userName, String password);
    }

    private EditText edUserName;
    private EditText edPassword;
    private EditText edEmail;

    private SignUpFragmentDelegate delegate;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        delegate = (SignUpFragmentDelegate) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        delegate = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        edUserName = (EditText) view.findViewById(R.id.edtUsername);
        edPassword = (EditText) view.findViewById(R.id.edtPassword);
        edEmail = (EditText) view.findViewById(R.id.edtEmail);
        view.findViewById(R.id.btnSignup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (delegate == null) {
                    return;
                }

                String userName = edUserName.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                int status = validateFormData(email, userName, password);

                if (status <= 0) {
                    delegate.SignUpFragment_TouchSignUpButton(email, userName, password);
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

    private int validateFormData(String email, String userName, String password) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password) || TextUtils.isEmpty(email)) {
            return R.string.alert_validate_empty;
        }

        if (!Validator.validateEmail(email)){
            return R.string.alert_validate_email;
        }

        return 0;
    }
}
