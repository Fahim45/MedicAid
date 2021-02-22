package com.cse25.medicaid.features;

import android.view.View;

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
        findViewById(R.id.menu_item_search_donor).setOnClickListener(v -> {
            printLogD("opening search donor activity");
            Navigator.startActivity(HomeUserActivity.this, SearchDonorActivity.class);
        });

        findViewById(R.id.menu_item_search_doctor).setOnClickListener(v -> {
            printLogD("opening search doctor activity");
            Navigator.startActivity(HomeUserActivity.this, SearchDoctorActivity.class);
        });

        findViewById(R.id.menu_item_med_reminder).setOnClickListener(v -> {
            printLogD("opening med reminder activity");
            showToastMessage("Under development");
        });

        findViewById(R.id.menu_item_First_aid_tips).setOnClickListener(v -> {
            printLogD("opening first aid tips activity");
            showToastMessage("Under development");
        });

    }
}
