package com.autel.sdksample.gimbal;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalRollAngleAdjust;
import com.autel.common.gimbal.GimbalState;
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.sdk.AModuleGimbal;
import com.autel.sdk.gimbal.AutelGimbal;
import com.autel.sdksample.BaseActivity;
import com.autel.sdksample.R;
import com.autel.sdksample.gimbal.adapter.GimbalModeAdapter;
import com.autel.sdksample.gimbal.adapter.RollAdjustAdapter;


public class GimbalActivity extends BaseActivity {
    EditText gimbalAngleWithFineTuning;
    EditText gimbalAngle;
    EditText dialAdjustSpeed;

    Spinner gimbalWorkModeList;
    Spinner rollAdjustList;

    GimbalWorkMode gimbalWorkMode = GimbalWorkMode.FPV;
    GimbalRollAngleAdjust gimbalRollAngleAdjust = GimbalRollAngleAdjust.MINUS;

    AutelGimbal autelGimbal;

    @Override
    protected void initOnCreate() {
        setContentView(R.layout.activity_gimbal);
        autelGimbal = AModuleGimbal.gimbal();

        gimbalAngleWithFineTuning = (EditText) findViewById(R.id.gimbalAngleWithFineTuning);
        gimbalAngle = (EditText) findViewById(R.id.gimbalAngle);
        dialAdjustSpeed = (EditText) findViewById(R.id.dialAdjustSpeed);

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
    }

    public void setGimbalAngleWithFineTuning(View view) {
        String value = gimbalAngleWithFineTuning.getText().toString();
        autelGimbal.setGimbalAngleWithFineTuning(isEmpty(value) ? -10 : Integer.valueOf(value));
    }

    public void setGimbalAngle(View view) {
        String value = gimbalAngle.getText().toString();
        autelGimbal.setGimbalAngle(isEmpty(value) ? 10 : Integer.valueOf(value));
    }

    public void setGimbalWorkMode(View view) {
        autelGimbal.setGimbalWorkMode(gimbalWorkMode, new CallbackWithNoParam() {
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

    public void getGimbalWorkMode(View view) {
        autelGimbal.getGimbalWorkMode(new CallbackWithOneParam<GimbalWorkMode>() {
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

    public void setRollAdjustData(View view) {
        autelGimbal.setRollAdjustData(gimbalRollAngleAdjust, new CallbackWithOneParam<Double>() {
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

    public void setGimbalDialAdjustSpeed(View view) {
        String value = dialAdjustSpeed.getText().toString();
        autelGimbal.setGimbalDialAdjustSpeed(isEmpty(value) ? 10 : Integer.valueOf(value), new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError rcError) {
                logOut("setGimbalDialAdjustSpeed RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setGimbalDialAdjustSpeed onSuccess ");
            }
        });
    }

    public void getGimbalDialAdjustSpeed(View view) {
        autelGimbal.getGimbalDialAdjustSpeed(new CallbackWithOneParam<Integer>() {

            @Override
            public void onFailure(AutelError rcError) {
                logOut("getGimbalDialAdjustSpeed RCError " + rcError.getDescription());
            }

            @Override
            public void onSuccess(Integer speed) {
                logOut("getGimbalDialAdjustSpeed onSuccess " + speed);
            }
        });
    }

    public void setGimbalStateListener(View view) {
        autelGimbal.setGimbalStateListener(new CallbackWithOneParam<GimbalState>() {
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

    public void resetGimbalStateListener(View view) {
        autelGimbal.setGimbalStateListener(null);
    }


    public void setGimbalAngleListener(View view) {
        autelGimbal.setGimbalAngleListener(new CallbackWithOneParam<Integer>() {
            @Override
            public void onSuccess(Integer integer) {
                logOut("setGimbalAngleListener onSuccess " + integer);
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("setGimbalAngleListener error " + autelError.getDescription());
            }
        });
    }

    public void resetGimbalAngleListener(View view) {
        autelGimbal.setGimbalAngleListener(null);
    }


}
