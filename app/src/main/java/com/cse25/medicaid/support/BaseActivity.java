package com.cse25.medicaid.support;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initViewComponents();
        addObserversAndHandlers();

        setTitle(setActionBarTitle());
        if(doYouWantToEnableBackButton() && getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void printLogD(String message) {
        LogManager.d(setDebugTag(), message);
    }

    protected void printLogE(String message) {
        LogManager.e(setDebugTag(), message);
    }

    protected abstract String setActionBarTitle();

    protected abstract String setDebugTag();

    protected abstract int getLayoutId();

    protected abstract boolean doYouWantToEnableBackButton();

    protected abstract void initViewComponents();

    protected abstract void addObserversAndHandlers();

}