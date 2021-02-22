package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;
import com.cse25.medicaid.support.Navigator;

public class SignUpActivity extends BaseActivity {
    @Override
    protected String setActionBarTitle() {
        return "SignUp";
    }

    @Override
    protected String setDebugTag() {
        return "SignUpActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_signup;
    }

    @Override
    protected boolean doYouWantToEnableBackButton() {
        return false;
    }

    @Override
    protected void initViewComponents() {

    }

    @Override
    protected void addObserversAndHandlers() {
        findViewById(R.id.login_button).setOnClickListener(v -> {
            Navigator.startActivity(SignUpActivity.this, LogInActivity.class);
            finish();
        });
    }
}
