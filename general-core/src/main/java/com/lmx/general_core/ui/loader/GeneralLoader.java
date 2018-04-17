package com.lmx.general_core.ui.loader;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.lmx.general_core.R;
import com.lmx.general_core.util.dimen.DimenUtil;

import java.util.ArrayList;

/**
 * Author:GeneralLoader
 * Created by LMX on 2018/3/29.
 * Description:
 */

public class GeneralLoader {
    private static final int LOADER_SIZE_SCALE = 8;
    private static final int LOADER_OFFSET_SCALE = 10;
    private static final String DEFAULTMESS="正在加载中请稍候.....";
    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();


    public static void showLoading(Context context,String loadMess) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);

        int deviceWidth = DimenUtil.getScreenWidth();
        int deviceHeight = DimenUtil.getScreenHeight();

        final Window dialogWindow = dialog.getWindow();

        if (dialogWindow != null) {
            final WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth / LOADER_SIZE_SCALE;
            lp.height = deviceHeight / LOADER_SIZE_SCALE;
            lp.height = lp.height + deviceHeight / LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();

    }

    public static void showLoading(Context context) {
        showLoading(context,DEFAULTMESS);
    }

    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                }
            }
        }
        LOADERS.removeAll(LOADERS);
    }
}
