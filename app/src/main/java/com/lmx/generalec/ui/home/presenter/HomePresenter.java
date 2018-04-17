package com.lmx.generalec.ui.home.presenter;

import android.util.Log;

import com.general.annotactions.apt.InstanceFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lmx.general_core.base.DefaultObserver;
import com.lmx.general_core.net.RetrofitClient;
import com.lmx.generalec.bean.GeneralBean;
import com.lmx.generalec.bean.BookBean;
import com.lmx.generalec.ui.home.contract.HomeContract;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Author:HomePresenter
 * Created by LMX on 2018/4/17
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
                .build().get().subscribe(new DefaultObserver<String>(mCompositeSubscription) {
            @Override
            public void onSuccess(String response){
                Gson gson = new Gson();
                Type objectType =new TypeToken<GeneralBean<List<BookBean>>>() {}.getType();
                GeneralBean baseBean=gson.fromJson(response, objectType);
                Log.d("","");
                // mView.LoadHemoInfoSuccess(response);
            }
        });
    }

    @Override
    public void onAttached() {

    }
}
