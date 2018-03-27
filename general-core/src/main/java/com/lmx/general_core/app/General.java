package com.lmx.general_core.app;

import android.content.Context;
import android.os.Handler;

/**
 * Author:General
 * Created by LMX on 2018/3/27.
 * Description: 项目管理类
 */

public class General {
    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getLatteConfigs()
                .put(com.lmx.general_core.ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(com.lmx.general_core.ConfigKeys.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfiguration(com.lmx.general_core.ConfigKeys.HANDLER);
    }


}
