package com.autel.sdksample;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.autel.common.remotecontroller.RemoteControllerStickCalibration;
import com.autel.sdksample.util.RCTest;


public class RCActivity extends AppCompatActivity {
    final String TAG = getClass().getSimpleName();
    private TextView log_output;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String text = (String) msg.obj;
            if (null != log_output) {
                log_output.setText(text);
            }
        }
    };

//    RadioGroup group;
    /**
     * 1 异步 ， 2同步
     */
    int cType = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc);
        log_output = (TextView) findViewById(R.id.log_output);
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

    public void setRCLanguage(View view) {
        RCTest.setRCLanguage(cType, handler);
    }

    public void getRCLanguage(View view) {
        RCTest.getRCLanguage(cType, handler);
    }

    public void getRCBindMode(View view) {
        RCTest.getRCBindMode(cType, handler);
    }

    public void enterBinding(View view) {
        RCTest.startRCBinding(cType, handler);
    }

    public void exitBinding(View view) {
        RCTest.exitBinding(handler);
    }

    public void setRFPower(View view) {
        RCTest.setRFPower(cType, handler);
    }

    public void getRFPower(View view) {
        RCTest.getRFPower(cType, handler);
    }

    public void getTeacherStudentMode(View view) {
        RCTest.getTeacherStudentMode(cType, handler);
    }

    public void setTeacherStudentMode(View view) {
        RCTest.setTeacherStudentMode(cType, handler);
    }

    public void startCalibration(View view) {
        RCTest.setRCCalibrationStep(cType, RemoteControllerStickCalibration.CALIBRATE, handler);
    }

    public void saveCalibration(View view) {
        RCTest.setRCCalibrationStep(cType, RemoteControllerStickCalibration.COMPLETE, handler);
    }

    public void exitCalibration(View view) {
        RCTest.setRCCalibrationStep(cType, RemoteControllerStickCalibration.EXIT, handler);
    }

    public void getRCLengthUnit(View view) {
        RCTest.getRCLengthUnit(cType, handler);
    }

    public void setRCLengthUnit(View view) {
        RCTest.setRCLengthUnit(cType, handler);
    }

    public void setRCCommandStickMode(View view) {
        RCTest.setRCCommandStickMode(cType, handler);
    }

    public void resetWifi(View view) {
        RCTest.resetWifi(cType);
    }

    public void uploadPhoneCompassAngle(View view) {
        RCTest.uploadPhoneCompassAngle(cType);
    }

    public void setRemoteButtonControllerMonitor(View view) {
        RCTest.setRemoteButtonControllerListener(handler);
    }

    public void resetRemoteButtonControllerMonitor(View view) {
        RCTest.resetRemoteButtonControllerListener();
    }

    public void setRCUploadDataMonitor(View view) {
        RCTest.setRCUploadDataListener(handler);
    }

    public void resetRCUploadDataMonitor(View view) {
        RCTest.resetRCUploadDataListener();
    }

    public void setRCInfoDataMonitor(View view) {
        RCTest.setRCInfoDataListener(handler);
    }

    public void resetRCInfoDataMonitor(View view) {
        RCTest.resetRCInfoDataListener();
    }

    public void setRemoteControllerConnectStateListener(View view) {
        RCTest.setRemoteControllerConnectStateListener(handler);
    }

    public void resetRemoteControllerConnectStateListener(View view) {
        RCTest.resetRemoteControllerConnectStateListener();
    }

}
