package com.lmx.general_core.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.lmx.general_core.app.General;

/**
 * Author:DimenUtil
 * Created by LMX on 2018/3/29.
 * Description:
 */

public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = General.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = General.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
