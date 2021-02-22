package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;

public class AddDonorActivity extends BaseActivity {
    @Override
    protected String setActionBarTitle() {
        return "Add Donor";
    }

    @Override
    protected String setDebugTag() {
        return "AddDonorActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_donor;
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
