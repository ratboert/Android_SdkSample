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

    public static void setRCLanguage(final Handler handler) {



    }

    public static void getRCLanguage(final Handler handler) {

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
    }

    public static void startRCBinding(final Handler handler) {

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
    }
    public static void exitBinding(final Handler handler) {
        AModuleRemoteController.remoteController().exitBinding();
    }

    public static void setRFPower(final Handler handler) {

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
    }

    public static void getRFPower(final Handler handler) {

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
    }

    public static void getTeacherStudentMode(final Handler handler) {

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
    }

    public static void setTeacherStudentMode(final Handler handler) {

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
    }


    public static void setRCCalibrationStep( final RemoteControllerStickCalibration step,final Handler handler) {

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
    }

    public static void setRCLengthUnit(final Handler handler) {

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
    }

    public static void getRCLengthUnit(final Handler handler) {

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
    }

    public static void setRCCommandStickMode(final Handler handler) {

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
    }

    public static void resetWifi() {

            AModuleRemoteController.remoteController().resetWifi();
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
