package com.autel.sdksample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.autel.sdksample.util.CameraParamsTest;


public class CameraParamsActivity extends AppCompatActivity {
//    RadioGroup group;
    /**
     * 1 异步 ， 2同步
     */
    int cType = 1;
    private TextView camera_params_log_output;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String text = (String) msg.obj;
            if (null != camera_params_log_output) {
                camera_params_log_output.setText(text);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_params);
        camera_params_log_output = (TextView) findViewById(R.id.camera_params_log_output);
//        group = (RadioGroup) findViewById(R.id.type);
//        RadioButton radioGroup = (RadioButton) findViewById(R.id.async);
//        radioGroup.toggle();
//        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (R.id.async == checkedId) {
//                    cType = 1;
//                } else {
//                    cType = 2;
//                }
//
//            }
//        });
    }

//    public void isSupportIRIS(View view) {
//        CameraParamsTest.isSupportIRIS(handler);
//    }
//
//    public void isSupportPhotoAutoFocusMeter(View view) {
//        CameraParamsTest.isSupportPhotoAutoFocusMeter(handler);
//    }
//
//    public void isSupportManualFocusDistance(View view) {
//        CameraParamsTest.isSupportManualFocusDistance(handler);
//    }
//
//    public void isSupportFocusMode(View view) {
//        CameraParamsTest.isSupportFocusMode(handler);
//    }
//
//    public void isSupportDigitalZoomScale(View view) {
//        CameraParamsTest.isSupportDigitalZoomScale(handler);
//    }
//
//    public void isSupportAutoExposureLockState(View view) {
//        CameraParamsTest.isSupportAutoExposureLockState(handler);
//    }

    public void getSupportedWhiteBalanceType(View view) {
        CameraParamsTest.getSupportedWhiteBalanceType(handler);
    }

    public void getSupportedISO(View view) {
        CameraParamsTest.getSupportedISO(handler);
    }

    public void getSupportedExposureMode(View view) {
        CameraParamsTest.getSupportedExposureMode(handler);
    }

    public void supportAspectRatio(View view) {
        CameraParamsTest.supportAspectRatio(handler);
    }

    public void supportVideoResolutionAndFps(View view) {
        CameraParamsTest.supportVideoResolutionAndFps(handler);
    }
}
