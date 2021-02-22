package com.cse25.medicaid.features;

import com.cse25.medicaid.R;
import com.cse25.medicaid.support.BaseActivity;
import com.cse25.medicaid.support.Navigator;

public class HomeAdminActivity extends BaseActivity {
    @Override
    protected String setActionBarTitle() {
        return "Home";
    }

    @Override
    protected String setDebugTag() {
        return "HomeAdminActivity";
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_admin;
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
        findViewById(R.id.menu_item_med_reminder).setOnClickListener(v -> {
            printLogD("opening med reminder activity");
            showToastMessage("Under development");
        });

        findViewById(R.id.menu_item_First_aid_tips).setOnClickListener(v -> {
            printLogD("opening first aid tips activity");
            showToastMessage("Under development");
        });

        findViewById(R.id.menu_item_search_donor).setOnClickListener(v -> {
            printLogD("opening search donor activity");
            Navigator.startActivity(HomeAdminActivity.this, SearchDonorActivity.class);
        });

        findViewById(R.id.menu_item_add_donor).setOnClickListener(v -> {
            printLogD("opening add donor activity");
            Navigator.startActivity(HomeAdminActivity.this, AddDonorActivity.class);
        });

        findViewById(R.id.menu_item_search_doctor).setOnClickListener(v -> {
            printLogD("opening search doctor activity");
            Navigator.startActivity(HomeAdminActivity.this, SearchDoctorActivity.class);
        });

        findViewById(R.id.menu_item_add_doctor).setOnClickListener(v -> {
            printLogD("opening add doctor activity");
            Navigator.startActivity(HomeAdminActivity.this, AddDoctorActivity.class);
        });

    }
}
