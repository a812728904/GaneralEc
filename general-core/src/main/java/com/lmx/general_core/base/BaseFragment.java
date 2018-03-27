package com.lmx.general_core.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
/**
 * Author:BaseFragment
 * Created by LMX on 2018/3/27.
 * Description: Fragment的基类
 */
public abstract class BaseFragment extends Fragment  {
    protected abstract int setLayoutResID();
    protected View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(setLayoutResID(), null);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }
    protected abstract void initData();




}
