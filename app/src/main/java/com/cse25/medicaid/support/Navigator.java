package com.cse25.medicaid.support;

import android.content.Context;
import android.content.Intent;

public class Navigator {

    public static void startActivity(Context context, Class<?> activity) {
        Intent i = new Intent(context, activity);
        context.startActivity(i);
    }
}
