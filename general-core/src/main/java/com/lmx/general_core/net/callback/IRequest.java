package com.lmx.general_core.net.callback;

/**
 * Author:IRequest
 * Created by LMX on 2018/3/29.
 * Description: 请求开始结束回调
 */

public interface IRequest {
    void onRequestStart();
    void onRequestEnd();
}
