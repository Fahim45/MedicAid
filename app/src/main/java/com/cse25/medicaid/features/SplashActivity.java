package com.cse25.medicaid.features;

import android.os.Handler;
import android.os.Looper;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;
import com.cse25.medicaid.support.Navigator;

public class SplashActivity extends BaseActivity {

    @Override
    protected String setActionBarTitle() {
        return "";
    }

    @Override
    protected String setDebugTag() {
        return "SplashActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected boolean doYouWantToEnableBackButton() {
        return false;
    }

    @Override
    protected void initViewComponents() {
        showLoginActivityAfterTwoSeconds();
    }

    @Override
    protected void addObserversAndHandlers() {

    }

    private void showLoginActivityAfterTwoSeconds() {
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> {
            Navigator.startActivity(SplashActivity.this, LogInActivity.class);
            finish();
        }, 2000);
    }
}
