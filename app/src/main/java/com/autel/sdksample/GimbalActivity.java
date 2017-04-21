package com.autel.sdksample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.sdksample.util.GimbalTest;


public class GimbalActivity extends AppCompatActivity {
    final String TAG = getClass().getSimpleName();
//    RadioGroup group;
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
    /**
     * 1 异步 ， 2同步
     */
    int cType = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gimbal);
//        group = (RadioGroup) findViewById(R.id.type);
//        RadioButton radioGroup = (RadioButton) findViewById(R.id.async);
//        radioGroup.toggle();
//        log_output = (TextView) findViewById(R.id.gb_log_output);
//        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (R.id.async == checkedId) {
//                    cType = 1;
//                } else {
//                    cType = 2;
//                }
//            }
//        });
    }

    public void setGimbalWheelAdjustSpeed(View view) {
        GimbalTest.setGimbalWheelAdjustSpeed(handler, cType);
    }

    public void getGimbalWheelAdjustSpeed(View view) {
        GimbalTest.getGimbalWheelAdjustSpeed(handler, cType);
    }

    public void setGimbalAngleListener(View view) {
        GimbalTest.setGimbalAngleListener(handler);
    }

    public void resetGimbalAngleListener(View view) {
        GimbalTest.resetGimbalAngleListener();
    }

    public void setGimbalStateListener(View view) {
        GimbalTest.setGimbalStateListener(handler);
    }

    public void resetGimbalStateListener(View view) {
        GimbalTest.resetGimbalStateListener();
    }

    public void setGimbalAngleSpeed(View view) {
        GimbalTest.setGimbalAngleSpeed();
    }

    public void setGimbalAngle(View view) {
        GimbalTest.setGimbalAngle();
    }

    public void setGimbalWorkModeFREE(View view) {
        GimbalTest.setGimbalWorkMode(GimbalWorkMode.FREE, handler);
    }

    public void setGimbalWorkModeFPV(View view) {
        GimbalTest.setGimbalWorkMode(GimbalWorkMode.FPV, handler);
    }

    public void getGimbalWorkMode(View view) {
        GimbalTest.getGimbalWorkMode(handler);
    }

    public void setRollAdjustDataPLUS(View view) {
        GimbalTest.setRollAdjustData(GimbalRollAngleAdjust.PLUS, handler);
    }

    public void setRollAdjustDataMINUS(View view) {
        GimbalTest.setRollAdjustData(GimbalRollAngleAdjust.MINUS, handler);
    }

    public void setRollAdjustDataRESET(View view) {
        GimbalTest.setRollAdjustData(GimbalRollAngleAdjust.RESET, handler);
    }

    public void setRollAdjustDataQUERY(View view) {
        GimbalTest.setRollAdjustData(GimbalRollAngleAdjust.QUERY, handler);
    }
}
