package com.rocky.moreapps.example;

import android.app.Application;

import com.rocky.moreapps.MoreAppsBuilder;
import com.rocky.moreapps.MoreAppsDialog;

public class CoreApp extends Application {
    public static final String JSON_FILE_URL = "https://raghavsatyadev.github.io/more_apps_example.json";
    private static final String TAG = CoreApp.class.getSimpleName();
    private static CoreApp mInstance;
    private MoreAppsDialog moreAppsDialog;

    public static synchronized CoreApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

//        this pattern is part of option-2
        createMoreAppDialog();
    }

    public MoreAppsDialog getMoreAppsDialog() {
        if (moreAppsDialog == null) createMoreAppDialog();
        return moreAppsDialog;
    }

    private void createMoreAppDialog() {
        moreAppsDialog = new MoreAppsBuilder(this, JSON_FILE_URL).build();
    }
}
