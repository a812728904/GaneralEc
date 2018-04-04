package com.lmx.generalec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lmx.general_core.net.RestService;
import com.lmx.general_core.net.RetrofitClient;
import com.lmx.general_core.net.callback.IError;
import com.lmx.general_core.net.callback.IFailure;
import com.lmx.general_core.net.callback.ISuccess;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       testNet();
    }

    private void testNet() {
        RetrofitClient.builder().url("http://news.baidu.com/").loader(this).success(new ISuccess() {
            @Override
            public void onSuccess(String response) {
                Log.d("mess",response);
            }
        }).error(new IError() {
            @Override
            public void onError(int code, String msg) {

            }
        }).failure(new IFailure() {
            @Override
            public void onFailure() {

            }
        }).build().get();

    }
}
