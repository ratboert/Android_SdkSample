package com.autel.sdksample.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by A16343 on 2016/12/1.
 */
public class CameraTest2 {
    private final static String TAG = "FCTest";

//    public static void setCameraBurstPhotoNum(PhotoBurstCount burstPhotoNum, final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "setPhotoBurstCount  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().setPhotoBurstCount(burstPhotoNum, new CallbackWithNoParam() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setPhotoBurstCount  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        logOut(handler, "setPhotoBurstCount state onSuccess");
//                    }
//                });
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setPhotoBurstCount(burstPhotoNum, new CallbackWithNoParam() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setPhotoBurstCount  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        logOut(handler, "setPhotoBurstCount state onSuccess");
//                    }
//                });
//            }else{
//                logOut(handler, "setPhotoBurstCount  description  camera type is not clear");
//            }
//        }
//    }
//
//
//    public static void getCameraBurstPhotoNum(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "getCameraBurstPhotoNum  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().getBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "getCameraBurstPhotoNum  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess(PhotoBurstCount data) {
//                        logOut(handler, "getCameraBurstPhotoNum " + data);
//                    }
//                });
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().getBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "getCameraBurstPhotoNum  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess(PhotoBurstCount data) {
//                        logOut(handler, "getCameraBurstPhotoNum " + data);
//                    }
//                });
//            }else{
//                logOut(handler, "getCameraBurstPhotoNum  description  camera type is not clear");
//            }
//        }
//
//    }
//
//    public static void getCameraTimelapseIntervalTime(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "getCameraTimelapseIntervalTime  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "getCameraTimelapseIntervalTime  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess(PhotoTimelapseInterval data) {
//                        logOut(handler, "getCameraTimelapseIntervalTime " + data);
//                    }
//                });
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "getCameraTimelapseIntervalTime  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess(PhotoTimelapseInterval data) {
//                        logOut(handler, "getCameraTimelapseIntervalTime " + data);
//                    }
//                });
//            }else{
//                logOut(handler, "getCameraTimelapseIntervalTime  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void setCameraTimelapseIntervalTime(PhotoTimelapseInterval timelapseIntervalTime, final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "setPhotoTimelapseInterval  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().setPhotoTimelapseInterval(timelapseIntervalTime, new CallbackWithNoParam() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setPhotoTimelapseInterval  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        logOut(handler, "setPhotoTimelapseInterval state onSuccess");
//                    }
//                });
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setPhotoTimelapseInterval(timelapseIntervalTime, new CallbackWithNoParam() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setPhotoTimelapseInterval  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        logOut(handler, "setPhotoTimelapseInterval state onSuccess");
//                    }
//                });
//            }else{
//                logOut(handler, "setPhotoTimelapseInterval  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void getPhotoAEBParameter(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "getPhotoAEBCount  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().getPhotoAEBCount(new CallbackWithOneParam<PhotoAEBCount>() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "getPhotoAEBCount  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess(PhotoAEBCount data) {
//                        logOut(handler, "getPhotoAEBCount " + data);
//                    }
//                });
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().getPhotoAEBCount(new CallbackWithOneParam<PhotoAEBCount>() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "getPhotoAEBCount  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess(PhotoAEBCount data) {
//                        logOut(handler, "getPhotoAEBCount " + data);
//                    }
//                });
//            }else{
//                logOut(handler, "getPhotoAEBCount  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void setCameraAebNum(PhotoAEBCount aebNum, final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "setPhotoAEBCount  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().setPhotoAEBCount(aebNum, new CallbackWithNoParam() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setPhotoAEBCount  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        logOut(handler, "setPhotoAEBCount state onSuccess");
//                    }
//                });
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setPhotoAEBCount(aebNum, new CallbackWithNoParam() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setPhotoAEBCount  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        logOut(handler, "setPhotoAEBCount state onSuccess");
//                    }
//                });
//            }else{
//                logOut(handler, "setPhotoAEBCount  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void getCameraManualFocusModeDistance(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "getCameraManualFocusModeDistance  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if (AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12) {
//                logOut(handler, "getCameraManualFocusModeDistance is not support for xb004");
//            } else if (AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008) {
//                AModuleCamera.cameraManager().getXb008().getFocusDistance(new CallbackWithOneParam<CameraManualFocusDistance>() {
//                    @Override
//                    public void onSuccess(CameraManualFocusDistance data) {
//                        logOut(handler, "getCameraManualFocusModeDistance  description  " + data);
//                    }
//
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "getCameraManualFocusModeDistance " + error.getDescription());
//                    }
//                });
//            } else {
//                logOut(handler, "getCameraManualFocusModeDistance  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void setCameraManualFocusModeDistance(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "setManualFocusDistance  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                logOut(handler, "setManualFocusDistance is not support for xb004");
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setManualFocusDistance(CameraManualFocusDistance.Distance_500_METRIC, new CallbackWithNoParam() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setManualFocusDistance  description  " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        logOut(handler, "setManualFocusDistance state onSuccess");
//                    }
//                });
//            }else{
//                logOut(handler, "setManualFocusDistance  description  camera type is not clear");
//            }
//        }
//    }
//
//
//    public static void setCameraModeListener(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "setMediaModeListener  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().setMediaModeListener(new CallbackWithOneParam<MediaMode>() {
//                    @Override
//                    public void onSuccess(MediaMode mode) {
//                        logOut(handler, "setMediaModeListener mode " + mode);
//                    }
//
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setMediaModeListener error " + error.getDescription());
//                    }
//                });
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setMediaModeListener(new CallbackWithOneParam<MediaMode>() {
//                    @Override
//                    public void onSuccess(MediaMode mode) {
//                        logOut(handler, "setMediaModeListener mode " + mode);
//                    }
//
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setMediaModeListener error " + error.getDescription());
//                    }
//                });
//            }else{
//                logOut(handler, "setMediaModeListener  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void resetCameraModeListener(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "resetCameraModeListener  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb008().setMediaModeListener(null);
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setMediaModeListener(null);
//            }else{
//                logOut(handler, "resetCameraModeListener  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void setCameraUploadGoalAreaListener(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "setMediaModeListener  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().setVisualTrackingListener(new CallbackWithOneParam<CameraGoalArea>() {
//
//
//                    @Override
//                    public void onSuccess(CameraGoalArea area) {
//                        logOut(handler, "CameraGoalArea area X" + area.getStartX() + "  Y  " + area.getStartY() + "  W  " + area.getWidth() + "  H  " + area.getHeight());
//                    }
//
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setMediaModeListener error " + error.getDescription());
//                    }
//                });
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setVisualTrackingListener(new CallbackWithOneParam<CameraGoalArea>() {
//
//
//                    @Override
//                    public void onSuccess(CameraGoalArea area) {
//                        logOut(handler, "CameraGoalArea area X" + area.getStartX() + "  Y  " + area.getStartY() + "  W  " + area.getWidth() + "  H  " + area.getHeight());
//                    }
//
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setMediaModeListener error " + error.getDescription());
//                    }
//                });
//            }else{
//                logOut(handler, "setMediaModeListener  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void resetCameraUploadGoalAreaListener(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "getFocusMode  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().setVisualTrackingListener(null);
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setVisualTrackingListener(null);
//            }else{
//                logOut(handler, "getFocusMode  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void setCameraMediaStateListener(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "setMediaStateListener  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().setMediaStateListener(new CallbackWithTwoParams<MediaStatus,String>() {
//                    @Override
//                    public void onSuccess(MediaStatus state, String data) {
//                        logOut(handler, "setMediaStateListener state " + state);
//                    }
//
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setMediaStateListener error " + error.getDescription());
//                    }
//                });
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setMediaStateListener(new CallbackWithTwoParams<MediaStatus,String>() {
//                    @Override
//                    public void onSuccess(MediaStatus state, String data) {
//                        logOut(handler, "setMediaStateListener state " + state);
//                    }
//
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setMediaStateListener error " + error.getDescription());
//                    }
//                });
//            }else{
//                logOut(handler, "setMediaStateListener  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void resetCameraMediaStateListener(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "resetCameraMediaStateListener  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().setMediaStateListener(null);
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setMediaStateListener(null);
//            }else{
//                logOut(handler, "resetCameraMediaStateListener  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void setCameraAutoFocusStateListener(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "setAutoFocusStateListener  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().setAutoFocusStateListener(new CallbackWithTwoParams<CameraLensFocusStatus,List<CameraSpotMeteringArea>>() {
//                    @Override
//                    public void onSuccess(CameraLensFocusStatus state, List<CameraSpotMeteringArea> data) {
//                        logOut(handler, "setAutoFocusStateListener state " + state);
//                    }
//
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setAutoFocusStateListener error " + error.getDescription());
//                    }
//                });
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setAutoFocusStateListener(new CallbackWithTwoParams<CameraLensFocusStatus,List<CameraSpotMeteringArea>>() {
//                    @Override
//                    public void onSuccess(CameraLensFocusStatus state, List<CameraSpotMeteringArea> data) {
//                        logOut(handler, "setAutoFocusStateListener state " + state);
//                    }
//
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setAutoFocusStateListener error " + error.getDescription());
//                    }
//                });
//            }else{
//                logOut(handler, "setAutoFocusStateListener  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void resetCameraAutoFocusStateListener(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "getFocusMode  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().setMediaStateListener(null);
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setMediaStateListener(null);
//            }else{
//                logOut(handler, "getFocusMode  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void setCameraHistogramListener(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "setHistogramListener  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().setHistogramListener(new CallbackWithOneParam<int[]>() {
//                    @Override
//                    public void onSuccess(int[] result) {
//                        logOut(handler, "setHistogramListener state " + result);
//                    }
//
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setHistogramListener error " + error.getDescription());
//                    }
//                });
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setHistogramListener(new CallbackWithOneParam<int[]>() {
//                    @Override
//                    public void onSuccess(int[] result) {
//                        logOut(handler, "setHistogramListener state " + result);
//                    }
//
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setHistogramListener error " + error.getDescription());
//                    }
//                });
//            }else{
//                logOut(handler, "setHistogramListener  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void resetCameraHistogramListener(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "resetCameraHistogramListener  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                AModuleCamera.cameraManager().getXb004().setHistogramListener(null);
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setHistogramListener(null);
//            }else{
//                logOut(handler, "resetCameraHistogramListener  description  camera type is not clear");
//            }
//        }
//    }
//
//    public static void setCameraAutoFocusMeterInSpotMode(final Handler handler) {
//        if (AModuleCamera.cameraManager().getParameterSupport().getError() != null) {
//            logOut(handler, "getFocusMode  error: " + AModuleCamera.cameraManager().getParameterSupport().getError().getDescription());
//        } else {
//            if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.R12){
//                logOut(handler, "getFocusMode is not support for xb004");
//            } else if(AModuleCamera.cameraManager().getParameterSupport().getResult().getCurrentProduct() == CameraProduct.XB008){
//                AModuleCamera.cameraManager().getXb008().setPhotoAutoFocusMeter(6, 3, new CallbackWithNoParam() {
//                    @Override
//                    public void onFailure(AutelError error) {
//                        logOut(handler, "setPhotoAutoFocusMeter error " + error.getDescription());
//                    }
//
//                    @Override
//                    public void onSuccess() {
//                        logOut(handler, "setPhotoAutoFocusMeter state onSuccess");
//                    }
//                });
//            }else{
//                logOut(handler, "getFocusMode  description  camera type is not clear");
//            }
//        }
//    }

    private static void logOut(Handler handler, String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }
}
