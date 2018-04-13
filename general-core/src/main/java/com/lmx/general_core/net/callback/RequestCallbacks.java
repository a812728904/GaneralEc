package com.lmx.general_core.net.callback;

import android.os.Handler;


import com.lmx.general_core.app.ConfigKeys;
import com.lmx.general_core.app.General;
import com.lmx.general_core.net.RetrofitCreate;
import com.lmx.general_core.ui.loader.GeneralLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author:RequestCallbacks
 * Created by LMX on 2018/3/29.
 * Description:Retrofit请求回调管理类
 */

public class RequestCallbacks implements Callback<String> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;

    private static final Handler HANDLER = General.getHandler();

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;

    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }

        onRequestFinish();
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

        onRequestFinish();
    }

    private void onRequestFinish() {
        final long delayed = General.getConfiguration(ConfigKeys.LOADER_DELAYED);
/*        if (LOADER_STYLE != null) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    RetrofitCreate.getParams().clear();
                    GeneralLoader.stopLoading();
                }
            }, delayed);
        }*/
    }
}
