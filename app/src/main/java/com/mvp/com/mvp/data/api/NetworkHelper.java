package com.mvp.com.mvp.data.api;

import com.mvp.com.mvp.data.api.restErrors.ApiError;
import com.mvp.com.mvp.model.Status;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by ankit on 6/3/17.
 * get rersponse from API's and give to data manager class
 */

public class NetworkHelper {

    private final MvpService mvpService;

    public NetworkHelper(MvpService mvpService) {
        this.mvpService = mvpService;
    }

    public Observable<Status> getResponse(){
        return mvpService.getResponse()
                .flatMap(new Function<Status, ObservableSource<?extends Status>>() {
                    @Override
                    public ObservableSource<?extends Status> apply(Status status) throws Exception {
                        if(status.getCode() == 200){
                            return Observable.just(status);
                        }else{
                            return Observable.error(new ApiError("Something went wrong, please try again!!"));
                        }

                    }
                });
    }

}
