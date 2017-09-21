package com.autel.sdksample.g2;

import android.view.View;

import com.autel.common.CallbackWithOneParam;
import com.autel.common.error.AutelError;
import com.autel.common.gimbal.g2.G2AngleInfo;
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
    }
}
