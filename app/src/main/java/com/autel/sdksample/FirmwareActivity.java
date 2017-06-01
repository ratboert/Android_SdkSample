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
        setTitle("Firmware");
        setContentView(R.layout.activity_firmware);
        firmwareInfo = AModuleFirmware.firmware();
        initClick();
    }

    private void initClick() {

        findViewById(R.id.getAircraftComponentVersion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        findViewById(R.id.getAircraftComponentSerialNumberVersion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        findViewById(R.id.getRemoteControllerVersion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        findViewById(R.id.getRemoteControllerSerialNumberVersion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
    }
}
