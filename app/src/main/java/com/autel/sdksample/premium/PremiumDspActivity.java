package com.autel.sdksample.premium;

import com.autel.sdk.dsp.AutelDsp;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.XStarAircraft;
import com.autel.sdksample.base.DspActivity;

/**
 * Created by A16343 on 2017/9/12.
 */

public class PremiumDspActivity extends DspActivity {
    @Override
    protected AutelDsp initController(BaseProduct product) {
        return ((XStarAircraft) product).getDsp();
    }
}
