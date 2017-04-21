package com.autel.sdksample.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.album.MediaInfo;
import com.autel.common.error.AutelError;
import com.autel.common.firmware.AircraftComponentSerialNumberVersionInfo;
import com.autel.common.firmware.AircraftComponentVersionInfo;
import com.autel.common.firmware.RemoteControllerSerialNumberVersionInfo;
import com.autel.common.firmware.RemoteControllerVersionInfo;
import com.autel.sdk.AModuleFirmware;

import java.util.List;

/**
 * Created by A16343 on 2016/12/6.
 */
public class FirmwareTest {
    private static final String TAG = "FirmwareTest";
    private static List<MediaInfo> mediaItems;

    public static void getAutelAircraftComponentVersion(final Handler handler) {
        AModuleFirmware.firmware().getAircraftComponentVersion(new CallbackWithOneParam<AircraftComponentVersionInfo>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getAircraftComponentVersion  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(AircraftComponentVersionInfo data) {
                logOut(handler, "getAircraftComponentVersion  data  " + data);
            }
        });
    }

    public static void getAutelAircraftComponentSerialNumberVersion(final Handler handler) {
        AModuleFirmware.firmware().getAircraftComponentSerialNumberVersion(new CallbackWithOneParam<AircraftComponentSerialNumberVersionInfo>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getAircraftComponentSerialNumberVersion  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(AircraftComponentSerialNumberVersionInfo data) {
                logOut(handler, "getAircraftComponentSerialNumberVersion  data  " + data);
            }
        });
    }

    public static void getAutelRCVersion(final Handler handler) {
        AModuleFirmware.firmware().getRemoteControllerVersion(new CallbackWithOneParam<RemoteControllerVersionInfo>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getRemoteControllerVersion  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerVersionInfo data) {
                logOut(handler, "getRemoteControllerVersion  data  " + data);
            }
        });
    }

    public static void getAutelRCSerialNumberVersion(final Handler handler) {
        AModuleFirmware.firmware().getRemoteControllerSerialNumberVersion(new CallbackWithOneParam<RemoteControllerSerialNumberVersionInfo>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getRemoteControllerSerialNumberVersion  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerSerialNumberVersionInfo data) {
                logOut(handler, "getRemoteControllerSerialNumberVersion  data  " + data);
            }
        });
    }

    private static void logOut(Handler handler, String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }

}
