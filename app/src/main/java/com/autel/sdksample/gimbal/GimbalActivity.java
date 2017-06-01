package com.autel.sdksample.gimbal;

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
import com.autel.common.gimbal.GimbalWorkMode;
import com.autel.sdk.gimbal.AutelGimbal;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.XStarAircraft;
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
        setTitle("Gimbal");
        setContentView(R.layout.activity_gimbal);
        BaseProduct product = getCurrentProduct();
        if (null != product && product instanceof XStarAircraft) {
            autelGimbal = ((XStarAircraft) product).getGimbal();
        }

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
                if (isEmpty(angleWithFineTuningRange.getText().toString())) {
                    autelGimbal.getParameterRangeManager(new CallbackWithOneParam<GimbalParameterRangeManager>() {
                        @Override
                        public void onSuccess(GimbalParameterRangeManager gimbalParameterRangeManager) {
                            RangePair<Integer> support = gimbalParameterRangeManager.getAngleWithFineTuning();
                            angleWithFineTuningRange.setText("angle with fine tuning from " + support.getValueFrom() + " to " + support.getValueTo());
                        }

                        @Override
                        public void onFailure(AutelError autelError) {

                        }
                    });
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
                if (isEmpty(gimbalAngleRange.getText().toString())) {
                    autelGimbal.getParameterRangeManager(new CallbackWithOneParam<GimbalParameterRangeManager>() {
                        @Override
                        public void onSuccess(GimbalParameterRangeManager gimbalParameterRangeManager) {
                            RangePair<Integer> support = gimbalParameterRangeManager.getAngle();
                            gimbalAngleRange.setText("angle from " + support.getValueFrom() + " to " + support.getValueTo());
                        }

                        @Override
                        public void onFailure(AutelError autelError) {

                        }
                    });
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
                if (isEmpty(dialAdjustSpeedRange.getText().toString())) {
                    autelGimbal.getParameterRangeManager(new CallbackWithOneParam<GimbalParameterRangeManager>() {
                        @Override
                        public void onSuccess(GimbalParameterRangeManager gimbalParameterRangeManager) {
                            RangePair<Integer> support = gimbalParameterRangeManager.getDialAdjustSpeed();
                            dialAdjustSpeedRange.setText("dial adjust speed from " + support.getValueFrom() + " to " + support.getValueTo());
                        }

                        @Override
                        public void onFailure(AutelError autelError) {

                        }
                    });
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
                autelGimbal.setGimbalAngleWithFineTuning(isEmpty(value) ? -10 : Integer.valueOf(value));
            }
        });
        findViewById(R.id.setGimbalAngle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = gimbalAngle.getText().toString();
                autelGimbal.setGimbalAngle(isEmpty(value) ? 10 : Integer.valueOf(value));
            }
        });
        findViewById(R.id.setGimbalWorkMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        findViewById(R.id.getGimbalWorkMode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        findViewById(R.id.setRollAdjustData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        findViewById(R.id.setGimbalDialAdjustSpeed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        findViewById(R.id.getGimbalDialAdjustSpeed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        findViewById(R.id.setGimbalStateListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        findViewById(R.id.resetGimbalStateListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelGimbal.setGimbalStateListener(null);
            }
        });
        findViewById(R.id.setGimbalAngleListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
        findViewById(R.id.resetGimbalAngleListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autelGimbal.setGimbalAngleListener(null);
            }
        });
    }
}
