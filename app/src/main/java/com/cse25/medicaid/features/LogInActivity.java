package com.cse25.medicaid.features;

import android.view.View;

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
        return R.layout.activity_login_fragment;
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
        findViewById(R.id.signin_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigator.startActivity(LogInActivity.this, SignUpActivity.class);
                finish();
            }
        });
    }


}
