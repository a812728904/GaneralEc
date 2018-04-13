package com.lmx.general_core.net;

import android.content.Context;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Author:RetrofitClientBuilder
 * Created by LMX on 2018/3/29.
 * Description:
 */

public class RetrofitClientBuilder {

    private static final WeakHashMap<String, Object> PARAMS = RetrofitCreate.getParams();
    private String mUrl = null;
    private String loadMess=null;
    private RequestBody mBody = null;
    private Context mContext = null;

    private File mFile = null;


    RetrofitClientBuilder() {
    }

    public final RetrofitClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RetrofitClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RetrofitClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RetrofitClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final RetrofitClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }


    public final RetrofitClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }



    public final RetrofitClientBuilder loader(Context context,String loadMess) {
        this.mContext = context;
        this.loadMess=loadMess;
        return this;
    }

    public final RetrofitClientBuilder loader(Context context) {
        this.mContext = context;
        return this;
    }

    public final RetrofitClient build() {
        return new RetrofitClient(mUrl, PARAMS,
                mBody, mFile, mContext,loadMess);
    }
}
