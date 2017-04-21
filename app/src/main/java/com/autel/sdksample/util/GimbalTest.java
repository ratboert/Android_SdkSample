package com.autel.sdksample.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalState;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.sdk.AModuleGimbal;

/**
 * Created by A16343 on 2016/12/6.
 */
public class GimbalTest {
    private static final String TAG = "GimbalTest";

    public static void setGimbalAngleListener(final Handler handler) {
        AModuleGimbal.gimbal().setGimbalAngleListener(new CallbackWithOneParam<Integer>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setGimbalAngleListener error " + error.getDescription());
            }

            @Override
            public void onSuccess(Integer angle) {
                logOut(handler, "setGimbalAngleListener angle   " + angle);
            }
        });
    }

    public static void resetGimbalAngleListener() {
        AModuleGimbal.gimbal().setGimbalAngleListener(null);
    }

    public static void setGimbalStateListener(final Handler handler) {
        AModuleGimbal.gimbal().setGimbalStateListener(new CallbackWithOneParam<GimbalState>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setGimbalStateListener error " + error.getDescription());
            }

            @Override
            public void onSuccess(GimbalState result) {
                logOut(handler, "setGimbalStateListener result   " + result);
            }
        });
    }

    public static void resetGimbalStateListener() {
        AModuleGimbal.gimbal().setGimbalStateListener(null);
    }

    public static void setGimbalAngleSpeed() {
        AModuleGimbal.gimbal().setGimbalAngleWithFineTuning(-10);
    }

    public static void setGimbalAngle() {
        AModuleGimbal.gimbal().setGimbalAngle(0);
    }

    public static void setGimbalWorkMode(GimbalWorkMode mode, final Handler handler) {
        AModuleGimbal.gimbal().setGimbalWorkMode(mode, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setGimbalWorkMode error " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setGimbalWorkMode result   onSuccess");
            }
        });
    }

    public static void getGimbalWorkMode(final Handler handler) {
        AModuleGimbal.gimbal().getGimbalWorkMode(new CallbackWithOneParam<GimbalWorkMode>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "getGimbalWorkMode error " + error.getDescription());
            }

            @Override
            public void onSuccess(GimbalWorkMode data) {
                logOut(handler, "getGimbalWorkMode data " + data);
            }
        });
    }

    public static void setRollAdjustData(GimbalRollAngleAdjust adjustData, final Handler handler) {
        AModuleGimbal.gimbal().setRollAdjustData(adjustData, new CallbackWithOneParam<Double>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setRollAdjustData error " + error.getDescription());
            }

            @Override
            public void onSuccess(Double data) {
                logOut(handler, "setRollAdjustData data " + data);
            }
        });
    }

    public static void setGimbalWheelAdjustSpeed(final Handler handler, int cType) {
        if (cType == 1) {
            AModuleGimbal.gimbal().setGimbalDialAdjustSpeed(50, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "setGimbalDialAdjustSpeed RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setGimbalDialAdjustSpeed onSuccess ");
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    GimbalWheelAdjustSpeedResult result = AModuleRemoteController.sync().setGimbalDialAdjustSpeed(60);
//                    if (null != result.getRcError()) {
//                        logOut(handler, "setGimbalDialAdjustSpeed RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "setGimbalDialAdjustSpeed onSuccess " + result.getGimbalWheelAjustSpeed());
//                    }
//                }
//            }.start();
        }

    }

    public static void getGimbalWheelAdjustSpeed(final Handler handler,int cType) {
        if (cType == 1) {
            AModuleGimbal.gimbal().getGimbalDialAdjustSpeed(new CallbackWithOneParam<Integer>() {
                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "getGimbalDialAdjustSpeed RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess(Integer speed) {
                    logOut(handler, "getGimbalDialAdjustSpeed onSuccess " + speed);
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    GimbalWheelAdjustSpeedResult result = AModuleRemoteController.sync().getGimbalDialAdjustSpeed();
//                    if (null != result.getRcError()) {
//                        logOut(handler, "setGimbalDialAdjustSpeed RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "setGimbalDialAdjustSpeed onSuccess " + result.getGimbalWheelAjustSpeed());
//                    }
//                }
//            }.start();
        }
    }

//    public static void getRollAdjust(final Handler handler) {
//        logOut(handler, "getRollAdjust " + AModuleGimbal.gimbal().getRollAdjust());
//    }
//
//    public static void getRoll(final Handler handler) {
//        logOut(handler, "getRoll " + AModuleGimbal.gimbal().getRoll());
//    }
//
//    public static void getPitch(final Handler handler) {
//        logOut(handler, "getPitch " + AModuleGimbal.gimbal().getPitch());
//    }
//
//    public static void getYaw(final Handler handler) {
//        logOut(handler, "getYaw " + AModuleGimbal.gimbal().getYaw());
//    }

    private static void logOut(Handler handler, String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }
}
