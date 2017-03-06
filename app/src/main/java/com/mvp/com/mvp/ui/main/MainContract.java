package com.mvp.com.mvp.ui.main;

import com.mvp.com.mvp.base.BaseContract;
import com.mvp.com.mvp.base.BasePresenter;

/**
 * Created by ankit on 6/3/17.
 */

public interface MainContract {

    interface View extends BaseContract{

        void showError(int msg);

    }

    interface Presenter extends BasePresenter{

        void getApiResponse();

    }

}
