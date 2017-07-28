package com.autel.sdksample;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.error.AutelError;
import com.autel.common.remotecontroller.RFPower;
import com.autel.common.remotecontroller.RemoteControllerCommandStickMode;
import com.autel.common.remotecontroller.RemoteControllerConnectState;
import com.autel.common.remotecontroller.RemoteControllerInfo;
import com.autel.common.remotecontroller.RemoteControllerLanguage;
import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;
import com.autel.common.remotecontroller.RemoteControllerParameterRangeManager;
import com.autel.common.remotecontroller.RemoteControllerParameterUnit;
import com.autel.common.remotecontroller.RemoteControllerStickCalibration;
import com.autel.common.remotecontroller.RemoteControllerVersionInfo;
import com.autel.common.remotecontroller.TeachingMode;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.XStarAircraft;
import com.autel.sdk.product.XStarPremiumAircraft;
import com.autel.sdk.remotecontroller.AutelRemoteController;


public class RemoteControllerActivity extends BaseActivity {
    final static String TAG = RemoteControllerActivity.class.getSimpleName();
    private TextView log_output;

    AutelRemoteController remoteController;

    private Spinner languageSpinner;
    private Spinner rfSpinner;
    private Spinner teachingModeSpinner;
    private Spinner lengthUnitSpinner;
    private Spinner commandStickModeSpinner;
    private EditText yawCoefficientValue;

    private RemoteControllerLanguage remoteControllerLanguage = RemoteControllerLanguage.ENGLISH;
    private RFPower rfPower = RFPower.FCC;
    private TeachingMode teachingMode = TeachingMode.STUDENT;
    private RemoteControllerParameterUnit parameterUnit = RemoteControllerParameterUnit.IMPERIAL;
    private RemoteControllerCommandStickMode commandStickMode = RemoteControllerCommandStickMode.CHINA;

