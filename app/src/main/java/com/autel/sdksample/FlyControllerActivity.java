package com.autel.sdksample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.AircraftActivateState;
import com.autel.common.flycontroller.BeginnerMode;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.sdk.AModuleFlyController;
import com.autel.sdk.flycontroller.AutelFlyController;
import com.autel.sdksample.util.FCTest;


public class FlyControllerActivity extends BaseActivity {
    final String TAG = getClass().getSimpleName();
    private TextView log_output;
    private AutelFlyController autelFlyController;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String text = (String) msg.obj;
            if (null != log_output) {
                log_output.setText(text);
            }
        }
    };

    @Override
    protected void initOnCreate() {
        setContentView(R.layout.activity_fc);
        autelFlyController = AModuleFlyController.flyController();

    }
//
//    public void setBeginnerModeState(View view) {
//        autelFlyController.setBeginnerModeState(BeginnerMode.ENABLED, new CallbackWithNoParam() {
//            @Override
//            public void onFailure(AutelError flycontrollerError) {
//                logOut(handler, "setBeginnerModeState AutelError " + flycontrollerError.getDescription());
//            }
//
//            @Override
//            public void onSuccess() {
//                logOut(handler, "setBeginnerModeState onSuccess ");
//            }
//        });
//        FCTest.setBeginnerModeState(handler);
//    }
//
//    public void getBeginnerModeState(View view) {
//        FCTest.getBeginnerModeState(handler);
//    }
//
//    public void restoreSDLogFrequency(View view) {
//        FCTest.restoreSDLogFrequency(cType);
//    }
//
//    public void getMaxHeight(View view) {
//        FCTest.getMaxHeight(handler);
//    }
//
//    public void setMaxHeight(View view) {
//        String value = ((EditText) findViewById(R.id.fcMaxHeight)).getText().toString();
//
//        FCTest.setMaxHeight(isEmpty(value) ? 80 : Integer.valueOf(value), handler);
//    }
//
//    public void getMaxRange(View view) {
//        FCTest.getMaxRange(cType, handler);
//    }
//
//    public void setMaxRange(View view) {
//        FCTest.setMaxRange(cType, handler);
//    }
//
//    public void getReturnRange(View view) {
//        FCTest.getReturnHeight(cType, handler);
//    }
//
//    public void setReturnRange(View view) {
//        FCTest.setReturnRange(cType, handler);
//    }
//
//    public void getHorizontalSpeed(View view) {
//        FCTest.getHorizontalSpeed(cType, handler);
//    }
//
//    public void setHorizontalSpeed(View view) {
//        FCTest.setHorizontalSpeed(cType, handler);
//    }
//
//    public void getAscendSpeed(View view) {
//        FCTest.getAscendSpeed(cType, handler);
//    }
//
//    public void setAscendSpeed(View view) {
//        FCTest.setAscendSpeed(cType, handler);
//    }
//
//    public void getDescendSpeed(View view) {
//        FCTest.getDescendSpeed(cType, handler);
//    }
//
//    public void setDescendSpeed(View view) {
//        FCTest.setDescendSpeed(cType, handler);
//    }
//
//    public void getAttiModeState(View view) {
//        FCTest.getAttiModeState(cType, handler);
//    }
//
//    public void setAttiModeState(View view) {
//        FCTest.setAttiModeState(cType, handler);
//    }
//
//    public void getLedPilotLamp(View view) {
//        FCTest.getLedPilotLamp(cType, handler);
//    }
//
//    public void setLedPilotLampAllOFF(View view) {
//        FCTest.setLedPilotLamp(cType, LedPilotLamp.ALL_OFF, handler);
//    }
//
//    public void setLedPilotLampAllON(View view) {
//        FCTest.setLedPilotLamp(cType, LedPilotLamp.ALL_ON, handler);
//    }
//
//    public void setLedPilotLampBackON(View view) {
//        FCTest.setLedPilotLamp(cType, LedPilotLamp.BACK_ONLY, handler);
//    }
//
//    public void setLedPilotLampFrontON(View view) {
//        FCTest.setLedPilotLamp(cType, LedPilotLamp.FRONT_ONLY, handler);
//    }
//
//    public void getYawSenCoefficient(View view) {
//        FCTest.getYawSenCoefficient(cType, handler);
//    }
//
//    public void setYawSenCoefficient(View view) {
//        FCTest.setYawSenCoefficient(cType, handler);
//    }
//
//    public void startCalibrateCompass(View view) {
//        FCTest.startCalibrateCompass(cType);
//    }
//
//    public void setCalibrateCompassListener(View view) {
//        FCTest.setCalibrateCompassListener(handler);
//    }
//
//    public void resetCalibrateCompassListener(View view) {
//        FCTest.resetCalibrateCompassListener();
//    }
//
//    public void setFCHeightInfoListener(View view) {
//        FCTest.setFCHeightInfoListener(handler);
//    }
//
//    public void resetFCHeightInfoListener(View view) {
//        FCTest.resetFCHeightInfoListener();
//    }
//
//    public void setWarningListener(View view) {
//        FCTest.setFlyControllerWarningListener(handler);
//    }
//
//    public void resetWarningListener(View view) {
//        FCTest.resetFlyControllerWarningListener();
//    }
//
//    public void setFlyControllerListener(View view) {
//        FCTest.setFlyControllerListener(handler);
//    }
//
//    public void resetFlyControllerListener(View view) {
//        FCTest.resetFlyControllerListener(null);
//    }
//
//    private boolean isEmpty(String value) {
//        if (null == value || "".equals(value)) {
//            return true;
//        }
//        return false;
//    }
//
//    private void clearFocus() {
//        findViewById(R.id.fcMaxHeight).clearFocus();
//        requestFocus(findViewById(R.id.setBeginnerModeState));
//    }
}
