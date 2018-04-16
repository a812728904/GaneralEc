package com.lmx.generalec;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.lmx.general_core.app.General;
import com.lmx.general_core.base.BaseApplication;
import com.lmx.general_core.net.interceptors.DebugInterceptor;
import com.lmx.general_core.net.interceptors.HeaderInterceptor;
import com.lmx.general_core.net.interceptors.LogInterceptor;
import com.lmx.general_core.net.interceptors.ReceivedCookiesInterceptor;

import java.util.ArrayList;

public class GaneralApplication extends BaseApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        General.init(this)
                .withLoaderDelayed(3000)
                .withInterceptor(new HeaderInterceptor())
                .withInterceptor(new ReceivedCookiesInterceptor())
                .withInterceptor(new LogInterceptor())
                .withApiHost("https://api.douban.com/").configure();
    }

}
