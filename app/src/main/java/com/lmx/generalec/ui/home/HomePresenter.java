package com.lmx.generalec.ui.home;


import com.general.annotactions.apt.InstanceFactory;
import com.lmx.general_core.app.General;
import com.lmx.general_core.net.RetrofitClient;
import com.lmx.general_core.util.ToastUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:HomePresenter
 * Created by LMX on 2018/4/11
 * Description:
 */
@InstanceFactory
public class HomePresenter extends HomeContract.Presenter {
    @Override
    public void getTabList() {

    }

    @Override
    public void getHomeInfo() {
         RetrofitClient.builder().url("v2/book/search?q=%E9%87%91%E7%93%B6%E6%A2%85&tag=&start=0&count=1")
                .build().get().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mCompositeSubscription.add(d);
            }

            @Override
            public void onNext(String s) {
                mView.LoadHemoInfoSuccess(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void onAttached() {

    }

}
