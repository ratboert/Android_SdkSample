package com.autel.sdksample.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.media.CameraAspectRatio;
import com.autel.common.camera.media.CameraExposureMode;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.CameraWhiteBalanceType;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.error.AutelError;
import com.autel.sdk.AModuleCamera;


public class CameraParamsTest {
    private static final String TAG = "CameraParamsTest";

//    public static void isSupportIRIS(Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "isSupportIRIS  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            logOut(handler, "isSupportIRIS  " + AModuleCamera.cameraManager().getParameterSupport().getResult().isSupportIRIS());
//        }
//    }
//
//    public static void isSupportPhotoAutoFocusMeter(Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "isSupportPhotoAutoFocusMeter  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            logOut(handler, "isSupportPhotoAutoFocusMeter  " + AModuleCamera.cameraManager().getParameterSupport().getResult().isSupportPhotoAutoFocusMeter());
//        }
//    }
//
//    public static void isSupportManualFocusDistance(Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "isSupportManualFocusDistance  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            logOut(handler, "isSupportManualFocusDistance  " + AModuleCamera.cameraManager().getParameterSupport().getResult().isSupportManualFocusDistance());
//        }
//    }
//
//    public static void isSupportFocusMode(Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "isSupportFocusMode  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            logOut(handler, "isSupportFocusMode  " + AModuleCamera.cameraManager().getParameterSupport().getResult().isSupportFocusMode());
//        }
//    }
//
//    public static void isSupportDigitalZoomScale(Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "isSupportDigitalZoomScale  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            logOut(handler, "isSupportDigitalZoomScale  " + AModuleCamera.cameraManager().getParameterSupport().getResult().isSupportDigitalZoomScale());
//        }
//    }
//
//    public static void isSupportAutoExposureLockState(Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "isSupportAutoExposureLockState  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            logOut(handler, "isSupportAutoExposureLockState  " + AModuleCamera.cameraManager().getParameterSupport().getResult().isSupportAutoExposureLockState());
//        }
//    }

    public static void getSupportedWhiteBalanceType(Handler handler) {
        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
            logOut(handler, "getSupportedWhiteBalanceType  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
        } else {
            CameraWhiteBalanceType[]  whiteBalanceType = AModuleCamera.cameraManager().getParameterSupport().getResult().supportedWhiteBalanceType();
            StringBuffer sb = new StringBuffer();
            for (CameraWhiteBalanceType type : whiteBalanceType){
                sb.append(type);
                sb.append(",");
            }
            logOut(handler, "getSupportedWhiteBalanceType  " + sb.toString());
        }
    }

    public static void getSupportedISO(Handler handler) {
        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
            logOut(handler, "getSupportedISO  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
        } else {
            CameraISO[]   whiteBalanceType = AModuleCamera.cameraManager().getParameterSupport().getResult().supportedISO();
            StringBuffer sb = new StringBuffer();
            for (CameraISO type : whiteBalanceType){
                sb.append(type);
                sb.append(",");
            }
            logOut(handler, "getSupportedISO  " + sb.toString());
        }
    }

    public static void getSupportedExposureMode(Handler handler) {
        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
            logOut(handler, "getSupportedExposureMode  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
        } else {
            CameraExposureMode[]   whiteBalanceType = AModuleCamera.cameraManager().getParameterSupport().getResult().supportedExposureMode();
            StringBuffer sb = new StringBuffer();
            for (CameraExposureMode type : whiteBalanceType){
                sb.append(type);
                sb.append(",");
            }
            logOut(handler, "getSupportedExposureMode  " + sb.toString());
        }
    }

    public static void supportAspectRatio(Handler handler) {
        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
            logOut(handler, "supportAspectRatio  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
        } else {
            CameraAspectRatio[]   whiteBalanceType = AModuleCamera.cameraManager().getParameterSupport().getResult().supportAspectRatio();
            StringBuffer sb = new StringBuffer();
            for (CameraAspectRatio type : whiteBalanceType){
                sb.append(type);
                sb.append(",");
            }
            logOut(handler, "supportAspectRatio  " + sb.toString());
        }
    }

    public static void supportVideoResolutionAndFps(final Handler handler) {
        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
            logOut(handler, "supportVideoResolutionAndFps  " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
        } else {
            AModuleCamera.cameraManager().getParameterSupport().getResult().supportVideoResolutionAndFps(new CallbackWithOneParam<VideoResolutionAndFps[]>() {
                @Override
                public void onSuccess(VideoResolutionAndFps[] data) {
                    StringBuffer sb = new StringBuffer();
                    for (VideoResolutionAndFps type : data){
                        sb.append(type);
                        sb.append(",");
                    }
                    logOut(handler, "supportVideoResolutionAndFps  " + sb.toString());
                }

                @Override
                public void onFailure(AutelError error) {
                    logOut(handler, "supportVideoResolutionAndFps  error: " + error);
                }
            });
        }
    }

    private static void logOut(Handler handler, String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }
}
