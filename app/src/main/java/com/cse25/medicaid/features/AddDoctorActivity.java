package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;

public class AddDoctorActivity extends BaseActivity {
    @Override
    protected String setActionBarTitle() {
        return "Add Doctor";
    }

    @Override
    protected String setDebugTag() {
        return "AddDoctorActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_doctor;
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
