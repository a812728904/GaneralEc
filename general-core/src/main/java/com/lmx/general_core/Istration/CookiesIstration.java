package com.lmx.general_core.Istration;

import android.annotation.SuppressLint;

import com.lmx.general_core.base.SharedPreferencesHelper;

/**
 * Author:CookiesIstration
 * Created by LMX on 2018/4/16
 * Description: cookies管理
 */
@SuppressLint("NewApi")
public class CookiesIstration {
    private volatile static CookiesIstration istration;
    private CookiesIstration(){}
    public static CookiesIstration getInstance() {
        if (istration == null) {
            synchronized (CookiesIstration.class) {
                if (istration == null) {
                    istration = new CookiesIstration();
                }
            }
        }
        return istration;
    }

    /**
     * 根据域名保存Cookie
     * @param hostKey
     * @param sessionId
     */
    public void saveCookie(String hostKey,String sessionId){
        SharedPreferencesHelper.getInstance().putData(hostKey,sessionId);
    }

    /**
     * 根据域名找到相对应的Cookie
     * @param hostKey
     * @return
     */
    public String queryCookie(String hostKey){
        return (String) SharedPreferencesHelper.getInstance().getData(hostKey,"");
    }


}