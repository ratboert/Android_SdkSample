package com.autel.sdksample.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.FlyControllerInfo;
import com.autel.common.flycontroller.BeginnerMode;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.sdk.AModuleFlyController;
import com.autel.sdk.AModuleRemoteController;

/**
 * Created by A16343 on 2016/11/11.
 */
public class FCTest {
    private final static String TAG = "FCTest";
    private static boolean attiEnable = false;

    public static void setBeginnerModeState(final Handler handler, int cType) {
        if (cType == 1) {
            AModuleFlyController.flyController().setBeginnerModeState(BeginnerMode.ENABLED, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "setBeginnerModeState AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setBeginnerModeState onSuccess ");
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    FCBeginnerModeResult result = AModuleFlyController.sync().setBeginnerMode(BeginnerMode.DISABLED);
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "setBeginnerMode AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "setBeginnerMode onSuccess " + result.getAutelBeginnerMode());
//                    }
//                }
//            }.start();
        }
    }

    public static void getBeginnerModeState(final Handler handler, int cType) {
        if (cType == 1) {
            AModuleFlyController.flyController().getBeginnerModeState(new CallbackWithOneParam<BeginnerMode>() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "getBeginnerModeState AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess(BeginnerMode autelBeginnerMode) {
                    logOut(handler, "getBeginnerModeState onSuccess " + autelBeginnerMode);
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    FCBeginnerModeResult result = AModuleFlyController.sync().getBeginnerModeState();
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "getBeginnerModeState AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "getBeginnerModeState onSuccess " + result.getAutelBeginnerMode());
//                    }
//                }
//            }.start();
        }
    }

    public static void restoreSDLogFrequency(int cType) {
//        if (cType == 1) {
//            AModuleFlyController.flyController().restoreSDLogFrequency(new FCRestoreSDLogFrequencyCallback() {
//                @Override
//                public void onFailure(AutelError flycontrollerError) {
//                   logOut(handler, "restoreSDLogFrequency AutelError " + flycontrollerError);
//                }
//
//                @Override
//                public void onSuccess(int frequencySDLog) {
//                   logOut(handler, "restoreSDLogFrequency onSuccess " + frequencySDLog);
//                }
//
//
//            });
//        } else {
//            new Thread() {
//                public void run() {
//                    FCSDLogFrequencyResult result = AModuleFlyController.sync().restoreSDLogFrequency();
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "restoreSDLogFrequency AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "restoreSDLogFrequency onSuccess " + result.getFrequencySDLog());
//                    }
//                }
//            }.start();
//        }
    }

    public static void getMaxHeight(final Handler handler, int cType) {
        if (cType == 1) {
            AModuleFlyController.flyController().getMaxHeight(new CallbackWithOneParam<Float>() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "getMaxHeight AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess(Float maxHeight) {
                    logOut(handler, "getMaxHeight  " + maxHeight);
                }


            });
        } else {
//            new Thread() {
//                public void run() {
//                    FCMaxHeightResult result = AModuleFlyController.sync().getMaxHeight();
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "getMaxHeight AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "getMaxHeight onSuccess " + result.getMaxHeight());
//                    }
//                }
//            }.start();
        }
    }

    public static void setMaxHeight(int height, final Handler handler) {
        AModuleFlyController.flyController().setMaxHeight(height, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError flycontrollerError) {
                logOut(handler, "setMaxHeight AutelError " + flycontrollerError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut(handler, "setMaxHeight onSuccess ");
            }


        });
    }

    public static void setMaxRange(int cType, final Handler handler) {
        if (cType == 1) {
            AModuleFlyController.flyController().setMaxRange(50, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "setMaxRange AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setMaxRange onSuccess ");
                }


            });
        } else {
//            new Thread() {
//                public void run() {
//                    FCMaxRangeResult result = AModuleFlyController.sync().setMaxRange(60);
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "setMaxRange AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "setMaxRange onSuccess " + result.getMaxRange());
//                    }
//                }
//            }.start();
        }
    }

    public static void getMaxRange(int cType, final Handler handler) {
        if (cType == 1) {
            AModuleFlyController.flyController().getMaxRange(new CallbackWithOneParam<Float>() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "getMaxRange AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess(Float maxRange) {
                    logOut(handler, "getMaxRange onSuccess " + maxRange);
                }


            });
        } else {
//            new Thread() {
//                public void run() {
//                    FCMaxRangeResult result = AModuleFlyController.sync().getMaxRange();
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "getMaxRange AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "getMaxRange onSuccess " + result.getMaxRange());
//                    }
//                }
//            }.start();
        }
    }

    public static void getReturnHeight(int cType, final Handler handler) {
        if (cType == 1) {
            AModuleFlyController.flyController().getReturnHeight(new CallbackWithOneParam<Float>() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "getReturnHeight AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess(Float returnHeight) {
                    logOut(handler, "getReturnHeight onSuccess " + returnHeight);
                }


            });
        } else {
//            new Thread() {
//                public void run() {
//                    FCReturnHeightResult result = AModuleFlyController.sync().getReturnHeight();
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "getReturnHeight AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "getReturnHeight onSuccess " + result.getReturnHeight());
//                    }
//                }
//            }.start();
        }
    }

    public static void setReturnRange(int cType, final Handler handler) {
        if (cType == 1) {
            AModuleFlyController.flyController().setReturnHeight(50, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "setReturnHeight AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setReturnHeight onSuccess ");
                }


            });
        } else {
//            new Thread() {
//                public void run() {
//                    FCReturnHeightResult result = AModuleFlyController.sync().setReturnHeight(60);
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "setReturnHeight AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "setReturnHeight onSuccess " + result.getReturnHeight());
//                    }
//                }
//            }.start();
        }
    }

    public static void getHorizontalSpeed(int cType, final Handler handler) {
        if (cType == 1)
            AModuleFlyController.flyController().getHorizontalSpeed(new CallbackWithOneParam<Float>() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "getHorizontalSpeed AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess(Float horizontalSpeed) {
                    logOut(handler, "getHorizontalSpeed onSuccess " + horizontalSpeed);
                }

            });
        else {
//            new Thread() {
//                public void run() {
//                    FCHorizontalSpeedResult result = AModuleFlyController.sync().getHorizontalSpeed();
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "getHorizontalSpeed AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "getHorizontalSpeed onSuccess " + result.getHorizontalSpeed());
//                    }
//                }
//            }.start();
        }
    }

    public static void setHorizontalSpeed(int cType, final Handler handler) {
        if (cType == 1)
            AModuleFlyController.flyController().setHorizontalSpeed(50, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "setHorizontalSpeed AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setHorizontalSpeed onSuccess ");
                }

            });
        else {
//            new Thread() {
//                public void run() {
//                    FCHorizontalSpeedResult result = AModuleFlyController.sync().setHorizontalSpeed(60);
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "setHorizontalSpeed AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "setHorizontalSpeed onSuccess " + result.getHorizontalSpeed());
//                    }
//                }
//            }.start();
        }
    }

    public static void getAscendSpeed(int cType, final Handler handler) {
        if (cType == 1)
            AModuleFlyController.flyController().getAscendSpeed(new CallbackWithOneParam<Float>() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "getAscendSpeed AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess(Float horizontalSpeed) {
                    logOut(handler, "getAscendSpeed onSuccess " + horizontalSpeed);
                }

            });
        else {
//            new Thread() {
//                public void run() {
//                    FCAscendSpeedResult result = AModuleFlyController.sync().getAscendSpeed();
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "getAscendSpeed AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "getAscendSpeed onSuccess " + result.getAscendSpeed());
//                    }
//                }
//            }.start();
        }
    }

    public static void setAscendSpeed(int cType, final Handler handler) {
        if (cType == 1)
            AModuleFlyController.flyController().setAscendSpeed(30, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "setAscendSpeed AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setAscendSpeed onSuccess ");
                }

            });
        else {
//            new Thread() {
//                public void run() {
//                    FCAscendSpeedResult result = AModuleFlyController.sync().setAscendSpeed(40);
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "setAscendSpeed AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "setAscendSpeed onSuccess " + result.getAscendSpeed());
//                    }
//                }
//            }.start();
        }
    }

    public static void getDescendSpeed(int cType, final Handler handler) {
        if (cType == 1)
            AModuleFlyController.flyController().getDescendSpeed(new CallbackWithOneParam<Float>() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "getDescendSpeed AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess(Float horizontalSpeed) {
                    logOut(handler, "getDescendSpeed onSuccess " + horizontalSpeed);
                }

            });
        else {
//            new Thread() {
//                public void run() {
//                    FCDescendSpeedResult result = AModuleFlyController.sync().getDescendSpeed();
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "getDescendSpeed AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "getDescendSpeed onSuccess " + result.getDescendSpeed());
//                    }
//                }
//            }.start();
        }
    }

    public static void setDescendSpeed(int cType, final Handler handler) {
        if (cType == 1)
            AModuleFlyController.flyController().setDescendSpeed(30, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "setDescendSpeed AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setDescendSpeed onSuccess ");
                }

            });
        else {
//            new Thread() {
//                public void run() {
//                    FCDescendSpeedResult result = AModuleFlyController.sync().setDescendSpeed(40);
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "setAscendSpeed AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "setAscendSpeed onSuccess " + result.getDescendSpeed());
//                    }
//                }
//            }.start();
        }
    }

    public static void getAttiModeState(int cType, final Handler handler) {
        if (cType == 1)
            AModuleFlyController.flyController().isAttitudeModeEnable(new CallbackWithOneParam<Boolean>() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "isAttitudeModeEnable AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess(Boolean result) {
                    attiEnable = result;
                    logOut(handler, "isAttitudeModeEnable onSuccess " + result);
                }
            });
        else {
//            new Thread() {
//                public void run() {
//                    FCAttiModeSwitchResult result = AModuleFlyController.sync().isAttitudeModeEnable();
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "isAttitudeModeEnable AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "isAttitudeModeEnable onSuccess " + result.getAttiModeSwitch());
//                    }
//                }
//            }.start();
        }
    }

    public static void setAttiModeState(int cType, final Handler handler) {
        if (cType == 1)
            AModuleFlyController.flyController().setAttitudeModeEnable(!attiEnable, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "setAttitudeModeEnable AutelError " + flycontrollerError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setAttitudeModeEnable onSuccess ");
                }

            });
        else {
//            new Thread() {
//                public void run() {
//                    FCAttiModeSwitchResult result = AModuleFlyController.sync().setAttitudeModeEnable(AttitudeMode.DISABLED);
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "setAttitudeModeEnable AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "setAttitudeModeEnable onSuccess " + result.getAttiModeSwitch());
//                    }
//                }
//            }.start();
        }
    }

    public static void getLedPilotLamp(int cType, final Handler handler) {
        if (cType == 1)
            AModuleFlyController.flyController().getLedPilotLamp(new CallbackWithOneParam<LedPilotLamp>() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "getLedPilotLamp AutelError " + flycontrollerError);
                }

                @Override
                public void onSuccess(LedPilotLamp ledPilotLamp) {
                    logOut(handler, "getLedPilotLamp onSuccess " + ledPilotLamp);
                }
            });
        else {
//            new Thread() {
//                public void run() {
//                    FCLedPilotLampResult result = AModuleFlyController.sync().getLedPilotLamp();
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "getLedPilotLamp AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "getLedPilotLamp onSuccess " + result.getLedPilotLamp());
//                    }
//                }
//            }.start();
        }
    }

    public static void setLedPilotLamp(int cType, final LedPilotLamp ledPilotLamp, final Handler handler) {
        if (cType == 1)
            AModuleFlyController.flyController().setLedPilotLamp(ledPilotLamp, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "setLedPilotLamp AutelError " + flycontrollerError);
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setLedPilotLamp onSuccess ");
                }
            });
        else {
//            new Thread() {
//                public void run() {
//                    FCLedPilotLampResult result = AModuleFlyController.sync().setLedPilotLamp(ledPilotLamp);
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "setLedPilotLamp AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "setLedPilotLamp onSuccess " + result.getLedPilotLamp());
//                    }
//                }
//            }.start();
        }
    }

    public static void getYawSenCoefficient(int cType, final Handler handler) {
        if (cType == 1)
            AModuleRemoteController.remoteController().getYawCoefficient(new CallbackWithOneParam<Double>() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "getYawCoefficient AutelError " + flycontrollerError);
                }

                @Override
                public void onSuccess(Double senCoeFfi) {
                    logOut(handler, "getYawCoefficient onSuccess " + senCoeFfi);
                }
            });
        else {
//            new Thread() {
//                public void run() {
//                    FCYawSenCoefficientResult result = AModuleFlyController.sync().getYawCoefficient();
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "getYawCoefficient AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "getYawCoefficient onSuccess " + result.getYawSenCoe());
//                    }
//                }
//            }.start();
        }
    }

    public static void setYawSenCoefficient(int cType, final Handler handler) {
        if (cType == 1)
            AModuleRemoteController.remoteController().setYawCoefficient(0.3f, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError flycontrollerError) {
                    logOut(handler, "setYawCoefficient AutelError " + flycontrollerError);
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setYawCoefficient onSuccess ");
                }
            });
        else {
//            new Thread() {
//                public void run() {
//                    FCYawSenCoefficientResult result = AModuleFlyController.sync().setYawCoefficient(0.5f);
//                    if (null != result.getAutelError()) {
//                       logOut(handler, "setYawCoefficient AutelError " + result.getAutelError());
//                    } else {
//                       logOut(handler, "setYawCoefficient onSuccess " + result.getYawSenCoe());
//                    }
//                }
//            }.start();
        }
    }

    public static void startCalibrateCompass(int cType) {
        if (cType == 1)
            AModuleFlyController.flyController().startCalibrateCompass();
        else {
//            new Thread() {
//                public void run() {
//                    AModuleFlyController.sync().startCalibrateCompass();
//                }
//            }.start();
        }
    }

    public static void setCalibrateCompassListener(final Handler handler) {
        AModuleFlyController.flyController().setCalibrateCompassListener(new CallbackWithOneParam<CalibrateCompassStatus>() {
            @Override
            public void onFailure(AutelError flycontrollerError) {
                logOut(handler, "setCalibrateCompassListener " + flycontrollerError.getDescription());
            }

            @Override
            public void onSuccess(CalibrateCompassStatus result) {
                logOut(handler, "setCalibrateCompassListener onSuccess " + result);
            }
        });
    }

    public static void resetCalibrateCompassListener() {
        AModuleFlyController.flyController().setCalibrateCompassListener(null);
    }

