package com.autel.sdksample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.autel.sdksample.util.FirmwareTest;


public class FirmwareActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_firmware);
//        group = (RadioGroup) findViewById(R.id.type);
//        log_output = (TextView) findViewById(R.id.fw_log_output);
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

    public void getAutelAircraftComponentVersion(View view) {
        FirmwareTest.getAutelAircraftComponentVersion(handler);
    }

    public void getAutelAircraftComponentSerialNumberVersion(View view) {
        FirmwareTest.getAutelAircraftComponentSerialNumberVersion(handler);
    }

    public void getAutelRCVersion(View view) {
        FirmwareTest.getAutelRCVersion(handler);
    }

    public void getAutelRCSerialNumberVersion(View view) {
        FirmwareTest.getAutelRCSerialNumberVersion(handler);
    }
}
