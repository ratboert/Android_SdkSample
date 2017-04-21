package com.autel.sdksample.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.remotecontroller.RFPower;
import com.autel.common.remotecontroller.RemoteControllerInfo;
import com.autel.common.remotecontroller.RemoteControllerParameterUnit;
import com.autel.common.remotecontroller.RemoteControllerStickCalibration;
import com.autel.common.remotecontroller.RemoteControllerCommandStickMode;
import com.autel.common.remotecontroller.RemoteControllerLanguage;
import com.autel.common.remotecontroller.RemoteControllerNavigateButtonEvent;
import com.autel.common.remotecontroller.RemoteControllerConnectState;
import com.autel.common.remotecontroller.TeachingMode;
import com.autel.sdk.AModuleRemoteController;

/**
 * Created by A16343 on 2016/11/11.
 */
public class RCTest {
    private final static String TAG = "RCTest";

    public static void setRCLanguage(int cType,final Handler handler) {

        if (cType == 1) {

            AModuleRemoteController.remoteController().setLanguage(RemoteControllerLanguage.ENGLISH, new CallbackWithNoParam() {

                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "setLanguage RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setLanguage onSuccess ");
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    RCLanguageResult result = AModuleRemoteController.sync().setLanguage(RemoteControllerLanguage.ENGLISE);
//                    if (null != result.getRcError()) {
//                        logOut(handler, "setLanguage RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "setLanguage onSuccess " + result.getRcLanguage());
//                    }
//                }
//            }.start();
        }
    }

    public static void getRCLanguage(int cType,final Handler handler) {

        if (cType == 1) {
            AModuleRemoteController.remoteController().getLanguage(new CallbackWithOneParam<RemoteControllerLanguage>() {
                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "getLanguage RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess(RemoteControllerLanguage rcLanguage) {
                    logOut(handler, "getLanguage onSuccess " + rcLanguage.toString());
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    RCLanguageResult result = AModuleRemoteController.sync().getLanguage();
//                    if (null != result.getRcError()) {
//                        logOut(handler, "getLanguage RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "getLanguage onSuccess " + result.getRcLanguage());
//                    }
//                }
//            }.start();
        }
    }

    public static void getRCBindMode(int cType,final Handler handler) {

//        if (cType == 1) {
//            AModuleRemoteController.remoteController().getBindState(new CallbackWithOneParam<RemoteControllerBindState>() {
//                @Override
//                public void onFailure(AutelError rcError) {
//                    logOut(handler, "getBindState RCError " + rcError.getDescription());
//                }
//
//                @Override
//                public void onSuccess(RemoteControllerBindState rcBindMode) {
//                    logOut(handler, "getBindState onSuccess " + rcBindMode);
//                }
//            });
//        } else {
//            new Thread() {
//                public void run() {
//                    RCBindModeResult result = AModuleRemoteController.sync().getBindState();
//                    if (null != result.getRcError()) {
//                        logOut(handler, "getBindState RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "getBindState onSuccess " + result.getRcBindMode());
//                    }
//                }
//            }.start();
//        }
    }

    public static void startRCBinding(int cType,final Handler handler) {

        if (cType == 1) {
            AModuleRemoteController.remoteController().enterBinding(new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "enterBinding RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "enterBinding onSuccess ");
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    RCBindingResult result = AModuleRemoteController.sync().enterBinding();
//                    if (null != result.getRcError()) {
//                        logOut(handler, "enterBinding RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "enterBinding onSuccess " + result.isStartSuccessful());
//                    }
//                }
//            }.start();
        }
    }
    public static void exitBinding(final Handler handler) {
        AModuleRemoteController.remoteController().exitBinding();
    }

    public static void setRFPower(int cType,final Handler handler) {

        if (cType == 1) {
            AModuleRemoteController.remoteController().setRFPower(RFPower.CE, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "setRFPower RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setRFPower onSuccess " );
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    RCPowerResult result = AModuleRemoteController.sync().setRFPower(RFPower.CE);
//                    if (null != result.getRcError()) {
//                        logOut(handler, "setRFPower RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "setRFPower onSuccess " + result.getAutelRFPower());
//                    }
//                }
//            }.start();
        }
    }

    public static void getRFPower(int cType,final Handler handler) {

        if (cType == 1) {
            AModuleRemoteController.remoteController().getRFPower(new CallbackWithOneParam<RFPower>() {
                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "getRFPower RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess(RFPower autelRFPower) {
                    logOut(handler, "getRFPower onSuccess " + autelRFPower);
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    RCPowerResult result = AModuleRemoteController.sync().getRFPower();
//                    if (null != result.getRcError()) {
//                        logOut(handler, "getRFPower RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "getRFPower onSuccess " + result.getAutelRFPower());
//                    }
//                }
//            }.start();
        }
    }

    public static void getTeacherStudentMode(int cType,final Handler handler) {

        if (cType == 1) {
            AModuleRemoteController.remoteController().getTeachingMode(new CallbackWithOneParam<TeachingMode>() {
                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "getTeachingMode RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess(TeachingMode autelTeachingMode) {
                    logOut(handler, "getTeachingMode onSuccess " + autelTeachingMode);
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    RCTeacherStudentModeResult result = AModuleRemoteController.sync().getTeachingMode();
//                    if (null != result.getRcError()) {
//                        logOut(handler, "getTeachingMode RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "getTeachingMode onSuccess " + result.getAutelTeacherStudentMode());
//                    }
//                }
//            }.start();
        }
    }

    public static void setTeacherStudentMode(int cType,final Handler handler) {

        if (cType == 1) {
            AModuleRemoteController.remoteController().setTeachingMode(TeachingMode.TEACHER, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "setTeachingMode RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setTeachingMode onSuccess ");
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    RCTeacherStudentModeResult result = AModuleRemoteController.sync().setTeachingMode(TeachingMode.STUDENT);
//                    if (null != result.getRcError()) {
//                        logOut(handler, "setTeachingMode RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "setTeachingMode onSuccess " + result.getAutelTeacherStudentMode());
//                    }
//                }
//            }.start();
        }
    }


    public static void setRCCalibrationStep(int cType, final RemoteControllerStickCalibration step,final Handler handler) {

        if (cType == 1) {
            AModuleRemoteController.remoteController().setStickCalibration(step, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "setStickCalibration RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess() {
//                    StringBuffer stringBuffer = new StringBuffer();
//                    for(int i: calibrationStep){
//                        stringBuffer.append(i+",");
//                    }
                    logOut(handler, "setStickCalibration onSuccess  ");
                }


            });
        } else {
//            new Thread() {
//                public void run() {
//                    RCCalibrationStepResult result = AModuleRemoteController.sync().setStickCalibration(step);
//                    if (null != result.getRcError()) {
//                        logOut(handler, "setStickCalibration RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "setStickCalibration onSuccess [0] " + result.getCalibrationStep()[0]);
//                    }
//                }
//            }.start();
        }
    }

    public static void setRCLengthUnit(int cType,final Handler handler) {

        if (cType == 1) {
            AModuleRemoteController.remoteController().setParameterUnit(RemoteControllerParameterUnit.IMPERIAL, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "setParameterUnit RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setParameterUnit onSuccess  ");
                }


            });
        } else {
//            new Thread() {
//                public void run() {
//                    RCLengthUnitResult result = AModuleRemoteController.sync().setParameterUnit(RemoteControllerParameterUnit.IMPERIAL);
//                    if (null != result.getRcError()) {
//                        logOut(handler, "setParameterUnit RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "setParameterUnit onSuccess  " + result.getAutelRCLengthUnit());
//                    }
//                }
//            }.start();
        }
    }

    public static void getRCLengthUnit(int cType,final Handler handler) {

        if (cType == 1) {
            AModuleRemoteController.remoteController().getLengthUnit(new CallbackWithOneParam<RemoteControllerParameterUnit>() {
                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "getLengthUnit RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess(RemoteControllerParameterUnit autelRCLengthUnit) {
                    logOut(handler, "getLengthUnit onSuccess " + autelRCLengthUnit);
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    RCLengthUnitResult result = AModuleRemoteController.sync().getLengthUnit();
//                    if (null != result.getRcError()) {
//                        logOut(handler, "getLengthUnit RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "getLengthUnit onSuccess " + result.getAutelRCLengthUnit());
//                    }
//                }
//            }.start();
        }
    }

    public static void setRCCommandStickMode(int cType,final Handler handler) {

        if (cType == 1) {
            AModuleRemoteController.remoteController().setCommandStickMode(RemoteControllerCommandStickMode.CHINA, new CallbackWithNoParam() {
                @Override
                public void onFailure(AutelError rcError) {
                    logOut(handler, "setCommandStickMode RCError " + rcError.getDescription());
                }

                @Override
                public void onSuccess() {
                    logOut(handler, "setCommandStickMode onSuccess ");
                }
            });
        } else {
//            new Thread() {
//                public void run() {
//                    RCCommandStickModeResult result = AModuleRemoteController.sync().setCommandStickMode(RemoteControllerCommandStickMode.CHINA);
//                    if (null != result.getRcError()) {
//                        logOut(handler, "setCommandStickMode RCError " + result.getRcError());
//                    } else {
//                        logOut(handler, "setCommandStickMode onSuccess " + result.getAutelRCCommandStickMode());
//                    }
//                }
//            }.start();
        }
    }

    public static void resetWifi(int cType) {

        if (cType == 1) {
            AModuleRemoteController.remoteController().resetWifi();
        } else {
//            new Thread() {
//                public void run() {
//                    AModuleRemoteController.sync().resetWifi();
//                }
//            }.start();
        }
    }

    public static void uploadPhoneCompassAngle(int cType) {

        if (cType == 1) {
//            AModuleRemoteController.remoteController().uploadPhoneCompassAngle(3);
        } else {
//            new Thread() {
//                public void run() {
//                    AModuleRemoteController.sync().uploadPhoneCompassAngle(3);
//                }
//            }.start();
        }
    }

    public static void setRemoteButtonControllerListener(final Handler handler) {

        AModuleRemoteController.remoteController().setRemoteButtonControllerListener(new CallbackWithOneParam<RemoteControllerNavigateButtonEvent>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "setRemoteButtonControllerListener rcError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerNavigateButtonEvent rcControlBtnEvent) {
                logOut(handler, "setRemoteButtonControllerListener onSuccess " + rcControlBtnEvent);
            }
        });
    }

    public static void resetRemoteButtonControllerListener() {
        AModuleRemoteController.remoteController().setRemoteButtonControllerListener(null);
    }

    public static void setRCUploadDataListener(final Handler handler) {
//        AModuleRemoteController.remoteController().setUploadDataListener(new CallbackWithOneParam<int[]>() {
//            @Override
//            public void onFailure(AutelError rcError) {
//                logOut(handler, "setUploadDataListener rcError " + rcError.getDescription());
//            }
//
//            @Override
//            public void onSuccess(int[] data) {
//                int size = data.length;
//                StringBuffer stringBuffer = new StringBuffer();
//                for (int i = 0; i < size; i++) {
//                    stringBuffer.append("   "+i);
//                    stringBuffer.append(":");
//                    stringBuffer.append(data[i]);
//                }
//                logOut(handler, "setUploadDataListener onSuccess " + stringBuffer.toString());
//            }
//        });
    }

    public static void resetRCUploadDataListener() {
//        AModuleRemoteController.remoteController().setUploadDataListener(null);
    }

    public static void setRCInfoDataListener(final Handler handler) {
        AModuleRemoteController.remoteController().setInfoDataListener(new CallbackWithOneParam<RemoteControllerInfo>() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut(handler, "setInfoDataListener rcError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerInfo data) {
                logOut(handler, "setInfoDataListener onSuccess " + data);
            }
        });
    }

    public static void resetRCInfoDataListener() {
        AModuleRemoteController.remoteController().setInfoDataListener(null);
    }

    public static void setRemoteControllerConnectStateListener(final Handler handler) {
        AModuleRemoteController.remoteController().setConnectStateListener(new CallbackWithOneParam<RemoteControllerConnectState>() {
            @Override
            public void onFailure(AutelError error) {
                logOut(handler, "setConnectStateListener error "+error.getDescription());
            }

            public void onSuccess(RemoteControllerConnectState state){
                logOut(handler, "setConnectStateListener "+state);
            }
        });
    }
    public static void resetRemoteControllerConnectStateListener() {
        AModuleRemoteController.remoteController().setConnectStateListener(null);
    }


    private static void logOut(Handler handler, String log) {
        Log.v(TAG, log);
        Message msg = handler.obtainMessage();
        msg.obj = log;
        handler.sendMessage(msg);
    }
}
