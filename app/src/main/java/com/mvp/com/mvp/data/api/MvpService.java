package com.mvp.com.mvp.data.api;

import com.mvp.com.mvp.model.Status;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ankit on 6/3/17.
 */

public interface MvpService {

    @GET("/url/to/get/response")
    Observable<Status> getResponse();

}
