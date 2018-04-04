package com.lmx.general_core.net.callback;

/**
 * Author:IError
 * Created by LMX on 2018/3/29.
 * Description:请求错误的回调
 */

public interface IError {
    void onError(int code, String msg);
}
