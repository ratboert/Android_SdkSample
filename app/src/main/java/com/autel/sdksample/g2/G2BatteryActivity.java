package com.autel.sdksample.g2;

import android.os.Bundle;

import com.autel.sdk.battery.AutelBattery;
import com.autel.sdk.battery.G2Battery;
import com.autel.sdk.product.BaseProduct;
import com.autel.sdk.product.G2Aircraft;
import com.autel.sdksample.R;
import com.autel.sdksample.base.BatteryActivity;


public class G2BatteryActivity extends BatteryActivity {
    private G2Battery mG2Battery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Battery");
    }

    @Override
    protected AutelBattery initController(BaseProduct product) {
        mG2Battery = ((G2Aircraft) product).getBattery();
        return mG2Battery;
    }

    @Override
    protected int getCustomViewResId() {
        return R.layout.activity_g2_battery;
    }
}