    @Override
    protected void initOnCreate() {
        setTitle("RemoteController");
        BaseProduct baseProduct = getCurrentProduct();
        if (null != baseProduct) {
            if (null != baseProduct) {
                switch (baseProduct.getType()) {
                    case X_STAR:
                        remoteController = ((XStarAircraft) baseProduct).getRemoteController();
                        break;
                    case PREMIUM:
                        remoteController = ((XStarPremiumAircraft) baseProduct).getRemoteController();
                        break;
                }
            }
        }
        if (null == remoteController) {
            setContentView(R.layout.activity_connect_exception);
            return;
        }

        setContentView(R.layout.activity_rc);

        /**
         * or remoteController = AModuleRemoteController.remoteController()
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
                        parameterUnit = RemoteControllerParameterUnit.METRIC;
                        break;
                    case 1:
                        parameterUnit = RemoteControllerParameterUnit.IMPERIAL;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        commandStickModeSpinner = (Spinner) findViewById(R.id.commandStickModeSpinner);
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

        final TextView yawCoefficientRange = (TextView) findViewById(R.id.yawCoefficientRange);
        yawCoefficientValue = (EditText) findViewById(R.id.yawCoefficientValue);
        yawCoefficientValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                String value = yawCoefficientRange.getText().toString();
                if (isEmpty(value)) {
                    RemoteControllerParameterRangeManager parameterRangeManager = remoteController.getParameterSupport();
                    RangePair<Float> support = parameterRangeManager.getYawCoefficient();
                    yawCoefficientRange.setText("yawCoefficient from " + support.getValueFrom() + "  to  " + support.getValueTo());
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void setRCLanguage(View view) {
        remoteController.setLanguage(remoteControllerLanguage, new CallbackWithNoParam() {

            @Override
            public void onFailure(AutelError rcError) {
                logOut("setLanguage RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setLanguage onSuccess ");
            }
        });
    }

    public void getRCLanguage(View view) {
        remoteController.getLanguage(new CallbackWithOneParam<RemoteControllerLanguage>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("getLanguage RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerLanguage rcLanguage) {
                logOut("getLanguage onSuccess " + rcLanguage.toString());
            }
        });
    }

    public void enterBinding(View view) {
        remoteController.enterBinding(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("enterBinding RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("enterBinding onSuccess ");
            }
        });
    }

    public void exitBinding(View view) {
        remoteController.exitBinding();
    }

    public void setRFPower(View view) {
        remoteController.setRFPower(rfPower, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("setRFPower RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setRFPower onSuccess ");
            }
        });
    }

    public void getRFPower(View view) {
        remoteController.getRFPower(new CallbackWithOneParam<RFPower>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("getRFPower RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RFPower autelRFPower) {
                logOut("getRFPower onSuccess " + autelRFPower);
            }
        });
    }

    public void getTeacherStudentMode(View view) {
        remoteController.getTeachingMode(new CallbackWithOneParam<TeachingMode>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("getTeachingMode RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(TeachingMode autelTeachingMode) {
                logOut("getTeachingMode onSuccess " + autelTeachingMode);
            }
        });
    }

    public void setTeacherStudentMode(View view) {
        remoteController.setTeachingMode(teachingMode, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("setTeachingMode RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setTeachingMode onSuccess ");
            }
        });
    }

    public void startCalibration(View view) {
        remoteController.setStickCalibration(RemoteControllerStickCalibration.CALIBRATE, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("setStickCalibration CALIBRATE RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setStickCalibration CALIBRATE onSuccess  ");
            }
        });
    }

    public void saveCalibration(View view) {
        remoteController.setStickCalibration(RemoteControllerStickCalibration.COMPLETE, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("setStickCalibration COMPLETE RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setStickCalibration COMPLETE onSuccess  ");
            }
        });
    }

//    public void exitCalibration(View view) {
//        remoteController.setStickCalibration(RemoteControllerStickCalibration.EXIT, new CallbackWithNoParam() {
//            @Override
//            public void onFailure(AutelError rcError) {
//                logOut("setStickCalibration EXIT RCError " + rcError.getDescription());
//            }
//
//            @Override
//            public void onSuccess() {
//                logOut("setStickCalibration EXIT onSuccess  ");
//            }
//        });
//    }

    public void getRCLengthUnit(View view) {
        remoteController.getLengthUnit(new CallbackWithOneParam<RemoteControllerParameterUnit>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("getLengthUnit RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerParameterUnit autelRCLengthUnit) {
                logOut("getLengthUnit onSuccess " + autelRCLengthUnit);
            }
        });
    }

    public void setRCLengthUnit(View view) {
        remoteController.setParameterUnit(parameterUnit, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("setParameterUnit RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setParameterUnit onSuccess  ");
            }

        });
    }

    public void setRCCommandStickMode(View view) {
        remoteController.setCommandStickMode(commandStickMode, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("setCommandStickMode RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setCommandStickMode onSuccess ");
            }
        });
    }

    public void getRCCommandStickMode(View view) {
        remoteController.getCommandStickMode(new CallbackWithOneParam<RemoteControllerCommandStickMode>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("getCommandStickMode RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerCommandStickMode mode) {
                logOut("getCommandStickMode onSuccess " + mode);
            }
        });
    }

    public void resetWifi(View view) {
        remoteController.resetWifi();
    }

    public void setYawCoefficient(View view) {
        String value = yawCoefficientValue.getText().toString();
        remoteController.setYawCoefficient(isEmpty(value) ? 0.3f : Float.valueOf(value), new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut("setYawCoefficient onSuccess ");
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("setYawCoefficient RCError " + autelError.getDescription());
            }
        });
    }

    public void getYawCoefficient(View view) {
        remoteController.getYawCoefficient(new CallbackWithOneParam<Float>() {
            @Override
            public void onSuccess(Float aDouble) {
                logOut("getYawCoefficient onSuccess " + aDouble);
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("getYawCoefficient RCError " + autelError.getDescription());
            }
        });
    }

    public void getVersionInfo(View view) {
        remoteController.getVersionInfo(new CallbackWithOneParam<RemoteControllerVersionInfo>() {
            @Override
            public void onSuccess(RemoteControllerVersionInfo versionInfo) {
                logOut("getVersionInfo onSuccess {" + versionInfo + "}");
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("getVersionInfo onFailure : " + autelError.getDescription());
            }
        });
    }

    public void getSerialNumber(View view) {
        remoteController.getSerialNumber(new CallbackWithOneParam<String>() {
            @Override
            public void onSuccess(String serialNumber) {
                logOut("getSerialNumber onSuccess " + serialNumber);
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("getSerialNumber onFailure : " + autelError.getDescription());
            }
        });
    }


    public void setRemoteButtonControllerMonitor(View view) {
        remoteController.setRemoteButtonControllerListener(new CallbackWithOneParam<RemoteControllerNavigateButtonEvent>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("setRemoteButtonControllerListener rcError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerNavigateButtonEvent rcControlBtnEvent) {
                logOut("setRemoteButtonControllerListener onSuccess " + rcControlBtnEvent);
            }
        });
    }

    public void resetRemoteButtonControllerMonitor(View view) {
        remoteController.setRemoteButtonControllerListener(null);
    }

    public void setRCInfoDataMonitor(View view) {
        remoteController.setInfoDataListener(new CallbackWithOneParam<RemoteControllerInfo>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("setInfoDataListener rcError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerInfo data) {
                logOut("setInfoDataListener onSuccess " + data);
            }
        });
    }

    public void resetRCInfoDataMonitor(View view) {
        remoteController.setInfoDataListener(null);
    }

    public void setRemoteControllerConnectStateListener(View view) {
        remoteController.setConnectStateListener(new CallbackWithOneParam<RemoteControllerConnectState>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setConnectStateListener error " + error.getDescription());
            }

            public void onSuccess(RemoteControllerConnectState state) {
                logOut("setConnectStateListener " + state);
            }
        });
    }

    public void resetRemoteControllerConnectStateListener(View view) {
        remoteController.setConnectStateListener(null);
    }
}
