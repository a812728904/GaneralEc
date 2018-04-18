package com.lmx.generalec.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.lmx.general_core.R;
import com.lmx.general_core.app.General;
import com.lmx.generalec.base.PermissionsActivity;
import com.lmx.general_core.avoidonresult.ActivityResultInfo;
import com.lmx.general_core.avoidonresult.AvoidOnResult;
import com.lmx.general_core.util.IntentUtil;
import com.lmx.general_core.util.ToastUtil;

import io.reactivex.functions.Consumer;
import pub.devrel.easypermissions.EasyPermissions;

/**
 *

 *
 * Created by LMX on 2016/6/15 0015.
 */
@SuppressLint("InlinedApi")
public class PermissionUtils {
    public final static int resultPermissionCode=10086;
    /**
     * 获取修改日历权限
     * group:android.permission-group.CALENDAR
     * permission:android.permission.READ_CALENDAR
     * permission:android.permission.WRITE_CALENDAR
     */
    public static void askCalendar(Context context,String... toastMess){
        getPermissionIntent(context,isUsDefauleToast(R.string.read_calendar,toastMess),Manifest.permission.READ_CALENDAR);
    }

    /**
     * 打开摄像头权限
     * group:android.permission-group.CAMERA
     * permission:android.permission.CAMERA
     */
    public static void askCamera(Context context,String... toastMess){
        getPermissionIntent(context,isUsDefauleToast(R.string.camera,toastMess),Manifest.permission.WRITE_EXTERNAL_STORAGE);

    }


    /**
     * 读写储存卡权限
     * group:android.permission-group.STORAGE
     * permission:android.permission.READ_EXTERNAL_STORAGE
     * permission:android.permission.WRITE_EXTERNAL_STORAG
     */

    public static void askExternalStorage(Context context,String... toastMess){
        getPermissionIntent(context,isUsDefauleToast(R.string.storage,toastMess),Manifest.permission_group.STORAGE);
    }

    /**
     * 手机权限
     * group:android.permission-group.PHONE
     * permission:android.permission.READ_CALL_LOG
     * permission:android.permission.READ_PHONE_STATE
     * permission:android.permission.CALL_PHONE
     * permission:android.permission.WRITE_CALL_LOG
     * permission:android.permission.USE_SIP
     * permission:android.permission.PROCESS_OUTGOING_CALLS
     * permission:com.android.voicemail.permission.ADD_VOICEMAIL
     */
    public static void askPhone(Context context,String... toastMess){
        getPermissionIntent(context,isUsDefauleToast(R.string.read_phone_state,toastMess),Manifest.permission.READ_PHONE_STATE);
    }
    public static void askCallPhone(Context context,String... toastMess){
        getPermissionIntent(context,isUsDefauleToast(R.string.call_phone,toastMess),Manifest.permission.CALL_PHONE);
    }

    /**
     * 短信权限
     * group:android.permission-group.SM
     * permission:android.permission.READ_SMS
     * permission:android.permission.RECEIVE_WAP_PUSH
     * permission:android.permission.RECEIVE_MMS
     * permission:android.permission.RECEIVE_SMS
     * permission:android.permission.SEND_SMS
     * permission:android.permission.READ_CELL_BROADCASTS
     */
    public static void askSms(Context context,String... toastMess){
        getPermissionIntent(context,isUsDefauleToast(R.string.send_sms,toastMess),Manifest.permission.SEND_SMS);
    }




    /**
     * 获得位置信息权限
     * group:android.permission-group.LOCATION
     * permission:android.permission.ACCESS_FINE_LOCATION
     * permission:android.permission.ACCESS_COARSE_LOCATION
     */
    public static void askLocationInfo(Context context,String... toastMess){
        getPermissionIntent(context,isUsDefauleToast(R.string.location,toastMess),Manifest.permission_group.LOCATION);
    }


    /**
     *  麦克风权限
     * group:android.permission-group.MICROPHONE
     * permission:android.permission.RECORD_AUDIO
     */
    public static void askRecord(Context context,String... toastMess){
        getPermissionIntent(context,isUsDefauleToast(R.string.microphone,toastMess),Manifest.permission.RECORD_AUDIO);

    }


    /**
     * 传感器权限
     * group:android.permission-group.SENSORS
     * permission:android.permission.BODY_SENSORS
     */
    public static void askSensors(Context context,String... toastMess){

        getPermissionIntent(context,isUsDefauleToast(R.string.sensors,toastMess),Manifest.permission_group.SENSORS);
    }

    /**
     * 联系人权限
     * group:android.permission-group.CONTACTS
     * permission:android.permission.WRITE_CONTACTS
     * permission:android.permission.GET_ACCOUNTS
     * permission:android.permission.READ_CONTACTS
     */
    public static void askContacts(Context context,String... toastMess){
        getPermissionIntent(context,isUsDefauleToast(R.string.contacts,toastMess),Manifest.permission_group.CONTACTS);
    }
    public static String isUsDefauleToast(int defauleToastId,String... userToast){
        if(userToast==null||userToast.length==0)
            return (String) General.getApplicationContext().getResources().getText(defauleToastId);
        else
            return userToast[0];
    }
    /**
     * 跳转到权限申请页面
     * @param toastMess 权限生命信息
     * @param permission
     */
    @SuppressLint("CheckResult")
    public static void getPermissionIntent(Context context, String toastMess, String permission){
        if(!verificationParams(context,permission))return;
        if(EasyPermissions.hasPermissions(context, permission)){
            ToastUtil.toToast("拥有"+permission+"权限");
        }else{
            Bundle bundle=new Bundle();
            bundle.putString("toastMess","toastMess");
            bundle.putString("permission",permission);
            Intent intent= IntentUtil.getIntent(context,PermissionsActivity.class,bundle);
            new AvoidOnResult((Activity)context)
                    .startForResult(intent).subscribe(new Consumer<ActivityResultInfo>() {
                @Override
                public void accept(ActivityResultInfo activityResultInfo) throws Exception {
                    Log.d("123123312","123123");
                }
            });
        }
    }

    /**
     * 验证参数是否为空
     */
    private static boolean verificationParams(Context context,String permission){
        if(context==null)return false;
        if(permission==null||permission.isEmpty())return false;
        return true;
    }



}
