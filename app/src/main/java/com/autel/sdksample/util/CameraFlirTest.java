package com.autel.sdksample.util;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.flir.FLIRDisplayMode;
import com.autel.common.camera.flir.FLIRPhotoSetting;
import com.autel.common.camera.flir.FLIRRecordSetting;
import com.autel.common.camera.flir.IRColorMode;
import com.autel.common.camera.flir.IRMSXSetting;
import com.autel.common.camera.flir.RadiometrySetting;
import com.autel.common.error.AutelError;
import com.autel.sdk.camera.AutelFLIR;

/**
 * Created by A16343 on 2017/02/27.
 */
public class CameraFlirTest {
    private final static String TAG = "CameraFlirTest";

    public static void setDisplayMode(FLIRDisplayMode mode, final Handler handler, AutelFLIR autelFLIR) {
        autelFLIR.setDisplayMode(mode, new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut(handler, "setDisplayMode  onSuccess  ");
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setDisplayMode  description  " + error.getDescription());
            }
        });
    }


    public static void getDisplayMode(final Handler handler, AutelFLIR autelFLIR) {
        autelFLIR.getDisplayMode(new CallbackWithOneParam<FLIRDisplayMode>() {
            @Override
            public void onSuccess(FLIRDisplayMode data) {
                logOut(handler, "getDisplayMode  onSuccess  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getDisplayMode  description  " + error.getDescription());
            }
        });
    }


    public static void setIRColorMode(IRColorMode colorMode, final Handler handler, AutelFLIR autelFLIR) {
        autelFLIR.setIRColorMode(colorMode, new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut(handler, "getDisplayMode  onSuccess  ");
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setIRColorMode  description  " + error.getDescription());
            }
        });
    }


    public static void getIRColorMode(final Handler handler, AutelFLIR autelFLIR) {
        autelFLIR.getIRColorMode(new CallbackWithOneParam<IRColorMode>() {
            @Override
            public void onSuccess(IRColorMode data) {
                logOut(handler, "getIRColorMode  onSuccess  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getIRColorMode  description  " + error.getDescription());
            }
        });
    }

    public static void setIRMSX(IRMSXSetting irmsxSetting, final Handler handler, AutelFLIR autelFLIR) {
        autelFLIR.setIRMSX(irmsxSetting, new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut(handler, "setIRMSX  onSuccess  ");
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setIRMSX  description  " + error.getDescription());
            }
        });
    }

    public static void getIRMSX(final Handler handler, AutelFLIR autelFLIR) {
        autelFLIR.getIRMSX(new CallbackWithOneParam<IRMSXSetting>() {
            @Override
            public void onSuccess(IRMSXSetting data) {
                logOut(handler, "getIRMSX  onSuccess  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getIRMSX  description  " + error.getDescription());
            }
        });
    }

    public static void setRecordingFormat(FLIRRecordSetting flirRecordSetting, final Handler handler, AutelFLIR autelFLIR) {
        autelFLIR.setRecordingFormat(flirRecordSetting, new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut(handler, "setRecordingFormat  onSuccess  ");
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setRecordingFormat  description  " + error.getDescription());
            }
        });
    }

    public static void getRecordingFormat(final Handler handler, AutelFLIR autelFLIR) {
        autelFLIR.getRecordingFormat(new CallbackWithOneParam<FLIRRecordSetting>() {
            @Override
            public void onSuccess(FLIRRecordSetting data) {
                logOut(handler, "getRecordingFormat  onSuccess  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getRecordingFormat  description  " + error.getDescription());
            }
        });
    }

    public static void setPhotoFormat(FLIRPhotoSetting photoSetting, final Handler handler, AutelFLIR autelFLIR) {
        autelFLIR.setPhotoFormat(photoSetting, new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut(handler, "setPhotoFormat  onSuccess  ");
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setRecordingFormat  description  " + error.getDescription());
            }
        });
    }

    public static void getPhotoFormat(final Handler handler, AutelFLIR autelFLIR) {
        autelFLIR.getPhotoFormat(new CallbackWithOneParam<FLIRPhotoSetting>() {
            @Override
            public void onSuccess(FLIRPhotoSetting data) {
                logOut(handler, "getPhotoFormat  onSuccess  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getPhotoFormat  description  " + error.getDescription());
            }
        });
    }
    public static void getRadiometrySettings(final Handler handler, AutelFLIR autelFLIR) {
        autelFLIR.getRadiometrySetting(new CallbackWithOneParam<RadiometrySetting>() {
            @Override
            public void onSuccess(RadiometrySetting data) {
                logOut(handler, "getRadiometrySetting  onSuccess  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getRadiometrySetting  description  " + error.getDescription());
            }
        });
    }

    public static void setRadiometrySettings(final Handler handler, AutelFLIR autelFLIR) {
        RadiometrySetting settings = new RadiometrySetting();
        settings.setSpotMeter(true);
        autelFLIR.setRadiometrySetting(settings, new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut(handler, "setRadiometrySetting  onSuccess  ");
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getRadiometrySetting  description  " + error.getDescription());
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
