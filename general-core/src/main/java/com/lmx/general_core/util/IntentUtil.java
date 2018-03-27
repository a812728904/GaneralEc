package com.lmx.general_core.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class IntentUtil {

	public static void toActivity(Context context, Class to, Bundle bundle) {
		Intent intent = new Intent(context, to);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		context.startActivity(intent);
	}

	public static void toActivityReult(Context context, Class to,
                                       Bundle bundle, int requestCode) {
		Intent intent = new Intent(context, to);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		((Activity)context).startActivityForResult(intent, requestCode);
	}
}
