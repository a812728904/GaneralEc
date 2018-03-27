package com.lmx.general_core.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Author:BaseActivity
 * Created by LMX on 2018/3/27.
 * Description: Activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected abstract int setLayoutResID();
    protected abstract void initData();
    protected void onCreate(android.os.Bundle savedInstanceState) {
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResID());
       // ButterKnife.bind(this);

        initData();

    }
    /*
        * 返回
        */
    public void doBack(View view) {
        onBackPressed();
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
     /*   super.overridePendingTransition(R.anim.slide_in_right,
                R.anim.slide_out_left);*/
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        /*overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);*/
    }

}
