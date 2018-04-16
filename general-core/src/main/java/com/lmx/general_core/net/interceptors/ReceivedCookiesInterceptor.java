package com.lmx.general_core.net.interceptors;

import com.lmx.general_core.Istration.CookiesIstration;

import java.io.IOException;

import okhttp3.Response;

/**
 * Author:ReceivedCookiesInterceptor
 * Created by LMX on 2018/4/16
 * Description:捕获Cookie并保存
 */
public class ReceivedCookiesInterceptor extends BaseInterceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            String sessionId = "";
            for (String header : originalResponse.headers("Set-Cookie")) {
                if (header.startsWith("PHPSESSID")) {
                    sessionId=header;
                }
            }

            CookiesIstration.getInstance().saveCookie(getHost(chain),sessionId);
        }
        return originalResponse;
    }


}
