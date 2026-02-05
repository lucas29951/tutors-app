package com.devs.tutorsapp;

import android.app.Application;

public class TeachMeApplication extends Application {

    private static TeachMeApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        android.util.Log.d("devtest", "Application iniciada");
    }

    public static TeachMeApplication getInstance() {
        return instance;
    }

}
