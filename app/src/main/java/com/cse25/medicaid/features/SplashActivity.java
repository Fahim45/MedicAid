package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;

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
        return R.layout.activity_splash_fragment;
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

    }
}
