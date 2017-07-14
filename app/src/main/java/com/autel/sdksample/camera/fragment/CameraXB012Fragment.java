package com.autel.sdksample.camera.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.camera.CameraProduct;
import com.autel.common.camera.base.MediaMode;
import com.autel.common.camera.base.PhotoFormat;
import com.autel.common.camera.media.CameraAntiFlicker;
import com.autel.common.camera.media.CameraAspectRatio;
import com.autel.common.camera.media.CameraAutoExposureLockState;
import com.autel.common.camera.media.CameraColorStyle;
import com.autel.common.camera.media.CameraExposureCompensation;
import com.autel.common.camera.media.CameraExposureMode;
import com.autel.common.camera.media.CameraISO;
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
import com.autel.common.camera.media.VideoEncodeFormat;
import com.autel.common.camera.media.VideoFormat;
import com.autel.common.camera.media.VideoResolutionAndFps;
import com.autel.common.camera.media.VideoSnapshotTimelapseInterval;
import com.autel.common.camera.media.VideoStandard;
import com.autel.common.camera.media.VideoSum;
import com.autel.common.camera.xb012.PIVMode;
import com.autel.common.camera.xb012.RealTimeVideoResolution;
import com.autel.common.camera.xb012.XB012ParameterRangeManager;
import com.autel.common.error.AutelError;
import com.autel.sdk.camera.AutelXB012;
import com.autel.sdksample.R;
import com.autel.sdksample.camera.CameraActivity;
import com.autel.sdksample.camera.fragment.adapter.AntiFlickerAdapter;
import com.autel.sdksample.camera.fragment.adapter.AspectRatioAdapter;
import com.autel.sdksample.camera.fragment.adapter.AutoExposureLockStateAdapter;
import com.autel.sdksample.camera.fragment.adapter.ColorStyleAdapter;
import com.autel.sdksample.camera.fragment.adapter.ExposureModeAdapter;
import com.autel.sdksample.camera.fragment.adapter.ExposureValueAdapter;
import com.autel.sdksample.camera.fragment.adapter.ISOValueAdapter;
import com.autel.sdksample.camera.fragment.adapter.PIVModeAdapter;
import com.autel.sdksample.camera.fragment.adapter.PhotoAEBCountAdapter;
import com.autel.sdksample.camera.fragment.adapter.PhotoBurstAdapter;
import com.autel.sdksample.camera.fragment.adapter.PhotoFormatAdapter;
import com.autel.sdksample.camera.fragment.adapter.PhotoStyleAdapter;
import com.autel.sdksample.camera.fragment.adapter.PhotoTimelapseIntervalAdapter;
import com.autel.sdksample.camera.fragment.adapter.RealTimeResolutionAdapter;
import com.autel.sdksample.camera.fragment.adapter.ShutterSpeedAdapter;
import com.autel.sdksample.camera.fragment.adapter.VideoEncodeAdapter;
import com.autel.sdksample.camera.fragment.adapter.VideoFormatAdapter;
import com.autel.sdksample.camera.fragment.adapter.VideoResolutionFpsAdapter;
import com.autel.sdksample.camera.fragment.adapter.VideoSnapshotTimeIntervalAdapter;
import com.autel.sdksample.camera.fragment.adapter.VideoStandardAdapter;
import com.autel.sdksample.camera.fragment.adapter.WhiteBalanceTypeAdapter;

import java.util.Arrays;

public class CameraXB012Fragment extends CameraBaseFragment {
    AutelXB012 xb012;

    Button setCameraColor;
    Spinner colorStyle;

    Button setExposureMode;
    Spinner exposureModeList;

    EditText spotMeteringAreaX;
    EditText spotMeteringAreaY;

    EditText photoCustomStyleContrast;
    EditText photoCustomStyleSaturation;
    EditText photoCustomStyleSharpness;

    Spinner exposureValueList;
    VideoResolutionFpsAdapter videoResolutionFpsAdapter;
    Spinner videoResolutionAndFrameRateList;

