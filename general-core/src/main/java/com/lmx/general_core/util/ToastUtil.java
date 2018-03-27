package com.lmx.general_core.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 吐司 提示框 工具类
 * 
 * @author LMX
 */
public class ToastUtil {
	public static void toToast(Context context, String message) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}
}
