package com.mvp.com.mvp.data;

import com.mvp.com.mvp.data.api.ApiClient;
import com.mvp.com.mvp.data.api.NetworkHelper;
import com.mvp.com.mvp.data.local.PrefManager;
import com.mvp.com.mvp.model.Status;

import io.reactivex.Observable;

/**
 * Created by ankit on 6/3/17.
 */

public class DataManager {

    private final NetworkHelper networkHelper;
    private final PrefManager mPrefManager;

    public DataManager() {
        this.networkHelper = new NetworkHelper(ApiClient.getMvpService());
        this.mPrefManager = PrefManager.getPrefManager();
    }

    public Observable<Status> getApiResponse(){
        return networkHelper.getResponse();
    }

}
