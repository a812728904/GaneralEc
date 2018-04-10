package com.lmx.general_core.net;

import android.content.Context;

import com.lmx.general_core.net.callback.IError;
import com.lmx.general_core.net.callback.IFailure;
import com.lmx.general_core.net.callback.IRequest;
import com.lmx.general_core.net.callback.ISuccess;
import com.lmx.general_core.net.callback.RequestCallbacks;
import com.lmx.general_core.net.download.DownloadHandler;
import com.lmx.general_core.ui.loader.GeneralLoader;
import com.lmx.general_core.ui.loader.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Author:RetrofitClient
 * Created by LMX on 2018/3/29.
 * Description:
 */

public class RetrofitClient {
    private static final WeakHashMap<String, Object> PARAMS = RetrofitCreate.getParams();
    private final String URL;
    private final RequestBody BODY;
    private final LoaderStyle LOADER_STYLE;
    private final File FILE;
    private final Context CONTEXT;

    RetrofitClient(String url,
               Map<String, Object> params,
               RequestBody body,
               File file,
               Context context,
               LoaderStyle loaderStyle) {
        this.URL = url;
        PARAMS.putAll(params);
        this.BODY = body;
        this.FILE = file;
        this.CONTEXT = context;
        this.LOADER_STYLE = loaderStyle;
    }

    public static RetrofitClientBuilder builder() {
        return new RetrofitClientBuilder();
    }

    private Observable<String> request(HttpMethod method) {
        final RestService service = RetrofitCreate.getRestService();
        Observable<String> call = null;



        if (LOADER_STYLE != null) {
            GeneralLoader.showLoading(CONTEXT, LOADER_STYLE);
        }

        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case POST_RAW:
                call = service.postRaw(URL, BODY);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case PUT_RAW:
                call = service.putRaw(URL, BODY);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body =
                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                call = service.upload(URL, body);
                break;
            default:
                break;
        }

       return call;
    }

  /*  private Callback<String> getRequestCallback() {
        return new RequestCallbacks(
                LOADER_STYLE
        );
    }*/

    public final Observable<String> get() {
        return request(HttpMethod.GET);
    }

    public final Observable<String> post() {
        if (BODY == null) {
            return request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            return request(HttpMethod.POST_RAW);
        }
    }

    public final Observable<String> put() {
        if (BODY == null) {
            return request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            return request(HttpMethod.PUT_RAW);
        }
    }

    public final Observable<String> delete() {
        return request(HttpMethod.DELETE);
    }

    public final Observable<String> upload() {
       return request(HttpMethod.UPLOAD);
    }

    public final Observable<ResponseBody> download() {
        return RetrofitCreate.getRestService().download(URL,PARAMS);
    }
}
