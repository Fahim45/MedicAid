package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;

public class SearchDonorActivity extends BaseActivity {
    @Override
    protected String setActionBarTitle() {
        return "Search Donor";
    }

    @Override
    protected String setDebugTag() {
        return "SearchDonorActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_donor;
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
