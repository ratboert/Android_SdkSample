package com.autel.sdksample;

import android.view.View;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.firmware.AircraftComponentSerialNumberVersionInfo;
import com.autel.common.firmware.AircraftComponentVersionInfo;
import com.autel.common.firmware.RemoteControllerSerialNumberVersionInfo;
import com.autel.common.firmware.RemoteControllerVersionInfo;
import com.autel.sdk.AModuleFirmware;
import com.autel.sdk.firmware.AutelFirmwareInfo;


public class FirmwareActivity extends BaseActivity {
    AutelFirmwareInfo firmwareInfo;
    @Override
    protected void initOnCreate() {
        setContentView(R.layout.activity_firmware);
        firmwareInfo = AModuleFirmware.firmware();
    }

    public void getAircraftComponentVersion(View view) {
        firmwareInfo.getAircraftComponentVersion(new CallbackWithOneParam<AircraftComponentVersionInfo>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getAircraftComponentVersion  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(AircraftComponentVersionInfo data) {
                logOut("getAircraftComponentVersion  data  " + data);
            }
        });
    }

    public void getAircraftComponentSerialNumberVersion(View view) {
        firmwareInfo.getAircraftComponentSerialNumberVersion(new CallbackWithOneParam<AircraftComponentSerialNumberVersionInfo>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getAircraftComponentSerialNumberVersion  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(AircraftComponentSerialNumberVersionInfo data) {
                logOut("getAircraftComponentSerialNumberVersion  data  " + data);
            }
        });
    }

    public void getRemoteControllerVersion(View view) {
        firmwareInfo.getRemoteControllerVersion(new CallbackWithOneParam<RemoteControllerVersionInfo>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getRemoteControllerVersion  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerVersionInfo data) {
                logOut("getRemoteControllerVersion  data  " + data);
            }
        });
    }

    public void getRemoteControllerSerialNumberVersion(View view) {
        firmwareInfo.getRemoteControllerSerialNumberVersion(new CallbackWithOneParam<RemoteControllerSerialNumberVersionInfo>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getRemoteControllerSerialNumberVersion  error  " + error.getDescription());
            }

            @Override
            public void onSuccess(RemoteControllerSerialNumberVersionInfo data) {
                logOut("getRemoteControllerSerialNumberVersion  data  " + data);
            }
        });
    }
}
