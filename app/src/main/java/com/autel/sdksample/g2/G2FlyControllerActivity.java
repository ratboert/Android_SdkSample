package com.autel.sdksample.g2;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.autel.common.CallbackWithNoParam;
import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.flycontroller.LandingGearState;
import com.autel.common.flycontroller.g2.G2FlyControllerInfo;
import com.autel.sdk.flycontroller.AutelFlyController;
import com.autel.sdk.flycontroller.G2FlyController;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.G2Aircraft;
import com.autel.sdksample.R;
import com.autel.sdksample.base.FlyControllerActivity;
import com.autel.sdksample.g2.adapter.LandingGearStateAdapter;

/**
 * Created by A16343 on 2017/9/6.
 */

public class G2FlyControllerActivity extends FlyControllerActivity {
    private G2FlyController mG2FlyController;
    LandingGearStateAdapter mLandingGearStateAdapter;
    LandingGearState selectedLandingGearState = LandingGearState.UNKNOWN;

    @Override
    protected AutelFlyController initController(BaseProduct product) {
        mG2FlyController = ((G2Aircraft) product).getFlyController();
        return mG2FlyController;
    }

    @Override
    protected int getCustomViewResId() {
        return R.layout.activity_g2_fc;
    }

    @Override
    protected void initUi() {
        super.initUi();
        mLandingGearStateAdapter = new LandingGearStateAdapter(this);
        ((Spinner) findViewById(R.id.landingGearStateList)).setAdapter(mLandingGearStateAdapter);
        ((Spinner) findViewById(R.id.landingGearStateList)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedLandingGearState = (LandingGearState) parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedLandingGearState = LandingGearState.UNKNOWN;
            }
        });
    }

    public void setFlyControllerListener(View view) {
        mG2FlyController.setFlyControllerInfoListener(new CallbackWithOneParam<G2FlyControllerInfo>() {
            @Override
            public void onSuccess(G2FlyControllerInfo data) {
                logOut("setFlyControllerListener data " + data);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("setFlyControllerListener " + error.getDescription());
            }
        });
    }

    public void resetFlyControllerListener(View view) {
        mG2FlyController.setFlyControllerInfoListener(null);
    }

    public void setLandingGearState(View view) {
        mG2FlyController.setLandingGearState(selectedLandingGearState, new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut("setLandingGearState onSuccess " + selectedLandingGearState);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("setLandingGearState onFailure " + error.getDescription());
            }
        });
    }

    public void droneArmed(View view) {
        mG2FlyController.droneArmed(new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut("droneArmed onSuccess " + selectedLandingGearState);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("droneArmed onFailure " + error.getDescription());
            }
        });
    }

    public void droneDisarmed(View view) {
        mG2FlyController.droneDisarmed(new CallbackWithNoParam() {
            @Override
            public void onSuccess() {
                logOut("droneDisarmed onSuccess " + selectedLandingGearState);
            }

            @Override
            public void onFailure(AutelError error) {
                logOut("droneDisarmed onFailure " + error.getDescription());
            }
        });
    }
}
