package com.mvp.com.mvp.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mvp.com.mvp.R;
import com.mvp.com.mvp.base.BaseActivity;
import com.mvp.com.mvp.data.DataManager;

/**
 * Created by ankit on 6/3/17.
 */

public class MainActivity  extends BaseActivity implements MainContract.View{


    private MainPresenter mainPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter = new MainPresenter(this,new DataManager());
        mainPresenter.getApiResponse();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void showError(int msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDetachView();
    }
}
