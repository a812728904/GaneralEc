package com.lmx.general_core.base;

import android.widget.Toast;

import com.google.gson.JsonParseException;
import com.lmx.general_core.R;
import com.lmx.general_core.net.exception.NoDataExceptionException;
import com.lmx.general_core.net.exception.ServerResponseException;
import com.lmx.general_core.ui.loader.GeneralLoader;
import com.lmx.general_core.util.LogUtils;
import com.lmx.general_core.util.ToastUtil;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Author:BaseObserver
 * Created by LMX on 2018/4/16
 * Description:
 */
public abstract class DefaultObserver<T> implements Observer<T> {
    private CompositeDisposable mCompositeSubscription;
    public DefaultObserver(CompositeDisposable mCompositeSubscription){
        this.mCompositeSubscription=mCompositeSubscription;
    }
    @Override
    public void onSubscribe(Disposable d) {
        mCompositeSubscription.add(d);
    }

    @Override
    public void onNext(T response) {
        onSuccess(response);
        onFinish();
    }

    @Override
    public void onError(Throwable e) {
        LogUtils.e("Retrofit", e.getMessage());
        if (e instanceof HttpException) {     //   HTTP错误
            onException(ExceptionReason.BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {   //   连接错误
            onException(ExceptionReason.CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {   //  连接超时
            onException(ExceptionReason.CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {   //  解析错误
            onException(ExceptionReason.PARSE_ERROR);
        }else if(e instanceof ServerResponseException){
            onFail(e.getMessage());
        }else if (e instanceof NoDataExceptionException){
            onSuccess(null);
        } else {
            onException(ExceptionReason.UNKNOWN_ERROR);
        }
        onFinish();
    }

    @Override
    public void onComplete() {
        onFinish();
    }

    /**
     * 请求成功
     *
     * @param response 服务器返回的数据
     */
    abstract public void onSuccess(T response);

    /**
     * 服务器返回数据，但响应码不为200
     *
     */
    /**
     * 服务器返回数据，但响应码不为1000
     */
    public void onFail(String message) {
        ToastUtil.toToast(message);
    }

    public void onFinish(){
        GeneralLoader.stopLoading();
    }

    /**
     * 请求异常
     *
     * @param reason
     */
    public void onException(ExceptionReason reason) {
        switch (reason) {
            case CONNECT_ERROR:
                ToastUtil.toToast(R.string.connect_error);
                break;

            case CONNECT_TIMEOUT:
                ToastUtil.toToast(R.string.connect_timeout);
                break;

            case BAD_NETWORK:
                ToastUtil.toToast(R.string.bad_network);
                break;

            case PARSE_ERROR:
                ToastUtil.toToast(R.string.parse_error);
                break;

            case UNKNOWN_ERROR:
            default:
                ToastUtil.toToast(R.string.unknown_error);
                break;
        }
    }

    /**
     * 请求网络失败原因
     */
    public enum ExceptionReason {
        /**
         * 解析数据失败
         */
        PARSE_ERROR,
        /**
         * 网络问题
         */
        BAD_NETWORK,
        /**
         * 连接错误
         */
        CONNECT_ERROR,
        /**
         * 连接超时
         */
        CONNECT_TIMEOUT,
        /**
         * 未知错误
         */
        UNKNOWN_ERROR,
    }
}
