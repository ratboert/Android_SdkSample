package com.autel.sdksample.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.battery.BatteryRecordState;
import com.autel.common.battery.BatteryStatus;
import com.autel.common.error.AutelError;
import com.autel.sdk.AModuleBattery;

import java.util.List;

/**
 * Created by A16343 on 2016/12/2.
 */
public class BatteryTest {
    private static final String TAG = "BatteryTest";


    public static void getLowBatteryThreshold(final Handler handler) {
        AModuleBattery.battery().getLowBatteryNotifyThreshold(new CallbackWithOneParam<Float>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getLowBatteryNotifyThreshold  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess(Float data) {
                logOut(handler, "getLowBatteryNotifyThreshold  data :  " + data);
            }
        });
    }

    public static void setLowBatteryNotifyThreshold(final Handler handler) {
        AModuleBattery.battery().setLowBatteryNotifyThreshold(0.25f, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setLowBatteryNotifyThreshold  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setLowBatteryNotifyThreshold   onSuccess ");
            }
        });
    }

    public static void getCriticalBatteryNotifyThreshold(final Handler handler) {
        AModuleBattery.battery().getCriticalBatteryNotifyThreshold(new CallbackWithOneParam<Float>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getCriticalBatteryNotifyThreshold  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess(Float data) {
                logOut(handler, "getCriticalBatteryNotifyThreshold  data :  " + data);
            }
        });
    }

    public static void setCriticalBatteryNotifyThreshold(final Handler handler) {
        AModuleBattery.battery().setCriticalBatteryNotifyThreshold(0.2f, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setCriticalBatteryNotifyThreshold  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setCriticalBatteryNotifyThreshold  onSuccess  " );
            }
        });
    }

    public static void getBatteryDischargeDay(final Handler handler) {
        AModuleBattery.battery().getDischargeDay(new CallbackWithOneParam<Integer>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getDischargeDay  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess(Integer data) {
                logOut(handler, "getDischargeDay  data :  " + data);
            }
        });
    }

    public static void setBatteryDischargeDay(final Handler handler) {
        AModuleBattery.battery().setDischargeDay(3, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setDischargeDay  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setDischargeDay  onSuccess :  ");
            }
        });
    }

    public static void getBatteryHistory(final Handler handler) {
        AModuleBattery.battery().getHistory(new CallbackWithOneParam<List<BatteryRecordState>>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getHistory  error :  " + error.getDescription());
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
                logOut(handler, "getHistory  data :  " + stringBuffer.toString());
            }
        });
    }

    public static void setBatteryRealTimeDataListener(final Handler handler) {
        AModuleBattery.battery().setAutelBatteryStatusListener(new CallbackWithOneParam<BatteryStatus>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setAutelBatteryStatusListener  error :  " + error.getDescription());
            }

            @Override
            public void onSuccess(BatteryStatus data) {
                logOut(handler, "setAutelBatteryStatusListener  data current battery :  " + data.getCurrent());
            }
        });
    }

    public static void resetBatteryRealTimeDataListener(Handler handler) {
        AModuleBattery.battery().setAutelBatteryStatusListener(null);
    }

//    public static void setAutelBatteryWarningListener(final Handler handler) {
//        AModuleBattery.battery().setAutelBatteryWarningListener(new CallbackWithOneParam<BatteryWarning>() {
//            @Override
//            public void onFailure(AutelError error) {
//                logOut(handler, "setAutelBatteryWarningListener  error :  " + error.getDescription());
//            }
//
//            @Override
//            public void onSuccess(BatteryWarning data) {
//                logOut(handler, "setAutelBatteryWarningListener  data :  " + data);
//            }
//        });
//    }

