package com.autel.sdksample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.autel.sdksample.util.DspTest;


public class DspActivity extends AppCompatActivity {
    final String TAG = getClass().getSimpleName();
//    RadioGroup group;
    private TextView dsp_log;
    private EditText dsp_set_rf_value;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String text = (String) msg.obj;
            if (null != dsp_log) {
                dsp_log.setText(text);
            }
        }
    };
    /**
     * 1 异步 ， 2同步
     */
    int cType = 1;
    private EditText ssidName;
    private EditText ssidPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsp);
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
        ssidName = (EditText) findViewById(R.id.SSIDName);
        ssidPwd = (EditText) findViewById(R.id.SSIDPwd);
        dsp_log = (TextView) findViewById(R.id.dsp_log);
        dsp_set_rf_value = (EditText) findViewById(R.id.dsp_set_rf_value);
    }

    public void setCurrentRFAStart(View v) {
        int rf = 0;
        if (!"".equals(dsp_set_rf_value.getText().toString())) {
            rf = Integer.valueOf(dsp_set_rf_value.getText().toString());
        }
        DspTest.setCurrentRFStart(rf, handler);
    }

    public void setCurrentRFACancel(View v) {
        DspTest.setCurrentRFCancel(handler);
    }


    public void getCurrentRFStart(View v) {
        DspTest.getCurrentRFStart(handler);
    }

    public void getCurrentRFCancel(View v) {
        DspTest.getCurrentRFCancel(handler);
    }

    public void getRFListStart(View v) {
        DspTest.getRFListStart(handler);
    }

    public void getRFListCancel(View v) {
        DspTest.getRFListCancel(handler);
    }

    public void updateNewSSIDInfo(View v) {
        DspTest.updateNewSSIDInfo(handler, ssidName.getText().toString(), ssidPwd.getText().toString());
    }

    public void getCurrentSSIDInfo(View v) {
        DspTest.getCurrentSSIDInfo(handler);
    }
}
