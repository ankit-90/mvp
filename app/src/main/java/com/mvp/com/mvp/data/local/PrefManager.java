package com.mvp.com.mvp.data.local;

/**
 * Created by ankit on 6/3/17.
 */

public class PrefManager {

    private static PrefManager prefManager;

    private PrefManager() {
        //default constructor must be private otherwise it will expose behavior of singleton
    }

    public static PrefManager getPrefManager(){
        if(prefManager == null){
            prefManager = new PrefManager();
        }
        return prefManager;
    }

}
