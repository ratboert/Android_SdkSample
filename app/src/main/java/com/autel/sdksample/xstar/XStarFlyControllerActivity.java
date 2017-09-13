package com.autel.sdksample.xstar;

import android.view.View;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.CallbackWithTwoParams;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.ARMWarning;
import com.autel.common.flycontroller.CalibrateCompassStatus;
import com.autel.common.flycontroller.FlyControllerInfo;
import com.autel.common.flycontroller.MagnetometerState;
import com.autel.sdk.flycontroller.AutelFlyController;
import com.autel.sdk.flycontroller.XStarFlyController;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.XStarAircraft;
import com.autel.sdksample.R;
import com.autel.sdksample.base.FlyControllerActivity;

/**
 * Created by A16343 on 2017/9/6.
 */

public class XStarFlyControllerActivity extends FlyControllerActivity {
    protected XStarFlyController mXStarFlyController;

    @Override
    protected AutelFlyController initController(BaseProduct product) {
        mXStarFlyController = ((XStarAircraft) product).getFlyController();
        return mXStarFlyController;
    }

    @Override
    protected int getCustomViewResId() {
        return R.layout.activity_fc;
    }


    public void setCalibrateCompassListener(View view) {
        mXStarFlyController.setCalibrateCompassListener(new CallbackWithOneParam<CalibrateCompassStatus>() {
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
        mXStarFlyController.setCalibrateCompassListener(null);
    }

    public void setUltraSonicHeightInfoListener(View view) {
        mXStarFlyController.setUltraSonicHeightInfoListener(new CallbackWithOneParam<Float>() {
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
        mXStarFlyController.setUltraSonicHeightInfoListener(null);
    }

    public void resetFCHeightInfoListener(View view) {
        mXStarFlyController.setUltraSonicHeightInfoListener(null);
    }

    public void setWarningListener(View view) {
        mXStarFlyController.setWarningListener(new CallbackWithTwoParams<ARMWarning, MagnetometerState>() {

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
        mXStarFlyController.setWarningListener(null);
    }

    public void setFlyControllerListener(View view) {
        mXStarFlyController.setFlyControllerInfoListener(new CallbackWithOneParam<FlyControllerInfo>() {
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
        mXStarFlyController.setFlyControllerInfoListener(null);
    }


}
