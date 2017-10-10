package com.autel.sdksample.xstar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.RangePair;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.GimbalParameterRangeManager;
import com.autel.sdk.gimbal.AutelGimbal;
import com.autel.sdk.gimbal.XStarGimbal;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.XStarAircraft;
import com.autel.sdksample.R;
import com.autel.sdksample.base.gimbal.GimbalActivity;

/**
 * Created by A16343 on 2017/9/6.
 */

public class XStarGimbalActivity extends GimbalActivity {
    private XStarGimbal mXStarGimbal;
    EditText gimbalAngle;
    EditText dialAdjustSpeed;

    @Override
    protected AutelGimbal initController(BaseProduct product) {
        mXStarGimbal = ((XStarAircraft) product).getGimbal();
        return mXStarGimbal;
    }

    @Override
    protected int getCustomViewResId() {
        return R.layout.activity_xstar_gimbal;
    }

    @Override
    protected void initUi() {
        super.initUi();
        gimbalAngle = (EditText) findViewById(R.id.gimbalAngle);
        dialAdjustSpeed = (EditText) findViewById(R.id.dialAdjustSpeed);
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
        
        findViewById(R.id.setGimbalAngleListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mXStarGimbal.setAngleListener(new CallbackWithOneParam<Integer>() {

                    @Override
                    public void onSuccess(Integer integer) {
                        logOut("setAngleListener onSuccess " + integer);
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("setAngleListener error " + autelError.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.resetGimbalAngleListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mXStarGimbal.setAngleListener(null);
            }
        });

        findViewById(R.id.setGimbalAngle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = gimbalAngle.getText().toString();
                mXStarGimbal.setGimbalAngle(isEmpty(value) ? 10 : Integer.valueOf(value));
            }
        });
        findViewById(R.id.setGimbalDialAdjustSpeed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = dialAdjustSpeed.getText().toString();
                mXStarGimbal.setGimbalDialAdjustSpeed(isEmpty(value) ? 10 : Integer.valueOf(value), new CallbackWithNoParam() {
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
                mXStarGimbal.getGimbalDialAdjustSpeed(new CallbackWithOneParam<Integer>() {

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
    }
}
