package com.autel.sdksample.util;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.camera.base.CameraWorkState;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.MediaStatus;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.base.SDCardState;
import com.autel.common.camera.media.CameraAntiFlicker;
import com.autel.common.camera.media.CameraAspectRatio;
import com.autel.common.camera.media.CameraAutoExposureLockState;
import com.autel.common.camera.media.CameraColorStyle;
import com.autel.common.camera.media.CameraExposureCompensation;
import com.autel.common.camera.media.CameraExposureMode;
import com.autel.common.camera.media.CameraISO;
import com.autel.common.camera.media.CameraLensFocusStatus;
import com.autel.common.camera.media.CameraShutterSpeed;
import com.autel.common.camera.media.CameraSpotMeteringArea;
import com.autel.common.camera.media.CameraWhiteBalance;
import com.autel.common.camera.media.CameraWhiteBalanceType;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.media.PhotoStyle;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoSum;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.VideoSum;
import com.autel.common.error.AutelError;
import com.autel.sdk.camera.AutelBaseCamera;
import com.autel.sdk.camera.AutelR12;

import java.util.List;

/**
 * Created by A16343 on 2016/11/11.
 */
public class CameraTest {
    private final static String TAG = "CameraTest";

    public static void setCameraSDCardStateListener(final Handler handler, AutelBaseCamera r12) {
        r12.setSDCardStateListener(new CallbackWithOneParam<SDCardState>() {
            @Override
            public void onSuccess(SDCardState state) {
                logOut(handler, "setSDCardStateListener  state  " + state);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setSDCardStateListener  description  " + error.getDescription());
            }
        });

    }

    public static void resetCameraSDCardStateListener(final Handler handler, AutelBaseCamera r12) {
        r12.setSDCardStateListener(null);
    }

