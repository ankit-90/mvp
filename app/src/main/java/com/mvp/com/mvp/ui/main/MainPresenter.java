package com.mvp.com.mvp.ui.main;

import android.util.Log;

import com.mvp.com.mvp.data.DataManager;
import com.mvp.com.mvp.model.Status;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ankit on 6/3/17.
 */

public class MainPresenter implements MainContract.Presenter {

    private final CompositeDisposable compositeDisposable;
    private final DataManager dataManager;
    private final MainContract.View view;

    public MainPresenter(MainContract.View view,DataManager dataManager) {
        this.compositeDisposable = new CompositeDisposable();
        this.dataManager = dataManager;
        this.view = view;
    }


    @Override
    public void onDetachView() {
        compositeDisposable.clear();
    }

    @Override
    public void getApiResponse() {
        compositeDisposable.add(dataManager.getApiResponse()
            .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Status>() {
                    @Override
                    public void accept(Status status) throws Exception {
                        Log.d("success","Success of API");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("exception","exception");
                        throwable.printStackTrace();
                    }
                }));
    }
}
