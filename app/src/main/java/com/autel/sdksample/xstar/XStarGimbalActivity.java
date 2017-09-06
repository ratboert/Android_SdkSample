package com.autel.sdksample.xstar;

import com.autel.sdk.gimbal.AutelGimbal;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.G2Aircraft;
import com.autel.sdk.product.XStarAircraft;
import com.autel.sdksample.base.gimbal.GimbalActivity;

/**
 * Created by A16343 on 2017/9/6.
 */

public class XStarGimbalActivity extends GimbalActivity {
    @Override
    protected AutelGimbal initController(BaseProduct product) {
        return ((XStarAircraft) product).getGimbal();
    }
}
