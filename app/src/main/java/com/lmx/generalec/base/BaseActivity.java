package com.lmx.generalec.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.lmx.general_core.base.BasePresenter;
import com.lmx.general_core.base.BaseView;
import com.lmx.generalec.util.InstanceUtil;

import java.lang.reflect.ParameterizedType;

import butterknife.ButterKnife;

/**
 * Author:BaseActivity
 * Created by LMX on 2018/3/27.
 * Description: Activity的基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected abstract int setLayoutResID();
    protected abstract void initData();
    protected P mPresenter;
    protected void onCreate(android.os.Bundle savedInstanceState) {
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResID());
        ButterKnife.bind(this);
        initPresenter();
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

    protected void initPresenter() {
        if (this instanceof BaseView &&
                this.getClass().getGenericSuperclass() instanceof ParameterizedType &&
                ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments().length > 0) {
            Class mPresenterClass = (Class) ((ParameterizedType) (this.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[0];
            mPresenter = InstanceUtil.getInstance(mPresenterClass);
            if (mPresenter != null) mPresenter.setView(this);
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDetached();
    }
}
