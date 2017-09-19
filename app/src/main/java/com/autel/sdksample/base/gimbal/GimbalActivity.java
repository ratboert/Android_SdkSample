package com.autel.sdksample.base.gimbal;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalParameterRangeManager;
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

    EditText gimbalAngleWithFineTuning;
    EditText gimbalAngle;
    EditText dialAdjustSpeed;

    Spinner gimbalWorkModeList;
    Spinner rollAdjustList;

    GimbalWorkMode gimbalWorkMode = GimbalWorkMode.FPV;
    GimbalRollAngleAdjust gimbalRollAngleAdjust = GimbalRollAngleAdjust.MINUS;


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
        final TextView angleWithFineTuningRange = (TextView) findViewById(R.id.angleWithFineTuningRange);
        gimbalAngleWithFineTuning.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (isEmpty(s.toString())) {
                    return;
                }

                if (isEmpty(angleWithFineTuningRange.getText().toString())) {
                    GimbalParameterRangeManager gimbalParameterRangeManager = mController.getParameterRangeManager();
                    RangePair<Integer> support = gimbalParameterRangeManager.getAngleWithFineTuning();
                    angleWithFineTuningRange.setText("angle with fine tuning from " + support.getValueFrom() + " to " + support.getValueTo());
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        final TextView gimbalAngleRange = (TextView) findViewById(R.id.gimbalAngleRange);
        gimbalAngle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (isEmpty(s.toString())) {
                    return;
                }
                if (isEmpty(gimbalAngleRange.getText().toString())) {
                    GimbalParameterRangeManager gimbalParameterRangeManager = mController.getParameterRangeManager();
                    RangePair<Integer> support = gimbalParameterRangeManager.getAngle();
                    gimbalAngleRange.setText("angle from " + support.getValueFrom() + " to " + support.getValueTo());
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        final TextView dialAdjustSpeedRange = (TextView) findViewById(R.id.dialAdjustSpeedRange);
        dialAdjustSpeed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (isEmpty(s.toString())) {
                    return;
                }

                if (isEmpty(dialAdjustSpeedRange.getText().toString())) {
                    GimbalParameterRangeManager gimbalParameterRangeManager = mController.getParameterRangeManager();
                    RangePair<Integer> support = gimbalParameterRangeManager.getDialAdjustSpeed();
                    dialAdjustSpeedRange.setText("dial adjust speed from " + support.getValueFrom() + " to " + support.getValueTo());
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        initClick();
    }

    private void initClick() {
        findViewById(R.id.setGimbalAngleWithFineTuning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = gimbalAngleWithFineTuning.getText().toString();
                mController.setGimbalAngleWithFineTuning(isEmpty(value) ? -10 : Integer.valueOf(value));
            }
        });
        findViewById(R.id.setGimbalAngle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = gimbalAngle.getText().toString();
                mController.setGimbalAngle(isEmpty(value) ? 10 : Integer.valueOf(value));
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
        findViewById(R.id.setGimbalDialAdjustSpeed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = dialAdjustSpeed.getText().toString();
                mController.setGimbalDialAdjustSpeed(isEmpty(value) ? 10 : Integer.valueOf(value), new CallbackWithNoParam() {
                    @Override
                    public void onFailure(AutelError rcError) {
                        logOut("setGimbalDialAdjustSpeed error " + rcError.getDescription());
                    }

                    @Override
                    public void onSuccess() {
                        logOut("setGimbalDialAdjustSpeed onSuccess ");
                    }
                });
            }
        });
        findViewById(R.id.getGimbalDialAdjustSpeed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.getGimbalDialAdjustSpeed(new CallbackWithOneParam<Integer>() {

                    @Override
                    public void onFailure(AutelError rcError) {
                        logOut("getGimbalDialAdjustSpeed error " + rcError.getDescription());
                    }

                    @Override
                    public void onSuccess(Integer speed) {
                        logOut("getGimbalDialAdjustSpeed onSuccess " + speed);
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