    CameraColorStyle cameraColorStyle = CameraColorStyle.None;
    CameraExposureMode cameraExposureMode = CameraExposureMode.Auto;
    CameraExposureCompensation cameraExposureCompensation = CameraExposureCompensation.NEGATIVE_0p3;
    CameraISO cameraISO = CameraISO.ISO_100;
    CameraShutterSpeed cameraShutterSpeed = CameraShutterSpeed.ShutterSpeed_1;
    CameraWhiteBalanceType cameraWhiteBalanceType = CameraWhiteBalanceType.AUTO;
    CameraAntiFlicker cameraAntiFlicker = CameraAntiFlicker.AUTO;
    CameraAutoExposureLockState cameraAutoExposureLockState = CameraAutoExposureLockState.LOCK;
    PhotoStyleType photoStyleType = PhotoStyleType.Standard;
    PhotoBurstCount photoBurstCount = PhotoBurstCount.BURST_3;
    PhotoTimelapseInterval photoTimelapseInterval = PhotoTimelapseInterval.SECOND_5;
    PhotoAEBCount photoAEBCount = PhotoAEBCount.CAPTURE_3;
    VideoFormat videoFormat = VideoFormat.MOV;
    VideoStandard selectedVideoStandard = VideoStandard.NTSC;
    VideoStandard currentVideoStandard = VideoStandard.NTSC;
    PhotoFormat photoFormat = PhotoFormat.JPEG;
    CameraAspectRatio aspectRatio = CameraAspectRatio.Aspect_16_9;
    VideoResolutionAndFps videoResolutionAndFps = null;
    VideoEncodeFormat videoEncoding = VideoEncodeFormat.H264;
    RealTimeVideoResolution realTimeVideoResolution = RealTimeVideoResolution.P_1280X720;
    PIVMode pivMode = PIVMode.Manual;
    VideoSnapshotTimelapseInterval snapshotTimelapseInterval = VideoSnapshotTimelapseInterval.SECOND_5;
    VideoResolutionAndFps currentVideoResolutionAndFps = null;

    ShutterSpeedAdapter shutterSpeedAdapter = null;
    Spinner shutterList = null;

