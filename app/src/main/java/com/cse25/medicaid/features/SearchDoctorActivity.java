package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;

public class SearchDoctorActivity extends BaseActivity {
    @Override
    protected String setActionBarTitle() {
        return "Search Doctor";
    }

    @Override
    protected String setDebugTag() {
        return "SearchDoctorActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_doctor;
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
