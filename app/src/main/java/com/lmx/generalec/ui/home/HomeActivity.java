package com.lmx.generalec.ui.home;

import android.util.Log;

import com.lmx.general_core.util.ToastUtil;
import com.lmx.generalec.R;
import com.lmx.generalec.base.BaseActivity;
import com.lmx.generalec.ui.home.contract.HomeContract;
import com.lmx.generalec.ui.home.presenter.HomePresenter;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:HomeActivity
 * Created by LMX on 2018/4/11
 * Description:
 */
public  class HomeActivity extends BaseActivity<HomePresenter>  implements HomeContract.View {
    String filePath="";
    @Override
    protected int setLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mPresenter.getHomeInfo();
      /*  File file=Environment.getExternalStorageDirectory();
        filePath=file.getPath();
        Log.d("lmx","");
        practice1();*/
    }


    @Override
    public void showTabList(List<String> mTabs) {

    }

    @Override
    public void LoadHemoInfoSuccess(String js) {
       ToastUtil.toToast(js);
    }
     Subscription  mSubscription=null;
    public  void practice1() {
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> emitter) throws Exception {
                try {
                    FileReader reader = new FileReader("/storage/emulated/0/NewTextFile.txt");
                    BufferedReader br = new BufferedReader(reader);
                    String str; while ((str = br.readLine()) != null && !emitter.isCancelled()) {
                        while (emitter.requested() == 0) {
                            if (emitter.isCancelled()) {
                                break;
                            }
                        } emitter.onNext(str);
                    }
                    br.close();
                    reader.close();
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
            }, BackpressureStrategy.ERROR)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Subscriber<String>() {
                @Override public void onSubscribe(Subscription s) {
                    Subscription  mSubscription = s;
                    s.request(1);
                } @Override
                    public void onNext(String string) {
                    Log.v("lmx",string);
                    try {
                        Thread.sleep(2000);
                        mSubscription.request(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onError(Throwable t) {
                    System.out.println(t);
                } @Override
                    public void onComplete() {

                    }
                });
    }


}
