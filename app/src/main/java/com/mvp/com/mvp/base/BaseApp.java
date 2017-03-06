package com.mvp.com.mvp.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by ankit on 6/3/17.
 */

public class BaseApp extends Application {

    private static BaseApp INSTANCE;

    //returns base application context for app
    public static Context getContext(){
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
