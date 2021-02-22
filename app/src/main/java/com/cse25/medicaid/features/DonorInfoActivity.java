package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;

public class DonorInfoActivity extends BaseActivity {
    @Override
    protected String setActionBarTitle() {
        return "Donor Information";
    }

    @Override
    protected String setDebugTag() {
        return "DonorInfoActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_donor_info;
    }

    @Override
    protected boolean doYouWantToEnableBackButton() {
        return true;
    }

    @Override
    protected void initViewComponents() {

    }

    @Override
    protected void addObserversAndHandlers() {

    }
}
