package com.autel.sdksample.camera.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.autel.common.camera.base.MediaMode;
import com.autel.sdk.camera.AutelBaseCamera;
import com.autel.sdksample.R;
import com.autel.sdksample.camera.CameraActivity;
import com.autel.sdksample.util.CameraTest;

/**
 * Created by A16343 on 2017/2/22.
 */

public class CameraBaseFragment extends Fragment {
    protected TextView log_output;
    protected Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String text = (String) msg.obj;
            if (null != log_output) {
                log_output.setText(text);
            }
        }
    };
    AutelBaseCamera baseCamera;


    protected void initClick(View view) {
        log_output = (TextView) view.findViewById(R.id.camera_log_output);
        baseCamera = ((CameraActivity) getActivity()).getCamera();
        view.findViewById(R.id.setCameraSDCardStateListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraSDCardStateListener();
            }
        });
        view.findViewById(R.id.resetCameraSDCardStateListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCameraSDCardStateListener();
            }
        });
        view.findViewById(R.id.getMediaMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMediaMode();
            }
        });
        view.findViewById(R.id.setMediaModeAEB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMediaModeAEB();
            }
        });
        view.findViewById(R.id.setMediaModeBURST).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMediaModeBURST();
            }
        });
        view.findViewById(R.id.setMediaModeTIMELAPSE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMediaModeTIMELAPSE();
            }
        });
        view.findViewById(R.id.setMediaModeVIDEO).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMediaModeVIDEO();
            }
        });
        view.findViewById(R.id.setMediaModeSINGLE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMediaModeSINGLE();
            }
        });
        view.findViewById(R.id.getVersion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVersion();
            }
        });
        view.findViewById(R.id.getTimeStamp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTimeStamp();
            }
        });
        view.findViewById(R.id.getProduct).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getProduct();
            }
        });
        view.findViewById(R.id.getNickName).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNickName();
            }
        });
        view.findViewById(R.id.getSdFreeSpace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSdFreeSpace();
            }
        });
        view.findViewById(R.id.getSDCardStatus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSDCardStatus();
            }
        });
        view.findViewById(R.id.getWorkStatus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWorkStatus();
            }
        });
        view.findViewById(R.id.resetCameraConnectStateListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCameraConnectStateListener();
            }
        });
        view.findViewById(R.id.setCameraConnectStateListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraConnectStateListener();
            }
        });
        view.findViewById(R.id.resetCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCamera();
            }
        });
        view.findViewById(R.id.formatSDCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formatSDCard();
            }
        });
        view.findViewById(R.id.stopTimelapse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimelapse();
            }
        });
        view.findViewById(R.id.takePhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });
        view.findViewById(R.id.stopRecordVideo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopRecordVideo();
            }
        });
        view.findViewById(R.id.startRecordVideo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecordVideo();
            }
        });
        view.findViewById(R.id.resetCameraMediaStateListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCameraMediaStateListener();
            }
        });
        view.findViewById(R.id.setCameraMediaStateListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCameraMediaStateListener();
            }
        });
        view.findViewById(R.id.resetAutelCameraModeListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAutelCameraModeListener();
            }
        });
        view.findViewById(R.id.setAutelCameraModeListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAutelCameraModeListener();
            }
        });
    }


    public void setCameraSDCardStateListener() {
        CameraTest.setCameraSDCardStateListener(handler, baseCamera);
    }

    public void resetCameraSDCardStateListener() {
        CameraTest.resetCameraSDCardStateListener(handler, baseCamera);
    }


    public void getMediaMode() {

        CameraTest.getMediaMode(handler, baseCamera);
    }

    public void setMediaModeAEB() {

        CameraTest.setCameraMode(MediaMode.AEB, handler, baseCamera);
    }

    public void setMediaModeBURST() {

        CameraTest.setCameraMode(MediaMode.BURST, handler, baseCamera);
    }

    public void setMediaModeTIMELAPSE() {

        CameraTest.setCameraMode(MediaMode.TIMELAPSE, handler, baseCamera);
    }

    public void setMediaModeVIDEO() {

        CameraTest.setCameraMode(MediaMode.VIDEO, handler, baseCamera);
    }

    public void setMediaModeSINGLE() {

        CameraTest.setCameraMode(MediaMode.SINGLE, handler, baseCamera);
    }

    public void setAutelCameraModeListener() {
        CameraTest.setCameraModeListener(handler, baseCamera);
    }

    public void resetAutelCameraModeListener() {
        CameraTest.resetCameraModeListener(handler, baseCamera);
    }

    public void setCameraMediaStateListener() {
        CameraTest.setCameraMediaStateListener(handler, baseCamera);
    }

    public void resetCameraMediaStateListener() {
        CameraTest.resetCameraMediaStateListener(handler, baseCamera);
    }


    public void takePhoto() {
        CameraTest.startTakePhoto(handler, baseCamera);
    }

    public void stopTimelapse() {
        CameraTest.stopTakePhoto(handler, baseCamera);
    }

    public void startRecordVideo() {
        CameraTest.startRecordVideo(handler, baseCamera);
    }

    public void stopRecordVideo() {
        CameraTest.stopRecordVideo(handler, baseCamera);
    }

    public void formatSDCard() {
        CameraTest.formatSDCard(handler, baseCamera);
    }

    public void resetCamera() {
        CameraTest.resetCamera(handler, baseCamera);
    }


    public void setCameraConnectStateListener() {
        CameraTest.setCameraConnectStateListener(handler, baseCamera);
    }

    public void resetCameraConnectStateListener() {
        CameraTest.resetCameraConnectStateListener(handler, baseCamera);
    }

    public void getWorkStatus() {
        CameraTest.getWorkStatus(handler, baseCamera);
    }

    public void getSDCardStatus() {
        CameraTest.getSDCardStatus(handler, baseCamera);
    }

    public void getNickName() {

        CameraTest.getNickName(handler, baseCamera);
    }

    public void getProduct() {

        CameraTest.getProduct(handler, baseCamera);
    }

    public void getTimeStamp() {

        CameraTest.getTimeStamp(handler, baseCamera);
    }

    public void getVersion() {

        CameraTest.getVersion(handler, baseCamera);
    }

    public void getSdFreeSpace() {
        CameraTest.getSdFreeSpace(handler, baseCamera);
    }
}
