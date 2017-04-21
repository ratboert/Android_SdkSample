package com.autel.sdksample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.autel.sdksample.util.BatteryTest;


public class BatteryActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_battery);
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
//            }
//        });
    }

    public void getLowBatteryThreshold(View view) {
        BatteryTest.getLowBatteryThreshold(handler);
    }

    public void setLowBatteryNotifyThreshold(View view) {
        BatteryTest.setLowBatteryNotifyThreshold(handler);
    }

    public void getCriticalBatteryNotifyThreshold(View view) {
        BatteryTest.getCriticalBatteryNotifyThreshold(handler);
    }

    public void setCriticalBatteryNotifyThreshold(View view) {
        BatteryTest.setCriticalBatteryNotifyThreshold(handler);
    }

    public void getBatteryDischargeDay(View view) {
        BatteryTest.getBatteryDischargeDay(handler);
    }

    public void setBatteryDischargeDay(View view) {
        BatteryTest.setBatteryDischargeDay(handler);
    }

    public void getBatteryHistory(View view) {
        BatteryTest.getBatteryHistory(handler);
    }

    public void setBatteryRealTimeDataListener(View view) {
        BatteryTest.setBatteryRealTimeDataListener(handler);
    }

    public void resetBatteryRealTimeDataListener(View view) {
        BatteryTest.resetBatteryRealTimeDataListener(handler);
    }

//    public void setAutelBatteryWarningListener(View view) {
//        BatteryTest.setAutelBatteryWarningListener(handler);
//    }
//
//    public void resetAutelBatteryWarningListener(View view) {
//        BatteryTest.resetAutelBatteryWarningListener(handler);
//    }

//    public void getBatteryStatus(View view) {
//        BatteryTest.getBatteryStatus(handler);
//    }

    /**
     * Get voltage of battery cells
     */
    public void getCells(View view) {
        BatteryTest.getCells(handler);
    }

    /**
     * Get battery voltage (the sum of cell1 to cell4)
     */
    public void getVoltage(View view) {
        BatteryTest.getVoltage(handler);
    }

    /**
     * Get battery capacity
     */
    public void getCapacity(View view) {
        BatteryTest.getCapacity(handler);
    }

    /**
     * Get battery current
     */
    public void getCurrent(View view) {
        BatteryTest.getCurrent(handler);
    }

    /**
     * Get battery temperature
     */
    public void getTemperature(View view) {
        BatteryTest.getTemperature(handler);
    }

    /**
     * Get charged times of battery
     */
    public void getTimesOfDischarges(View view) {
        BatteryTest.getTimesOfDischarges(handler);
    }

    /**
     * Get full charged capacity of battery
     */
    public void getFullChargeCapacity(View view) {
        BatteryTest.getFullChargeCapacity(handler);
    }

    /**
     * Get battery level
     */
    public void getRemainingPercent(View view) {
        BatteryTest.getRemainingPercent(handler);
    }

    /**
     * Get sn of battery
     */
    public void getSerialNumber(View view) {
        BatteryTest.getSerialNumber(handler);
    }

    /**
     * Get firmware version of battery
     */
    public void getVersion(View view) {
        BatteryTest.getVersion(handler);
    }

    /**
     * Get designed capacity of battery
     */
    public void getDesignCap(View view) {
        BatteryTest.getDesignCap(handler);
    }

//    /**
//     * 是否电池过热
//     * Tests  whether the battery is over-heated
//     */
//    public void isOverHeated(View view) {
//        BatteryTest.isOverHeated(handler);
//    }
}
