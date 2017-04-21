package com.autel.sdksample.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.dsp.AutelCancellable;
import com.autel.common.dsp.RFData;
import com.autel.common.dsp.SSIDInfo;
import com.autel.common.error.AutelError;
import com.autel.sdk.AModuleDsp;

import java.util.List;

/**
 * Created by A16343 on 2016/12/2.
 */
public class DspTest {
    private static final String TAG = "DspTest";
    private static AutelCancellable getRFList;
    private static AutelCancellable getCurrentRF;
    private static AutelCancellable setCurrentRF;

    public static void getRFListStart(final Handler handler) {
        getRFList =  AModuleDsp.dsp().getRFDataList(3, new CallbackWithOneParam<List<RFData>>() {
            @Override
            public void onFailure(AutelError error) {
                Log.v(TAG, "getRFDataList  error  " + error.getDescription());
                Message message = handler.obtainMessage();
                message.obj = "getRFDataList  error  " + error.getDescription();
                handler.sendMessage(message);
            }

            @Override
            public void onSuccess(List<RFData> data) {
                Message message = handler.obtainMessage();
                message.obj = "getRFDataList  " + data;
                handler.sendMessage(message);
                Log.v(TAG, "getRFDataList  " + data);
            }
        });
    }

    public static void getRFListCancel(final Handler handler){
        if(null != getRFList){
            Log.v(TAG, "getRFDataList  cancel " + getRFList.cancel());
            Message message = handler.obtainMessage();
            message.obj = "getRFDataList  cancel " + getRFList.cancel();
            handler.sendMessage(message);
        }else{
            Log.v(TAG, "getRFDataList  cancel null");
            Message message = handler.obtainMessage();
            message.obj = "getRFDataList  cancel null";
            handler.sendMessage(message);
        }

    }

    public static void getCurrentRFStart(final Handler handler) {
        getCurrentRF = AModuleDsp.dsp().getCurrentRFData(3, new CallbackWithOneParam<RFData>() {
            @Override
            public void onFailure(AutelError error) {
                Log.v(TAG, "getCurrentRFData  error  " + error.getDescription());
                Message message = handler.obtainMessage();
                message.obj = "getCurrentRFData  error  " + error.getDescription();
                handler.sendMessage(message);
            }

            @Override
            public void onSuccess(RFData data) {
                Log.v(TAG, "getCurrentRFData  " + data);
                Message message = handler.obtainMessage();
                message.obj = "getCurrentRFData  " + data;
                handler.sendMessage(message);
            }
        });
    }

    public static void getCurrentRFCancel(final Handler handler) {
        if(null != getCurrentRF){
            Log.v(TAG, "getCurrentRFCancel  cancle " + getCurrentRF.cancel());
            Message message = handler.obtainMessage();
            message.obj = "getCurrentRFCancel  cancle " + getCurrentRF.cancel();
            handler.sendMessage(message);
        }else{
            Log.v(TAG, "getCurrentRFCancel  cancel null");

            Message message = handler.obtainMessage();
            message.obj = "getCurrentRFCancel  cancel null";
            handler.sendMessage(message);
        }
    }

    public static void setCurrentRFStart(int newRouteHz,final Handler handler) {
        setCurrentRF = AModuleDsp.dsp().setCurrentRFData(newRouteHz, 3, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                Log.v(TAG, "setCurrentRFData  error  " + error.getDescription());
                Message message = handler.obtainMessage();
                message.obj = "setCurrentRFData  error  " + error.getDescription();
                handler.sendMessage(message);
            }

            @Override
            public void onSuccess() {
                Log.v(TAG, "setCurrentRFData  onSuccess");
                Message message = handler.obtainMessage();
                message.obj = "setCurrentRFData  onSuccess";
                handler.sendMessage(message);
            }
        });
    }

    public static void setCurrentRFCancel(final Handler handler) {
        if(null != setCurrentRF){
            logOut(handler, "setCurrentRFCancel  cancel " + setCurrentRF.cancel());
        }else{
            logOut(handler, "setCurrentRFCancel  cancel null");
        }
    }

    public static void updateNewSSIDInfo(final Handler handler, String name, String pwd) {
        AModuleDsp.dsp().updateNewSSIDInfo(name, pwd, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setCurrentRFData  error  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setCurrentRFData  onSuccess");
            }
        });
    }

    public static void getCurrentSSIDInfo(final Handler handler) {
        logOut(handler, "getCurrentSSIDInfo  " + AModuleDsp.dsp().getCurrentSSIDInfo());
    }
    private static void logOut(Handler handler, String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }
}
