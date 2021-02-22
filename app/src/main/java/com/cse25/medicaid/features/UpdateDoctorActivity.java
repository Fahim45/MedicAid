package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;

public class UpdateDoctorActivity extends BaseActivity {
    @Override
    protected String setActionBarTitle() {
        return "Update Doctor";
    }

    @Override
    protected String setDebugTag() {
        return "UpdateDoctorActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_doctor;
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