//    public static void setGPSInfoListener(final Handler handler) {
//        AModuleFlyController.flyController().setGPSInfoListener(new CallbackWithOneParam<GPSInfo>() {
//            @Override
//            public void onFailure(AutelError flycontrollerError) {
//
//            }
//
//            @Override
//            public void onSuccess(GPSInfo result) {
//               logOut(handler, "setGPSInfoListener onSuccess " + result);
//            }
//
//        });
//    }
//
//    public static void resetGPSInfoListener() {
//        AModuleFlyController.flyController().setGPSInfoListener(null);
//    }
//
//    public static void setAttitudeInfoListener(final Handler handler) {
//        AModuleFlyController.flyController().setAttitudeInfoListener(new CallbackWithOneParam<AttitudeInfo>() {
//            @Override
//            public void onFailure(AutelError flycontrollerError) {
//
//            }
//
//            @Override
//            public void onSuccess(AttitudeInfo result) {
//               logOut(handler, "setAttitudeInfoListener onSuccess " + result);
//            }
//        });
//    }
//
//    public static void resetAttitudeInfoListener() {
//        AModuleFlyController.flyController().setAttitudeInfoListener(null);
//    }
//
//    public static void setAltitudeAndSpeedInfoListener(final Handler handler) {
//        AModuleFlyController.flyController().setAltitudeAndSpeedInfoListener(new CallbackWithOneParam<AltitudeAndSpeedInfo>() {
//            @Override
//            public void onFailure(AutelError flycontrollerError) {
//
//            }
//
//            @Override
//            public void onSuccess(AltitudeAndSpeedInfo result) {
//               logOut(handler, "setAltitudeAndSpeedInfoListener onSuccess " + result);
//            }
//        });
//    }
//
//    public static void resetAltitudeAndSpeedInfoListener() {
//        AModuleFlyController.flyController().setAltitudeAndSpeedInfoListener(null);
//    }
//
//    public static void setHomeInfoListener(final Handler handler) {
//        AModuleFlyController.flyController().setHomeInfoListener(new CallbackWithOneParam<FlyHome>() {
//            @Override
//            public void onFailure(AutelError flycontrollerError) {
//
//            }
//
//            @Override
//            public void onSuccess(FlyHome result) {
//               logOut(handler, "setHomeInfoListener onSuccess " + result);
//            }
//        });
//    }
//
//    public static void resetHomeInfoListener() {
//        AModuleFlyController.flyController().setHomeInfoListener(null);
//    }

    public static void setFCHeightInfoListener(final Handler handler) {

        AModuleFlyController.flyController().setUltraSonicHeightInfoListener(new CallbackWithOneParam<Float>() {
            @Override
            public void onFailure(AutelError flycontrollerError) {

            }

            @Override
            public void onSuccess(Float result) {
                logOut(handler, "setUltraSonicHeightInfoListener onSuccess " + result);
            }
        });
    }

    public static void resetFCHeightInfoListener() {
        AModuleFlyController.flyController().setUltraSonicHeightInfoListener(null);
    }

    //    public static void setFlyControllerStatusListener(final Handler handler) {
