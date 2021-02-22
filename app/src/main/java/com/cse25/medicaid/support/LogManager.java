package com.cse25.medicaid.support;

import android.util.Log;

public class LogManager {

    private static final String TAG = "[cse25]";

    public static void d(String tag, String message) {
        Log.d(TAG + "[" + tag + "]", message);
    }

    public static void e(String tag, String message) {
        Log.e(TAG + "[" + tag + "]", message);
    }

}
