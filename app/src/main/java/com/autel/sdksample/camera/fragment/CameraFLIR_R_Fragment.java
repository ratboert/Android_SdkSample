package com.autel.sdksample.camera.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.autel.common.camera.flir.FLIRDisplayMode;
import com.autel.common.camera.flir.FLIRIRMSXSetting;
import com.autel.common.camera.flir.FLIRPhotoFormat;
import com.autel.common.camera.flir.FLIRPhotoSetting;
import com.autel.common.camera.flir.FLIRRecordSetting;
import com.autel.common.camera.flir.FLIRVideoRecordMode;
import com.autel.common.camera.flir.IRColorMode;
import com.autel.common.camera.flir.IRFileFormat;
import com.autel.sdk.camera.AutelFlirDuo;
import com.autel.sdksample.R;
import com.autel.sdksample.camera.CameraActivity;
import com.autel.sdksample.util.CameraFlirTest;

public class CameraFLIR_R_Fragment extends CameraBaseFragment {
    AutelFlirDuo autelFLIR;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_camera_flir, null);
        autelFLIR = (AutelFlirDuo) ((CameraActivity) getActivity()).getCamera();
        initClick(view);
        initR12Click(view);
        return view;
    }

    void setDisplayModeNORMAL() {
        CameraFlirTest.setDisplayMode(FLIRDisplayMode.NORMAL, handler, autelFLIR);
    }

    void setDisplayModePICTURE_IN_PICTURE() {
        CameraFlirTest.setDisplayMode(FLIRDisplayMode.PICTURE_IN_PICTURE, handler, autelFLIR);
    }

    void setDisplayModeIR() {
        CameraFlirTest.setDisplayMode(FLIRDisplayMode.IR, handler, autelFLIR);
    }

    void getDisplayMode() {
        CameraFlirTest.getDisplayMode(handler, autelFLIR);
    }

    void setIRColorModeHOT_METAL() {
        CameraFlirTest.setIRColorMode(IRColorMode.HOT_METAL, handler, autelFLIR);
    }

    void setIRColorModeWHITE_HOT() {
        CameraFlirTest.setIRColorMode(IRColorMode.WHITE_HOT, handler, autelFLIR);
    }

    void setIRColorModeRAINBOW() {
        CameraFlirTest.setIRColorMode(IRColorMode.RAINBOW, handler, autelFLIR);
    }

    void getIRColorMode() {
        CameraFlirTest.getIRColorMode(handler, autelFLIR);
    }

    void setIRMSX() {
        FLIRIRMSXSetting irmsxSetting = new FLIRIRMSXSetting();
        irmsxSetting.setPosY(3);
        irmsxSetting.setPosX(30);
        irmsxSetting.setEnable(true);
        irmsxSetting.setStrength(5);
        CameraFlirTest.setIRMSX(irmsxSetting, handler, autelFLIR);
    }

    void getIRMSX() {
        CameraFlirTest.getIRMSX(handler, autelFLIR);
    }

    void setRecordingFormat() {
        FLIRRecordSetting flirRecordSetting = new FLIRRecordSetting();
        flirRecordSetting.setFileFormat(IRFileFormat.MOV);
        flirRecordSetting.setRecordVideoMode(FLIRVideoRecordMode.IR_AND_VISIBLE);
        CameraFlirTest.setRecordingFormat(flirRecordSetting, handler, autelFLIR);
    }

    void getRecordingFormat() {
        CameraFlirTest.getRecordingFormat(handler, autelFLIR);
    }

    void setPhotoFormatRJPG() {
        FLIRPhotoSetting flirPhotoSetting = new FLIRPhotoSetting();
        flirPhotoSetting.setFormat(FLIRPhotoFormat.RJPG);
        flirPhotoSetting.setDuration(4);
        flirPhotoSetting.setInterval(2);
        CameraFlirTest.setPhotoFormat(flirPhotoSetting, handler, autelFLIR);
    }

    void setPhotoFormatRJPEG() {
        FLIRPhotoSetting flirPhotoSetting = new FLIRPhotoSetting();
        flirPhotoSetting.setFormat(FLIRPhotoFormat.RJPEG);
        CameraFlirTest.setPhotoFormat(flirPhotoSetting, handler, autelFLIR);
    }

    void setPhotoFormatJPG_TIFF() {
        FLIRPhotoSetting flirPhotoSetting = new FLIRPhotoSetting();
        flirPhotoSetting.setFormat(FLIRPhotoFormat.JPG_TIFF);
        CameraFlirTest.setPhotoFormat(flirPhotoSetting, handler, autelFLIR);
    }

    void getPhotoFormat() {
        CameraFlirTest.getPhotoFormat(handler, autelFLIR);
    }

//    void getRadiometrySettings() {
//        CameraFlirTest.getRadiometrySettings(handler, autelFLIR);
//    }
//
//    void setRadiometrySettings() {
//        CameraFlirTest.setRadiometrySettings(handler, autelFLIR);
//    }


    private void initR12Click(View view) {
        view.findViewById(R.id.setDisplayModeNORMAL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayModeNORMAL();
            }
        });
        view.findViewById(R.id.setDisplayModePICTURE_IN_PICTURE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayModePICTURE_IN_PICTURE();
            }
        });
        view.findViewById(R.id.setDisplayModeIR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDisplayModeIR();
            }
        });
        view.findViewById(R.id.getDisplayMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDisplayMode();
            }
        });
        view.findViewById(R.id.setIRColorModeHOT_METAL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIRColorModeHOT_METAL();
            }
        });
        view.findViewById(R.id.setIRColorModeWHITE_HOT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIRColorModeWHITE_HOT();
            }
        });
        view.findViewById(R.id.setIRColorModeRAINBOW).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIRColorModeRAINBOW();
            }
        });
        view.findViewById(R.id.getIRColorMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIRColorMode();
            }
        });
        view.findViewById(R.id.setIRMSX).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setIRMSX();
            }
        });
        view.findViewById(R.id.getIRMSX).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIRMSX();
            }
        });
        view.findViewById(R.id.setRecordingFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecordingFormat();
            }
        });
        view.findViewById(R.id.getRecordingFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRecordingFormat();
            }
        });
        view.findViewById(R.id.setPhotoFormatRJPG).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPhotoFormatRJPG();
            }
        });
        view.findViewById(R.id.setPhotoFormatRJPEG).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPhotoFormatRJPEG();
            }
        });
        view.findViewById(R.id.setPhotoFormatJPG_TIFF).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPhotoFormatJPG_TIFF();
            }
        });
        view.findViewById(R.id.getPhotoFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPhotoFormat();
            }
        });
        view.findViewById(R.id.getRadiometrySettings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getRadiometrySettings();
            }
        });
        view.findViewById(R.id.setRadiometrySettings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setRadiometrySettings();
            }
        });
    }

}
