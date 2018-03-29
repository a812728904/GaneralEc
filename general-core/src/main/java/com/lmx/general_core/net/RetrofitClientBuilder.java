package com.lmx.general_core.net;

import android.content.Context;

import com.lmx.general_core.net.callback.IError;
import com.lmx.general_core.net.callback.IFailure;
import com.lmx.general_core.net.callback.IRequest;
import com.lmx.general_core.net.callback.ISuccess;
import com.lmx.general_core.ui.loader.LoaderStyle;

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
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;
    private RequestBody mBody = null;
    private Context mContext = null;
    private LoaderStyle mLoaderStyle = null;
    private File mFile = null;
    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;

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

    public final RetrofitClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    public final RetrofitClientBuilder dir(String dir) {
        this.mDownloadDir = dir;
        return this;
    }

    public final RetrofitClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }

    public final RetrofitClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RetrofitClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RetrofitClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RetrofitClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RetrofitClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    public final RetrofitClientBuilder loader(Context context, LoaderStyle style) {
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }

    public final RetrofitClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RetrofitClient build() {
        return new RetrofitClient(mUrl, PARAMS,
                mDownloadDir, mExtension, mName,
                mIRequest, mISuccess, mIFailure,
                mIError, mBody, mFile, mContext,
                mLoaderStyle);
    }
}
