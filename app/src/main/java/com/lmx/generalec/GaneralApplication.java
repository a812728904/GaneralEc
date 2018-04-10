package com.lmx.generalec;

import android.app.Application;

import com.lmx.general_core.app.General;
import com.lmx.general_core.net.interceptors.DebugInterceptor;
import com.lmx.general_core.net.interceptors.LogInterceptor;

public class GaneralApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        General.init(this)
                .withLoaderDelayed(3000)
                .withInterceptor(new LogInterceptor())
                .withApiHost("http://127.0.0.1").configure();
    }
}
