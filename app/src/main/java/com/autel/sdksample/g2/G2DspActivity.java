package com.autel.sdksample.g2;

import com.autel.sdk.dsp.AutelDsp;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.G2Aircraft;
import com.autel.sdksample.base.DspActivity;

/**
 * Created by A16343 on 2017/9/12.
 */

public class G2DspActivity extends DspActivity {
    @Override
    protected AutelDsp initController(BaseProduct product) {
        return ((G2Aircraft) product).getDsp();
    }
}
