package com.cse25.medicaid.entities;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.cse25.medicaid.R;

public class MALoadingDialog extends Dialog {

    private final String message;

    public MALoadingDialog(@NonNull Context context, String message) {
        super(context);
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_loading);
        setCancelable(false);
        TextView dialogMessageView = findViewById(R.id.dialog_message_view);
        dialogMessageView.setText(message);
    }
}