    public static void setCameraAutoExposureState(final CameraAutoExposureLockState lockState, final Handler handler, AutelR12 r12) {
        r12.setAutoExposureLockState(lockState, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setAutoExposureLockState  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setAutoExposureLockState  lockState  " + lockState + " onSuccess ");
            }
        });
    }

    public static void getCameraAutoExposureState(final Handler handler, AutelR12 r12) {
        r12.getAutoExposureLockState(new CallbackWithOneParam<CameraAutoExposureLockState>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getAutoExposureLockState  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraAutoExposureLockState data) {
                logOut(handler, "getAutoExposureLockState  " + data);
            }
        });
    }

    public static void getPhotoExposureMode(final Handler handler, AutelR12 r12) {
        r12.getExposureMode(new CallbackWithOneParam<CameraExposureMode>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getExposureMode  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraExposureMode data) {
                logOut(handler, "getExposureMode  " + data);
            }
        });
    }



    public static void setCameraSpotMeter(final Handler handler, AutelR12 r12) {
        r12.setSpotMeteringArea(2, 3, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setSpotMeteringArea  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setSpotMeteringArea  " + "  state  onSuccess" );
            }
        });
    }

    public static void getSpotMeterLocation(final Handler handler, AutelR12 r12) {
        r12.getSpotMeteringArea(new CallbackWithOneParam<CameraSpotMeteringArea>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getSpotMeteringArea  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraSpotMeteringArea data) {
                logOut(handler, "getSpotMeteringArea X " + data.X + "  Y " + data.Y);
            }
        });
    }

    public static void setCameraMode(MediaMode mode, final Handler handler, AutelBaseCamera r12) {
        r12.setMediaMode(mode, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setMediaMode  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setMediaMode state onSuccess");
            }
        });

    }

    public static void getExposure(final Handler handler, AutelR12 r12) {
        r12.getExposure(new CallbackWithOneParam<CameraExposureCompensation>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getExposure  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraExposureCompensation data) {
                logOut(handler, "getExposure " + data);
            }
        });
    }

    public static void setExposureValue(final Handler handler, AutelR12 r12) {
        r12.setExposure(CameraExposureCompensation.NEGATIVE_0p3, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setExposure  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setExposure state onSuccess");
            }
        });
    }

    public static void getISO(final Handler handler, AutelR12 r12) {
        r12.getISO(new CallbackWithOneParam<CameraISO>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getISO  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraISO data) {
                logOut(handler, "getISO " + data);
            }
        });
    }

    public static void setISO(final Handler handler, AutelR12 r12) {
        r12.setISO(CameraISO.ISO_200, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setISO  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setISO state onSuccess");
            }
        });
    }

    public static void getShutter(final Handler handler, AutelR12 r12) {
        r12.getShutter(new CallbackWithOneParam<CameraShutterSpeed>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getShutter  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraShutterSpeed data) {
                logOut(handler, "getShutter " + data);
            }
        });
    }

    public static void setShutter(final Handler handler, AutelR12 r12) {
        r12.setShutter(CameraShutterSpeed.ShutterSpeed_1_1dot25, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setShutter  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setShutter state onSuccess");
            }
        });

    }

    public static void getAspectRatio(final Handler handler, AutelR12 r12) {
        r12.getAspectRatio(new CallbackWithOneParam<CameraAspectRatio>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getAspectRatio  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraAspectRatio data) {
                logOut(handler, "getAspectRatio " + data);
            }
        });
    }

    public static void setAspectRatio(CameraAspectRatio ratio, final Handler handler, AutelR12 r12) {
        r12.setAspectRatio(ratio, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setAspectRatio  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setAspectRatio state onSuccess");
            }
        });
    }

    public static void setPhotoFormat(PhotoFormat format, final Handler handler, AutelR12 r12) {
        r12.setPhotoFormat(format, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setPhotoFormat  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setPhotoFormat state onSuccess");
            }
        });
    }

    public static void getPhotoFormat(final Handler handler, AutelR12 r12) {
        r12.getPhotoFormat(new CallbackWithOneParam<PhotoFormat>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getPhotoFormat  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(PhotoFormat data) {
                logOut(handler, "getPhotoFormat " + data);
            }
        });
    }

    public static void getWhiteBalance(final Handler handler, AutelR12 r12) {
        r12.getWhiteBalance(new CallbackWithOneParam<CameraWhiteBalance>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getWhiteBalance  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraWhiteBalance data) {
                logOut(handler, "getWhiteBalance " + data.type + "  colorTemperature  " + data.colorTemperature);
            }
        });
    }

    public static void setWhiteBalance(CameraWhiteBalanceType whiteBalance, final Handler handler, AutelR12 r12) {
        CameraWhiteBalance whiteBalance1 = new CameraWhiteBalance();
        whiteBalance1.type = whiteBalance;
        r12.setWhiteBalance(whiteBalance1, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setWhiteBalance  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setWhiteBalance state onSuccess");
            }
        });
    }

    public static void setCameraCustomWhiteBalance(final Handler handler, AutelR12 r12) {
        CameraWhiteBalance whiteBalance1 = new CameraWhiteBalance();
        whiteBalance1.type = CameraWhiteBalanceType.CUSTOM;
        whiteBalance1.colorTemperature = 2100;
        r12.setWhiteBalance(whiteBalance1, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setWhiteBalance  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setWhiteBalance state onSuccess");
            }
        });
    }

    public static void setCameraColor(CameraColorStyle cameraColor, final Handler handler, AutelR12 r12) {
        r12.setColorStyle(cameraColor, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setColorStyle  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setColorStyle state onSuccess");
            }
        });
    }

    public static void getVideoResolution(final Handler handler, AutelR12 r12) {
        r12.getVideoResolutionAndFps(new CallbackWithOneParam<VideoResolutionAndFps>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getVideoResolutionAndFps  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(VideoResolutionAndFps data) {
                logOut(handler, "getVideoResolutionAndFps " + data);
            }
        });
    }

    public static void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolution, final Handler handler, AutelR12 r12) {
        r12.setVideoResolutionAndFrameRate(videoResolution, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setVideoResolutionAndFrameRate  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setVideoResolutionAndFrameRate state onSuccess");
            }
        });
    }

    public static void getVideoStandard(final Handler handler, AutelR12 r12) {
        r12.getVideoStandard(new CallbackWithOneParam<VideoStandard>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getVideoStandard  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(VideoStandard data) {
                logOut(handler, "getVideoStandard " + data);
            }
        });

    }

    public static void setCameraVideoStandard(VideoStandard videoStandard, final Handler handler, AutelR12 r12) {
        r12.setVideoStandard(videoStandard, new CallbackWithNoParam() {

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setVideoStandard  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setVideoStandard state onSuccess");
            }
        });
    }

    public static void setCameraVideoSubtitleEnable(boolean enable, final Handler handler, AutelR12 r12) {
        r12.setVideoSubtitleEnable(enable, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setVideoSubtitleEnable  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setVideoSubtitleEnable state onSuccess");
            }
        });
    }

    public static void is3DDenoiseEnable(final Handler handler, AutelR12 r12) {
        r12.is3DDenoiseEnable(new CallbackWithOneParam<Boolean>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "is3DDenoiseEnable  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(Boolean data) {
                logOut(handler, "is3DDenoiseEnable " + data);
            }
        });
    }

    public static void set3DDenoiseEnable(boolean enable, final Handler handler, AutelR12 r12) {
        r12.set3DNoiseReductionEnable(enable, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "set3DNoiseReductionEnable  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "set3DNoiseReductionEnable state onSuccess");
            }
        });

    }

    public static void getAntiFlicker(final Handler handler, AutelR12 r12) {
        r12.getAntiFlicker(new CallbackWithOneParam<CameraAntiFlicker>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getAntiFlicker  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraAntiFlicker data) {
                logOut(handler, "getAntiFlicker " + data);
            }
        });
    }

    public static void setAntiFlicker(CameraAntiFlicker flicker, final Handler handler, AutelR12 r12) {
        r12.setAntiFlicker(flicker, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setAntiFlicker  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setAntiFlicker state onSuccess");
            }
        });
    }

    public static void setPhotoStyle(PhotoStyleType styleType, final Handler handler, AutelR12 r12) {
        r12.setPhotoStyle(styleType, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setPhotoStyle  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setPhotoStyle state onSuccess");
            }
        });
    }

    public static void setCameraCustomPhotoStyle(final Handler handler, AutelR12 r12) {
        r12.setPhotoStyle(1, 2, 3, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setPhotoStyle  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setPhotoStyle state onSuccess");
            }
        });
    }


    public static void startTakePhoto(final Handler handler, AutelBaseCamera r12) {
        r12.startTakePhoto(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "startTakePhoto " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "startTakePhoto onSuccess");
            }
        });
    }


    public static void stopTakePhoto(final Handler handler, AutelBaseCamera r12) {
        r12.stopTakePhoto(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "stopTakePhoto " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "stopTakePhoto onSuccess");
            }
        });
    }


    public static void startRecordVideo(final Handler handler, AutelBaseCamera r12) {
        r12.startRecordVideo(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "startRecordVideo " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "startRecordVideo onSuccess");
            }
        });
    }

    public static void stopRecordVideo(final Handler handler, AutelBaseCamera r12) {
        r12.stopRecordVideo(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "stopRecordVideo " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "stopRecordVideo onSuccess");
            }
        });
    }

    public static void formatSDCard(final Handler handler, AutelBaseCamera r12) {
        r12.formatSDCard(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "formatSDCard " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "formatSDCard onSuccess");
            }
        });
    }

    public static void resetCamera(final Handler handler, AutelBaseCamera r12) {
        r12.resetDefaults(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "resetDefaults " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "resetDefaults onSuccess");
            }
        });
    }



    public static void getCameraCurrentVideoRecordTime(final Handler handler, AutelR12 r12) {
        r12.getCurrentRecordTimeSeconds(new CallbackWithOneParam<Integer>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getCurrentRecordTimeSeconds " + error.getDescription());
            }

            @Override
            public void onSuccess(Integer data) {
                logOut(handler, "getCurrentRecordTimeSeconds " + data);
            }
        });
    }





    public static void setCameraConnectStateListener(final Handler handler, AutelBaseCamera r12) {
        r12.setConnectStateListener(new CallbackWithOneParam<Boolean>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setConnectStateListener camera error " + error.getDescription());
            }

            @Override
            public void onSuccess(Boolean data) {
                logOut(handler, data ? "camera connected" : "camera disconnect");
            }
        });
    }

    public static void resetCameraConnectStateListener(final Handler handler, AutelBaseCamera r12) {
        r12.setConnectStateListener(null);
    }


    public static void getWorkStatus(final Handler handler, AutelBaseCamera r12) {
        r12.getWorkStatus(new CallbackWithOneParam<CameraWorkState>() {
            @Override
            public void onSuccess(CameraWorkState data) {
                logOut(handler, "getWorkStatus " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getWorkStatus " + error.getDescription());
            }
        });
    }

    public static void getSDCardStatus(final Handler handler, AutelBaseCamera r12) {
        r12.getSDCardStatus(new CallbackWithOneParam<SDCardState>() {
            @Override
            public void onSuccess(SDCardState data) {
                logOut(handler, "getSDCardStatus " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getSDCardStatus " + error.getDescription());
            }
        });
    }

    public static void getMediaMode(final Handler handler, AutelBaseCamera r12) {
        r12.getMediaMode(new CallbackWithOneParam<MediaMode>() {
            @Override
            public void onSuccess(MediaMode data) {
                logOut(handler, "getMediaMode " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getMediaMode " + error.getDescription());
            }
        });
    }

    public static void getSdFreeSpace(final Handler handler, AutelBaseCamera r12) {
        r12.getSDCardFreeSpace(new CallbackWithOneParam<Long>() {
            @Override
            public void onSuccess(Long data) {
                logOut(handler, "getSDCardFreeSpace " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getSDCardFreeSpace " + error.getDescription());
            }
        });
    }

    public static void getVideoSum(final Handler handler, AutelR12 r12) {
        r12.getVideoSum(new CallbackWithOneParam<VideoSum>() {
            @Override
            public void onSuccess(VideoSum data) {
                logOut(handler, "getVideoSum " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getVideoSum " + error.getDescription());
            }
        });

    }

    public static void getPhotoSum(final Handler handler, AutelR12 r12) {
        r12.getPhotoSum(new CallbackWithOneParam<PhotoSum>() {
            @Override
            public void onSuccess(PhotoSum data) {
                logOut(handler, "getPhotoSum " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getPhotoSum " + error.getDescription());
            }
        });

    }

    public static void getCurrentRecordTimeSeconds(final Handler handler, AutelR12 r12) {
        r12.getCurrentRecordTimeSeconds(new CallbackWithOneParam<Integer>() {
            @Override
            public void onSuccess(Integer data) {
                logOut(handler, "getCurrentRecordTimeSeconds " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getCurrentRecordTimeSeconds " + error.getDescription());
            }
        });
    }

    public static void getVideoResolutionAndFps(final Handler handler, AutelR12 r12) {
        r12.getVideoResolutionAndFps(new CallbackWithOneParam<VideoResolutionAndFps>() {
            @Override
            public void onSuccess(VideoResolutionAndFps data) {
                logOut(handler, "getVideoResolutionAndFps " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getVideoResolutionAndFps " + error.getDescription());
            }
        });
    }

    public static void getNickName(final Handler handler, AutelBaseCamera r12) {
        r12.getNickName(new CallbackWithOneParam<String>() {
            @Override
            public void onSuccess(String data) {
                logOut(handler, "getNickName " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getNickName " + error.getDescription());
            }
        });
    }

    public static void getProduct(final Handler handler, AutelBaseCamera r12) {
        logOut(handler, "getProduct " + r12.getProduct());
    }

    public static void isSubtitleSwitchEnable(final Handler handler, AutelR12 r12) {
        r12.isSubtitleSwitchEnable(new CallbackWithOneParam<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                logOut(handler, "isSubtitleSwitchEnable " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "isSubtitleSwitchEnable " + error.getDescription());
            }
        });
    }

    public static void getTimeStamp(final Handler handler, AutelBaseCamera r12) {
        r12.getTimeStamp(new CallbackWithOneParam<Long>() {
            @Override
            public void onSuccess(Long data) {
                logOut(handler, "getTimeStamp " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getTimeStamp " + error.getDescription());
            }
        });
    }

    public static void getVideoFormat(final Handler handler, AutelR12 r12) {
        r12.getVideoFormat(new CallbackWithOneParam<VideoFormat>() {
            @Override
            public void onSuccess(VideoFormat data) {
                logOut(handler, "getVideoFormat " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getVideoFormat " + error.getDescription());
            }
        });
    }

    public static void getBurstNum(final Handler handler, AutelR12 r12) {
        r12.getBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
            @Override
            public void onSuccess(PhotoBurstCount data) {
                logOut(handler, "getBurstCount " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getBurstCount " + error.getDescription());
            }
        });
    }

    public static void getPhotoTimelapseInterval(final Handler handler, AutelR12 r12) {
        r12.getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
            @Override
            public void onSuccess(PhotoTimelapseInterval data) {
                logOut(handler, "getPhotoTimelapseInterval " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getPhotoTimelapseInterval " + error.getDescription());
            }
        });
    }

    public static void getVersion(final Handler handler, AutelBaseCamera r12) {
        r12.getVersion(new CallbackWithOneParam<String>() {
            @Override
            public void onSuccess(String data) {
                logOut(handler, "getVersion " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getVersion " + error.getDescription());
            }
        });
    }

    public static void isHistogramStatusEnable(final Handler handler, AutelR12 r12) {
        r12.isHistogramStatusEnable(new CallbackWithOneParam<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                logOut(handler, "isHistogramStatusEnable " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "isHistogramStatusEnable " + error.getDescription());
            }
        });
    }

    public static void getPhotoStyle(final Handler handler, AutelR12 r12) {
        r12.getPhotoStyle(new CallbackWithOneParam<PhotoStyle>() {
            @Override
            public void onSuccess(PhotoStyle data) {
                logOut(handler, "getPhotoStyle " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getPhotoStyle " + error.getDescription());
            }
        });
    }

    public static void getColorStyle(final Handler handler, AutelR12 r12) {
        r12.getColorStyle(new CallbackWithOneParam<CameraColorStyle>() {
            @Override
            public void onSuccess(CameraColorStyle data) {
                logOut(handler, "getColorStyle " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getColorStyle " + error.getDescription());
            }
        });
    }

    public static void setCameraBurstPhotoNum(PhotoBurstCount burstPhotoNum, final Handler handler, AutelR12 r12) {
        r12.setPhotoBurstCount(burstPhotoNum, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setPhotoBurstCount  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setPhotoBurstCount state onSuccess");
            }
        });
    }


    public static void getCameraBurstPhotoNum(final Handler handler, AutelR12 r12) {
        r12.getBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getCameraBurstPhotoNum  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(PhotoBurstCount data) {
                logOut(handler, "getCameraBurstPhotoNum " + data);
            }
        });

    }

    public static void getCameraTimelapseIntervalTime(final Handler handler, AutelR12 r12) {
        r12.getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getCameraTimelapseIntervalTime  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(PhotoTimelapseInterval data) {
                logOut(handler, "getCameraTimelapseIntervalTime " + data);
            }
        });
    }

    public static void setCameraTimelapseIntervalTime(PhotoTimelapseInterval timelapseIntervalTime, final Handler handler, AutelR12 r12) {
        r12.setPhotoTimelapseInterval(timelapseIntervalTime, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setPhotoTimelapseInterval  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setPhotoTimelapseInterval state onSuccess");
            }
        });
    }

    public static void getPhotoAEBParameter(final Handler handler, AutelR12 r12) {
        r12.getPhotoAEBCount(new CallbackWithOneParam<PhotoAEBCount>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getPhotoAEBCount  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(PhotoAEBCount data) {
                logOut(handler, "getPhotoAEBCount " + data);
            }
        });
    }

    public static void setCameraAebNum(PhotoAEBCount aebNum, final Handler handler, AutelR12 r12) {
        r12.setPhotoAEBCount(aebNum, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setPhotoAEBCount  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setPhotoAEBCount state onSuccess");
            }
        });
    }



    public static void setCameraModeListener(final Handler handler, AutelBaseCamera r12) {
        r12.setMediaModeListener(new CallbackWithOneParam<MediaMode>() {
            @Override
            public void onSuccess(MediaMode mode) {
                logOut(handler, "setMediaModeListener mode " + mode);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setMediaModeListener error " + error.getDescription());
            }
        });
    }

    public static void resetCameraModeListener(final Handler handler, AutelBaseCamera r12) {
        r12.setMediaModeListener(null);
    }

    public static void setCameraUploadGoalAreaListener(final Handler handler, AutelR12 r12) {
//        r12.setVisualTrackingListener(new CallbackWithOneParam<CameraGoalArea>() {
//
//
//            @Override
//            public void onSuccess(CameraGoalArea area) {
//                logOut(handler, "CameraGoalArea area X" + area.getStartX() + "  Y  " + area.getStartY() + "  W  " + area.getWidth() + "  H  " + area.getHeight());
//            }
//
//            @Override
//            public void onFailure(AutelError error) {
//                logOut(handler, "setMediaModeListener error " + error.getDescription());
//            }
//        });
    }

    public static void resetCameraUploadGoalAreaListener(final Handler handler, AutelR12 r12) {
//        r12.setVisualTrackingListener(null);
    }

    public static void setCameraMediaStateListener(final Handler handler, AutelBaseCamera r12) {
        r12.setMediaStateListener(new CallbackWithTwoParams<MediaStatus,String>() {
            @Override
            public void onSuccess(MediaStatus state, String data) {
                logOut(handler, "setMediaStateListener state " + state);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setMediaStateListener error " + error.getDescription());
            }
        });
    }

    public static void resetCameraMediaStateListener(final Handler handler, AutelBaseCamera r12) {
        r12.setMediaStateListener(null);
    }

    public static void setCameraAutoFocusStateListener(final Handler handler, AutelR12 r12) {
        r12.setAutoFocusStateListener(new CallbackWithTwoParams<CameraLensFocusStatus,List<CameraSpotMeteringArea>>() {
            @Override
            public void onSuccess(CameraLensFocusStatus state, List<CameraSpotMeteringArea> data) {
                logOut(handler, "setAutoFocusStateListener state " + state);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setAutoFocusStateListener error " + error.getDescription());
            }
        });
    }

    public static void resetCameraAutoFocusStateListener(final Handler handler, AutelR12 r12) {
        r12.setMediaStateListener(null);
    }

    public static void setCameraHistogramListener(final Handler handler, AutelR12 r12) {
        r12.setHistogramListener(new CallbackWithOneParam<int[]>() {
            @Override
            public void onSuccess(int[] result) {
                logOut(handler, "setHistogramListener state " + result);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setHistogramListener error " + error.getDescription());
            }
        });
    }

    public static void resetCameraHistogramListener(final Handler handler, AutelR12 r12) {
        r12.setHistogramListener(null);
    }

    private static void logOut(Handler handler, String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }
}
