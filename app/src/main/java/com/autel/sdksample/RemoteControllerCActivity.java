package com.autel.sdksample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.remotecontroller.RFPower;
import com.autel.common.remotecontroller.RemoteControllerCommandStickMode;
import com.autel.common.remotecontroller.RemoteControllerConnectState;
import com.autel.common.remotecontroller.RemoteControllerInfo;
import com.autel.common.remotecontroller.RemoteControllerLanguage;
import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;
import com.autel.common.remotecontroller.RemoteControllerParameterUnit;
import com.autel.common.remotecontroller.RemoteControllerStickCalibration;
import com.autel.common.remotecontroller.TeachingMode;
import com.autel.sdk.Autel;
import com.autel.sdk.remotecontroller.AutelRemoteController;
import com.autel.sdksample.util.RCTest;


public class RemoteControllerCActivity extends AppCompatActivity {
    final static String TAG = RemoteControllerCActivity.class.getSimpleName();
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

    AutelRemoteController controller;

    private Spinner languageSpinner;
    private Spinner rfSpinner;
    private Spinner teachingModeSpinner;
    private Spinner lengthUnitSpinner;
    private Spinner commandStickModeSpinner;

    private RemoteControllerLanguage remoteControllerLanguage = RemoteControllerLanguage.ENGLISH;
    private RFPower rfPower = RFPower.FCC;
    private TeachingMode teachingMode = TeachingMode.STUDENT;
    private RemoteControllerParameterUnit parameterUnit = RemoteControllerParameterUnit.IMPERIAL;
    private RemoteControllerCommandStickMode commandStickMode = RemoteControllerCommandStickMode.CHINA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rc);
        log_output = (TextView) findViewById(R.id.log_output);

        controller = Autel.getRemoteController();
        /**
         * or controller = AModuleRemoteController.remoteController()
         */

        languageSpinner = (Spinner) findViewById(R.id.languageSpinner);
        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                remoteControllerLanguage = 0 == position ? RemoteControllerLanguage.ENGLISH : RemoteControllerLanguage.CHINESE;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rfSpinner = (Spinner) findViewById(R.id.rfSpinner);
        rfSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rfPower = 0 == position ? RFPower.FCC : RFPower.CE;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        teachingModeSpinner = (Spinner) findViewById(R.id.teachingModeSpinner);
        teachingModeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        teachingMode = TeachingMode.DISABLED;
                        break;
                    case 1:
                        teachingMode = TeachingMode.TEACHER;
                        break;
                    case 2:
                        teachingMode = TeachingMode.STUDENT;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lengthUnitSpinner = (Spinner) findViewById(R.id.lengthUnitSpinner);
        lengthUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        parameterUnit = RemoteControllerParameterUnit.IMPERIAL;
                        break;
                    case 1:
                        parameterUnit = RemoteControllerParameterUnit.METRIC;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        commandStickModeSpinner = (Spinner) findViewById(R.id.lengthUnitSpinner);
        commandStickModeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        commandStickMode = RemoteControllerCommandStickMode.USA;
                        break;
                    case 1:
                        commandStickMode = RemoteControllerCommandStickMode.CHINA;
                        break;
                    case 2:
                        commandStickMode = RemoteControllerCommandStickMode.JAPAN;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setRCLanguage(View view) {
        controller.setLanguage(remoteControllerLanguage, new CallbackWithNoParam() {

            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "setLanguage RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setLanguage onSuccess ");
            }
        });
    }

    public void getRCLanguage(View view) {
        controller.getLanguage(new CallbackWithOneParam<RemoteControllerLanguage>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "getLanguage RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerLanguage rcLanguage) {
                logOut(handler, "getLanguage onSuccess " + rcLanguage.toString());
            }
        });
    }

    public void enterBinding(View view) {
        controller.enterBinding(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "enterBinding RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "enterBinding onSuccess ");
            }
        });
    }

    public void exitBinding(View view) {
        controller.exitBinding();
    }

    public void setRFPower(View view) {
        controller.setRFPower(rfPower, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "setRFPower RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setRFPower onSuccess ");
            }
        });
    }

    public void getRFPower(View view) {
        controller.getRFPower(new CallbackWithOneParam<RFPower>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "getRFPower RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RFPower autelRFPower) {
                logOut(handler, "getRFPower onSuccess " + autelRFPower);
            }
        });
    }

    public void getTeacherStudentMode(View view) {
        controller.getTeachingMode(new CallbackWithOneParam<TeachingMode>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "getTeachingMode RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(TeachingMode autelTeachingMode) {
                logOut(handler, "getTeachingMode onSuccess " + autelTeachingMode);
            }
        });
    }

    public void setTeacherStudentMode(View view) {
        controller.setTeachingMode(teachingMode, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "setTeachingMode RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setTeachingMode onSuccess ");
            }
        });
    }

    public void startCalibration(View view) {
        controller.setStickCalibration(RemoteControllerStickCalibration.CALIBRATE, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "setStickCalibration CALIBRATE RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setStickCalibration CALIBRATE onSuccess  ");
            }
        });
    }

    public void saveCalibration(View view) {
        controller.setStickCalibration(RemoteControllerStickCalibration.COMPLETE, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "setStickCalibration COMPLETE RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setStickCalibration COMPLETE onSuccess  ");
            }
        });
    }

    public void exitCalibration(View view) {
        controller.setStickCalibration(RemoteControllerStickCalibration.EXIT, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "setStickCalibration EXIT RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setStickCalibration EXIT onSuccess  ");
            }
        });
    }

    public void getRCLengthUnit(View view) {
        controller.getLengthUnit(new CallbackWithOneParam<RemoteControllerParameterUnit>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "getLengthUnit RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerParameterUnit autelRCLengthUnit) {
                logOut(handler, "getLengthUnit onSuccess " + autelRCLengthUnit);
            }
        });
    }

    public void setRCLengthUnit(View view) {
        controller.setParameterUnit(parameterUnit, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "setParameterUnit RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setParameterUnit onSuccess  ");
            }

        });
    }

    public void setRCCommandStickMode(View view) {
        controller.setCommandStickMode(commandStickMode, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "setCommandStickMode RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setCommandStickMode onSuccess ");
            }
        });
    }

    public void resetWifi(View view) {
        controller.resetWifi();
    }


    public void setRemoteButtonControllerMonitor(View view) {
        controller.setRemoteButtonControllerListener(new CallbackWithOneParam<RemoteControllerNavigateButtonEvent>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "setRemoteButtonControllerListener rcError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerNavigateButtonEvent rcControlBtnEvent) {
                logOut(handler, "setRemoteButtonControllerListener onSuccess " + rcControlBtnEvent);
            }
        });
    }

    public void resetRemoteButtonControllerMonitor(View view) {
        controller.setRemoteButtonControllerListener(null);
    }

    public void setRCInfoDataMonitor(View view) {
        controller.setInfoDataListener(new CallbackWithOneParam<RemoteControllerInfo>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "setInfoDataListener rcError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerInfo data) {
                logOut(handler, "setInfoDataListener onSuccess " + data);
            }
        });
    }

    public void resetRCInfoDataMonitor(View view) {
        controller.setInfoDataListener(null);
    }

    public void setRemoteControllerConnectStateListener(View view) {
        controller.setConnectStateListener(new CallbackWithOneParam<RemoteControllerConnectState>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setConnectStateListener error " + error.getDescription());
            }

            public void onSuccess(RemoteControllerConnectState state) {
                logOut(handler, "setConnectStateListener " + state);
            }
        });
    }

    public void resetRemoteControllerConnectStateListener(View view) {
        controller.setConnectStateListener(null);
    }

    private static void logOut(Handler handler, String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }

}
