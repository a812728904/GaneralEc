package com.lmx.generalec;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lmx.general_core.app.General;
import com.lmx.general_core.net.RestService;
import com.lmx.general_core.net.RetrofitClient;
import com.lmx.general_core.net.callback.IError;
import com.lmx.general_core.net.callback.IFailure;
import com.lmx.general_core.net.callback.ISuccess;
import com.lmx.general_core.util.ToastUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    protected CompositeDisposable mCompositeSubscription = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       testNet();
    }

    private void testNet() {




    }


}
