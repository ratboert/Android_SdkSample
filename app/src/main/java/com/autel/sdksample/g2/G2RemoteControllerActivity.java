package com.autel.sdksample.g2;

import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.G2Aircraft;
import com.autel.sdk.remotecontroller.AutelRemoteController;
import com.autel.sdksample.R;
import com.autel.sdksample.base.RemoteControllerActivity;


public class G2RemoteControllerActivity extends RemoteControllerActivity {


    @Override
    protected AutelRemoteController initController(BaseProduct product) {
        return ((G2Aircraft) product).getRemoteController();
    }

    @Override
    protected int getCustomViewResId() {
        return R.layout.activity_rc;
    }
}
