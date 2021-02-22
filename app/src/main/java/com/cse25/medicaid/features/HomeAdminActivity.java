package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;

public class HomeAdminActivity extends BaseActivity {
    @Override
    protected String setActionBarTitle() {
        return "Home";
    }

    @Override
    protected String setDebugTag() {
        return "HomeAdminActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_admin;
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
