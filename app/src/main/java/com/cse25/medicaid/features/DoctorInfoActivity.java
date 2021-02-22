package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;

public class DoctorInfoActivity extends BaseActivity {
    @Override
    protected String setActionBarTitle() {
        return "Doctor Information";
    }

    @Override
    protected String setDebugTag() {
        return "DoctorInfoActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_doctor_info;
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
