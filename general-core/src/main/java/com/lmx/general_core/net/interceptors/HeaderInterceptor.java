package com.lmx.general_core.net.interceptors;

import android.annotation.SuppressLint;

import com.lmx.general_core.Istration.CookiesIstration;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/**
 * Author:HeaderInterceptor
 * Created by LMX on 2018/4/16
 * Description: HTTP请求头
 */
public class HeaderInterceptor extends BaseInterceptor  {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return  getResponse(chain);
    }

    /**
     * 添加头部
     * @param chain
     * @return
     * @throws IOException
     */
    private Response getResponse(Chain chain) throws IOException {
        Request.Builder reqBuilder= chain.request().newBuilder();
        reqBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                //.addHeader("Accept-Encoding", "gzip")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "*/*");
        initCookie(chain,reqBuilder);
       return chain.proceed(reqBuilder.build());
    }

    @SuppressLint("NewApi")
    private void initCookie(Chain chain, Request.Builder reqBuilder) {
        String sessionID=CookiesIstration.getInstance().queryCookie(getHost(chain));
        if(sessionID==null||sessionID.isEmpty())return;
        reqBuilder.addHeader("Cookie", sessionID);
    }


}
