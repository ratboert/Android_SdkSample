package com.autel.sdksample.premium;

import com.autel.sdk.gimbal.AutelGimbal;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.XStarPremiumAircraft;
import com.autel.sdksample.base.gimbal.GimbalActivity;

/**
 * Created by A16343 on 2017/9/6.
 */

public class XStarPremiumGimbalActivity extends GimbalActivity {
    @Override
    protected AutelGimbal initController(BaseProduct product) {
        return ((XStarPremiumAircraft) product).getGimbal();
    }
}
