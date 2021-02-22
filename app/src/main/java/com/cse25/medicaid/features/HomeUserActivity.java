package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;
import com.cse25.medicaid.support.Navigator;

public class HomeUserActivity extends BaseActivity {
    @Override
    protected String setActionBarTitle() {
        return "Home";
    }

    @Override
    protected String setDebugTag() {
        return "HomeUserActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_user;
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
