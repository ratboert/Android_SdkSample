package com.autel.sdksample.base.gimbal;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalState;
import com.autel.common.gimbal.GimbalVersionInfo;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.sdk.gimbal.AutelGimbal;
import com.autel.sdksample.R;
import com.autel.sdksample.base.BaseActivity;
import com.autel.sdksample.base.gimbal.adapter.GimbalModeAdapter;
import com.autel.sdksample.base.gimbal.adapter.RollAdjustAdapter;


public abstract class GimbalActivity extends BaseActivity<AutelGimbal> {
    Spinner gimbalWorkModeList;
    Spinner rollAdjustList;
    GimbalRollAngleAdjust gimbalRollAngleAdjust = GimbalRollAngleAdjust.MINUS;
    GimbalWorkMode gimbalWorkMode = GimbalWorkMode.FPV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Gimbal");
    }

    @Override
    protected int getCustomViewResId() {
        return R.layout.activity_base_battery;
    }


    @Override
    protected void initUi() {


        gimbalWorkModeList = (Spinner) findViewById(R.id.gimbalWorkModeList);
        gimbalWorkModeList.setAdapter(new GimbalModeAdapter(this));
        gimbalWorkModeList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gimbalWorkMode = (GimbalWorkMode) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        initClick();
    }

    private void initClick() {
        rollAdjustList = (Spinner) findViewById(R.id.rollAdjustList);
        rollAdjustList.setAdapter(new RollAdjustAdapter(this));
        rollAdjustList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gimbalRollAngleAdjust = (GimbalRollAngleAdjust) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.setRollAdjustData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.setRollAdjustData(gimbalRollAngleAdjust, new CallbackWithOneParam<Double>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setRollAdjustData error " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(Double data) {
                        logOut("setRollAdjustData data " + data);
                    }
                });
            }
        });
        findViewById(R.id.setGimbalWorkMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.setGimbalWorkMode(gimbalWorkMode, new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setGimbalWorkMode error " + error.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setGimbalWorkMode result   onSuccess");
                    }
                });
            }
        });
        findViewById(R.id.getGimbalWorkMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.getGimbalWorkMode(new CallbackWithOneParam<GimbalWorkMode>() {
                    @Override
                    public void onFailure(AutelError error) {
                        logOut("getGimbalWorkMode error " + error.getDescription());
                    }

                    @Override
                    public void onSuccess(GimbalWorkMode data) {
                        logOut("getGimbalWorkMode data " + data);
                    }
                });
            }
        });

        findViewById(R.id.setGimbalStateListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.setGimbalStateListener(new CallbackWithOneParam<GimbalState>() {
                    @Override
                    public void onSuccess(GimbalState gimbalState) {
                        logOut("setGimbalStateListener onSuccess " + gimbalState);
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("setGimbalStateListener error " + autelError.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.resetGimbalStateListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.setGimbalStateListener(null);
            }
        });
        findViewById(R.id.getVersionInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.getVersionInfo(new CallbackWithOneParam<GimbalVersionInfo>() {
                    @Override
                    public void onSuccess(GimbalVersionInfo gimbalVersionInfo) {
                        logOut("getVersionInfo onSuccess {" + gimbalVersionInfo + "}");
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("getVersionInfo onFailure " + autelError.getDescription());
                    }
                });
            }
        });
    }
}