//    public static void resetAutelBatteryWarningListener(Handler handler) {
//        AModuleBattery.battery().setAutelBatteryWarningListener(null);
//    }

    public static void getBatteryStatus(Handler handler) {
//        String log = "serialNumber  " + AModuleBattery.battery().getSerialNumber() + "  getTemperature  " + AModuleBattery.battery().getTemperature();
//        logOut(handler, log);
    }

    /**
     * Get voltage of battery cells
     */
    public static void getCells(final Handler handler) {
        AModuleBattery.battery().getCells(new CallbackWithOneParam<int[]>() {
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
                logOut(handler, "getCells  " + sb.toString());
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getCells  " + error.getDescription());
            }
        });
    }

    /**
     * Get battery voltage (the sum of cell1 to cell4)
     */
    public static void getVoltage(final Handler handler) {
        AModuleBattery.battery().getVoltage(new CallbackWithOneParam<Double>() {
            @Override
            public void onSuccess(Double data) {
                logOut(handler, "getVoltage  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getVoltage  " + error.getDescription());
            }
        });
    }

    /**
     * Get battery capacity
     */
    public static void getCapacity(final Handler handler) {
        AModuleBattery.battery().getCapacity(new CallbackWithOneParam<Float>() {
            @Override
            public void onSuccess(Float data) {
                logOut(handler, "getCapacity  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getCapacity  " + error.getDescription());
            }
        });
    }

    /**
     * Get battery current
     */
    public static void getCurrent(final Handler handler) {
        AModuleBattery.battery().getCurrent(new CallbackWithOneParam<Float>() {
            @Override
            public void onSuccess(Float data) {
                logOut(handler, "getCurrent  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getCurrent  " + error.getDescription());
            }
        });
    }

    /**
     * Get battery temperature
     */
    public static void getTemperature(final Handler handler) {
        AModuleBattery.battery().getTemperature(new CallbackWithOneParam<Float>() {
            @Override
            public void onSuccess(Float data) {
                logOut(handler, "getTemperature  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getTemperature  " + error.getDescription());
            }
        });
    }

    /**
     * Get charged times of battery
     */
    public static void getTimesOfDischarges(final Handler handler) {
        AModuleBattery.battery().getDischargeCount(new CallbackWithOneParam<Float>() {
            @Override
            public void onSuccess(Float data) {
                logOut(handler, "getDischargeCount  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getDischargeCount  " + error.getDescription());
            }
        });
    }

    /**
     * Get full charged capacity of battery
     */
    public static void getFullChargeCapacity(final Handler handler) {
        AModuleBattery.battery().getFullChargeCapacity(new CallbackWithOneParam<Integer>() {
            @Override
            public void onSuccess(Integer data) {
                logOut(handler, "getFullChargeCapacity  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getFullChargeCapacity  " + error.getDescription());
            }
        });
    }

    /**
     * Get battery level
     */
    public static void getRemainingPercent(final Handler handler) {
        AModuleBattery.battery().getVoltage(new CallbackWithOneParam<Double>() {
            @Override
            public void onSuccess(Double data) {
                logOut(handler, "getRemainingPercent  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getRemainingPercent  " + error.getDescription());
            }
        });
    }

    /**
     * Get sn of battery
     */
    public static void getSerialNumber(final Handler handler) {
        AModuleBattery.battery().getSerialNumber(new CallbackWithOneParam<String>() {
            @Override
            public void onSuccess(String data) {
                logOut(handler, "getSerialNumber  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getSerialNumber  " + error.getDescription());
            }
        });
    }

    /**
     * Get firmware version of battery
     */
    public static void getVersion(final Handler handler) {
        AModuleBattery.battery().getVersion(new CallbackWithOneParam<String>() {
            @Override
            public void onSuccess(String data) {
                logOut(handler, "getVersion  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getVersion  " + error.getDescription());
            }
        });
    }

    /**
     * Get designed capacity of battery
     */
    public static void getDesignCap(final Handler handler) {
        AModuleBattery.battery().getDesignCapacity(new CallbackWithOneParam<Integer>() {
            @Override
            public void onSuccess(Integer data) {
                logOut(handler, "getDesignCapacity  " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getDesignCapacity  " + error.getDescription());
            }
        });
    }

//    /**
//     * 是否电池过热
//     * Tests  whether the battery is over-heated
//     */
//    public static void isOverHeated(final Handler handler) {
//        AModuleBattery.battery().isOverHeated(new CallbackWithOneParam<Boolean>() {
//            @Override
//            public void onSuccess(Boolean data) {
//                logOut(handler, "isOverHeated  " + data);
//            }
//
//            @Override
//            public void onFailure(AutelError error) {
//                logOut(handler, "isOverHeated  " + error.getDescription());
//            }
//        });
//    }


    private static void logOut(Handler handler, String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }
}
