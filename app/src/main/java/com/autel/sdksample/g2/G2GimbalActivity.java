package com.autel.sdksample.g2;

import android.view.View;
import android.widget.EditText;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.g2.G2AngleInfo;
import com.autel.common.gimbal.g2.GimbalAngleData;
import com.autel.common.gimbal.g2.GimbalAngleSpeed;
import com.autel.sdk.gimbal.AutelGimbal;
import com.autel.sdk.gimbal.G2Gimbal;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.G2Aircraft;
import com.autel.sdksample.R;
import com.autel.sdksample.base.gimbal.GimbalActivity;

/**
 * Created by A16343 on 2017/9/6.
 */

public class G2GimbalActivity extends GimbalActivity {
    private G2Gimbal mG2Gimbal;
    private EditText gimbalAnglePitch;
    private EditText gimbalAngleRoll;
    private EditText gimbalAngleYaw;
    private EditText gimbalAnglePitchSpeed;
    private EditText gimbalAngleRollSpeed;
    private EditText gimbalAngleYawSpeed;
    private EditText rollAdjustDataValue;

    @Override
    protected AutelGimbal initController(BaseProduct product) {
        mG2Gimbal = ((G2Aircraft) product).getGimbal();
        return mG2Gimbal;
    }

    @Override
    protected int getCustomViewResId() {
        return R.layout.activity_g2_gimbal;
    }

    @Override
    protected void initUi() {
        super.initUi();
        gimbalAnglePitch = (EditText) findViewById(R.id.gimbalAnglePitch);
        gimbalAngleRoll = (EditText) findViewById(R.id.gimbalAngleRoll);
        gimbalAngleYaw = (EditText) findViewById(R.id.gimbalAngleYaw);
        gimbalAnglePitchSpeed = (EditText) findViewById(R.id.gimbalAnglePitchSpeed);
        gimbalAngleRollSpeed = (EditText) findViewById(R.id.gimbalAngleRollSpeed);
        gimbalAngleYawSpeed = (EditText) findViewById(R.id.gimbalAngleYawSpeed);
        findViewById(R.id.setGimbalAngleListener).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mG2Gimbal.setAngleListener(new CallbackWithOneParam<G2AngleInfo>() {

                    @Override
                    public void onSuccess(G2AngleInfo data) {
                        logOut("setAngleListener onSuccess " + data);
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
                mG2Gimbal.setAngleListener(null);
            }
        });
        findViewById(R.id.getGimbalAngle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mG2Gimbal.getGimbalAngle(new CallbackWithOneParam<GimbalAngleData>() {
                    @Override
                    public void onSuccess(GimbalAngleData data) {
                        logOut("getGimbalAngle onSuccess " + data);
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("getGimbalAngle onSuccess " + autelError.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.setGimbalAngle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pitchValue = gimbalAnglePitch.getText().toString();
                int pitch = isEmpty(pitchValue) ? 0 : Integer.valueOf(pitchValue);

                String rollValue = gimbalAngleRoll.getText().toString();
                int roll = isEmpty(rollValue) ? 0 : Integer.valueOf(rollValue);

                String yawValue = gimbalAngleYaw.getText().toString();
                int yaw = isEmpty(yawValue) ? 0 : Integer.valueOf(yawValue);

                GimbalAngleData angleData = new GimbalAngleData();
                angleData.setPitch(pitch);
                angleData.setRoll(roll);
                angleData.setYaw(yaw);
                mG2Gimbal.setGimbalAngle(angleData, new CallbackWithNoParam() {
                    @Override
                    public void onSuccess() {
                        logOut("setGimbalAngle onSuccess ");
                    }

                    @Override
                    public void onFailure(AutelError autelError) {
                        logOut("setGimbalAngle onFailure " + autelError.getDescription());
                    }
                });
            }
        });
        findViewById(R.id.setGimbalAngleSpeed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pitchValue = gimbalAnglePitchSpeed.getText().toString();
                int pitch = isEmpty(pitchValue) ? 0 : Integer.valueOf(pitchValue);

                String rollValue = gimbalAngleRollSpeed.getText().toString();
                int roll = isEmpty(rollValue) ? 0 : Integer.valueOf(rollValue);

                String yawValue = gimbalAngleYawSpeed.getText().toString();
                int yaw = isEmpty(yawValue) ? 0 : Integer.valueOf(yawValue);

                GimbalAngleSpeed angleSpeed = new GimbalAngleSpeed();
                angleSpeed.setPitchSpeed(pitch);
                angleSpeed.setRollSpeed(roll);
                angleSpeed.setYawSpeed(yaw);
                mG2Gimbal.setGimbalDialAdjustSpeed(angleSpeed);
            }
        });
        findViewById(R.id.setRollAdjustData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rollValue = rollAdjustDataValue.getText().toString();
                int rollOffset = isEmpty(rollValue) ? 0 : Integer.valueOf(rollValue);
                mG2Gimbal.setRollAdjustData(rollOffset, new CallbackWithOneParam<Double>() {
                    @Override
                    public void onSuccess(Double data) {
                        logOut("setRollAdjustData onSuccess " + data);
                    }

                    @Override
                    public void onFailure(AutelError error) {
                        logOut("setRollAdjustData onFailure " + error.getDescription());
                    }
                });
            }
        });
    }
}
