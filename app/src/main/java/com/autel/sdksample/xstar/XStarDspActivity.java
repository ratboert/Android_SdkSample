package com.autel.sdksample.xstar;

import com.autel.sdk.dsp.AutelDsp;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.XStarPremiumAircraft;
import com.autel.sdksample.base.DspActivity;

/**
 * Created by A16343 on 2017/9/12.
 */

public class XStarDspActivity extends DspActivity {
    @Override
    protected AutelDsp initController(BaseProduct product) {
        return ((XStarPremiumAircraft) product).getDsp();
    }
}