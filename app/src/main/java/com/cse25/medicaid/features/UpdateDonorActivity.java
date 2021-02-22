package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;

public class UpdateDonorActivity extends BaseActivity {
    @Override
    protected String setActionBarTitle() {
        return "Update Donor";
    }

    @Override
    protected String setDebugTag() {
        return "UpdateDonorActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_donor;
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
