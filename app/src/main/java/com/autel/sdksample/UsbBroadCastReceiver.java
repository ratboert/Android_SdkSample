package com.autel.sdksample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.autel.sdksample.mission.MapActivity;

/**
 * 监听USB连接设备的广播
 */
public class UsbBroadCastReceiver extends BroadcastReceiver {
    final String TAG = getClass().getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        /**
         * 只会监听由USB连接到设备的广播，接收到连接到设备的广播后启动主页
         */
        Log.v(TAG, "action " + intent.getAction());
        Intent i = new Intent();
        i.setClass(context, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}

