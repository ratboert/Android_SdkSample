package com.autel.sdksample;

import android.view.View;
import android.widget.EditText;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.BatteryRecordState;
import com.autel.common.battery.BatteryStatus;
import com.autel.common.error.AutelError;
import com.autel.sdk.AModuleBattery;
import com.autel.sdk.battery.AutelBattery;

import java.util.List;


public class BatteryActivity extends BaseActivity {
    private AutelBattery autelBattery;

    private EditText lowBatteryNotifyThreshold;
    private EditText criticalBatteryNotifyThreshold;
    private EditText dischargeDay;

    @Override
    protected void initOnCreate() {
        setContentView(R.layout.activity_battery);
        autelBattery = AModuleBattery.battery();
        lowBatteryNotifyThreshold = (EditText) findViewById(R.id.lowBatteryNotifyThreshold);
        criticalBatteryNotifyThreshold = (EditText) findViewById(R.id.criticalBatteryNotifyThreshold);
        dischargeDay = (EditText) findViewById(R.id.dischargeDay);

    }

    public void getLowBatteryNotifyThreshold(View view) {
        autelBattery.getLowBatteryNotifyThreshold(new CallbackWithOneParam<Float>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getLowBatteryNotifyThreshold  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess(Float data) {
                logOut("getLowBatteryNotifyThreshold  data :  " + data);
            }
        });
    }

    public void setLowBatteryNotifyThreshold(View view) {
        String value = lowBatteryNotifyThreshold.getText().toString();
        autelBattery.setLowBatteryNotifyThreshold(isEmpty(value) ? 0.25f : Float.valueOf(value), new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setLowBatteryNotifyThreshold  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setLowBatteryNotifyThreshold   onSuccess ");
            }
        });
    }

    public void getCriticalBatteryNotifyThreshold(View view) {
        autelBattery.getCriticalBatteryNotifyThreshold(new CallbackWithOneParam<Float>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getCriticalBatteryNotifyThreshold  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess(Float data) {
                logOut("getCriticalBatteryNotifyThreshold  data :  " + data);
            }
        });
    }

    public void setCriticalBatteryNotifyThreshold(View view) {
        String value = criticalBatteryNotifyThreshold.getText().toString();
        autelBattery.setCriticalBatteryNotifyThreshold(isEmpty(value) ? 0.25f : Float.valueOf(value), new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setCriticalBatteryNotifyThreshold  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setCriticalBatteryNotifyThreshold  onSuccess  ");
            }
        });
    }

    public void getDischargeDay(View view) {
        autelBattery.getDischargeDay(new CallbackWithOneParam<Integer>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getDischargeDay  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess(Integer data) {
                logOut("getDischargeDay  data :  " + data);
            }
        });
    }

    public void setDischargeDay(View view) {
        String value = dischargeDay.getText().toString();
        autelBattery.setDischargeDay(isEmpty(value) ? 2 : Integer.valueOf(value), new CallbackWithNoParam() {
            @Override
            public void onSuccess() {

                logOut("setDischargeDay  onSuccess  ");
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("setDischargeDay  error :  " + autelError.getDescription());
            }
        });
    }

    public void getHistory(View view) {
        autelBattery.getHistory(new CallbackWithOneParam<List<BatteryRecordState>>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getHistory  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess(List<BatteryRecordState> data) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < data.size(); i++) {
                    stringBuffer.append(i);
                    stringBuffer.append(" = ");
                    stringBuffer.append(data.get(i));
                    stringBuffer.append(";");
                }
                logOut("getHistory  data :  " + stringBuffer.toString());
            }
        });
    }

    /**
     * Get voltage of battery cells
     */
    public void getCells(View view) {
        autelBattery.getCells(new CallbackWithOneParam<int[]>() {
            @Override
            public void onSuccess(int[] data) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < data.length; i++) {
                    sb.append("index ");
                    sb.append(i);
                    sb.append(" = ");
                    sb.append(data[i]);
                    sb.append("   ");
                }
                logOut("getCells  " + sb.toString());
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getCells  " + error.getDescription());
            }
        });
    }

    /**
     * Get battery voltage (the sum of cell1 to cell4)
     */
    public void getVoltage(View view) {
        autelBattery.getVoltage(new CallbackWithOneParam<Double>() {
            @Override
            public void onSuccess(Double data) {
                logOut("getVoltage  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getVoltage  " + error.getDescription());
            }
        });
    }

    /**
     * Get battery capacity
     */
    public void getCapacity(View view) {
        autelBattery.getCapacity(new CallbackWithOneParam<Float>() {
            @Override
            public void onSuccess(Float data) {
                logOut("getCapacity  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getCapacity  " + error.getDescription());
            }
        });
    }

    /**
     * Get battery current
     */
    public void getCurrent(View view) {
        autelBattery.getCurrent(new CallbackWithOneParam<Float>() {
            @Override
            public void onSuccess(Float data) {
                logOut("getCurrent  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getCurrent  " + error.getDescription());
            }
        });
    }
    /**
     * Get battery temperature
     */
    public void getTemperature(View view) {
        autelBattery.getTemperature(new CallbackWithOneParam<Float>() {
            @Override
            public void onSuccess(Float data) {
                logOut("getTemperature  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getTemperature  " + error.getDescription());
            }
        });
    }

    /**
     * Get charged times of battery
     */
    public void getDischargeCount(View view) {
        autelBattery.getDischargeCount(new CallbackWithOneParam<Float>() {
            @Override
            public void onSuccess(Float data) {
                logOut("getDischargeCount  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getDischargeCount  " + error.getDescription());
            }
        });
    }


    /**
     * Get full charged capacity of battery
     */
    public void getFullChargeCapacity(View view) {
        autelBattery.getFullChargeCapacity(new CallbackWithOneParam<Integer>() {
            @Override
            public void onSuccess(Integer data) {
                logOut("getFullChargeCapacity  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getFullChargeCapacity  " + error.getDescription());
            }
        });
    }

    /**
     * Get battery level
     */
    public void getRemainingPercent(View view) {
        autelBattery.getVoltage(new CallbackWithOneParam<Double>() {
            @Override
            public void onSuccess(Double data) {
                logOut("getRemainingPercent  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getRemainingPercent  " + error.getDescription());
            }
        });
    }

    /**
     * Get sn of battery
     */
    public void getSerialNumber(View view) {
        autelBattery.getSerialNumber(new CallbackWithOneParam<String>() {
            @Override
            public void onSuccess(String data) {
                logOut("getSerialNumber  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getSerialNumber  " + error.getDescription());
            }
        });
    }

    /**
     * Get firmware version of battery
     */
    public void getVersion(View view) {
        autelBattery.getVersion(new CallbackWithOneParam<String>() {
            @Override
            public void onSuccess(String data) {
                logOut("getVersion  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getVersion  " + error.getDescription());
            }
        });
    }


    /**
     * Get designed capacity of battery
     */
    public void getDesignCapacity(View view) {
        autelBattery.getDesignCapacity(new CallbackWithOneParam<Integer>() {
            @Override
            public void onSuccess(Integer data) {
                logOut("getDesignCapacity  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("getDesignCapacity  " + error.getDescription());
            }
        });
    }

    public void setBatteryRealTimeDataListener(View view) {
        autelBattery.setAutelBatteryStatusListener(new CallbackWithOneParam<BatteryStatus>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setAutelBatteryStatusListener  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess(BatteryStatus data) {
                logOut("setAutelBatteryStatusListener  data current battery :  " + data);
            }
        });
    }

    public void resetBatteryRealTimeDataListener(View view) {
        autelBattery.setAutelBatteryStatusListener(null);
    }














//    /**
//     * 是否电池过热
//     * Tests  whether the battery is over-heated
//     */
//    public void isOverHeated(View view) {
//        BatteryTest.isOverHeated(handler);
//    }
}
