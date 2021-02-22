package com.cse25.medicaid.support;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BaseDatabase {

    private static final String DEBUG_TAG = "[BaseDatabase]";

    @SuppressLint("ApplySharedPref")
    public static void set(String key, Object value) {
        try{
            ByteArrayOutputStream serializedData = new ByteArrayOutputStream();
            ObjectOutputStream serializer = new ObjectOutputStream(serializedData);
            serializer.writeObject(value);

            //Insert serialized object into shared preferences
            SharedPreferences sharedPreferences = BaseApplication.getInstance().getSharedPreferences(tagGenerator(key), Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(key, Base64.encodeToString(serializedData.toByteArray(), Base64.DEFAULT));
            edit.commit();
        }catch (Exception e) {
            LogManager.e(DEBUG_TAG, "set value failed [key " + key + "]");
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        Object ret = null;
        try {
            SharedPreferences sharedPreferences = BaseApplication.getInstance().getSharedPreferences(tagGenerator(key), Context.MODE_PRIVATE);
            String serializedData = sharedPreferences.getString(key, null);
            if(serializedData != null){
                ByteArrayInputStream input = new ByteArrayInputStream(Base64.decode(serializedData, Base64.DEFAULT));
                ObjectInputStream inputStream = new ObjectInputStream(input);
                ret = inputStream.readObject();
            }
        } catch (Exception e) {
            LogManager.e(DEBUG_TAG, "set value failed [key " + key + "]");
            e.printStackTrace();
        }
        return ret;
    }

    private static String tagGenerator(String key){
        return String.format("tag_%s",key);
    }
}