    private CameraProduct currentCameraProduct;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_camera_xb012, null);
        xb012 = (AutelXB012) ((CameraActivity) getActivity()).getCamera();
        currentCameraProduct = xb012.getProduct();
        logOut("");
        initView(view);
        initClick(view);
        initXB012Click(view);
        initData();

        return view;
    }

    private void initData() {
        if (null != xb012) {
            xb012.getVideoResolutionAndFrameRate(new CallbackWithOneParam<VideoResolutionAndFps>() {
                @Override
                public void onFailure(AutelError error) {
                }

                @Override
                public void onSuccess(VideoResolutionAndFps data) {
                    currentVideoResolutionAndFps = data;
                    initShuttleSpeedList();
                }
            });
            xb012.getVideoStandard(new CallbackWithOneParam<VideoStandard>() {
                @Override
                public void onFailure(AutelError error) {
                }

                @Override
                public void onSuccess(VideoStandard data) {
                    currentVideoStandard = data;
                    initVideoResolutionFpsList();
                }
            });
        }
    }


    private void initXB012Click(View view) {
        final EditText digitalZoomScaleValue = (EditText) view.findViewById(R.id.digitalZoomScaleValue);
        final TextView digitalZoomScaleRange = (TextView) view.findViewById(R.id.digitalZoomScaleRange);
        digitalZoomScaleValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (isEmpty(digitalZoomScaleRange.getText().toString())) {
                    RangePair<Integer> digitalScaleRange = xb012.getParameterRangeManager().getDigitalZoomScale();
                    digitalZoomScaleRange.setText("integer value of digital scale,  range from " + digitalScaleRange.getValueFrom() + " to " + digitalScaleRange.getValueTo());
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        view.findViewById(R.id.setDigitalZoomScale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = digitalZoomScaleValue.getText().toString();
                int parameter = isEmpty(value) ? 100 : Integer.valueOf(value);
                xb012.setDigitalZoomScale(parameter, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setDigitalZoomScale  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("setDigitalZoomScale  description  " + autelError.getDescription());
                    }
                });
            }
        });

        view.findViewById(R.id.getDigitalZoomScale).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getDigitalZoomScale(new CallbackWithOneParam<Integer>() {
                    @Override
                    public void onSuccess(Integer value) {
                        logOut("getDigitalZoomScale  onSuccess  " + value);
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("getDigitalZoomScale  description  " + autelError.getDescription());
                    }
                });
            }
        });

        view.findViewById(R.id.getMediaMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getMediaMode(new CallbackWithOneParam<MediaMode>() {
                    @Override
                    public void onSuccess(final MediaMode data) {
                        logOut("getMediaMode " + data);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (null != currentVideoResolutionAndFps) {
                                    shutterSpeedAdapter.setData(xb012.getParameterRangeManager().getCameraShutterSpeed(data, currentVideoResolutionAndFps.fps));
                                    shutterList.setAdapter(shutterSpeedAdapter);
                                }
                            }
                        });
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getMediaMode " + error.getDescription());
                    }
                });
            }
        });


        view.findViewById(R.id.setMediaMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setMediaMode(mediaMode, new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setMediaMode  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("xb012  setMediaMode state onSuccess ");
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (null != currentVideoResolutionAndFps) {
                                    shutterSpeedAdapter.setData(xb012.getParameterRangeManager().getCameraShutterSpeed(mediaMode, currentVideoResolutionAndFps.fps));
                                    shutterList.setAdapter(shutterSpeedAdapter);
                                }
                            }
                        });
                    }
                });
            }
        });


        view.findViewById(R.id.setSpotMeteringArea).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NoX = spotMeteringAreaX.getText().toString();
                String NoY = spotMeteringAreaY.getText().toString();
                xb012.setSpotMeteringArea(isEmpty(NoX) ? 1 : Integer.valueOf(NoX), isEmpty(NoY) ? 1 : Integer.valueOf(NoY), new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setSpotMeteringArea  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("setSpotMeteringArea  description  " + autelError.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.getSpotMeteringArea).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        xb012.getSpotMeteringArea(new CallbackWithOneParam<CameraSpotMeteringArea>() {
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
                });

        view.findViewById(R.id.setExposure).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        xb012.setExposure(cameraExposureCompensation, new CallbackWithNoParam() {
                            @Override
                            public void onSuccess() {
                                logOut("setExposure  onSuccess  ");
                            }

                            @Override
                            public void onFailure(AutelError autelError) {
                                logOut("setExposure  description  " + autelError.getDescription());
                            }
                        });
                    }
                });


        view.findViewById(R.id.getExposure).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        xb012.getExposure(new CallbackWithOneParam<CameraExposureCompensation>() {
                            @Override
                            public void onSuccess(CameraExposureCompensation cameraExposureCompensation) {
                                logOut("getExposure  onSuccess  " + cameraExposureCompensation);
                            }

                            @Override
                            public void onFailure(AutelError autelError) {
                                logOut("getExposure  description  " + autelError.getDescription());
                            }
                        });
                    }
                });


        view.findViewById(R.id.setISO).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        xb012.setISO(cameraISO, new CallbackWithNoParam() {
                            @Override
                            public void onSuccess() {
                                logOut("setISO  onSuccess  ");
                            }

                            @Override
                            public void onFailure(AutelError autelError) {
                                logOut("setISO  description  " + autelError.getDescription());
                            }
                        });
                    }
                });

        view.findViewById(R.id.getISO).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        xb012.getISO(new CallbackWithOneParam<CameraISO>() {
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
                });


        view.findViewById(R.id.setShutter).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        xb012.setShutter(cameraShutterSpeed, new CallbackWithNoParam() {
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
                });

        view.findViewById(R.id.getShutter).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        xb012.getShutter(new CallbackWithOneParam<CameraShutterSpeed>() {
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
                });

        view.findViewById(R.id.setColorStyle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setColorStyle(cameraColorStyle, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setColorStyle  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("setAutoExposureLockState  description  " + autelError.getDescription());
                    }
                });
            }
        });

        view.findViewById(R.id.getColorStyle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getColorStyle(new CallbackWithOneParam<CameraColorStyle>() {
                    @Override
                    public void onSuccess(CameraColorStyle cameraColorStyle) {
                        logOut("getColorStyle  onSuccess  " + cameraColorStyle);
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("getColorStyle  description  " + autelError.getDescription());
                    }
                });
            }
        });

        view.findViewById(R.id.setWhiteBalance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraWhiteBalance cameraWhiteBalance = new CameraWhiteBalance();
                cameraWhiteBalance.type = cameraWhiteBalanceType;

                xb012.setWhiteBalance(cameraWhiteBalance, new CallbackWithNoParam() {
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
        });

        view.findViewById(R.id.getWhiteBalance).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getWhiteBalance(new CallbackWithOneParam<CameraWhiteBalance>() {
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
        });

        view.findViewById(R.id.setAntiFlicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setAntiFlicker(cameraAntiFlicker, new CallbackWithNoParam() {
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
        });

        view.findViewById(R.id.getAntiFlicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getAntiFlicker(new CallbackWithOneParam<CameraAntiFlicker>() {
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
        });

        view.findViewById(R.id.setAutoExposureLockState).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setAutoExposureLockState(cameraAutoExposureLockState, new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setAutoExposureLockState  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setAutoExposureLockState  onSuccess  ");
                    }
                });
            }
        });

        view.findViewById(R.id.getAutoExposureLockState).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getAutoExposureLockState(new CallbackWithOneParam<CameraAutoExposureLockState>() {
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
        });

        view.findViewById(R.id.isHistogramStatusEnable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.isHistogramStatusEnable(new CallbackWithOneParam<Boolean>() {
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
        });

        view.findViewById(R.id.setExposureMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setExposureMode(cameraExposureMode, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setExposureMode  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("setAutoExposureLockState  description  " + autelError.getDescription());
                    }
                });
            }
        });

        view.findViewById(R.id.getExposureMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getExposureMode(new CallbackWithOneParam<CameraExposureMode>() {
                    @Override
                    public void onSuccess(CameraExposureMode cameraExposureMode) {
                        logOut("getExposureMode  onSuccess  " + cameraExposureMode);
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("getExposureMode  description  " + autelError.getDescription());
                    }
                });
            }
        });

        view.findViewById(R.id.setPhotoStyle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (photoStyleType == PhotoStyleType.Custom) {
                    photoCustomStyleContrast.setVisibility(View.VISIBLE);
                    photoCustomStyleSaturation.setVisibility(View.VISIBLE);
                    photoCustomStyleSharpness.setVisibility(View.VISIBLE);
                    String contrastValue = photoCustomStyleContrast.getText().toString();
                    String saturationValue = photoCustomStyleSaturation.getText().toString();
                    String sharpnessValue = photoCustomStyleSharpness.getText().toString();

                    xb012.setPhotoStyle(isEmpty(contrastValue) ? 1 : Integer.valueOf(contrastValue),
                            isEmpty(saturationValue) ? 2 : Integer.valueOf(saturationValue),
                            isEmpty(sharpnessValue) ? 3 : Integer.valueOf(sharpnessValue), new CallbackWithNoParam() {
                                @Override
                                public void onFailure(AutelError error) {
                                    logOut("setPhotoStyle  description  " + error.getDescription());
                                }

                                @Override
                                public void onSuccess() {
                                    logOut("setPhotoStyle state onSuccess");
                                }
                            });
                } else {
                    xb012.setPhotoStyle(photoStyleType, new CallbackWithNoParam() {
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
            }
        });

        view.findViewById(R.id.getPhotoStyle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getPhotoStyle(new CallbackWithOneParam<PhotoStyle>() {
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
        });

        ((Switch) view.findViewById(R.id.setVideoSubtitleEnable)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                xb012.setVideoSubtitleEnable(isChecked, new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setVideoSubtitleEnable  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setVideoSubtitleEnable onSuccess");
                    }
                });
            }
        });

        view.findViewById(R.id.isSubtitleEnable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.isSubtitleEnable(new CallbackWithOneParam<Boolean>() {
                    @Override
                    public void onSuccess(Boolean data) {
                        logOut("isSubtitleEnable " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("isSubtitleEnable " + error.getDescription());
                    }
                });
            }
        });

        view.findViewById(R.id.setPhotoBurstCount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setPhotoBurstCount(photoBurstCount, new CallbackWithNoParam() {
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
        });

        view.findViewById(R.id.getPhotoBurstCount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getPhotoBurstCount(new CallbackWithOneParam<PhotoBurstCount>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getPhotoBurstCount  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(PhotoBurstCount data) {
                        logOut("getPhotoBurstCount " + data);
                    }
                });
            }
        });

        view.findViewById(R.id.setPhotoTimelapseInterval).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setPhotoTimelapseInterval(photoTimelapseInterval, new CallbackWithNoParam() {
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
        });

        view.findViewById(R.id.getPhotoTimelapseInterval).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getPhotoTimelapseInterval(new CallbackWithOneParam<PhotoTimelapseInterval>() {
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
        });

        view.findViewById(R.id.setPhotoAEBCount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setPhotoAEBCount(photoAEBCount, new CallbackWithNoParam() {
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
        });

        view.findViewById(R.id.getPhotoAEBCount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getPhotoAEBCount(new CallbackWithOneParam<PhotoAEBCount>() {
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
        });

        view.findViewById(R.id.setVideoEncoding).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setVideoEncodeFormat(videoEncoding, new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setVideoEncoder  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setVideoEncoder onSuccess");
                    }
                });
            }
        });

        view.findViewById(R.id.getVideoEncodeFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getVideoEncodeFormat(new CallbackWithOneParam<VideoEncodeFormat>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getVideoEncodeFormat  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(VideoEncodeFormat data) {
                        logOut("getVideoEncodeFormat " + data);
                    }
                });
            }
        });

        view.findViewById(R.id.getVideoSum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getVideoSum(new CallbackWithOneParam<VideoSum>() {
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
        });

        view.findViewById(R.id.getPhotoSum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getPhotoSum(new CallbackWithOneParam<PhotoSum>() {
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
        });

        view.findViewById(R.id.setVideoFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setVideoFormat(videoFormat, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setVideoFormat onSuccess");
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("setVideoFormat " + autelError.getDescription());
                    }
                });
            }
        });

        view.findViewById(R.id.getVideoFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getVideoFormat(new CallbackWithOneParam<VideoFormat>() {
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
        });

        view.findViewById(R.id.setVideoStandard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setVideoStandard(selectedVideoStandard, new CallbackWithNoParam() {

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setVideoStandard  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setVideoStandard state onSuccess");
                        currentVideoStandard = selectedVideoStandard;
                        initVideoResolutionFpsList();
                    }
                });
            }
        });

        view.findViewById(R.id.getVideoStandard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getVideoStandard(new CallbackWithOneParam<VideoStandard>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getVideoStandard  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(VideoStandard data) {
                        logOut("getVideoStandard " + data);
                        currentVideoStandard = data;
                        initVideoResolutionFpsList();
                    }
                });
            }
        });

        view.findViewById(R.id.setPhotoFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setPhotoFormat(photoFormat, new CallbackWithNoParam() {
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
        });

        view.findViewById(R.id.getPhotoFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getPhotoFormat(new CallbackWithOneParam<PhotoFormat>() {
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
        });

        view.findViewById(R.id.setAspectRatio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setAspectRatio(aspectRatio, new CallbackWithNoParam() {
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
        });

        view.findViewById(R.id.getAspectRatio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getAspectRatio(new CallbackWithOneParam<CameraAspectRatio>() {
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
        });



        view.findViewById(R.id.getRealTimeVideoResolution).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getRealTimeVideoResolution(new CallbackWithOneParam<RealTimeVideoResolution>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getRealTimeVideoResolution  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(RealTimeVideoResolution data) {
                        logOut("getRealTimeVideoResolution " + data);
                    }
                });
            }
        });
        view.findViewById(R.id.setRealTimeVideoResolution).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setRealTimeVideoResolution(realTimeVideoResolution, new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setRealTimeVideoResolution  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setRealTimeVideoResolution onSuccess");
                    }
                });
            }
        });
        view.findViewById(R.id.getPIVMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getPIVMode(new CallbackWithOneParam<PIVMode>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getPIVMode  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(PIVMode mode) {
                        logOut("getPIVMode onSuccess " + mode);
                    }
                });
            }
        });
        view.findViewById(R.id.setPIVMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setPIVMode(pivMode, new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setPIVMode  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setPIVMode onSuccess");
                    }
                });
            }
        });
        view.findViewById(R.id.setAutoPIVTimelapseInterval).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setAutoPIVTimelapseInterval(snapshotTimelapseInterval, new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setAutoPIVTimelapseInterval  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setAutoPIVTimelapseInterval onSuccess");
                    }
                });
            }
        });

        view.findViewById(R.id.getAutoPIVTimelapseInterval).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getAutoPIVTimelapseInterval(new CallbackWithOneParam<VideoSnapshotTimelapseInterval>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getAutoPIVTimelapseInterval  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(VideoSnapshotTimelapseInterval mode) {
                        logOut("getAutoPIVTimelapseInterval onSuccess " + mode);
                    }
                });
            }
        });

        view.findViewById(R.id.setVideoResolutionAndFrameRate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.setVideoResolutionAndFrameRate(videoResolutionAndFps, new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setVideoResolutionAndFrameRate  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setVideoResolutionAndFrameRate onSuccess");
                        currentVideoResolutionAndFps = videoResolutionAndFps;
                        initShuttleSpeedList();
                    }
                });
            }
        });

        view.findViewById(R.id.getVideoResolutionAndFrameRate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xb012.getVideoResolutionAndFrameRate(new CallbackWithOneParam<VideoResolutionAndFps>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getVideoResolutionAndFrameRate  description  " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(VideoResolutionAndFps data) {
                        logOut("getVideoResolutionAndFrameRate " + data);
                        currentVideoResolutionAndFps = data;
                        initShuttleSpeedList();
                    }
                });
            }
        });

        videoResolutionAndFrameRateList = (Spinner) view.findViewById(R.id.videoResolutionAndFrameRateList);
        videoResolutionFpsAdapter = new VideoResolutionFpsAdapter(getContext());
        view.findViewById(R.id.getVideoStandard).callOnClick();
    }

    private void initVideoResolutionFpsList() {
        if (null != xb012) {
            XB012ParameterRangeManager parameterRangeManager = xb012.getParameterRangeManager();
            videoResolutionFpsAdapter.setData(Arrays.asList(parameterRangeManager.getVideoResolutionAndFps(currentVideoStandard)));
        }
        videoResolutionAndFrameRateList.setAdapter(videoResolutionFpsAdapter);
        videoResolutionAndFrameRateList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                videoResolutionAndFps = (VideoResolutionAndFps) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initShuttleSpeedList() {
        xb012.getMediaMode(new CallbackWithOneParam<MediaMode>() {
            @Override
            public void onSuccess(final MediaMode mode) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (null != currentVideoResolutionAndFps) {
                            shutterSpeedAdapter.setData(xb012.getParameterRangeManager().getCameraShutterSpeed(mode, currentVideoResolutionAndFps.fps));
                            shutterList.setAdapter(shutterSpeedAdapter);
                        }
                    }
                });
            }

            @Override
            public void onFailure(AutelError autelError) {

            }
        });

    }

    private void initView(View view) {
        XB012ParameterRangeManager rangeManager = xb012.getParameterRangeManager();

        Spinner autoPIVTimelapseIntervalList = (Spinner) view.findViewById(R.id.autoPIVTimelapseIntervalList);
        autoPIVTimelapseIntervalList.setAdapter(new VideoSnapshotTimeIntervalAdapter(getContext()));
        autoPIVTimelapseIntervalList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                snapshotTimelapseInterval = (VideoSnapshotTimelapseInterval) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner pivModeList = (Spinner) view.findViewById(R.id.PIVModeList);
        pivModeList.setAdapter(new PIVModeAdapter(getContext()));
        pivModeList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pivMode = (PIVMode) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner realTimeVideoResolutionList = (Spinner) view.findViewById(R.id.realTimeVideoResolutionList);
        realTimeVideoResolutionList.setAdapter(new RealTimeResolutionAdapter(getContext()));
        realTimeVideoResolutionList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                realTimeVideoResolution = (RealTimeVideoResolution) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner videoEncodeList = (Spinner) view.findViewById(R.id.videoEncodeList);
        videoEncodeList.setAdapter(new VideoEncodeAdapter(getContext()));
        videoEncodeList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                videoEncoding = (VideoEncodeFormat) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner aspectRatioList = (Spinner) view.findViewById(R.id.aspectRatioList);
        aspectRatioList.setAdapter(new AspectRatioAdapter(getContext(), currentCameraProduct));
        aspectRatioList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                aspectRatio = (CameraAspectRatio) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner photoFormatList = (Spinner) view.findViewById(R.id.photoFormatList);
        photoFormatList.setAdapter(new PhotoFormatAdapter(getContext()));
        photoFormatList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                photoFormat = (PhotoFormat) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner videoStandardList = (Spinner) view.findViewById(R.id.videoStandardList);
        videoStandardList.setAdapter(new VideoStandardAdapter(getContext()));
        videoStandardList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedVideoStandard = (VideoStandard) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner videoFormatList = (Spinner) view.findViewById(R.id.videoFormatList);
        videoFormatList.setAdapter(new VideoFormatAdapter(getContext()));
        videoFormatList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                videoFormat = (VideoFormat) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner photoAEBCountList = (Spinner) view.findViewById(R.id.photoAEBCountList);
        photoAEBCountList.setAdapter(new PhotoAEBCountAdapter(getContext()));
        photoAEBCountList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                photoAEBCount = (PhotoAEBCount) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner photoTimelapseIntervalList = (Spinner) view.findViewById(R.id.photoTimelapseIntervalList);
        if (null != xb012) {
            photoTimelapseIntervalList.setAdapter(new PhotoTimelapseIntervalAdapter(getContext(),
                    Arrays.asList(xb012.getParameterRangeManager().getPhotoTimelapseInterval())));
        }

        photoTimelapseIntervalList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                photoTimelapseInterval = (PhotoTimelapseInterval) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner photoBurstCountList = (Spinner) view.findViewById(R.id.photoBurstCountList);
        photoBurstCountList.setAdapter(new PhotoBurstAdapter(getContext()));
        photoBurstCountList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                photoBurstCount = (PhotoBurstCount) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        photoCustomStyleContrast = (EditText) view.findViewById(R.id.photoCustomStyleContrast);
        photoCustomStyleSaturation = (EditText) view.findViewById(R.id.photoCustomStyleSaturation);
        photoCustomStyleSharpness = (EditText) view.findViewById(R.id.photoCustomStyleSharpness);

        Spinner photoStyleList = (Spinner) view.findViewById(R.id.photoStyleList);
        photoStyleList.setAdapter(new PhotoStyleAdapter(getContext()));
        photoStyleList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                photoStyleType = (PhotoStyleType) parent.getAdapter().getItem(position);
                if (photoStyleType == PhotoStyleType.Custom) {
                    photoCustomStyleContrast.setVisibility(View.VISIBLE);
                    photoCustomStyleSaturation.setVisibility(View.VISIBLE);
                    photoCustomStyleSharpness.setVisibility(View.VISIBLE);
                } else {
                    photoCustomStyleContrast.setVisibility(View.GONE);
                    photoCustomStyleSaturation.setVisibility(View.GONE);
                    photoCustomStyleSharpness.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        exposureValueList = (Spinner) view.findViewById(R.id.exposureValueList);
        exposureValueList.setAdapter(new ExposureValueAdapter(getContext()));
        exposureValueList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cameraExposureCompensation = (CameraExposureCompensation) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        shutterList = (Spinner) view.findViewById(R.id.shutterList);
        shutterSpeedAdapter = new ShutterSpeedAdapter(getContext());
        shutterList.setAdapter(shutterSpeedAdapter);
        shutterList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cameraShutterSpeed = (CameraShutterSpeed) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner ISOList = (Spinner) view.findViewById(R.id.ISOList);
        ISOList.setAdapter(new ISOValueAdapter(getContext(), Arrays.asList(rangeManager.getCameraISO())));
        ISOList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cameraISO = (CameraISO) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        colorStyle = (Spinner) view.findViewById(R.id.colorStyle);
        colorStyle.setAdapter(new ColorStyleAdapter(getContext()));
        colorStyle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cameraColorStyle = (CameraColorStyle) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner whiteBalanceTypeList = (Spinner) view.findViewById(R.id.whiteBalanceTypeList);
        whiteBalanceTypeList.setAdapter(new WhiteBalanceTypeAdapter(getContext(), currentCameraProduct));
        whiteBalanceTypeList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cameraWhiteBalanceType = (CameraWhiteBalanceType) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner antiFlickerList = (Spinner) view.findViewById(R.id.antiFlickerList);
        antiFlickerList.setAdapter(new AntiFlickerAdapter(getContext()));
        antiFlickerList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cameraAntiFlicker = (CameraAntiFlicker) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner autoExposureLockStateList = (Spinner) view.findViewById(R.id.autoExposureLockStateList);
        autoExposureLockStateList.setAdapter(new AutoExposureLockStateAdapter(getContext()));
        autoExposureLockStateList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cameraAutoExposureLockState = (CameraAutoExposureLockState) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        exposureModeList = (Spinner) view.findViewById(R.id.exposureModeList);
        exposureModeList.setAdapter(new ExposureModeAdapter(getContext(), Arrays.asList(rangeManager.getCameraExposureMode())));
        exposureModeList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cameraExposureMode = (CameraExposureMode) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spotMeteringAreaX = (EditText) view.findViewById(R.id.spotMeteringAreaX);
        spotMeteringAreaY = (EditText) view.findViewById(R.id.spotMeteringAreaY);

    }
}