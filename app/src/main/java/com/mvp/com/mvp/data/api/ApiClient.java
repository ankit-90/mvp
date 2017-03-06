package com.mvp.com.mvp.data.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ankit on 6/3/17.
 */

public class ApiClient {

    private static MvpService mvpService;
    private static final String BASE_URL = "base url of api";

    private ApiClient() {
    }

    public static MvpService getMvpService(){
        if(mvpService == null){
            final OkHttpClient okHttpClient = makeHttpClient();
            final Retrofit retrofit = makeRetrofit(okHttpClient);
            mvpService = retrofit.create(MvpService.class);
        }
        return mvpService;
    }

    private static OkHttpClient makeHttpClient(){
        return new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20,TimeUnit.SECONDS)
                .cache(null)
                .build();
    }

    private static Retrofit makeRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

}
