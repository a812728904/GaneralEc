package com.lmx.generalec;


import android.Manifest;

import com.lmx.generalec.util.PermissionUtils;
import com.lmx.generalec.base.BaseActivity;

import io.reactivex.disposables.CompositeDisposable;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends BaseActivity implements PermissionUtils.PermissResult{
    private static final int REQUEST_CODE = 0; // 请求码
    // 所需的全部权限
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.MODIFY_AUDIO_SETTINGS
    };

    protected CompositeDisposable mCompositeSubscription = new CompositeDisposable();

    @Override
    protected int setLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        testNet();
    }



    private void testNet() {
        PermissionUtils.askRecord(this,this);

    }


    @Override
    public void permissOkResult() {

    }
}