//        AModuleFlyController.flyController().setFlyControllerStatusListener(new CallbackWithOneParam<FlyControllerStatus>() {
//            @Override
//            public void onFailure(AutelError flycontrollerError) {
//
//            }
//
//            @Override
//            public void onSuccess(FlyControllerStatus controllerStatus) {
//               logOut(handler, "setFlyControllerStatusListener onSuccess " + controllerStatus);
//            }
//        });
//    }
//
//    public static void resetFlyControllerStatusListener() {
//        AModuleFlyController.flyController().setFlyControllerStatusListener(null);
//    }
    public static void setFlyControllerWarningListener(final Handler handler) {
        AModuleFlyController.flyController().setWarningListener(new CallbackWithTwoParams<ARMWarning, MagnetometerState>() {

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setFlyControllerWarningListener " + error.getDescription());
            }

            @Override
            public void onSuccess(ARMWarning data1, MagnetometerState data2) {
                logOut(handler, "setFlyControllerWarningListener ARMWarning " + data1 + " MagnetometerState " + data2);
            }
        });
    }

    public static void resetFlyControllerWarningListener() {
        AModuleFlyController.flyController().setWarningListener(null);
    }

    public static void setFlyControllerListener(final Handler handler) {
        AModuleFlyController.flyController().setFlyControllerInfoListener(new CallbackWithOneParam<FlyControllerInfo>() {
            @Override
            public void onSuccess(FlyControllerInfo data) {
                logOut(handler, "setFlyControllerListener data " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setFlyControllerListener " + error);
            }
        });
    }

    public static void resetFlyControllerListener(final Handler handler) {
        AModuleFlyController.flyController().setFlyControllerInfoListener(null);
    }

    public static void isAircraftHasSNCode(final Handler handler) {
//        AModuleFlyController.flyController().isAircraftHasSNCode(new CallbackWithNoParam() {
//            @Override
//            public void onFailure(AutelError error) {
//                logOut(handler, "isAircraftHasSNCode AutelError " + error.getDescription());
//            }
//
//            @Override
//            public void onSuccess(Boolean data) {
//                logOut(handler, "isAircraftHasSNCode  " + data);
//            }
//        });
    }

//    public static void getAircraftActivateState(final Handler handler) {
//        AModuleFlyController.flyController().getAircraftActivateState(new CallbackWithOneParam<AircraftActivateState>() {
//            @Override
//            public void onFailure(AutelError error) {
//                logOut(handler, "getAircraftActivateState AutelError " + error.getDescription());
//            }
//
//            @Override
//            public void onSuccess(AircraftActivateState state) {
//                logOut(handler, "getAircraftActivateState  " + state);
//            }
//        });
//    }
//    public static void setAircraftActivateState(final Handler handler, AircraftActivateState state) {
//        AModuleFlyController.flyController().setAircraftActivateState(state, new CallbackWithOneParam<AircraftActivateState>() {
//            @Override
//            public void onFailure(AutelError error) {
//                logOut(handler, "setAircraftActivateState AutelError " + error.getDescription());
//            }
//
//            @Override
//            public void onSuccess(AircraftActivateState state) {
//                logOut(handler, "setAircraftActivateState  " + state);
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
