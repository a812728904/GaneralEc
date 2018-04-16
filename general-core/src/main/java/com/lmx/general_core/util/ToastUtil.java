package com.lmx.general_core.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.lmx.general_core.app.General;

/**
 * 吐司 提示框 工具类
 * 
 * @author LMX
 */
public class ToastUtil {
	public static void toToast( String message) {
		Toast.makeText(General.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}
	public static void toToast( int resId) {
		String resMess= (String) General.getApplicationContext().getResources().getText(resId);
        resMess = TextUtils.isEmpty(resMess == null ? "" : resMess.toString()) ? "请检查您的网络！"
                : resMess;
		Toast.makeText(General.getApplicationContext(), resMess, Toast.LENGTH_SHORT).show();
	}
}
