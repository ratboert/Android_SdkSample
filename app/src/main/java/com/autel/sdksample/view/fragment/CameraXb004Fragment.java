package com.autel.sdksample.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.autel.common.camera.media.CameraAntiFlicker;
import com.autel.common.camera.media.CameraAspectRatio;
import com.autel.common.camera.media.CameraAutoExposureLockState;
import com.autel.common.camera.media.CameraColorStyle;
import com.autel.common.camera.media.CameraWhiteBalanceType;
import com.autel.common.camera.media.PhotoAEBCount;
import com.autel.common.camera.media.PhotoBurstCount;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.media.PhotoStyleType;
import com.autel.common.camera.media.PhotoTimelapseInterval;
import com.autel.common.camera.media.VideoFps;
import com.autel.common.camera.media.VideoResolution;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoStandard;
import com.autel.sdk.camera.AutelR12;
import com.autel.sdksample.CameraActivity;
import com.autel.sdksample.R;
import com.autel.sdksample.util.CameraTest;

/**
 * Created by A16343 on 2017/2/22.
 */

public class CameraXb004Fragment extends CameraBaseFragment {
    AutelR12 autelR12;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_camera_xb04, null);
        autelR12 = (AutelR12) ((CameraActivity) getActivity()).getCamera();
        initClick(view);
        initR12Click(view);
        return view;
    }


    public void setCameraAutoExposureStateLocked() {
        CameraTest.setCameraAutoExposureState(CameraAutoExposureLockState.LOCK, handler, autelR12);
    }

    public void setCameraAutoExposureStateUnlocked() {
        CameraTest.setCameraAutoExposureState(CameraAutoExposureLockState.UNLOCK, handler, autelR12);
    }

    public void setCameraAutoExposureStateDisable() {

        CameraTest.setCameraAutoExposureState(CameraAutoExposureLockState.DISABLE, handler, autelR12);
    }

    public void getCameraAutoExposureState() {

        CameraTest.getCameraAutoExposureState(handler, autelR12);
    }

    public void getPhotoExposureMode() {

        CameraTest.getPhotoExposureMode(handler, autelR12);
    }

    public void getSpotMeteringArea() {

        CameraTest.getSpotMeterLocation(handler, autelR12);
    }

    public void setCameraSpotMeter() {

        CameraTest.setCameraSpotMeter(handler, autelR12);
    }

    public void getExposureValue() {

        CameraTest.getExposure(handler, autelR12);
    }

    public void setExposureValue() {

        CameraTest.setExposureValue(handler, autelR12);
    }

    public void getCameraISO() {

        CameraTest.getISO(handler, autelR12);
    }

    public void setCameraISO() {

        CameraTest.setISO(handler, autelR12);
    }

    public void getCameraShutter() {

        CameraTest.getShutter(handler, autelR12);
    }

    public void setCameraShutter() {

        CameraTest.setShutter(handler, autelR12);
    }

    public void getCameraAspectRatio() {

        CameraTest.getAspectRatio(handler, autelR12);
    }

    public void setCameraAspectRatioAspect_3_2() {

        CameraTest.setAspectRatio(CameraAspectRatio.Aspect_3_2, handler, autelR12);
    }

    public void setCameraAspectRatioAspect_4_3() {

        CameraTest.setAspectRatio(CameraAspectRatio.Aspect_4_3, handler, autelR12);
    }

    public void setCameraAspectRatioAspect_16_9() {

        CameraTest.setAspectRatio(CameraAspectRatio.Aspect_16_9, handler, autelR12);
    }

    public void getCameraPhotoFormat() {

        CameraTest.getPhotoFormat(handler, autelR12);
    }

    public void setCameraPhotoFormatJPEG() {

        CameraTest.setPhotoFormat(PhotoFormat.JPEG, handler, autelR12);
    }

    public void setCameraPhotoFormatRAW() {

        CameraTest.setPhotoFormat(PhotoFormat.RAW, handler, autelR12);
    }

    public void setCameraPhotoFormatRawAndJPEG() {

        CameraTest.setPhotoFormat(PhotoFormat.RawAndJPEG, handler, autelR12);
    }

    public void getCameraWhiteBalance() {
        CameraTest.getWhiteBalance(handler, autelR12);
    }

    public void setCameraWhiteBalanceFluor() {
        CameraTest.setWhiteBalance(CameraWhiteBalanceType.FLUOROMETER, handler, autelR12);
    }

    public void setCameraWhiteBalanceIncan() {
        CameraTest.setWhiteBalance(CameraWhiteBalanceType.INCANDESCENT, handler, autelR12);
    }

    public void setCameraWhiteBalanceAuto() {
        CameraTest.setWhiteBalance(CameraWhiteBalanceType.AUTO, handler, autelR12);
    }

    public void setCameraWhiteBalanceSunny() {
        CameraTest.setWhiteBalance(CameraWhiteBalanceType.SUNNY, handler, autelR12);
    }

    public void setCameraWhiteBalanceCloudy() {
        CameraTest.setWhiteBalance(CameraWhiteBalanceType.CLOUDY, handler, autelR12);
    }

    public void setCameraWhiteBalanceCustom() {
        CameraTest.setWhiteBalance(CameraWhiteBalanceType.CUSTOM, handler, autelR12);
    }

    public void setCameraCustomWhiteBalance() {
        CameraTest.setCameraCustomWhiteBalance(handler, autelR12);
    }

    public void getCameraColor() {
        CameraTest.getColorStyle(handler, autelR12);
    }

    public void setCameraColorNone() {
        CameraTest.setCameraColor(CameraColorStyle.None, handler, autelR12);
    }

    public void setCameraColorVivid() {
        CameraTest.setCameraColor(CameraColorStyle.Vivid, handler, autelR12);
    }

    public void setCameraColorBlackAndWhite() {
        CameraTest.setCameraColor(CameraColorStyle.BlackAndWhite, handler, autelR12);
    }

    public void setCameraColorArt() {
        CameraTest.setCameraColor(CameraColorStyle.Art, handler, autelR12);
    }

    public void setCameraColorFilm() {
        CameraTest.setCameraColor(CameraColorStyle.Film, handler, autelR12);
    }

    public void setCameraColorBeach() {
        CameraTest.setCameraColor(CameraColorStyle.Beach, handler, autelR12);
    }

    public void setCameraColorDream() {
        CameraTest.setCameraColor(CameraColorStyle.Dream, handler, autelR12);
    }

    public void setCameraColorClassic() {
        CameraTest.setCameraColor(CameraColorStyle.Classic, handler, autelR12);
    }

    public void setCameraColorLog() {
        CameraTest.setCameraColor(CameraColorStyle.Log, handler, autelR12);
    }

    public void setCameraColorNostalgic() {
        CameraTest.setCameraColor(CameraColorStyle.Nostalgic, handler, autelR12);
    }

    public void setVideoResolutionAndFrameRate() {
        VideoResolutionAndFps resolutionAndFps = new VideoResolutionAndFps();
        resolutionAndFps.resolution = VideoResolution.Resolution_1280x720;
        resolutionAndFps.fps = VideoFps.FrameRate_48ps;
        CameraTest.setVideoResolutionAndFrameRate(resolutionAndFps, handler, autelR12);
    }

    public void setCameraVideoStandardNTSC() {
        CameraTest.setCameraVideoStandard(VideoStandard.NTSC, handler, autelR12);
    }

    public void setCameraVideoStandardPAL() {
        CameraTest.setCameraVideoStandard(VideoStandard.PAL, handler, autelR12);
    }

    public void setCameraVideoSubtitleEnable() {
        CameraTest.setCameraVideoSubtitleEnable(true, handler, autelR12);
    }

    public void setCameraVideoSubtitleDisable() {
        CameraTest.setCameraVideoSubtitleEnable(false, handler, autelR12);
    }

    public void isCamera3DDenoiseEnable() {
        CameraTest.is3DDenoiseEnable(handler, autelR12);
    }

    public void setCamera3DDenoiseEnable() {
        CameraTest.set3DDenoiseEnable(true, handler, autelR12);
    }

    public void setCamera3DDenoiseDisable() {
        CameraTest.set3DDenoiseEnable(false, handler, autelR12);
    }

    public void getCameraAntiFlicker() {
        CameraTest.getAntiFlicker(handler, autelR12);
    }

    public void setCameraAntiFlicker60HZ() {
        CameraTest.setAntiFlicker(CameraAntiFlicker.ANTI_FLICKER_60HZ, handler, autelR12);
    }

    public void setCameraAntiFlicker50HZ() {
        CameraTest.setAntiFlicker(CameraAntiFlicker.ANTI_FLICKER_50HZ, handler, autelR12);
    }

    public void setCameraAntiFlickerAUTO() {
        CameraTest.setAntiFlicker(CameraAntiFlicker.AUTO, handler, autelR12);
    }

    public void getCameraPhotoStyle() {
        CameraTest.getPhotoStyle(handler, autelR12);
    }

    public void setCameraPhotoStyleStandard() {
        CameraTest.setPhotoStyle(PhotoStyleType.Standard, handler, autelR12);
    }

    public void setCameraPhotoStyleSoft() {
        CameraTest.setPhotoStyle(PhotoStyleType.Soft, handler, autelR12);
    }

    public void setCameraPhotoStyleLandscape() {
        CameraTest.setPhotoStyle(PhotoStyleType.Landscape, handler, autelR12);
    }

    public void setCameraPhotoStyleCustom() {
        CameraTest.setPhotoStyle(PhotoStyleType.Custom, handler, autelR12);
    }

    public void setCameraCustomPhotoStyle() {
        CameraTest.setCameraCustomPhotoStyle(handler, autelR12);
    }

    public void setCameraBurstPhotoNum3() {
        CameraTest.setCameraBurstPhotoNum(PhotoBurstCount.BURST_3, handler, autelR12);
    }

    public void setCameraBurstPhotoNum5() {
        CameraTest.setCameraBurstPhotoNum(PhotoBurstCount.BURST_5, handler, autelR12);
    }

    public void setCameraBurstPhotoNum7() {
        CameraTest.setCameraBurstPhotoNum(PhotoBurstCount.BURST_7, handler, autelR12);
    }

    public void getCameraBurstPhotoNum() {
        CameraTest.getCameraBurstPhotoNum(handler, autelR12);
    }

    public void getCameraTimelapseIntervalTime() {
        CameraTest.getCameraTimelapseIntervalTime(handler, autelR12);
    }

    public void setCameraTimelapseIntervalTime5() {
        CameraTest.setCameraTimelapseIntervalTime(PhotoTimelapseInterval.SECOND_5, handler, autelR12);
    }

    public void setCameraTimelapseIntervalTime7() {
        CameraTest.setCameraTimelapseIntervalTime(PhotoTimelapseInterval.SECOND_7, handler, autelR12);
    }

    public void setCameraTimelapseIntervalTime10() {
        CameraTest.setCameraTimelapseIntervalTime(PhotoTimelapseInterval.SECOND_10, handler, autelR12);
    }

    public void setCameraTimelapseIntervalTime20() {
        CameraTest.setCameraTimelapseIntervalTime(PhotoTimelapseInterval.SECOND_20, handler, autelR12);
    }

    public void setCameraTimelapseIntervalTime30() {
        CameraTest.setCameraTimelapseIntervalTime(PhotoTimelapseInterval.SECOND_30, handler, autelR12);
    }

    public void getCameraAebNum() {
        CameraTest.getPhotoAEBParameter(handler, autelR12);
    }

    public void setCameraAebNum3() {
        CameraTest.setCameraAebNum(PhotoAEBCount.CAPTURE_3, handler, autelR12);
    }

    public void setCameraAebNum5() {
        CameraTest.setCameraAebNum(PhotoAEBCount.CAPTURE_5, handler, autelR12);
    }

    public void setCameraUploadGoalAreaListener() {
        CameraTest.setCameraUploadGoalAreaListener(handler, autelR12);
    }

    public void resetCameraUploadGoalAreaListener() {
        CameraTest.resetCameraUploadGoalAreaListener(handler, autelR12);
    }

    public void setCameraAutoFocusStateListener() {
        CameraTest.setCameraAutoFocusStateListener(handler, autelR12);
    }

    public void resetCameraAutoFocusStateListener() {
        CameraTest.resetCameraAutoFocusStateListener(handler, autelR12);
    }

    public void setCameraHistogramListener() {
        CameraTest.setCameraHistogramListener(handler, autelR12);
    }

    public void resetCameraHistogramListener() {
        CameraTest.resetCameraHistogramListener(handler, autelR12);
    }

    public void getCameraCurrentVideoRecordTime() {
        CameraTest.getCameraCurrentVideoRecordTime(handler, autelR12);
    }

    public void getVideoSum() {
        CameraTest.getVideoSum(handler, autelR12);
    }

    public void getPhotoSum() {
        CameraTest.getPhotoSum(handler, autelR12);
    }

    public void getVideoResolutionAndFps() {
        CameraTest.getVideoResolutionAndFps(handler, autelR12);
    }

    public void isSubtitleSwitchEnable() {

        CameraTest.isSubtitleSwitchEnable(handler, autelR12);
    }

    public void getVideoFormat() {

        CameraTest.getVideoFormat(handler, autelR12);
    }


    public void getVideoStandard() {

        CameraTest.getVideoStandard(handler, autelR12);
    }

    public void isHistogramStatusEnable() {

        CameraTest.isHistogramStatusEnable(handler, autelR12);
    }


    public void getColorStyle() {

        CameraTest.getColorStyle(handler, autelR12);
    }

    private void initR12Click(View view) {
        view.findViewById(R.id.setCameraAutoExposureStateLocked).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraAutoExposureStateLocked();
            }
        });
        view.findViewById(R.id.setCameraAutoExposureStateUnlocked).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraAutoExposureStateUnlocked();
            }
        });
        view.findViewById(R.id.setCameraAutoExposureStateDisable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraAutoExposureStateDisable();
            }
        });
        view.findViewById(R.id.getCameraAutoExposureState).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraAutoExposureState();
            }
        });
        view.findViewById(R.id.getPhotoExposureMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPhotoExposureMode();
            }
        });
        view.findViewById(R.id.getSpotMeteringArea).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSpotMeteringArea();
            }
        });
        view.findViewById(R.id.setCameraSpotMeter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraSpotMeter();
            }
        });
        view.findViewById(R.id.getExposureValue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getExposureValue();
            }
        });
        view.findViewById(R.id.setExposureValue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExposureValue();
            }
        });
        view.findViewById(R.id.getCameraISO).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraISO();
            }
        });
        view.findViewById(R.id.setCameraISO).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraISO();
            }
        });
        view.findViewById(R.id.getCameraShutter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraShutter();
            }
        });
        view.findViewById(R.id.setCameraShutter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraShutter();
            }
        });
        view.findViewById(R.id.getCameraAspectRatio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraAspectRatio();
            }
        });
        view.findViewById(R.id.setCameraAspectRatioAspect_3_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraAspectRatioAspect_3_2();
            }
        });
        view.findViewById(R.id.setCameraAspectRatioAspect_4_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraAspectRatioAspect_4_3();
            }
        });
        view.findViewById(R.id.setCameraAspectRatioAspect_16_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraAspectRatioAspect_16_9();
            }
        });
        view.findViewById(R.id.getCameraPhotoFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraPhotoFormat();
            }
        });
        view.findViewById(R.id.setCameraPhotoFormatJPEG).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraPhotoFormatJPEG();
            }
        });
        view.findViewById(R.id.setCameraPhotoFormatRAW).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraPhotoFormatRAW();
            }
        });
        view.findViewById(R.id.setCameraPhotoFormatRawAndJPEG).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraPhotoFormatRawAndJPEG();
            }
        });
        view.findViewById(R.id.getCameraWhiteBalance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraWhiteBalance();
            }
        });
        view.findViewById(R.id.getColorStyle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getColorStyle();
            }
        });
        view.findViewById(R.id.isHistogramStatusEnable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHistogramStatusEnable();
            }
        });
        view.findViewById(R.id.getVideoStandard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVideoStandard();
            }
        });
        view.findViewById(R.id.getVideoFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVideoFormat();
            }
        });
        view.findViewById(R.id.isSubtitleSwitchEnable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSubtitleSwitchEnable();
            }
        });
        view.findViewById(R.id.getVideoResolutionAndFps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVideoResolutionAndFps();
            }
        });
        view.findViewById(R.id.getPhotoSum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPhotoSum();
            }
        });
        view.findViewById(R.id.getVideoSum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVideoSum();
            }
        });
        view.findViewById(R.id.getCameraCurrentVideoRecordTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraCurrentVideoRecordTime();
            }
        });
        view.findViewById(R.id.resetCameraHistogramListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCameraHistogramListener();
            }
        });
        view.findViewById(R.id.setCameraHistogramListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraHistogramListener();
            }
        });
        view.findViewById(R.id.resetCameraAutoFocusStateListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCameraAutoFocusStateListener();
            }
        });
        view.findViewById(R.id.setCameraAutoFocusStateListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraAutoFocusStateListener();
            }
        });
        view.findViewById(R.id.resetCameraUploadGoalAreaListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCameraUploadGoalAreaListener();
            }
        });
        view.findViewById(R.id.setCameraUploadGoalAreaListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraUploadGoalAreaListener();
            }
        });
        view.findViewById(R.id.setCameraAebNum5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraAebNum5();
            }
        });
        view.findViewById(R.id.setCameraAebNum3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraAebNum3();
            }
        });
        view.findViewById(R.id.getCameraAebNum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraAebNum();
            }
        });
        view.findViewById(R.id.setCameraTimelapseIntervalTime30).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraTimelapseIntervalTime30();
            }
        });
        view.findViewById(R.id.setCameraTimelapseIntervalTime20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraTimelapseIntervalTime20();
            }
        });
        view.findViewById(R.id.setCameraTimelapseIntervalTime10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraTimelapseIntervalTime10();
            }
        });
        view.findViewById(R.id.setCameraTimelapseIntervalTime5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraTimelapseIntervalTime5();
            }
        });
        view.findViewById(R.id.getCameraTimelapseIntervalTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraTimelapseIntervalTime();
            }
        });
        view.findViewById(R.id.getCameraBurstPhotoNum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraBurstPhotoNum();
            }
        });
        view.findViewById(R.id.setCameraBurstPhotoNum7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraBurstPhotoNum7();
            }
        });
        view.findViewById(R.id.setCameraBurstPhotoNum5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraBurstPhotoNum5();
            }
        });
        view.findViewById(R.id.setCameraBurstPhotoNum3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraBurstPhotoNum3();
            }
        });
        view.findViewById(R.id.setCameraCustomPhotoStyle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraCustomPhotoStyle();
            }
        });
        view.findViewById(R.id.setCameraPhotoStyleCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraPhotoStyleCustom();
            }
        });
        view.findViewById(R.id.setCameraPhotoStyleLandscape).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraPhotoStyleLandscape();
            }
        });
        view.findViewById(R.id.setCameraPhotoStyleSoft).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraPhotoStyleSoft();
            }
        });
        view.findViewById(R.id.setCameraPhotoStyleStandard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraPhotoStyleStandard();
            }
        });
        view.findViewById(R.id.getCameraPhotoStyle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraPhotoStyle();
            }
        });
        view.findViewById(R.id.setCameraAntiFlickerAUTO).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraAntiFlickerAUTO();
            }
        });
        view.findViewById(R.id.setCameraAntiFlicker50HZ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraAntiFlicker50HZ();
            }
        });
        view.findViewById(R.id.setCameraAntiFlicker60HZ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraAntiFlicker60HZ();
            }
        });
        view.findViewById(R.id.setCamera3DDenoiseDisable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCamera3DDenoiseDisable();
            }
        });
        view.findViewById(R.id.setCamera3DDenoiseEnable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCamera3DDenoiseEnable();
            }
        });
        view.findViewById(R.id.isCamera3DDenoiseEnable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCamera3DDenoiseEnable();
            }
        });
        view.findViewById(R.id.setCameraVideoSubtitleDisable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraVideoSubtitleDisable();
            }
        });
        view.findViewById(R.id.setCameraVideoSubtitleEnable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraVideoSubtitleEnable();
            }
        });
        view.findViewById(R.id.setCameraVideoStandardPAL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraVideoStandardPAL();
            }
        });
        view.findViewById(R.id.setCameraVideoStandardNTSC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraVideoStandardNTSC();
            }
        });
        view.findViewById(R.id.setVideoResolutionAndFrameRate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setVideoResolutionAndFrameRate();
            }
        });
        view.findViewById(R.id.setCameraColorNostalgic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraColorNostalgic();
            }
        });
        view.findViewById(R.id.setCameraColorLog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraColorLog();
            }
        });
        view.findViewById(R.id.setCameraColorClassic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraColorClassic();
            }
        });
        view.findViewById(R.id.setCameraColorDream).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraColorDream();
            }
        });
        view.findViewById(R.id.setCameraColorBeach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraColorBeach();
            }
        });
        view.findViewById(R.id.setCameraColorFilm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraColorFilm();
            }
        });
        view.findViewById(R.id.setCameraColorArt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraColorArt();
            }
        });
        view.findViewById(R.id.setCameraColorBlackAndWhite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraColorBlackAndWhite();
            }
        });
        view.findViewById(R.id.setCameraColorVivid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraColorVivid();
            }
        });
        view.findViewById(R.id.setCameraColorNone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraColorNone();
            }
        });
        view.findViewById(R.id.getCameraColor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraColor();
            }
        });
        view.findViewById(R.id.setCameraCustomWhiteBalance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraCustomWhiteBalance();
            }
        });
        view.findViewById(R.id.setCameraWhiteBalanceCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraWhiteBalanceCustom();
            }
        });
        view.findViewById(R.id.setCameraWhiteBalanceCloudy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraWhiteBalanceCloudy();
            }
        });
        view.findViewById(R.id.setCameraWhiteBalanceSunny).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraWhiteBalanceSunny();
            }
        });
        view.findViewById(R.id.setCameraWhiteBalanceAuto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraWhiteBalanceAuto();
            }
        });
        view.findViewById(R.id.setCameraWhiteBalanceIncan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraWhiteBalanceIncan();
            }
        });
        view.findViewById(R.id.setCameraWhiteBalanceFluor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraWhiteBalanceFluor();
            }
        });
        view.findViewById(R.id.getCameraWhiteBalance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCameraWhiteBalance();
            }
        });
    }

}
