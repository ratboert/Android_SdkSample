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

    public static void setCameraSDCardStateListener(AutelBaseCamera r12) {
        r12.setSDCardStateListener(new CallbackWithOneParam<SDCardState>() {
            @Override
            public void onSuccess(SDCardState state) {
                logOut("setSDCardStateListener  state  " + state);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("setSDCardStateListener  description  " + error.getDescription());
            }
        });

    }

    public static void resetCameraSDCardStateListener(AutelBaseCamera r12) {
        r12.setSDCardStateListener(null);
    }

    public static void setCameraAutoExposureState(final CameraAutoExposureLockState lockState, AutelR12 r12) {
        r12.setAutoExposureLockState(lockState, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setAutoExposureLockState  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setAutoExposureLockState  lockState  " + lockState + " onSuccess ");
            }
        });
    }

    public static void getCameraAutoExposureState(AutelR12 r12) {
        r12.getAutoExposureLockState(new CallbackWithOneParam<CameraAutoExposureLockState>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getAutoExposureLockState  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraAutoExposureLockState data) {
                logOut("getAutoExposureLockState  " + data);
            }
        });
    }

    public static void getPhotoExposureMode(AutelR12 r12) {
        r12.getExposureMode(new CallbackWithOneParam<CameraExposureMode>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getExposureMode  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraExposureMode data) {
                logOut("getExposureMode  " + data);
            }
        });
    }



    public static void setCameraSpotMeter(AutelR12 r12) {
        r12.setSpotMeteringArea(2, 3, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setSpotMeteringArea  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setSpotMeteringArea  " + "  state  onSuccess" );
            }
        });
    }

    public static void getSpotMeterLocation(AutelR12 r12) {
        r12.getSpotMeteringArea(new CallbackWithOneParam<CameraSpotMeteringArea>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getSpotMeteringArea  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraSpotMeteringArea data) {
                logOut("getSpotMeteringArea X " + data.X + "  Y " + data.Y);
            }
        });
    }

    public static void setCameraMode(MediaMode mode, AutelBaseCamera r12) {
        r12.setMediaMode(mode, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setMediaMode  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setMediaMode state onSuccess");
            }
        });

    }

    public static void getExposure(AutelR12 r12) {
        r12.getExposure(new CallbackWithOneParam<CameraExposureCompensation>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getExposure  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraExposureCompensation data) {
                logOut("getExposure " + data);
            }
        });
    }

    public static void setExposureValue(AutelR12 r12) {
        r12.setExposure(CameraExposureCompensation.NEGATIVE_0p3, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setExposure  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setExposure state onSuccess");
            }
        });
    }

    public static void getISO(AutelR12 r12) {
        r12.getISO(new CallbackWithOneParam<CameraISO>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getISO  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraISO data) {
                logOut("getISO " + data);
            }
        });
    }

    public static void setISO(AutelR12 r12) {
        r12.setISO(CameraISO.ISO_200, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setISO  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setISO state onSuccess");
            }
        });
    }

    public static void getShutter(AutelR12 r12) {
        r12.getShutter(new CallbackWithOneParam<CameraShutterSpeed>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getShutter  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraShutterSpeed data) {
                logOut("getShutter " + data);
            }
        });
    }

    public static void setShutter(AutelR12 r12) {
        r12.setShutter(CameraShutterSpeed.ShutterSpeed_1_1dot25, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setShutter  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setShutter state onSuccess");
            }
        });

    }

    public static void getAspectRatio(AutelR12 r12) {
        r12.getAspectRatio(new CallbackWithOneParam<CameraAspectRatio>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getAspectRatio  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraAspectRatio data) {
                logOut("getAspectRatio " + data);
            }
        });
    }

    public static void setAspectRatio(CameraAspectRatio ratio, AutelR12 r12) {
        r12.setAspectRatio(ratio, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setAspectRatio  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setAspectRatio state onSuccess");
            }
        });
    }

    public static void setPhotoFormat(PhotoFormat format, AutelR12 r12) {
        r12.setPhotoFormat(format, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setPhotoFormat  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setPhotoFormat state onSuccess");
            }
        });
    }

    public static void getPhotoFormat(AutelR12 r12) {
        r12.getPhotoFormat(new CallbackWithOneParam<PhotoFormat>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getPhotoFormat  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(PhotoFormat data) {
                logOut("getPhotoFormat " + data);
            }
        });
    }

    public static void getWhiteBalance(AutelR12 r12) {
        r12.getWhiteBalance(new CallbackWithOneParam<CameraWhiteBalance>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getWhiteBalance  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraWhiteBalance data) {
                logOut("getWhiteBalance " + data.type + "  colorTemperature  " + data.colorTemperature);
            }
        });
    }

    public static void setWhiteBalance(CameraWhiteBalanceType whiteBalance, AutelR12 r12) {
        CameraWhiteBalance whiteBalance1 = new CameraWhiteBalance();
        whiteBalance1.type = whiteBalance;
        r12.setWhiteBalance(whiteBalance1, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setWhiteBalance  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setWhiteBalance state onSuccess");
            }
        });
    }

    public static void setCameraCustomWhiteBalance(AutelR12 r12) {
        CameraWhiteBalance whiteBalance1 = new CameraWhiteBalance();
        whiteBalance1.type = CameraWhiteBalanceType.CUSTOM;
        whiteBalance1.colorTemperature = 2100;
        r12.setWhiteBalance(whiteBalance1, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setWhiteBalance  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setWhiteBalance state onSuccess");
            }
        });
    }

    public static void setCameraColor(CameraColorStyle cameraColor, AutelR12 r12) {
        r12.setColorStyle(cameraColor, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setColorStyle  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setColorStyle state onSuccess");
            }
        });
    }

    public static void getVideoResolution(AutelR12 r12) {
        r12.getVideoResolutionAndFps(new CallbackWithOneParam<VideoResolutionAndFps>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getVideoResolutionAndFps  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(VideoResolutionAndFps data) {
                logOut("getVideoResolutionAndFps " + data);
            }
        });
    }

    public static void setVideoResolutionAndFrameRate(VideoResolutionAndFps videoResolution, AutelR12 r12) {
        r12.setVideoResolutionAndFrameRate(videoResolution, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setVideoResolutionAndFrameRate  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setVideoResolutionAndFrameRate state onSuccess");
            }
        });
    }

    public static void getVideoStandard(AutelR12 r12) {
        r12.getVideoStandard(new CallbackWithOneParam<VideoStandard>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getVideoStandard  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(VideoStandard data) {
                logOut("getVideoStandard " + data);
            }
        });

    }

    public static void setCameraVideoStandard(VideoStandard videoStandard, AutelR12 r12) {
        r12.setVideoStandard(videoStandard, new CallbackWithNoParam() {

            @Override
            public void onFailure(AutelError error) {
                logOut("setVideoStandard  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setVideoStandard state onSuccess");
            }
        });
    }

    public static void setCameraVideoSubtitleEnable(boolean enable, AutelR12 r12) {
        r12.setVideoSubtitleEnable(enable, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setVideoSubtitleEnable  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setVideoSubtitleEnable state onSuccess");
            }
        });
    }

    public static void is3DDenoiseEnable(AutelR12 r12) {
        r12.is3DDenoiseEnable(new CallbackWithOneParam<Boolean>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("is3DDenoiseEnable  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(Boolean data) {
                logOut("is3DDenoiseEnable " + data);
            }
        });
    }

    public static void set3DDenoiseEnable(boolean enable, AutelR12 r12) {
        r12.set3DNoiseReductionEnable(enable, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("set3DNoiseReductionEnable  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("set3DNoiseReductionEnable state onSuccess");
            }
        });

    }

    public static void getAntiFlicker(AutelR12 r12) {
        r12.getAntiFlicker(new CallbackWithOneParam<CameraAntiFlicker>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getAntiFlicker  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(CameraAntiFlicker data) {
                logOut("getAntiFlicker " + data);
            }
        });
    }

    public static void setAntiFlicker(CameraAntiFlicker flicker, AutelR12 r12) {
        r12.setAntiFlicker(flicker, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setAntiFlicker  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setAntiFlicker state onSuccess");
            }
        });
    }

    public static void setPhotoStyle(PhotoStyleType styleType, AutelR12 r12) {
        r12.setPhotoStyle(styleType, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setPhotoStyle  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setPhotoStyle state onSuccess");
            }
        });
    }

    public static void setCameraCustomPhotoStyle(AutelR12 r12) {
        r12.setPhotoStyle(1, 2, 3, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setPhotoStyle  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setPhotoStyle state onSuccess");
            }
        });
    }


    public static void startTakePhoto(AutelBaseCamera r12) {
        r12.startTakePhoto(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("startTakePhoto " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("startTakePhoto onSuccess");
            }
        });
    }


    public static void stopTakePhoto(AutelBaseCamera r12) {
        r12.stopTakePhoto(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("stopTakePhoto " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("stopTakePhoto onSuccess");
            }
        });
    }


    public static void startRecordVideo(AutelBaseCamera r12) {
        r12.startRecordVideo(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("startRecordVideo " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("startRecordVideo onSuccess");
            }
        });
    }

    public static void stopRecordVideo(AutelBaseCamera r12) {
        r12.stopRecordVideo(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("stopRecordVideo " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("stopRecordVideo onSuccess");
            }
        });
    }

    public static void formatSDCard(AutelBaseCamera r12) {
        r12.formatSDCard(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("formatSDCard " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("formatSDCard onSuccess");
            }
        });
    }

    public static void resetCamera(AutelBaseCamera r12) {
        r12.resetDefaults(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("resetDefaults " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("resetDefaults onSuccess");
            }
        });
    }



    public static void getCameraCurrentVideoRecordTime(AutelR12 r12) {
        r12.getCurrentRecordTimeSeconds(new CallbackWithOneParam<Integer>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getCurrentRecordTimeSeconds " + error.getDescription());
            }

            @Override
            public void onSuccess(Integer data) {
                logOut("getCurrentRecordTimeSeconds " + data);
            }
        });
    }





    public static void setCameraConnectStateListener(AutelBaseCamera r12) {
        r12.setConnectStateListener(new CallbackWithOneParam<Boolean>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setConnectStateListener camera error " + error.getDescription());
            }

            @Override
            public void onSuccess(Boolean data) {
                logOut(data ? "camera connected" : "camera disconnect");
            }
        });
    }

    public static void resetCameraConnectStateListener(AutelBaseCamera r12) {
        r12.setConnectStateListener(null);
    }


    public static void getWorkStatus(AutelBaseCamera r12) {
        r12.getWorkStatus(new CallbackWithOneParam<CameraWorkState>() {
            @Override
            public void onSuccess(CameraWorkState data) {
                logOut("getWorkStatus " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getWorkStatus " + error.getDescription());
            }
        });
    }

    public static void getSDCardStatus(AutelBaseCamera r12) {
        r12.getSDCardStatus(new CallbackWithOneParam<SDCardState>() {
            @Override
            public void onSuccess(SDCardState data) {
                logOut("getSDCardStatus " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getSDCardStatus " + error.getDescription());
            }
        });
    }

    public static void getMediaMode(AutelBaseCamera r12) {
        r12.getMediaMode(new CallbackWithOneParam<MediaMode>() {
            @Override
            public void onSuccess(MediaMode data) {
                logOut("getMediaMode " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getMediaMode " + error.getDescription());
            }
        });
    }

    public static void getSdFreeSpace(AutelBaseCamera r12) {
        r12.getSDCardFreeSpace(new CallbackWithOneParam<Long>() {
            @Override
            public void onSuccess(Long data) {
                logOut("getSDCardFreeSpace " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getSDCardFreeSpace " + error.getDescription());
            }
        });
    }

    public static void getVideoSum(AutelR12 r12) {
        r12.getVideoSum(new CallbackWithOneParam<VideoSum>() {
            @Override
            public void onSuccess(VideoSum data) {
                logOut("getVideoSum " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getVideoSum " + error.getDescription());
            }
        });

    }

    public static void getPhotoSum(AutelR12 r12) {
        r12.getPhotoSum(new CallbackWithOneParam<PhotoSum>() {
            @Override
            public void onSuccess(PhotoSum data) {
                logOut("getPhotoSum " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getPhotoSum " + error.getDescription());
            }
        });

    }

    public static void getCurrentRecordTimeSeconds(AutelR12 r12) {
        r12.getCurrentRecordTimeSeconds(new CallbackWithOneParam<Integer>() {
            @Override
            public void onSuccess(Integer data) {
                logOut("getCurrentRecordTimeSeconds " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getCurrentRecordTimeSeconds " + error.getDescription());
            }
        });
    }

    public static void getVideoResolutionAndFps(AutelR12 r12) {
        r12.getVideoResolutionAndFps(new CallbackWithOneParam<VideoResolutionAndFps>() {
            @Override
            public void onSuccess(VideoResolutionAndFps data) {
                logOut("getVideoResolutionAndFps " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getVideoResolutionAndFps " + error.getDescription());
            }
        });
    }

    public static void getNickName(AutelBaseCamera r12) {
        r12.getNickName(new CallbackWithOneParam<String>() {
            @Override
            public void onSuccess(String data) {
                logOut("getNickName " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getNickName " + error.getDescription());
            }
        });
    }

    public static void getProduct(AutelBaseCamera r12) {
        logOut("getProduct " + r12.getProduct());
    }

    public static void isSubtitleSwitchEnable(AutelR12 r12) {
        r12.isSubtitleSwitchEnable(new CallbackWithOneParam<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                logOut("isSubtitleSwitchEnable " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("isSubtitleSwitchEnable " + error.getDescription());
            }
        });
    }

    public static void getTimeStamp(AutelBaseCamera r12) {
        r12.getTimeStamp(new CallbackWithOneParam<Long>() {
            @Override
            public void onSuccess(Long data) {
                logOut("getTimeStamp " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getTimeStamp " + error.getDescription());
            }
        });
    }

    public static void getVideoFormat(AutelR12 r12) {
        r12.getVideoFormat(new CallbackWithOneParam<VideoFormat>() {
            @Override
            public void onSuccess(VideoFormat data) {
                logOut("getVideoFormat " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getVideoFormat " + error.getDescription());
            }
        });
    }

    public static void getBurstNum(AutelR12 r12) {
        r12.getBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
            @Override
            public void onSuccess(PhotoBurstCount data) {
                logOut("getBurstCount " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getBurstCount " + error.getDescription());
            }
        });
    }

    public static void getPhotoTimelapseInterval(AutelR12 r12) {
        r12.getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
            @Override
            public void onSuccess(PhotoTimelapseInterval data) {
                logOut("getPhotoTimelapseInterval " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getPhotoTimelapseInterval " + error.getDescription());
            }
        });
    }

    public static void getVersion(AutelBaseCamera r12) {
        r12.getVersion(new CallbackWithOneParam<String>() {
            @Override
            public void onSuccess(String data) {
                logOut("getVersion " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getVersion " + error.getDescription());
            }
        });
    }

    public static void isHistogramStatusEnable(AutelR12 r12) {
        r12.isHistogramStatusEnable(new CallbackWithOneParam<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                logOut("isHistogramStatusEnable " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("isHistogramStatusEnable " + error.getDescription());
            }
        });
    }

    public static void getPhotoStyle(AutelR12 r12) {
        r12.getPhotoStyle(new CallbackWithOneParam<PhotoStyle>() {
            @Override
            public void onSuccess(PhotoStyle data) {
                logOut("getPhotoStyle " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getPhotoStyle " + error.getDescription());
            }
        });
    }

    public static void getColorStyle(AutelR12 r12) {
        r12.getColorStyle(new CallbackWithOneParam<CameraColorStyle>() {
            @Override
            public void onSuccess(CameraColorStyle data) {
                logOut("getColorStyle " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getColorStyle " + error.getDescription());
            }
        });
    }

    public static void setCameraBurstPhotoNum(PhotoBurstCount burstPhotoNum, AutelR12 r12) {
        r12.setPhotoBurstCount(burstPhotoNum, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setPhotoBurstCount  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setPhotoBurstCount state onSuccess");
            }
        });
    }


    public static void getCameraBurstPhotoNum(AutelR12 r12) {
        r12.getBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getCameraBurstPhotoNum  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(PhotoBurstCount data) {
                logOut("getCameraBurstPhotoNum " + data);
            }
        });

    }

    public static void getCameraTimelapseIntervalTime(AutelR12 r12) {
        r12.getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getCameraTimelapseIntervalTime  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(PhotoTimelapseInterval data) {
                logOut("getCameraTimelapseIntervalTime " + data);
            }
        });
    }

    public static void setCameraTimelapseIntervalTime(PhotoTimelapseInterval timelapseIntervalTime, AutelR12 r12) {
        r12.setPhotoTimelapseInterval(timelapseIntervalTime, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setPhotoTimelapseInterval  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setPhotoTimelapseInterval state onSuccess");
            }
        });
    }

    public static void getPhotoAEBParameter(AutelR12 r12) {
        r12.getPhotoAEBCount(new CallbackWithOneParam<PhotoAEBCount>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getPhotoAEBCount  description  " + error.getDescription());
            }

            @Override
            public void onSuccess(PhotoAEBCount data) {
                logOut("getPhotoAEBCount " + data);
            }
        });
    }

    public static void setCameraAebNum(PhotoAEBCount aebNum, AutelR12 r12) {
        r12.setPhotoAEBCount(aebNum, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setPhotoAEBCount  description  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setPhotoAEBCount state onSuccess");
            }
        });
    }



    public static void setCameraModeListener(AutelBaseCamera r12) {
        r12.setMediaModeListener(new CallbackWithOneParam<MediaMode>() {
            @Override
            public void onSuccess(MediaMode mode) {
                logOut("setMediaModeListener mode " + mode);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("setMediaModeListener error " + error.getDescription());
            }
        });
    }

    public static void resetCameraModeListener(AutelBaseCamera r12) {
        r12.setMediaModeListener(null);
    }

    public static void setCameraUploadGoalAreaListener(AutelR12 r12) {
//        r12.setVisualTrackingListener(new CallbackWithOneParam<CameraGoalArea>() {
//
//
//            @Override
//            public void onSuccess(CameraGoalArea area) {
//                logOut("CameraGoalArea area X" + area.getStartX() + "  Y  " + area.getStartY() + "  W  " + area.getWidth() + "  H  " + area.getHeight());
//            }
//
//            @Override
//            public void onFailure(AutelError error) {
//                logOut("setMediaModeListener error " + error.getDescription());
//            }
//        });
    }

    public static void resetCameraUploadGoalAreaListener(AutelR12 r12) {
//        r12.setVisualTrackingListener(null);
    }

    public static void setCameraMediaStateListener(AutelBaseCamera r12) {
        r12.setMediaStateListener(new CallbackWithTwoParams<MediaStatus,String>() {
            @Override
            public void onSuccess(MediaStatus state, String data) {
                logOut("setMediaStateListener state " + state);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("setMediaStateListener error " + error.getDescription());
            }
        });
    }

    public static void resetCameraMediaStateListener(AutelBaseCamera r12) {
        r12.setMediaStateListener(null);
    }

    public static void setCameraAutoFocusStateListener(AutelR12 r12) {
        r12.setAutoFocusStateListener(new CallbackWithTwoParams<CameraLensFocusStatus,List<CameraSpotMeteringArea>>() {
            @Override
            public void onSuccess(CameraLensFocusStatus state, List<CameraSpotMeteringArea> data) {
                logOut("setAutoFocusStateListener state " + state);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("setAutoFocusStateListener error " + error.getDescription());
            }
        });
    }

    public static void resetCameraAutoFocusStateListener(AutelR12 r12) {
        r12.setMediaStateListener(null);
    }

    public static void setCameraHistogramListener(AutelR12 r12) {
        r12.setHistogramListener(new CallbackWithOneParam<int[]>() {
            @Override
            public void onSuccess(int[] result) {
                logOut("setHistogramListener state " + result);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("setHistogramListener error " + error.getDescription());
            }
        });
    }

    public static void resetCameraHistogramListener(AutelR12 r12) {
        r12.setHistogramListener(null);
    }

    private static void logOut(String log) {
        Log.v(TAG, log);
//        Message msg = handler.obtainMessage();
//        msg.obj = log;
//        handler.sendMessage(msg);
    }
}
