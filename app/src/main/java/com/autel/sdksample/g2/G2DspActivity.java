package com.autel.sdksample.g2;

import com.autel.sdk.dsp.AutelDsp;
import com.autel.sdk.dsp.G2Dsp;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.G2Aircraft;
import com.autel.sdksample.R;
import com.autel.sdksample.base.DspActivity;

/**
 * Created by A16343 on 2017/9/12.
 */

public class G2DspActivity extends DspActivity {
    G2Dsp mG2Dsp;

    @Override
    protected AutelDsp initController(BaseProduct product) {
        mG2Dsp = ((G2Aircraft) product).getDsp();
        return mG2Dsp;
    }

    @Override
    protected int getCustomViewResId() {
        return R.layout.activity_g2_dsp;
    }

    @Override
    protected void initUi() {
        super.initUi();
    }
}
