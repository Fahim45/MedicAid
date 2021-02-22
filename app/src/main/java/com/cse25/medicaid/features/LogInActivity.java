package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;
import com.cse25.medicaid.support.Navigator;

public class LogInActivity extends BaseActivity {

    @Override
    protected String setActionBarTitle() {
        return "Login";
    }

    @Override
    protected String setDebugTag() {
        return "LogInActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
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
        findViewById(R.id.signin_button).setOnClickListener(v -> {
            Navigator.startActivity(LogInActivity.this, SignUpActivity.class);
            finish();
        });
        findViewById(R.id.login_button).setOnClickListener(v -> {
            Navigator.startActivity(LogInActivity.this, HomeAdminActivity.class);
            finish();
        });
    }


}
