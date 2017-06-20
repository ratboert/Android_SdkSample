package com.autel.sdksample.camera.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.camera.flir.FLIRDisplayMode;
import com.autel.common.camera.flir.FLIRIRMSXSetting;
import com.autel.common.camera.flir.FLIRPhotoFormat;
import com.autel.common.camera.flir.FLIRPhotoSetting;
import com.autel.common.camera.flir.FLIRRecordSetting;
import com.autel.common.camera.flir.FLIRVideoRecordMode;
import com.autel.common.camera.flir.IRColorMode;
import com.autel.common.camera.flir.IRFileFormat;
import com.autel.common.error.AutelError;
import com.autel.sdk.camera.AutelFlirDuo;
import com.autel.sdksample.R;
import com.autel.sdksample.camera.CameraActivity;

public class CameraFLIRFragment extends CameraBaseFragment {
    AutelFlirDuo autelFLIR;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_camera_flir, null);
        autelFLIR = (AutelFlirDuo) ((CameraActivity) getActivity()).getCamera();
        logOut("");
        initClick(view);
        initR12Click(view);
        return view;
    }


    private void initR12Click(View view) {
        view.findViewById(R.id.setDisplayModeNORMAL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelFLIR.setDisplayMode(FLIRDisplayMode.NORMAL, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setDisplayMode  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setDisplayMode  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.setDisplayModePICTURE_IN_PICTURE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelFLIR.setDisplayMode(FLIRDisplayMode.PICTURE_IN_PICTURE, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setDisplayMode  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setDisplayMode  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.setDisplayModeIR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelFLIR.setDisplayMode(FLIRDisplayMode.IR, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setDisplayMode  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setDisplayMode  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.getDisplayMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelFLIR.getDisplayMode(new CallbackWithOneParam<FLIRDisplayMode>() {
                    @Override
                    public void onSuccess(FLIRDisplayMode data) {
                        logOut("getDisplayMode  onSuccess  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getDisplayMode  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.setIRColorModeHOT_METAL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelFLIR.setIRColorMode(IRColorMode.HOT_METAL, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setIRColorMode  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setIRColorMode  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.setIRColorModeWHITE_HOT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelFLIR.setIRColorMode(IRColorMode.WHITE_HOT, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setIRColorMode  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setIRColorMode  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.setIRColorModeRAINBOW).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelFLIR.setIRColorMode(IRColorMode.RAINBOW, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setIRColorMode  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setIRColorMode  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.getIRColorMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelFLIR.getIRColorMode(new CallbackWithOneParam<IRColorMode>() {
                    @Override
                    public void onSuccess(IRColorMode data) {
                        logOut("getIRColorMode  onSuccess  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getIRColorMode  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.setIRMSX).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLIRIRMSXSetting irmsxSetting = new FLIRIRMSXSetting();
                irmsxSetting.setPosY(3);
                irmsxSetting.setPosX(30);
                irmsxSetting.setEnable(true);
                irmsxSetting.setStrength(5);
                autelFLIR.setIRMSX(irmsxSetting, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setIRMSX  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setIRMSX  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.getIRMSX).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelFLIR.getIRMSX(new CallbackWithOneParam<FLIRIRMSXSetting>() {
                    @Override
                    public void onSuccess(FLIRIRMSXSetting data) {
                        logOut("getIRMSX  onSuccess  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getIRMSX  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.setRecordingFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLIRRecordSetting flirRecordSetting = new FLIRRecordSetting();
                flirRecordSetting.setFileFormat(IRFileFormat.MOV);
                flirRecordSetting.setRecordVideoMode(FLIRVideoRecordMode.IR_AND_VISIBLE);
                autelFLIR.setRecordingFormat(flirRecordSetting, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setRecordingFormat  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setRecordingFormat  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.getRecordingFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelFLIR.getRecordingFormat(new CallbackWithOneParam<FLIRRecordSetting>() {
                    @Override
                    public void onSuccess(FLIRRecordSetting data) {
                        logOut("getRecordingFormat  onSuccess  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getRecordingFormat  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.setPhotoFormatRJPG).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLIRPhotoSetting flirPhotoSetting = new FLIRPhotoSetting();
                flirPhotoSetting.setFormat(FLIRPhotoFormat.RJPG);
                flirPhotoSetting.setDuration(4);
                flirPhotoSetting.setInterval(2);
                autelFLIR.setPhotoFormat(flirPhotoSetting, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setPhotoFormat  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setRecordingFormat  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.setPhotoFormatRJPEG).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLIRPhotoSetting flirPhotoSetting = new FLIRPhotoSetting();
                flirPhotoSetting.setFormat(FLIRPhotoFormat.RJPEG);
                autelFLIR.setPhotoFormat(flirPhotoSetting, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setPhotoFormat  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setRecordingFormat  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.setPhotoFormatJPG_TIFF).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FLIRPhotoSetting flirPhotoSetting = new FLIRPhotoSetting();
                flirPhotoSetting.setFormat(FLIRPhotoFormat.JPG_TIFF);
                autelFLIR.setPhotoFormat(flirPhotoSetting, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setPhotoFormat  onSuccess  ");
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setRecordingFormat  description  " + error.getDescription());
                    }
                });
            }
        });
        view.findViewById(R.id.getPhotoFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelFLIR.getPhotoFormat(new CallbackWithOneParam<FLIRPhotoSetting>() {
                    @Override
                    public void onSuccess(FLIRPhotoSetting data) {
                        logOut("getPhotoFormat  onSuccess  " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getPhotoFormat  description  " + error.getDescription());
                    }
                });
            }
        });
    }

}
