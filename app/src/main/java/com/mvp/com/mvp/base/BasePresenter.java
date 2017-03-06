package com.mvp.com.mvp.base;

/**
 * Created by ankit on 6/3/17.
 */

public interface BasePresenter {

    // prefers attach view method instead of presenter constructor but for now we will do it with constructor

    void onDetachView();

}
