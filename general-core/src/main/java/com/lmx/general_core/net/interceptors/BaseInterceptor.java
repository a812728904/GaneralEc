package com.lmx.general_core.net.interceptors;

import java.util.LinkedHashMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;

public abstract class BaseInterceptor implements Interceptor {
    /**
     * 获得请求参数map集合
     * @param chain
     * @return
     */
    protected LinkedHashMap<String, String> getUrlParameters(Chain chain) {
        final HttpUrl url = chain.request().url();
        int size = url.querySize();
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        for (int i = 0; i < size; i++) {
            params.put(url.queryParameterName(i), url.queryParameterValue(i));
        }
        return params;
    }
    /**
     * 获得指定请求参数
     * @param chain
     * @return
     */
    protected String getUrlParameters(Chain chain, String key) {
        final Request request = chain.request();
        return request.url().queryParameter(key);
    }

    protected LinkedHashMap<String, String> getBodyParameters(Chain chain) {
        final FormBody formBody = (FormBody) chain.request().body();
        final LinkedHashMap<String, String> params = new LinkedHashMap<>();
        int size = 0;
        if (formBody != null) {
            size = formBody.size();
        }
        for (int i = 0; i < size; i++) {
            params.put(formBody.name(i), formBody.value(i));
        }
        return params;
    }

    protected String getBodyParameters(Chain chain, String key) {
        return getBodyParameters(chain).get(key);
    }
    /**
     * 获得域名
     * @param chain
     * @return
     */
    protected String getHost(Chain chain) {
        final HttpUrl url = chain.request().url();
        return url.host();
    }
}
