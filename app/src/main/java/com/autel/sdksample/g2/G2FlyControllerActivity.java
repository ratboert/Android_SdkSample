package com.autel.sdksample.g2;

import com.autel.sdk.flycontroller.AutelFlyController;
import com.autel.sdk.flycontroller.G2FlyController;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.G2Aircraft;
import com.autel.sdksample.R;
import com.autel.sdksample.base.FlyControllerActivity;

/**
 * Created by A16343 on 2017/9/6.
 */

public class G2FlyControllerActivity extends FlyControllerActivity {
    private G2FlyController mG2FlyController;


    @Override
    protected AutelFlyController initController(BaseProduct product) {
        return ((G2Aircraft) product).getFlyController();
    }

    @Override
    protected int getCustomViewResId() {
        return R.layout.activity_fc;
    }
}
