package com.autel.sdksample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.autel.common.flycontroller.AircraftActivateState;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.sdksample.util.FCTest;


public class FlyControllerActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_fc);
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

        requestFocus(findViewById(R.id.setBeginnerModeState));
    }

    public void setBeginnerModeState(View view) {
        FCTest.setBeginnerModeState(handler, cType);
    }

    public void getBeginnerModeState(View view) {
        FCTest.getBeginnerModeState(handler, cType);
    }

    public void restoreSDLogFrequency(View view) {
        FCTest.restoreSDLogFrequency(cType);
    }

    public void getMaxHeight(View view) {
        FCTest.getMaxHeight(handler, cType);
    }

    public void setMaxHeight(View view) {
        String value = ((EditText) findViewById(R.id.fcMaxHeight)).getText().toString();

        FCTest.setMaxHeight(isEmpty(value) ? 80 : Integer.valueOf(value), handler);
    }

    public void getMaxRange(View view) {
        FCTest.getMaxRange(cType, handler);
    }

    public void setMaxRange(View view) {
        FCTest.setMaxRange(cType, handler);
    }

    public void getReturnRange(View view) {
        FCTest.getReturnHeight(cType, handler);
    }

    public void setReturnRange(View view) {
        FCTest.setReturnRange(cType, handler);
    }

    public void getHorizontalSpeed(View view) {
        FCTest.getHorizontalSpeed(cType, handler);
    }

    public void setHorizontalSpeed(View view) {
        FCTest.setHorizontalSpeed(cType, handler);
    }

    public void getAscendSpeed(View view) {
        FCTest.getAscendSpeed(cType, handler);
    }

    public void setAscendSpeed(View view) {
        FCTest.setAscendSpeed(cType, handler);
    }

    public void getDescendSpeed(View view) {
        FCTest.getDescendSpeed(cType, handler);
    }

    public void setDescendSpeed(View view) {
        FCTest.setDescendSpeed(cType, handler);
    }

    public void getAttiModeState(View view) {
        FCTest.getAttiModeState(cType, handler);
    }

    public void setAttiModeState(View view) {
        FCTest.setAttiModeState(cType, handler);
    }

    public void getLedPilotLamp(View view) {
        FCTest.getLedPilotLamp(cType, handler);
    }

    public void setLedPilotLampAllOFF(View view) {
        FCTest.setLedPilotLamp(cType, LedPilotLamp.ALL_OFF, handler);
    }

    public void setLedPilotLampAllON(View view) {
        FCTest.setLedPilotLamp(cType, LedPilotLamp.ALL_ON, handler);
    }

    public void setLedPilotLampBackON(View view) {
        FCTest.setLedPilotLamp(cType, LedPilotLamp.BACK_ONLY, handler);
    }

    public void setLedPilotLampFrontON(View view) {
        FCTest.setLedPilotLamp(cType, LedPilotLamp.FRONT_ONLY, handler);
    }

    public void getYawSenCoefficient(View view) {
        FCTest.getYawSenCoefficient(cType, handler);
    }

    public void setYawSenCoefficient(View view) {
        FCTest.setYawSenCoefficient(cType, handler);
    }

    public void startCalibrateCompass(View view) {
        FCTest.startCalibrateCompass(cType);
    }

    public void setCalibrateCompassListener(View view) {
        FCTest.setCalibrateCompassListener(handler);
    }

    public void resetCalibrateCompassListener(View view) {
        FCTest.resetCalibrateCompassListener();
    }

    public void setFCHeightInfoListener(View view) {
        FCTest.setFCHeightInfoListener(handler);
    }

    public void resetFCHeightInfoListener(View view) {
        FCTest.resetFCHeightInfoListener();
    }

    public void setWarningListener(View view) {
        FCTest.setFlyControllerWarningListener(handler);
    }

    public void resetWarningListener(View view) {
        FCTest.resetFlyControllerWarningListener();
    }

    public void setFlyControllerListener(View view) {
        FCTest.setFlyControllerListener(handler);
    }

    public void resetFlyControllerListener(View view) {
        FCTest.resetFlyControllerListener(null);
    }

    private boolean isEmpty(String value) {
        if (null == value || "".equals(value)) {
            return true;
        }
        return false;
    }

    private void clearFocus() {
        findViewById(R.id.fcMaxHeight).clearFocus();
        requestFocus(findViewById(R.id.setBeginnerModeState));
    }

    private void requestFocus(View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }
}
