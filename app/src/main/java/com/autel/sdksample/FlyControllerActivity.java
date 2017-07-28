package com.autel.sdksample;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.RangePair;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyControllerInfo;
import com.autel.common.flycontroller.FlyControllerVersionInfo;
import com.autel.common.flycontroller.LedPilotLamp;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.common.flycontroller.xstar.XStarParameterRangeManager;
import com.autel.sdk.flycontroller.XStarFlyController;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.XStarAircraft;
import com.autel.sdk.product.XStarPremiumAircraft;


public class FlyControllerActivity extends BaseActivity {
    final String TAG = getClass().getSimpleName();
    private XStarFlyController autelFlyController;
    private Switch beginnerSwitch;

    private EditText fcMaxHeight;
    private EditText fcMaxRange;
    private EditText fcReturnHeight;
    private EditText fcHorizontalSpeed;
    private EditText fcAscendSpeed;
    private EditText fcDescendSpeed;
    private EditText locationAsHomePoint_la;
    private EditText locationAsHomePoint_lon;
    private Switch attiModeSwitch;
    private Spinner fcLedPilotLamp;

    private LedPilotLamp ledPilotLamp = LedPilotLamp.ALL_OFF;

    @Override
    protected void initOnCreate() {
        setTitle("FlyController");

        BaseProduct baseProduct = getCurrentProduct();
        if (null != baseProduct) {
            if (null != baseProduct) {
                switch (baseProduct.getType()) {
                    case X_STAR:
                        autelFlyController = ((XStarAircraft) baseProduct).getFlyController();
                        break;
                    case PREMIUM:
                        autelFlyController = ((XStarPremiumAircraft) baseProduct).getFlyController();
                        break;
                }
            }
        }
        if (null == autelFlyController) {
            setContentView(R.layout.activity_connect_exception);
            return;
        }

        setContentView(R.layout.activity_fc);

        beginnerSwitch = (Switch) findViewById(R.id.beginnerSwitch);
        beginnerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setBeginnerModeState(isChecked);
            }
        });
        beginnerSwitch.setChecked(true);

        fcMaxHeight = (EditText) findViewById(R.id.fcMaxHeight);
        fcMaxRange = (EditText) findViewById(R.id.fcMaxRange);
        fcReturnHeight = (EditText) findViewById(R.id.fcReturnHeight);
        fcHorizontalSpeed = (EditText) findViewById(R.id.fcHorizontalSpeed);
        fcAscendSpeed = (EditText) findViewById(R.id.fcAscendSpeed);
        fcDescendSpeed = (EditText) findViewById(R.id.fcDescendSpeed);
        locationAsHomePoint_la = (EditText) findViewById(R.id.locationAsHomePoint_la);
        locationAsHomePoint_lon = (EditText) findViewById(R.id.locationAsHomePoint_lon);

        attiModeSwitch = (Switch) findViewById(R.id.attiModeSwitch);
        attiModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setAttiModeEnable(isChecked);
            }
        });
        attiModeSwitch.setChecked(true);
        fcLedPilotLamp = (Spinner) findViewById(R.id.fcLedPilotLamp);
        fcLedPilotLamp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ledPilotLamp = LedPilotLamp.ALL_OFF;
                        break;
                    case 1:
                        ledPilotLamp = LedPilotLamp.BACK_ONLY;
                        break;
                    case 2:
                        ledPilotLamp = LedPilotLamp.FRONT_ONLY;
                        break;
                    case 3:
                        ledPilotLamp = LedPilotLamp.ALL_ON;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final TextView returnHeightRangeNotify = (TextView) findViewById(R.id.returnHeightRangeNotify);
        fcReturnHeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() == 0){
                    return;
                }

                String value = returnHeightRangeNotify.getText().toString();
                if (isEmpty(value)) {
                    XStarParameterRangeManager parameterRangeManager = autelFlyController.getParameterRangeManager();
                    if (null != parameterRangeManager) {
                        RangePair<Float> support = parameterRangeManager.getReturnHeightRange();
                        returnHeightRangeNotify.setText("return height range from " + support.getValueFrom() + "  to  " + support.getValueTo());
                    }
                }
            }
        });

        final TextView maxHeightRange = (TextView) findViewById(R.id.maxHeightRange);
        fcMaxHeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() == 0){
                    return;
                }

                String value = maxHeightRange.getText().toString();
                if (isEmpty(value)) {
                    XStarParameterRangeManager parameterRangeManager = autelFlyController.getParameterRangeManager();
                    if (null != parameterRangeManager) {
                        RangePair<Float> support = parameterRangeManager.getHeightRange();
                        maxHeightRange.setText("max height range from " + support.getValueFrom() + "  to  " + support.getValueTo());
                    }
                }
            }
        });

        final TextView maxRangeRange = (TextView) findViewById(R.id.maxRangeRange);
        fcMaxRange.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() == 0){
                    return;
                }

                String value = maxRangeRange.getText().toString();
                if (isEmpty(value)) {
                    XStarParameterRangeManager parameterRangeManager = autelFlyController.getParameterRangeManager();
                    if (null != parameterRangeManager) {
                        RangePair<Float> support = parameterRangeManager.getRangeOfMaxRange();
                        maxRangeRange.setText("max Range range from " + support.getValueFrom() + "  to  " + support.getValueTo());
                    }
                }
            }
        });

        final TextView fcDescendSpeedNotify = (TextView) findViewById(R.id.fcDescendSpeedNotify);
        fcDescendSpeed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() == 0){
                    return;
                }

                String value = fcDescendSpeedNotify.getText().toString();
                if (isEmpty(value)) {
                    XStarParameterRangeManager parameterRangeManager = autelFlyController.getParameterRangeManager();
                    if (null != parameterRangeManager) {
                        RangePair<Float> support = parameterRangeManager.getDescendSpeedRange();
                        fcDescendSpeedNotify.setText("DescendSpeed Range range from " + support.getValueFrom() + "m/s  to  " + support.getValueTo()+"m/s");
                    }
                }
            }
        });

        final TextView fcAscendSpeedValue = (TextView) findViewById(R.id.fcAscendSpeedValue);
        fcAscendSpeed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() == 0){
                    return;
                }

                String value = fcAscendSpeedValue.getText().toString();
                if (isEmpty(value)) {
                    XStarParameterRangeManager parameterRangeManager = autelFlyController.getParameterRangeManager();
                    if (null != parameterRangeManager) {
                        RangePair<Float> support = parameterRangeManager.getAscendSpeedRange();
                        fcAscendSpeedValue.setText("AscendSpeed Range range from " + support.getValueFrom() + "m/s  to  " + support.getValueTo()+"m/s");
                    }
                }
            }
        });

        final TextView fcHorizontalSpeedValue = (TextView) findViewById(R.id.fcHorizontalSpeedValue);
        fcHorizontalSpeed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length() == 0){
                    return;
                }

                String value = fcHorizontalSpeedValue.getText().toString();
                if (isEmpty(value)) {
                    XStarParameterRangeManager parameterRangeManager = autelFlyController.getParameterRangeManager();
                    if (null != parameterRangeManager) {
                        RangePair<Float> support = parameterRangeManager.getHorizontalSpeedRange();
                        fcHorizontalSpeedValue.setText("AscendSpeed Range range from " + support.getValueFrom() + "m/s  to  " + support.getValueTo()+"m/s");
                    }
                }
            }
        });
    }

    public void setBeginnerModeState(boolean enable) {
        autelFlyController.setBeginnerModeEnable(enable, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setBeginnerModeEnable AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setBeginnerModeEnable onSuccess ");
            }
        });
    }

    public void getBeginnerModeState(View view) {
        autelFlyController.isBeginnerModeEnable(new CallbackWithOneParam<Boolean>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("isBeginnerModeEnable AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess(Boolean mode) {
                logOut("isBeginnerModeEnable  " + mode);
            }
        });
    }


    public void getMaxHeight(View view) {
        autelFlyController.getMaxHeight(new CallbackWithOneParam<Float>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getMaxHeight AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess(Float maxHeight) {
                logOut("getMaxHeight  " + maxHeight);
            }
        });
    }

    public void setMaxHeight(View view) {
        String value = fcMaxHeight.getText().toString();

        autelFlyController.setMaxHeight(isEmpty(value) ? 80 : Integer.valueOf(value), new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setMaxHeight AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setMaxHeight onSuccess ");
            }


        });
    }

    public void getMaxRange(View view) {
        autelFlyController.getMaxRange(new CallbackWithOneParam<Float>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getMaxRange AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess(Float maxRange) {
                logOut("getMaxRange onSuccess " + maxRange);
            }
        });
    }

    public void setMaxRange(View view) {
        String value = fcMaxRange.getText().toString();

        autelFlyController.setMaxRange(isEmpty(value) ? 1000 : Integer.valueOf(value), new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setMaxRange AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setMaxRange onSuccess ");
            }


        });
    }

    public void getReturnHeight(View view) {
        autelFlyController.getReturnHeight(new CallbackWithOneParam<Float>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getReturnHeight AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess(Float returnHeight) {
                logOut("getReturnHeight onSuccess " + returnHeight);
            }


        });
    }

    public void setReturnHeight(View view) {
        String value = fcReturnHeight.getText().toString();
        autelFlyController.setReturnHeight(isEmpty(value) ? 20 : Integer.valueOf(value), new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setReturnHeight AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setReturnHeight onSuccess ");
            }
        });
    }

    public void getHorizontalSpeed(View view) {
        autelFlyController.getHorizontalSpeed(new CallbackWithOneParam<Float>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getHorizontalSpeed AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess(Float horizontalSpeed) {
                logOut("getHorizontalSpeed onSuccess " + horizontalSpeed);
            }

        });
    }

    public void setHorizontalSpeed(View view) {
        String value = fcHorizontalSpeed.getText().toString();
        autelFlyController.setHorizontalSpeed(isEmpty(value) ? 5 : Integer.valueOf(value), new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setHorizontalSpeed AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setHorizontalSpeed onSuccess ");
            }
        });
    }

    public void getAscendSpeed(View view) {
        autelFlyController.getAscendSpeed(new CallbackWithOneParam<Float>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getAscendSpeed AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess(Float horizontalSpeed) {
                logOut("getAscendSpeed onSuccess " + horizontalSpeed);
            }

        });
    }


    public void setAscendSpeed(View view) {
        String value = fcAscendSpeed.getText().toString();
        autelFlyController.setAscendSpeed(isEmpty(value) ? 5 : Integer.valueOf(value), new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setAscendSpeed AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setAscendSpeed onSuccess ");
            }

        });
    }

    public void getDescendSpeed(View view) {
        autelFlyController.getDescendSpeed(new CallbackWithOneParam<Float>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getDescendSpeed AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess(Float horizontalSpeed) {
                logOut("getDescendSpeed onSuccess " + horizontalSpeed);
            }

        });
    }

    public void setDescendSpeed(View view) {
        String value = fcDescendSpeed.getText().toString();
        autelFlyController.setDescendSpeed(isEmpty(value) ? 5 : Integer.valueOf(value), new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setDescendSpeed AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setDescendSpeed onSuccess ");
            }

        });
    }

    public void isAttiModeEnable(View view) {
        autelFlyController.isAttitudeModeEnable(new CallbackWithOneParam<Boolean>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("isAttitudeModeEnable AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess(Boolean result) {
                logOut("isAttitudeModeEnable " + result);
            }
        });
    }

    public void setAttiModeEnable(boolean enable) {
        autelFlyController.setAttitudeModeEnable(enable, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setAttitudeModeEnable AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setAttitudeModeEnable onSuccess ");
            }

        });
    }

    public void getLedPilotLamp(View view) {
        autelFlyController.getLedPilotLamp(new CallbackWithOneParam<LedPilotLamp>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("getLedPilotLamp AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess(LedPilotLamp ledPilotLamp) {
                logOut("getLedPilotLamp onSuccess " + ledPilotLamp);
            }
        });
    }

    public void setLedPilotLamp(View view) {
        autelFlyController.setLedPilotLamp(ledPilotLamp, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setLedPilotLamp AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setLedPilotLamp onSuccess ");
            }
        });
    }

    public void setLocationAsHomePoint(View view) {
        long lat = isEmpty(locationAsHomePoint_la.getText().toString()) ? 0 : Long.valueOf(locationAsHomePoint_la.getText().toString());
        long lon = isEmpty(locationAsHomePoint_lon.getText().toString()) ? 0 : Long.valueOf(locationAsHomePoint_lon.getText().toString());
        autelFlyController.setLocationAsHomePoint(lat, lon, new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setLocationAsHomePoint AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setLocationAsHomePoint onSuccess ");
            }
        });
    }

    public void setAircraftLocationAsHomePoint(View view) {
        autelFlyController.setAircraftLocationAsHomePoint(new CallbackWithNoParam() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setAircraftLocationAsHomePoint AutelError " + error.getDescription());
            }

            @Override
            public void onSuccess() {
                logOut("setAircraftLocationAsHomePoint onSuccess ");
            }
        });
    }

    public void startCalibrateCompass(View view) {
        autelFlyController.startCalibrateCompass();
    }

    public void takeOff(View view) {
        autelFlyController.takeOff(new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut("takeOff onSuccess ");
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("takeOff AutelError " + autelError.getDescription());
            }
        });
    }

    public void land(View view) {
        autelFlyController.land(new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut("land onSuccess ");
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("land AutelError " + autelError.getDescription());
            }
        });
    }

    public void goHome(View view) {
        autelFlyController.goHome(new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut("goHome onSuccess ");
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("goHome AutelError " + autelError.getDescription());
            }
        });
    }

    public void cancelReturn(View view) {
        autelFlyController.cancelReturn(new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut("cancelReturn onSuccess ");
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("cancelReturn AutelError " + autelError.getDescription());
            }
        });
    }

    public void cancelLand(View view) {
        autelFlyController.cancelLand(new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut("cancelLand onSuccess ");
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("cancelLand AutelError " + autelError.getDescription());
            }
        });
    }

    public void setCalibrateCompassListener(View view) {
        autelFlyController.setCalibrateCompassListener(new CallbackWithOneParam<CalibrateCompassStatus>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setCalibrateCompassListener " + error.getDescription());
            }

            @Override
            public void onSuccess(CalibrateCompassStatus result) {
                logOut("setCalibrateCompassListener onSuccess " + result);
            }
        });
    }

    public void resetCalibrateCompassListener(View view) {
        autelFlyController.setCalibrateCompassListener(null);
    }

    public void setUltraSonicHeightInfoListener(View view) {
        autelFlyController.setUltraSonicHeightInfoListener(new CallbackWithOneParam<Float>() {
            @Override
            public void onFailure(AutelError error) {
                logOut("setUltraSonicHeightInfoListener error " + error.getDescription());
            }

            @Override
            public void onSuccess(Float result) {
                logOut("setUltraSonicHeightInfoListener onSuccess " + result);
            }
        });
    }

    public void resetUltraSonicHeightInfoListener(View view) {
        autelFlyController.setUltraSonicHeightInfoListener(null);
    }

    public void resetFCHeightInfoListener(View view) {
        autelFlyController.setUltraSonicHeightInfoListener(null);
    }

    public void setWarningListener(View view) {
        autelFlyController.setWarningListener(new CallbackWithTwoParams<ARMWarning, MagnetometerState>() {

            @Override
            public void onFailure(AutelError error) {
                logOut("setWarningListener " + error.getDescription());
            }

            @Override
            public void onSuccess(ARMWarning data1, MagnetometerState data2) {
                logOut("setWarningListener ARMWarning " + data1 + " MagnetometerState " + data2);
            }
        });
    }

    public void resetWarningListener(View view) {
        autelFlyController.setWarningListener(null);
    }

    public void setFlyControllerListener(View view) {
        autelFlyController.setFlyControllerInfoListener(new CallbackWithOneParam<FlyControllerInfo>() {
            @Override
            public void onSuccess(FlyControllerInfo data) {
                logOut("setFlyControllerListener data " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("setFlyControllerListener " + error.getDescription());
            }
        });
    }

    public void resetFlyControllerListener(View view) {
        autelFlyController.setFlyControllerInfoListener(null);
    }

    public void getVersionInfo(View view) {
        autelFlyController.getVersionInfo(new CallbackWithOneParam<FlyControllerVersionInfo>() {
            @Override
            public void onSuccess(FlyControllerVersionInfo flyControllerVersionInfo) {
                logOut("getVersionInfo data {" + flyControllerVersionInfo+"}");
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("getVersionInfo onFailure : " + autelError.getDescription());
            }
        });
    }
    public void getSerialNumber(View view) {
        autelFlyController.getSerialNumber(new CallbackWithOneParam<String >() {
            @Override
            public void onSuccess(String serialNumber) {
                logOut("getSerialNumber data " + serialNumber);
            }

            @Override
            public void onFailure(AutelError autelError) {
                logOut("getSerialNumber onFailure : " + autelError.getDescription());
            }
        });
    }
}
